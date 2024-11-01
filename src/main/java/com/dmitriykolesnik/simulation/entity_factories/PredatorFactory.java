package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Predator;
import com.dmitriykolesnik.simulation.exceptions.EntityNotCreatedException;
import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public abstract class PredatorFactory<T extends Predator> extends MovingEntityFactory<T> {
    private final int minAttackForce;
    private final int maxAttackForce;

    protected PredatorFactory(int minHealthPoints, int maxHealthPoints, int minSpeed,
                              int maxSpeed, int minAttackForce, int maxAttackForce) {
        super(minHealthPoints, maxHealthPoints, minSpeed, maxSpeed);
        this.minAttackForce = minAttackForce;
        this.maxAttackForce = maxAttackForce;
    }

    @Override
    protected T createEntity(int healthPoints, int speed) {
        int attackForce = UtilSimulation.getRandomNumberBetween(minAttackForce, maxAttackForce);

        if (GameSettings.checkForGlobalSettings(healthPoints, speed, attackForce)) {
            return produce(healthPoints, speed, attackForce);
        } else {
            throw new EntityNotCreatedException("Predator creation failed");
        }

    }

    protected abstract T produce(int healthPoints, int speed, int attackForce);
}
