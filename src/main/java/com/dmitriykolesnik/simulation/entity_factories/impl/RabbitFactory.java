package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entity_factories.NonPredatorFactory;


public class RabbitFactory extends NonPredatorFactory<Rabbit> {

    public RabbitFactory() {
        super(60, 100, 4, 5);
    }

    @Override
    protected Rabbit produce(int healthPoints, int speed) {
        return new Rabbit(healthPoints, speed);
    }
}
