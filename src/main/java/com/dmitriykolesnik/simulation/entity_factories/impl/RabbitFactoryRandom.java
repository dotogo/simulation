package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entity_factories.NonPredatorEntityFactory;


public class RabbitFactoryRandom extends NonPredatorEntityFactory<Rabbit> {
    private static final int MIN_HEALTH_POINTS = 60;
    private static final int MAX_HEALTH_POINTS = 100;
    private static final int MIN_SPEED = 4;
    private static final int MAX_SPEED = 5;


    @Override
    protected int getMinHealthPoints() {
        return MIN_HEALTH_POINTS;
    }

    @Override
    protected int getMaxHealthPoints() {
        return MAX_HEALTH_POINTS;
    }

    @Override
    protected int getMinSpeed() {
        return MIN_SPEED;
    }

    @Override
    protected int getMaxSpeed() {
        return MAX_SPEED;
    }

    @Override
    protected Rabbit produce(int healthPoints, int speed) {
        return new Rabbit(healthPoints, speed);
    }
}
