package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entity_factories.NonPredatorEntityFactory;


public class RabbitFactory extends NonPredatorEntityFactory<Rabbit> {

    public RabbitFactory() {
        super(60, 100, 4, 5);
    }

    @Override
    protected Rabbit produce(int healthPoints, int speed) {
        return new Rabbit(healthPoints, speed);
    }
}
