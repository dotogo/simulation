package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.menu.Menu;
import com.dmitriykolesnik.simulation.world_map.*;

public class SimulationManager {
    private final static String SMALL_WORLD_ITEM = "Small World (Wolfs and Rabbits only, console logging is enable)";
    private final static String MEDIUM_WORLD_ITEM = "Basic World (Wolfs, Rabbits, Cats, Mouses, console logging is not enable)";
    private final static String CUSTOM_WORLD_ITEM = "Custom WorldMap";
    private WorldMapFactory worldMapFactory;
    private WorldMap worldMap;
    private boolean isPrintLogging;

    Menu mainMenu = new Menu("Main menu", "Choose your World:", "Error. Try again");
    Menu gameMenu = new Menu("Simulation menu", "Make selection", "Error. Try again");

    {
        mainMenu.addItem(SMALL_WORLD_ITEM, this::createSmallWorldMap);
        mainMenu.addItem(MEDIUM_WORLD_ITEM, this::createBasicWorldMap);
        mainMenu.addItem(CUSTOM_WORLD_ITEM, this::createCustomWorldMap);
    }

    private void createSmallWorldMap() {
        worldMapFactory = new SmallWorldMapFactory();
        worldMap = worldMapFactory.create();
        isPrintLogging = true;
    }

    private void createBasicWorldMap() {
        WorldSizeSetter worldSizeSetter = new WorldSizeSetter();
        worldSizeSetter.perform();
        int horizontalSize = worldSizeSetter.getHorizontalSize();
        int verticalSize = worldSizeSetter.getVerticalSize();
        worldMapFactory = new BasicWorldMapFactory(horizontalSize, verticalSize);
        worldMap = worldMapFactory.create();
        isPrintLogging = false;
    }

    private void createCustomWorldMap() {

    }

    public void runSimulation() {
        mainMenu.show();
        mainMenu.execute();
        Simulation simulation = new Simulation(worldMap, isPrintLogging);
        simulation.start();
    }

}
