package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Cat;
import com.dmitriykolesnik.simulation.entity_factories.PredatorEntityFactory;


public class CatFactoryRandom extends PredatorEntityFactory<Cat> {
    private static final int MIN_HEALTH_POINTS = 55;
    private static final int MAX_HEALTH_POINTS = 75;
    private static final int MIN_SPEED = 2;
    private static final int MAX_SPEED = 3;
    private static final int MIN_ATTACK_FORCE = 5;
    private static final int MAX_ATTACK_FORCE = 10;

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
    protected int getMinAttackForce() {
        return MIN_ATTACK_FORCE;
    }

    @Override
    protected int getMaxAttackForce() {
        return MAX_ATTACK_FORCE;
    }

    @Override
    protected Cat produce(int healthPoints, int speed, int attackForce) {
        return new Cat(healthPoints, speed, attackForce);
    }
}


