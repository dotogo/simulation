package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.exceptions.EntityNotCreatedException;
import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public abstract class NonPredatorEntityFactory <T extends Creature> implements EntityFactory<T> {
    protected abstract int getMinHealthPoints();
    protected abstract int getMaxHealthPoints();
    protected abstract int getMinSpeed();
    protected abstract int getMaxSpeed();

    @Override
    public T create() {
        int healthPoints = UtilSimulation.getRandomNumberBetween(getMinHealthPoints(), getMaxHealthPoints());
        int speed = UtilSimulation.getRandomNumberBetween(getMinSpeed(), getMaxSpeed());

        if (GameSettings.checkForGlobalSettings(healthPoints, speed)) {
            return produce(healthPoints, speed);
        } else {
            throw new EntityNotCreatedException("NonPredator creation failed");
        }
    }

    protected abstract T produce(int healthPoints, int speed);
}
