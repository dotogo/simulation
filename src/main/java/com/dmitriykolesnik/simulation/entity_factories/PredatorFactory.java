package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Predator;
import com.dmitriykolesnik.simulation.exceptions.EntityNotCreatedException;
import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public abstract class PredatorFactory<T extends Predator> implements EntityFactory <T> {
    private final int minHealthPoints;
    private final int maxHealthPoints;
    private final int minSpeed;
    private final int maxSpeed;
    private final int minAttackForce;
    private final int maxAttackForce;

    protected PredatorFactory(int minHealthPoints, int maxHealthPoints, int minSpeed,
                              int maxSpeed, int minAttackForce, int maxAttackForce) {
        this.minHealthPoints = minHealthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.minAttackForce = minAttackForce;
        this.maxAttackForce = maxAttackForce;
    }

    @Override
    public T create() {
        int healthPoints = UtilSimulation.getRandomNumberBetween(minHealthPoints, maxHealthPoints);
        int speed = UtilSimulation.getRandomNumberBetween(minSpeed, maxSpeed);
        int attackForce = UtilSimulation.getRandomNumberBetween(minAttackForce, maxAttackForce);

        if (GameSettings.checkForGlobalSettings(healthPoints, speed, attackForce)) {
            return produce(healthPoints, speed, attackForce);
        } else {
            throw new EntityNotCreatedException("Predator creation failed");
        }
    }

    protected abstract T produce(int healthPoints, int speed, int attackForce);
}
