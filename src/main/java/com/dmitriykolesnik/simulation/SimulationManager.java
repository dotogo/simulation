package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.menu.Menu;
import com.dmitriykolesnik.simulation.pathfinder.BreadthFirstSearch;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.world_map.*;

public class SimulationManager {
    private static final String SMALL_WORLD_ITEM = "Small World -> size 15x15 (Wolfs and Rabbits only, console logging enabled)";
    private static final String MEDIUM_WORLD_ITEM = "Basic World -> variable size (Wolfs, Rabbits, Cats, Mouses, logging disabled)";
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
        PathFinder pathFinder = new BreadthFirstSearch(worldMap);
        Simulation simulation = new Simulation(worldMap, pathFinder, isLoggingEnabled);
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

        int width = worldMapConfigurator.getWidth();
        int height = worldMapConfigurator.getHeight();
        int occupancyRate = 0;

        if (!GameSettings.isDefaultEntitiesAmount(width, height)) {
            worldMapConfigurator.setEntityOccupancyRate();
            occupancyRate = worldMapConfigurator.getOccupancyRate();
        }

        worldMapFactory = new BasicWorldMapFactory(width, height, occupancyRate);
        worldMap = worldMapFactory.create();
        isLoggingEnabled = false;
    }

//    private void createCustomWorldMap() {
//
//    }

}




