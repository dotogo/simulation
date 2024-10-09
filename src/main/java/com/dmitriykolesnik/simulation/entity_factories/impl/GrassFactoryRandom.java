package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.entity_factories.StaticEntityFactory;


public class GrassFactoryRandom extends StaticEntityFactory<Grass> {
    private static final int MIN_FOOD_VALUE = 10;
    private static final int MAX_FOOD_VALUE = 40;


    @Override
    protected int getMinFoodValue() {
        return MIN_FOOD_VALUE;
    }

    @Override
    protected int getMaxFoodValue() {
        return MAX_FOOD_VALUE;
    }

    @Override
    protected Grass produce(int foodValue) {
        return new Grass(foodValue);
    }
}
