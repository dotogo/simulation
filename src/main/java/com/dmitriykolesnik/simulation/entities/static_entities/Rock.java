package com.dmitriykolesnik.simulation.entities.static_entities;

import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.EntityType;

public class Rock extends Entity {

    @Override
    public EntityType getEntityType() {
        return EntityType.ROCK;
    }
}
