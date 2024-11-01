package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.NonPredator;
import com.dmitriykolesnik.simulation.exceptions.EntityNotCreatedException;
import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public abstract class NonPredatorFactory<T extends NonPredator> implements EntityFactory <T> {
    private final int minHealthPoints;
    private final int maxHealthPoints;
    private final int minSpeed;
    private final int maxSpeed;

    protected NonPredatorFactory(int minHealthPoints, int maxHealthPoints, int minSpeed, int maxSpeed) {
        this.minHealthPoints = minHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public T create() {
        int healthPoints = UtilSimulation.getRandomNumberBetween(minHealthPoints, maxHealthPoints);
        int speed = UtilSimulation.getRandomNumberBetween(minSpeed, maxSpeed);

        if (GameSettings.checkForGlobalSettings(healthPoints, speed)) {
            return produce(healthPoints, speed);
        } else {
            throw new EntityNotCreatedException("NonPredator creation failed");
        }
    }

    protected abstract T produce(int healthPoints, int speed);
}
