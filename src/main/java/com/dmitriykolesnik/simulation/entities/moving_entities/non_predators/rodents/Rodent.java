package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.NonPredator;

public abstract class Rodent extends NonPredator {
    public Rodent(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

}
