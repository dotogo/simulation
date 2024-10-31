package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores.Zebra;
import com.dmitriykolesnik.simulation.entity_factories.NonPredatorEntityFactory;


public class ZebraFactory extends NonPredatorEntityFactory<Zebra> {

    public ZebraFactory() {
        super(175, 225, 5, 8);
    }

    @Override
    protected Zebra produce(int healthPoints, int speed) {
        return new Zebra(healthPoints, speed);
    }
}


