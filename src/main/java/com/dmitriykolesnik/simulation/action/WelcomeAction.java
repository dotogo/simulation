package com.dmitriykolesnik.simulation.action;


public class WelcomeAction extends InitAction {
    private static final String WELCOME = "   ***   Welcome to Simulation!   ***\n";

    public void perform() {
        System.out.println(WELCOME);
    }
}
