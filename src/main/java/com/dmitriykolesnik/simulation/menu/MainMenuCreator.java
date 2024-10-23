package com.dmitriykolesnik.simulation.menu;

import com.dmitriykolesnik.simulation.SimulationManager;

public class MainMenuCreator {
    private static final String SMALL_WORLD_ITEM = "Small World -> size 15x15 (Wolfs and Rabbits only, console logging enabled)";
    private static final String MEDIUM_WORLD_ITEM = "Basic World -> variable size (Wolfs, Rabbits, Cats, Mouses, logging disabled)";
    private static final String MAIN_MENU = "\nMain menu";

    private Menu mainMenu = new Menu("\nMain menu", "Choose your World!", "Error. Try again");

//    {
//        mainMenu.addItem(SMALL_WORLD_ITEM, SimulationManager::createSmallWorldMap);
//        mainMenu.addItem(MEDIUM_WORLD_ITEM, this::createBasicWorldMap);
//    }


}
