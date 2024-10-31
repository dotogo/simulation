package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Cat;
import com.dmitriykolesnik.simulation.entity_factories.PredatorEntityFactory;


public class CatFactory extends PredatorEntityFactory<Cat> {

    public CatFactory() {
        super(75, 95, 2, 4, 20, 40);
    }

    @Override
    protected Cat produce(int healthPoints, int speed, int attackForce) {
        return new Cat(healthPoints, speed, attackForce);
    }
}


