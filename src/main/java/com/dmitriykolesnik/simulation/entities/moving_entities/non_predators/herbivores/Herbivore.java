package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.NonPredator;
import com.dmitriykolesnik.simulation.entities.static_entities.FoodForHerbivores;

public abstract class Herbivore extends NonPredator {
    protected static final Class<?> TYPE_OF_FOOD = FoodForHerbivores.class;

    public Herbivore(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

    @Override
    protected Class<?> getTypeOfFood() {
        return TYPE_OF_FOOD;
    }

}
