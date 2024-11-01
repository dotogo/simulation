package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.entities.static_entities.EdiblePlant;
import com.dmitriykolesnik.simulation.exceptions.EntityNotCreatedException;
import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public abstract class EdiblePlantFactory<T extends EdiblePlant> implements EntityFactory<T> {
    private final int minFoodValue;
    private final int maxFoodValue;

    protected EdiblePlantFactory(int minFoodValue, int maxFoodValue) {
        this.minFoodValue = minFoodValue;
        this.maxFoodValue = maxFoodValue;
    }

    @Override
    public T create() {
        int foodValue = UtilSimulation.getRandomNumberBetween(minFoodValue, maxFoodValue);

        if (GameSettings.checkForGlobalSettings(foodValue)) {
            return produce(foodValue);
        } else {
            throw new EntityNotCreatedException("Entity creation failed");
        }
    }

    protected abstract T produce(int foodValue);
}
