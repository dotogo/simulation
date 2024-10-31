package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Mouse;
import com.dmitriykolesnik.simulation.entity_factories.NonPredatorEntityFactory;


public class MouseFactory extends NonPredatorEntityFactory<Mouse> {

    public MouseFactory() {
        super(30, 55, 2 ,3);
    }

    @Override
    protected Mouse produce(int healthPoints, int speed) {
        return new Mouse(healthPoints, speed);
    }
}
