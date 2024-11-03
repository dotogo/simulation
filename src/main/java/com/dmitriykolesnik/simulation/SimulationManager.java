package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.menu.MainMenu;
import com.dmitriykolesnik.simulation.pathfinder.BreadthFirstSearch;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.world_map.*;

public class SimulationManager {
    private final WorldMapSetupService worldMapSetupService = new WorldMapSetupService();
    private final MainMenu mainMenu = new MainMenu(worldMapSetupService);

    public void run() {
        mainMenu.show();
        mainMenu.execute();

        WorldMap worldMap = worldMapSetupService.getWorldMap();
        boolean isLoggingEnabled = worldMapSetupService.isLoggingEnabled();
        PathFinder pathFinder = new BreadthFirstSearch(worldMap);
        Simulation simulation = new Simulation(worldMap, pathFinder, isLoggingEnabled);
        simulation.start();
    }

}




