package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.NonPredator;
import com.dmitriykolesnik.simulation.exceptions.EntityNotCreatedException;
import com.dmitriykolesnik.simulation.util.GameSettings;


public abstract class NonPredatorFactory<T extends NonPredator> extends MovingEntityFactory<T> {

    protected NonPredatorFactory(int minHealthPoints, int maxHealthPoints, int minSpeed, int maxSpeed) {
        super(minHealthPoints, maxHealthPoints, minSpeed, maxSpeed);
    }

    @Override
    protected T createEntity(int healthPoints, int speed) {
        if (GameSettings.checkEntitySettings(healthPoints, speed)) {
            return produce(healthPoints, speed);
        } else {
            throw new EntityNotCreatedException("NonPredator creation failed");
        }
    }

    protected abstract T produce(int healthPoints, int speed);
}
