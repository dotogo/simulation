package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.exceptions.EntityNotCreatedException;
import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public abstract class StaticEntityFactory <T extends Entity> implements EntityFactory<T> {
    protected abstract int getMinFoodValue();

    protected abstract int getMaxFoodValue();

    @Override
    public T create() {
        int foodValue = UtilSimulation.getRandomNumberBetween(getMinFoodValue(), getMaxFoodValue());

        if (GameSettings.checkForGlobalSettings(foodValue)) {
            return produce(foodValue);
        } else {
            throw new EntityNotCreatedException("Entity creation failed");
        }
    }

    protected abstract T produce(int foodValue);
}
