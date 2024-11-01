package com.dmitriykolesnik.simulation.entities.static_entities;

import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.util.GameSettings;


public abstract class EdiblePlant extends Entity {
    private final int foodValue;

    public EdiblePlant(int foodValue) {
        if (GameSettings.checkEntitySettings(foodValue)) {
            this.foodValue = foodValue;
        } else {
            throw new IllegalArgumentException("foodValue must be > " + GameSettings.MIN_FOOD_VALUE +
                    " and <= " + GameSettings.MAX_FOOD_VALUE);
        }
    }

    public int getFoodValue() {
        return foodValue;
    }
}
