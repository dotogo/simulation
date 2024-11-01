package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.entity_factories.EdiblePlantFactory;


public class GrassFactory extends EdiblePlantFactory<Grass> {

    public GrassFactory() {
        super(10, 40);
    }

    @Override
    protected Grass produce(int foodValue) {
        return new Grass(foodValue);
    }
}
