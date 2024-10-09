package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Wolf;
import com.dmitriykolesnik.simulation.entity_factories.PredatorEntityFactory;


public class WolfFactoryRandom extends PredatorEntityFactory<Wolf> {
    private static final int MIN_HEALTH_POINTS = 80;
    private static final int MAX_HEALTH_POINTS = 100;
    private static final int MIN_SPEED = 4;
    private static final int MAX_SPEED = 5;
    private static final int MIN_ATTACK_FORCE = 30;
    private static final int MAX_ATTACK_FORCE = 90;

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
    protected Wolf produce(int healthPoints, int speed, int attackForce) {
        return new Wolf(healthPoints, speed, attackForce);
    }
}
