package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.static_entities.Grain;
import com.dmitriykolesnik.simulation.entity_factories.EdiblePlantFactory;


public class GrainFactory extends EdiblePlantFactory<Grain> {

    public GrainFactory() {
        super(5, 20);
    }

    @Override
    protected Grain produce(int foodValue) {
        return new Grain(foodValue);
    }
}
