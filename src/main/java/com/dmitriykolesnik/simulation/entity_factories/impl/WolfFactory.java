package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Wolf;
import com.dmitriykolesnik.simulation.entity_factories.PredatorEntityFactory;


public class WolfFactory extends PredatorEntityFactory<Wolf> {

    public WolfFactory() {
        super(80, 100, 4, 5, 30, 70);
    }

    @Override
    protected Wolf produce(int healthPoints, int speed, int attackForce) {
        return new Wolf(healthPoints, speed, attackForce);
    }
}
