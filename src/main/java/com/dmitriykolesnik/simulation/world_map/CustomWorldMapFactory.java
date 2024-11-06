package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.EntityFactoryRegistry;
import com.dmitriykolesnik.simulation.entities.static_entities.Rock;
import com.dmitriykolesnik.simulation.entities.static_entities.Tree;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CustomWorldMapFactory implements WorldMapFactory {
    private final int width;
    private final int height;
    private final Map<Class<? extends Entity>, Integer> entitiesCounter;
    private final EntityFactoryRegistry factoryRegistry = new EntityFactoryRegistry();

    public CustomWorldMapFactory(int width, int height, Map<Class<? extends Entity>, Integer> entitiesCounter) {
        this.width = width;
        this.height = height;
        this.entitiesCounter = entitiesCounter;
    }

    @Override
    public WorldMap create() {
        WorldMap worldMap = new WorldMap(width, height);
        List<Coordinates> allCoordinates = worldMap.getAllCoordinates();
        List<Entity> entities = populateEntities();

        Collections.shuffle(allCoordinates);
        for (int i = 0; i < entities.size(); i++) {
            worldMap.setEntity(allCoordinates.get(i), entities.get(i));
        }
        return worldMap;
    }

    private List<Entity> populateEntities() {
        List<Entity> allEntities = new ArrayList<>();

        entitiesCounter.forEach((entityClass, count) -> {
            EntityFactory<? extends Entity> factory = factoryRegistry.getFactoryMap().get(entityClass);

            if (factory != null) {
                for (int i = 0; i < count; i++) {
                    allEntities.add(factory.create());
                }

            } else if (entityClass == Tree.class || entityClass == Rock.class) {
                allEntities.addAll(Collections.nCopies(count, createStaticEntity(entityClass)));
            }
        });
        return allEntities;
    }

    private Entity createStaticEntity(Class<? extends Entity> entityClass) {
        return entityClass == Tree.class ? new Tree() : new Rock();
    }
}
