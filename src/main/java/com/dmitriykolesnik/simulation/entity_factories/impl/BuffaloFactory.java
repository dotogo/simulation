package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores.Buffalo;
import com.dmitriykolesnik.simulation.entity_factories.NonPredatorFactory;


public class BuffaloFactory extends NonPredatorFactory<Buffalo> {

    public BuffaloFactory() {
        super(200, 280, 4, 6);
    }

    @Override
    protected Buffalo produce(int healthPoints, int speed) {
        return new Buffalo(healthPoints, speed);
    }
}


