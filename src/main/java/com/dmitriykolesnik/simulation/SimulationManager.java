package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.action.ActionsDataSingleton;
import com.dmitriykolesnik.simulation.action.SetWorldSizeAction;
import com.dmitriykolesnik.simulation.menu.Menu;
import com.dmitriykolesnik.simulation.world_map.SmallWorldMapFactory;
import com.dmitriykolesnik.simulation.world_map.WolfRabbitWorldMapFactory;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import com.dmitriykolesnik.simulation.world_map.WorldMapFactory;

public class SimulationManager {
    private final static String SMALL_WORLD_ITEM = "Small WorldMap (Wolfs and Rabbits only, console logging is enable)";
    private final static String MEDIUM_WORLD_ITEM = "Medium WorldMap (Wolfs, Rabbits, Cats, Mouses, console logging is not enable)";
    private final static String CUSTOM_WORLD_ITEM = "Custom WorldMap";
    private WorldMapFactory worldMapFactory;
    private WorldMap worldMap;
    private boolean isPrintLogging = true;

    Menu mainMenu = new Menu("Main menu", "Make selection", "Error. Try again");
    Menu gameMenu = new Menu("Simulation menu", "Make selection", "Error. Try again");

    {
        mainMenu.addItem(SMALL_WORLD_ITEM, () -> System.out.println("Action of Small WorldMap"));
        mainMenu.addItem(MEDIUM_WORLD_ITEM, () -> System.out.println("Action of Medium WorldMap"));
        mainMenu.addItem(CUSTOM_WORLD_ITEM, () -> System.out.println("Action of Custom WorldMap"));
    }


    private void createWorldMap() {
        int x_Size = ActionsDataSingleton.getInstance().getX_SizeWorldMap();
        int y_Size = ActionsDataSingleton.getInstance().getY_SizeWorldMap();
        //worldMapFactory = new WolfRabbitWorldMapFactory(x_Size, y_Size);
        worldMapFactory = new SmallWorldMapFactory();
        worldMap = worldMapFactory.create();
    }

    public void runSimulation() {
        new SetWorldSizeAction().perform();
        createWorldMap();
        Simulation simulation = new Simulation(worldMap, isPrintLogging);
        simulation.start();
    }

}
