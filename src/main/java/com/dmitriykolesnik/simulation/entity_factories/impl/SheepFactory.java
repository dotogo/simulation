package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores.Sheep;
import com.dmitriykolesnik.simulation.entity_factories.NonPredatorFactory;


public class SheepFactory extends NonPredatorFactory<Sheep> {

    public SheepFactory() {
        super(130, 170, 3, 5);
    }

    @Override
    protected Sheep produce(int healthPoints, int speed) {
        return new Sheep(healthPoints, speed);
    }
}


