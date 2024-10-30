package com.dmitriykolesnik.simulation;

public class TextPrinter {
    private static final String QUIT_TEXT = "To quit, press 'q'";
    private static final String PAUSE_TEXT = "To pause, press 's'";
    private static final String ENTER_TEXT = " and then ENTER";
    private static final String RESUME_TEXT = "To resume, press 's'";

    public void printNextTurnText(int turnCounter) {
        System.out.println("Next Turn #" + turnCounter);
    }

    public void printStartText(int seconds) {
        System.out.printf("\nThe Simulation is starting in %d seconds...\n\n" +
                PAUSE_TEXT + "\n" + QUIT_TEXT + "\n", seconds );
    }

    public void printPauseText() {
        System.out.println("Simulation paused. \n" +
                RESUME_TEXT + ENTER_TEXT + "\n" +
                QUIT_TEXT + ENTER_TEXT);
    }

    public void printResumeText() {
        System.out.println("Simulation resumed.\n" +
                PAUSE_TEXT + "\n" + QUIT_TEXT + "\n");
    }

    public void printStopText() {
        System.out.println("You have decided to leave the Simulation.");
    }

    public void printFinishText() {
        System.out.println("\nSimulation finished. The World is not enough. Be brave, try again.");
    }

}
