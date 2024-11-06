package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.EntityFactoryRegistry;
import com.dmitriykolesnik.simulation.entities.EntitySelectionManager;
import com.dmitriykolesnik.simulation.menu.CustomWorldMenu;
import com.dmitriykolesnik.simulation.util.GameSettings;

import java.util.Map;

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

    public void createCustomWorldMap() {
        WorldMapConfigurator worldMapConfigurator = new WorldMapConfigurator();
        worldMapConfigurator.setSizes();

        int width = worldMapConfigurator.getWidth();
        int height = worldMapConfigurator.getHeight();
        int minNumberOfEntities = worldMapConfigurator.getMinAvailableNumberOfEntities();
        int maxNumberOfEntities = worldMapConfigurator.getMaxAvailableNumberOfEntities();

        Map<Class<? extends Entity>, Integer> entitiesCounter = getClassIntegerMap(minNumberOfEntities, maxNumberOfEntities);
        worldMapFactory = new CustomWorldMapFactory(width, height, entitiesCounter);

        worldMap = worldMapFactory.create();
        isLoggingEnabled = false;
    }

    private Map<Class<? extends Entity>, Integer> getClassIntegerMap(int minNumberOfEntities, int maxNumberOfEntities) {
        EntityFactoryRegistry entityFactoryRegistry = new EntityFactoryRegistry();
        EntitySelectionManager entitySelectionManager = new EntitySelectionManager(entityFactoryRegistry, minNumberOfEntities, maxNumberOfEntities);

        CustomWorldMenu customWorldMenu = new CustomWorldMenu(entitySelectionManager);

        while (!entitySelectionManager.isSelectionFinished()) {
            customWorldMenu.show();
            customWorldMenu.execute();
        }
        return entitySelectionManager.getEntityCounts();
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
