package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.menu.Menu;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import com.dmitriykolesnik.simulation.world_map.WorldMapFactory;

public class SimulationManager {
    WorldMapFactory worldMapFactory;
    WorldMap worldMap;

    Menu mainMenu = new Menu("Main menu", "Make selection", "Error. Try again");
    Menu gameMenu = new Menu("Simulation menu", "Make selection", "Error. Try again");

}
