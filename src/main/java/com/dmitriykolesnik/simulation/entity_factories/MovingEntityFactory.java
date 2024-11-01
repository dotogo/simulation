package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.util.UtilSimulation;


public abstract class MovingEntityFactory<T extends Creature> implements EntityFactory<T> {
    private final int minHealthPoints;
    private final int maxHealthPoints;
    private final int minSpeed;
    private final int maxSpeed;

    protected MovingEntityFactory(int minHealthPoints, int maxHealthPoints, int minSpeed, int maxSpeed) {
        this.minHealthPoints = minHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public T create() {
        int healthPoints = UtilSimulation.getRandomNumberBetween(minHealthPoints, maxHealthPoints);
        int speed = UtilSimulation.getRandomNumberBetween(minSpeed, maxSpeed);
        return createEntity(healthPoints, speed);
    }

    protected abstract T createEntity(int healthPoints, int speed);
}




