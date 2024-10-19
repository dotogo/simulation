package com.dmitriykolesnik.simulation.for_something;

import com.dmitriykolesnik.simulation.action.CreateWorldMapAction;
import com.dmitriykolesnik.simulation.action.InputWorldSizeAction;
import com.dmitriykolesnik.simulation.action.WelcomeAction;
import com.dmitriykolesnik.simulation.menu.Menu;

public class Test {
    public static void main(String[] args) {
        Menu menu = new Menu("Main menu", "Make selection", "Error. Try again");

        menu.addItem("Show Welcome message", new WelcomeAction());
        menu.addItem("Specify World SIze", new InputWorldSizeAction());
        menu.addItem("Create WorldMap", new CreateWorldMapAction());

        while (true) {
            menu.show();
            menu.execute();


        }
    }
}
