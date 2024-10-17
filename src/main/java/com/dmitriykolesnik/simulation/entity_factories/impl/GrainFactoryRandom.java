package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.static_entities.Grain;
import com.dmitriykolesnik.simulation.entity_factories.StaticEntityFactory;

public class GrainFactoryRandom extends StaticEntityFactory<Grain> {
    private static final int MIN_FOOD_VALUE = 5;
    private static final int MAX_FOOD_VALUE = 20;

    @Override
    protected int getMinFoodValue() {
        return MIN_FOOD_VALUE;
    }

    @Override
    protected int getMaxFoodValue() {
        return MAX_FOOD_VALUE;
    }

    @Override
    protected Grain produce(int foodValue) {
        return new Grain(foodValue);
    }
}
