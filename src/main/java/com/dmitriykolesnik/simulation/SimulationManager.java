package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.menu.Menu;
import com.dmitriykolesnik.simulation.world_map.*;

public class SimulationManager {
    private static final String SMALL_WORLD_ITEM = "Small World -> size 15x15 (Wolfs and Rabbits only, console logging enabled)";
    private static final String MEDIUM_WORLD_ITEM = "Basic World -> variable size (Wolfs, Rabbits, Cats, Mouses, logging disabled)";
    private static final int MAX_WORLD_MAP_AREA_FOR_USING_DEFAULT_ENTITIES_AMOUNT = 144;
    private WorldMapFactory worldMapFactory;
    private WorldMap worldMap;
    private boolean isLoggingEnabled;

    Menu mainMenu = new Menu("\nMain menu", "Choose your World!", "Error. Try again");

    {
        mainMenu.addItem(SMALL_WORLD_ITEM, this::createSmallWorldMap);
        mainMenu.addItem(MEDIUM_WORLD_ITEM, this::createBasicWorldMap);
    }

    public void run() {
        mainMenu.show();
        mainMenu.execute();
        Simulation simulation = new Simulation(worldMap, isLoggingEnabled);
        simulation.start();
    }

    private void createSmallWorldMap() {
        worldMapFactory = new SmallWorldMapFactory();
        worldMap = worldMapFactory.create();
        isLoggingEnabled = true;
    }

    private void createBasicWorldMap() {
        WorldMapConfigurator worldMapConfigurator = new WorldMapConfigurator();
        worldMapConfigurator.setSizes();
        worldMapConfigurator.setEntityOccupancyRate();

        int horizontalSize = worldMapConfigurator.getHorizontalSize();
        int verticalSize = worldMapConfigurator.getVerticalSize();
        int occupancyRate = 0;

        if (isUseNotDefaultEntitiesAmount(horizontalSize, verticalSize)) {
            occupancyRate = worldMapConfigurator.getOccupancyRate();
        }

        worldMapFactory = new BasicWorldMapFactory(horizontalSize, verticalSize, occupancyRate);
        worldMap = worldMapFactory.create();
        isLoggingEnabled = false;
    }

//    private void createCustomWorldMap() {
//
//    }

    private boolean isUseNotDefaultEntitiesAmount(int horizontalSize, int verticalSize) {
        return horizontalSize * verticalSize > MAX_WORLD_MAP_AREA_FOR_USING_DEFAULT_ENTITIES_AMOUNT;
    }

//    private void addItemsToCustomMenu() {
//        customWorldMenu.addItem(SET_WORLD_DIMENSIONS, );
//    }


}




/*
public class SimulationManager {
    private static final String SMALL_WORLD_ITEM = "Small World -> size 15x15 (Wolfs and Rabbits only, console logging enabled)";
    private static final String MEDIUM_WORLD_ITEM = "Basic World -> variable size (Wolfs, Rabbits, Cats, Mouses, logging disabled)";
    //private static final String CUSTOM_WORLD_ITEM = "Custom World -> ";

    //private static final String SET_WORLD_DIMENSIONS = "Lord, please set the dimensions of your World.";
    private static final int MAX_WORLD_MAP_AREA_FOR_USING_DEFAULT_ENTITIES_AMOUNT = 144;
    private WorldMapFactory worldMapFactory;
    private WorldMap worldMap;
    private boolean isLoggingEnabled;

    Menu mainMenu = new Menu("\nMain menu", "Choose your World!", "Error. Try again");
    //Menu customWorldMenu = new Menu("Custom World menu", "Make selection", "Error. Try again");

    {
        mainMenu.addItem(SMALL_WORLD_ITEM, this::createSmallWorldMap);
        mainMenu.addItem(MEDIUM_WORLD_ITEM, this::createBasicWorldMap);
        //mainMenu.addItem(CUSTOM_WORLD_ITEM, this::createCustomWorldMap);
    }

    public void run() {
        mainMenu.show();
        mainMenu.execute();
        Simulation simulation = new Simulation(worldMap, isLoggingEnabled);
        simulation.start();
    }

    private void createSmallWorldMap() {
        worldMapFactory = new SmallWorldMapFactory();
        worldMap = worldMapFactory.create();
        isLoggingEnabled = true;
    }

    private void createBasicWorldMap() {
        WorldMapConfigurator worldMapConfigurator = new WorldMapConfigurator();
        worldMapConfigurator.setSizes();
        worldMapConfigurator.setEntityOccupancyRate();

        int horizontalSize = worldMapConfigurator.getHorizontalSize();
        int verticalSize = worldMapConfigurator.getVerticalSize();
        int occupancyRate = 0;

        if (isUseNotDefaultEntitiesAmount(horizontalSize, verticalSize)) {
            occupancyRate = worldMapConfigurator.getOccupancyRate();
        }

        worldMapFactory = new BasicWorldMapFactory(horizontalSize, verticalSize, occupancyRate);
        worldMap = worldMapFactory.create();
        isLoggingEnabled = false;
    }

//    private void createCustomWorldMap() {
//
//    }

    private boolean isUseNotDefaultEntitiesAmount(int horizontalSize, int verticalSize) {
        return horizontalSize * verticalSize > MAX_WORLD_MAP_AREA_FOR_USING_DEFAULT_ENTITIES_AMOUNT;
    }

//    private void addItemsToCustomMenu() {
//        customWorldMenu.addItem(SET_WORLD_DIMENSIONS, );
//    }


}


*/

