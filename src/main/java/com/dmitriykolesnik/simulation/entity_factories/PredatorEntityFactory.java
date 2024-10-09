package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.exceptions.EntityNotCreatedException;
import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public abstract class PredatorEntityFactory <T extends Creature> implements EntityFactory <T> {
    protected abstract int getMinHealthPoints();
    protected abstract int getMaxHealthPoints();
    protected abstract int getMinSpeed();
    protected abstract int getMaxSpeed();
    protected abstract int getMinAttackForce();
    protected abstract int getMaxAttackForce();

    @Override
    public T create () {
        int healthPoints = UtilSimulation.getRandomNumberBetween(getMinHealthPoints(), getMaxHealthPoints());
        int speed = UtilSimulation.getRandomNumberBetween(getMinSpeed(), getMaxSpeed());
        int attackForce = UtilSimulation.getRandomNumberBetween(getMinAttackForce(), getMaxAttackForce());

        if (GameSettings.checkForGlobalSettings(healthPoints, speed, attackForce)) {
            return produce(healthPoints, speed, attackForce);
        } else {
            throw new EntityNotCreatedException("Predator creation failed");
        }
    }

    protected abstract T produce(int healthPoints, int speed, int attackForce);
}
