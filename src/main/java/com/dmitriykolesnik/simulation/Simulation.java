package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.action.*;
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
    private final WorldMap worldMap;
    private int turnCounter;
    private final boolean isLoggingEnabled;
    private volatile boolean isStopped = false;
    private final AtomicBoolean isPaused = new AtomicBoolean(false);
    private final WorldMapRenderer mapRender = new ConsoleWorldMapRenderer();
    private WorldMapFactory worldMapFactory; // = new WolfRabbitWorldMapFactory(30, 15);

//    private final Object pauseLock = new Object(); // Блокировка для паузы
//    private final ReentrantLock lock = new ReentrantLock(); // Блокировка
//    private final Condition pauseCondition = lock.newCondition(); // Условие для паузы

    // действия, совершаемые перед стартом симуляции. Пример - расставить объекты и существ на карте
    private List<Actions> initActions;

    // действия, совершаемые каждый ход. Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало
    private List<Actions> turnActions;
    private static final String QUIT_TEXT = "To quit, press 'q'";
    private static final String PAUSE_TEXT = "To pause, press 's'";
    private static final String ENTER_TEXT = " and then ENTER";
    private static final String RESUME_TEXT = "To resume, press 's'";

    public Simulation(WorldMap worldMap, boolean isLoggingEnabled) {
        this.worldMap = worldMap;
        this.isLoggingEnabled = isLoggingEnabled;
    }

    // просимулировать и отрендерить один ход
    public void nextTurn() {
        mapRender.render(worldMap);
        performTurnActions();
        turnCounter++;
    }

    public void start() {
        initializeInitActions();
        performInitActions();
        initializeTurnActions();

        // Start a thread to process keyboard input
        new Thread(this::pause).start();

        if (turnCounter == 0) {
            int waitSecondsAfterStartingText = SLEEP_MILLISECONDS_AFTER_STARTING_TEXT / 1000;
            startingPrintText(waitSecondsAfterStartingText);
            sleepThread(SLEEP_MILLISECONDS_AFTER_STARTING_TEXT);
        }

        // Main Simulation loop
        while (!isStopped) {
            if (!isPaused.get()) {
                if (turnCounter != 0) {
                    nextTurnPrintText();
                }
                nextTurn();
            }
            sleepThread(SLEEP_MILLISECONDS_BETWEEN_TURNS);
        }
        finishPrintText();
    }

    // Приостановить бесконечный цикл симуляции и рендеринга
    public void pause() {
        while (!isStopped) {
            try {
                int input = System.in.read(); // Считываем одиночный символ

                if (input == 's') {
                    boolean currentPausedState = isPaused.get();

                    if (isPaused.compareAndSet(currentPausedState, !currentPausedState)) {
                        if (!currentPausedState) {
                            pausePrintText();
                        } else {
                            resumePrintText();
                            sleepThread(SLEEP_MILLISECONDS_AFTER_RESUME);
                        }
                    }
                }

                if (input == 'q') {
                    isStopped = true;
                    stoppedPrintText();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





// рабочий вариант с wait, notify, synchronized
//    public void startSimulation() {
//        for (Actions action : initActions) {
//            action.perform();
//        }
//
//        int x_Size = 15;
//        int y_Size = 15;
//
//
//        worldMapFactory = new WolfRabbitWorldMapFactory(x_Size, y_Size);
//        worldMap = worldMapFactory.create();
//
//        // Запускаем поток для обработки ввода с клавиатуры
//        new Thread(this::pauseSimulation).start();
//
//        if (turnCounter == 0) {
//            startingPrintText();
//
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
//
//        // Главный цикл симуляции
//        while (!isStopped) {
//            synchronized (pauseLock) {
//                // Если симуляция на паузе, ждем возобновления
//                while (isPaused) {
//                    try {
//                        pauseLock.wait(); // Ждем уведомления
//                    } catch (InterruptedException e) {
//                        Thread.currentThread().interrupt();
//                    }
//                }
//            }
//
//            if (!isStopped) {
//                if (turnCounter != 0) {
//                    nextTurnPrintText();
//                }
//                nextTurn();
//
//                // Имитация задержки между шагами симуляции
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }
//        finishPrintText();
//    }
//
//    // Метод для обработки пользовательского ввода (для паузы и остановки)
//    public void pauseSimulation() {
//        while (!isStopped) {
//            try {
//                int input = System.in.read(); // Считываем одиночный символ
//
//                if (input == 's') {
//                    synchronized (pauseLock) {
//                        isPaused = !isPaused; // Меняем состояние паузы
//                        if (!isPaused) {
//                            pauseLock.notify(); // Уведомляем поток о возобновлении симуляции
//                            resumePrintText();
//
//                            try {
//                                Thread.sleep(2000);
//                            } catch (InterruptedException e) {
//                                Thread.currentThread().interrupt();
//                            }
//
//                        } else {
//                            pausePrintText();
//                        }
//                    }
//                } else if (input == 'q') {
//                    synchronized (pauseLock) {
//                        isStopped = true;
//                        isPaused = false;
//                        pauseLock.notify(); // Уведомляем, чтобы выйти из паузы и завершить симуляцию
//                    }
//                    stoppedPrintText();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }





    private void initializeInitActions() {
        initActions = Arrays.asList(new WelcomeAction());
    }

    private void performInitActions() {
        for (Actions action : initActions) {
            action.perform();
        }
    }

    private void initializeTurnActions() {
        turnActions = new ArrayList<>(List.of(new CountGrassAction(worldMap),
                                              new MoveAllCreaturesAction(worldMap, isLoggingEnabled)));
    }

    private void performTurnActions() {
        for (Actions action : turnActions) {
            action.perform();
        }
    }

    private void startingPrintText(int seconds) {
        System.out.printf("\nThe Simulation is starting in %d seconds...\n\n" +
                PAUSE_TEXT + "\n" + QUIT_TEXT + "\n", seconds );
    }

    private void pausePrintText() {
        System.out.println("Simulation paused. \n" +
                RESUME_TEXT + ENTER_TEXT + "\n" +
                QUIT_TEXT + ENTER_TEXT);
    }

    private void resumePrintText() {
        System.out.println("Simulation resumed.\n" +
                PAUSE_TEXT + "\n" + QUIT_TEXT + "\n");
    }

    private void stoppedPrintText() {
        System.out.println("You have decided to leave the Simulation.");
    }

    private void finishPrintText() {
        System.out.println("\nSimulation finished. The World is not enough. Be brave, try again.");
    }

    private void nextTurnPrintText() {
        System.out.println("Next Turn #" + turnCounter);
    }

    private void sleepThread(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
