package com.dmitriykolesnik.simulation.entities.static_entities;

import com.dmitriykolesnik.simulation.entities.EntityType;


public class Grain extends EdiblePlant implements FoodForRodents {

    public Grain(int foodValue) {
        super(foodValue);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.GRAIN;
    }

}
