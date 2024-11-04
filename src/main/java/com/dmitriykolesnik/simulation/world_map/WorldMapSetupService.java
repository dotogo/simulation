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
        int occupancyRate = getOccupancyRate(width, height, worldMapConfigurator);

        if (isDefaultEntitiesWillBePopulated(occupancyRate)) {
            worldMapFactory = new BasicWorldMapFactory(width, height);
        } else {
            worldMapFactory = new BasicWorldMapFactory(width, height, occupancyRate);
        }

        worldMap = worldMapFactory.create();
        isLoggingEnabled = false;
    }

    private int getOccupancyRate(int width, int height, WorldMapConfigurator worldMapConfigurator) {
        if (!GameSettings.isDefaultEntitiesAmount(width, height)) {
            worldMapConfigurator.setEntityOccupancyRate();
            return worldMapConfigurator.getOccupancyRate();
        }
        return 0;
    }

    private boolean isDefaultEntitiesWillBePopulated(int occupancyRate) {
        return occupancyRate == 0;
    }

}
