package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Lion;
import com.dmitriykolesnik.simulation.entity_factories.PredatorEntityFactory;


public class LionFactory extends PredatorEntityFactory<Lion> {

    public LionFactory() {
        super(290, 350, 5, 7, 200, 280);
    }

    @Override
    protected Lion produce(int healthPoints, int speed, int attackForce) {
        return new Lion(healthPoints, speed, attackForce);
    }
}


