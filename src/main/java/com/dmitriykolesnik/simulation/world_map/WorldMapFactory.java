package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;

import java.util.ArrayList;
import java.util.List;

public interface WorldMapFactory {


    WorldMap create();

    default List<Entity> getEntitiesToBePopulated(EntityFactory<? extends Entity> entityFactory, int amount) {
        List<Entity> entities = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Entity entity = entityFactory.create();
            entities.add(entity);
        }
        return entities;
    }

    default List<Entity> getEntitiesToBePopulated(Entity entity, int amount) {
        List<Entity> entities = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            entities.add(entity);
        }
        return entities;
    }
}
