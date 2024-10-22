package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.NonPredator;

public abstract class Herbivore extends NonPredator {

    public Herbivore(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

}
