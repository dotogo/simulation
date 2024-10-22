package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.menu.Menu;
import com.dmitriykolesnik.simulation.world_map.*;

public class SimulationManager {
    private final static String SMALL_WORLD_ITEM = "Small World -> size 15x15 (Wolfs and Rabbits only, console logging enabled)";
    private final static String MEDIUM_WORLD_ITEM = "Basic World -> variable size (Wolfs, Rabbits, Cats, Mouses, logging disabled)";
    private final static String CUSTOM_WORLD_ITEM = "Custom World -> ";
    private WorldMapFactory worldMapFactory;
    private WorldMap worldMap;
    private boolean isPrintLogging;

    Menu mainMenu = new Menu("\nMain menu", "Choose your World!", "Error. Try again");
    Menu gameMenu = new Menu("Simulation menu", "Make selection", "Error. Try again");

    {
        mainMenu.addItem(SMALL_WORLD_ITEM, this::createSmallWorldMap);
        mainMenu.addItem(MEDIUM_WORLD_ITEM, this::createBasicWorldMap);
        mainMenu.addItem(CUSTOM_WORLD_ITEM, this::createCustomWorldMap);
    }

    public void runSimulation() {
        mainMenu.show();
        mainMenu.execute();
        Simulation simulation = new Simulation(worldMap, isPrintLogging);
        simulation.start();
    }

    private void createSmallWorldMap() {
        worldMapFactory = new SmallWorldMapFactory();
        worldMap = worldMapFactory.create();
        isPrintLogging = true;
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
        isPrintLogging = false;
    }

    private void createCustomWorldMap() {

    }

    private boolean isUseNotDefaultEntitiesAmount(int horizontalSize, int verticalSize) {
        return horizontalSize * verticalSize > 144;
    }



}
