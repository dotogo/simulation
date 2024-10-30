package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.action.*;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.view.ConsoleWorldMapRenderer;
import com.dmitriykolesnik.simulation.view.WorldMapRenderer;
import com.dmitriykolesnik.simulation.world_map.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Simulation {
    private static final int SLEEP_MILLISECONDS_BETWEEN_TURNS = 1000;
    private static final int SLEEP_MILLISECONDS_AFTER_RESUME = 2000;
    private static final int SLEEP_MILLISECONDS_AFTER_STARTING_TEXT = 3000;

    private static final String QUIT_TEXT = "To quit, press 'q'";
    private static final String PAUSE_TEXT = "To pause, press 's'";
    private static final String ENTER_TEXT = " and then ENTER";
    private static final String RESUME_TEXT = "To resume, press 's'";

    private final boolean isLoggingEnabled;
    private final WorldMap worldMap;
    private final PathFinder pathFinder;

    private final AtomicBoolean isPaused = new AtomicBoolean(false);
    private final WorldMapRenderer mapRender = new ConsoleWorldMapRenderer();

    private volatile boolean isStopped = false;
    private int turnCounter;
    private List<Actions> initActions;
    private List<Actions> turnActions;

    public Simulation(WorldMap worldMap, PathFinder pathFinder, boolean isLoggingEnabled) {
        this.worldMap = worldMap;
        this.pathFinder = pathFinder;
        this.isLoggingEnabled = isLoggingEnabled;
    }

    public void start() {
        initializeInitActions();
        performInitActions();
        initializeTurnActions();

        // Start a thread to process keyboard input
        new Thread(this::pause).start();

        if (turnCounter == 0) {
            int waitSecondsAfterStartingText = SLEEP_MILLISECONDS_AFTER_STARTING_TEXT / 1000;
            printStartText(waitSecondsAfterStartingText);
            sleepThread(SLEEP_MILLISECONDS_AFTER_STARTING_TEXT);
        }

        // Main Simulation loop
        while (!isStopped) {
            processNextTurn();
            sleepThread(SLEEP_MILLISECONDS_BETWEEN_TURNS);
        }
        printFinishText();
    }

    public void pause() {
        while (!isStopped) {
            try {
                int input = System.in.read();

                if (input == 's') {
                    togglePauseState();
                }

                if (input == 'q') {
                    isStopped = true;
                    printStopText();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void togglePauseState() {
        boolean currentPausedState = isPaused.get();

        if (isPaused.compareAndSet(currentPausedState, !currentPausedState)) {
            if (!currentPausedState) {
                printPauseText();
            } else {
                printResumeText();
                sleepThread(SLEEP_MILLISECONDS_AFTER_RESUME);
            }
        }
    }

    private void processNextTurn() {
        if (!isPaused.get()) {
            if (turnCounter != 0) {
                printNextTurnText();
            }
            nextTurn();
        }
    }

    private void nextTurn() {
        mapRender.render(worldMap);
        performTurnActions();
        turnCounter++;
    }

    private void printNextTurnText() {
        System.out.println("Next Turn #" + turnCounter);
    }

    private void initializeInitActions() {
        initActions = Arrays.asList(
                new WelcomeAction(),
                new CountEntitiesAction(worldMap));
    }

    private void performInitActions() {
        for (Actions action : initActions) {
            action.perform();
        }
    }

    private void initializeTurnActions() {
        turnActions = new ArrayList<>(List.of(
                new CountGrassAction(worldMap),
                new CountEntitiesAction(worldMap),
                new EntitySpawnAction(worldMap),
                new MoveAllCreaturesAction(worldMap, pathFinder, isLoggingEnabled)));
    }

    private void performTurnActions() {
        for (Actions action : turnActions) {
            action.perform();
        }
    }

    private void printStartText(int seconds) {
        System.out.printf("\nThe Simulation is starting in %d seconds...\n\n" +
                PAUSE_TEXT + "\n" + QUIT_TEXT + "\n", seconds );
    }

    private void printPauseText() {
        System.out.println("Simulation paused. \n" +
                RESUME_TEXT + ENTER_TEXT + "\n" +
                QUIT_TEXT + ENTER_TEXT);
    }

    private void printResumeText() {
        System.out.println("Simulation resumed.\n" +
                PAUSE_TEXT + "\n" + QUIT_TEXT + "\n");
    }

    private void printStopText() {
        System.out.println("You have decided to leave the Simulation.");
    }

    private void printFinishText() {
        System.out.println("\nSimulation finished. The World is not enough. Be brave, try again.");
    }

    private void sleepThread(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
