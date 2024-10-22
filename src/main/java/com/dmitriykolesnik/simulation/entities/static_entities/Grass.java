package com.dmitriykolesnik.simulation.entities.static_entities;

import com.dmitriykolesnik.simulation.entities.EntityType;


public class Grass extends EdiblePlant implements FoodForHerbivores, FoodForRodents {

    public Grass(int foodValue) {
        super(foodValue);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.GRASS;
    }

}
