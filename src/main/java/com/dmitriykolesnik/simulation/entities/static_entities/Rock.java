package com.dmitriykolesnik.simulation.entities.static_entities;

import com.dmitriykolesnik.simulation.entities.EntityType;


public class Rock extends NonEdibleEntity {

    @Override
    public EntityType getEntityType() {
        return EntityType.ROCK;
    }

}
