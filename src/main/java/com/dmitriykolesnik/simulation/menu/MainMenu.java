package com.dmitriykolesnik.simulation.menu;

import com.dmitriykolesnik.simulation.world_map.WorldMapSetupService;

public class MainMenu extends Menu {
    private static final String SMALL_WORLD_ITEM = "Small World -> size 15x15 (Wolfs and Rabbits only, console logging enabled)";
    private static final String BASIC_WORLD_ITEM = "Basic World -> variable size (Wolfs, Rabbits, Cats, Mouses, logging disabled)";

    public MainMenu(WorldMapSetupService worldMapSetupService) {
        super("Main menu", "Choose your World!", "Error. Try again");

        addItem(SMALL_WORLD_ITEM, worldMapSetupService::createSmallWorldMap);
        addItem(BASIC_WORLD_ITEM, worldMapSetupService::createBasicWorldMap);
    }
}
