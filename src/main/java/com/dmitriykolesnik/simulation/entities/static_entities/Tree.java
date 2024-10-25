package com.dmitriykolesnik.simulation.entities.static_entities;

import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.EntityType;


public class Tree extends NonEdibleEntity {

    @Override
    public EntityType getEntityType() {
        return EntityType.TREE;
    }

}
