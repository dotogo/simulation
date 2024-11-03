package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.util.GameSettings;

public class WorldMapSetupService {
    private WorldMapFactory worldMapFactory;
    private WorldMap worldMap;
    private boolean isLoggingEnabled;

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public boolean isLoggingEnabled() {
        return isLoggingEnabled;
    }

    public void createSmallWorldMap() {
        worldMapFactory = new SmallWorldMapFactory();
        worldMap = worldMapFactory.create();
        isLoggingEnabled = true;
    }

    public void createBasicWorldMap() {
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

}
