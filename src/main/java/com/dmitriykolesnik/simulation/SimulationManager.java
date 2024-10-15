package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.action.ActionsDataSingleton;
import com.dmitriykolesnik.simulation.action.SetWorldSizeAction;
import com.dmitriykolesnik.simulation.menu.Menu;
import com.dmitriykolesnik.simulation.world_map.WolfRabbitWorldMapFactory;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import com.dmitriykolesnik.simulation.world_map.WorldMapFactory;

public class SimulationManager {
    private WorldMapFactory worldMapFactory;
    private WorldMap worldMap;
    private boolean isPrintLogging = true;

    Menu mainMenu = new Menu("Main menu", "Make selection", "Error. Try again");
    Menu gameMenu = new Menu("Simulation menu", "Make selection", "Error. Try again");


    private void createWorldMap() {
        int x_Size = ActionsDataSingleton.getInstance().getX_SizeWorldMap();
        int y_Size = ActionsDataSingleton.getInstance().getY_SizeWorldMap();
        worldMapFactory = new WolfRabbitWorldMapFactory(x_Size, y_Size);
        worldMap = worldMapFactory.create();
    }

    public void runSimulation() {
        new SetWorldSizeAction().perform();
        createWorldMap();
        Simulation simulation = new Simulation(worldMap, isPrintLogging);
        simulation.start();
    }

}
