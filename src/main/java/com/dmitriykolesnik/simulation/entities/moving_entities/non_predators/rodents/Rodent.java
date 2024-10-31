package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.NonPredator;
import com.dmitriykolesnik.simulation.entities.static_entities.FoodForRodents;

public abstract class Rodent extends NonPredator {
    protected static final Class<?> TYPE_OF_FOOD = FoodForRodents.class;

    public Rodent(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

    @Override
    protected Class<?> getTypeOfFood() {
        return TYPE_OF_FOOD;
    }

}
