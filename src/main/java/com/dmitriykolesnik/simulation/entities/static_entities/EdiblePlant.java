package com.dmitriykolesnik.simulation.entities.static_entities;

import com.dmitriykolesnik.simulation.entities.Entity;


public abstract class EdiblePlant extends Entity {
    private final int foodValue;

    public EdiblePlant(int foodValue) {
        if (foodValue > 0 && foodValue <= 100) {
            this.foodValue = foodValue;
        } else {
            throw new IllegalArgumentException("foodValue must be > 0 and <= 100");
        }
    }

    public int getFoodValue() {
        return foodValue;
    }
}
