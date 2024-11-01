package com.dmitriykolesnik.simulation.entity_factories.impl;

import com.dmitriykolesnik.simulation.entities.moving_entities.predators.TyrannosaurusRex;
import com.dmitriykolesnik.simulation.entity_factories.PredatorFactory;


public class TyrannosaurusRexFactory extends PredatorFactory<TyrannosaurusRex> {

    public TyrannosaurusRexFactory() {
        super(400, 450, 6, 8, 240, 300);
    }

    @Override
    protected TyrannosaurusRex produce(int healthPoints, int speed, int attackForce) {
        return new TyrannosaurusRex(healthPoints, speed, attackForce);
    }
}


