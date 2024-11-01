package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores.Zebra;
import com.dmitriykolesnik.simulation.entity_factories.NonPredatorFactory;


public class ZebraFactory extends NonPredatorFactory<Zebra> {

    public ZebraFactory() {
        super(175, 225, 5, 8);
    }

    @Override
    protected Zebra produce(int healthPoints, int speed) {
        return new Zebra(healthPoints, speed);
    }
}


