package com.dmitriykolesnik.simulation.entities.moving_entities.predators;

import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForBigPredators;

public class TyrannosaurusRex extends Predator {
    private static final int MAX_AVAILABLE_HEALTH_POINTS = 500;
    private static final int REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND = 25;
    private static final Class<?> TYPE_OF_FOOD = PreyForBigPredators.class;

    public TyrannosaurusRex(int healthPoints, int speed, int attackForce) {
        super(healthPoints, speed, attackForce);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.T_REX;
    }

    @Override
    protected int getMaxAvailableHealthPoints() {
        return MAX_AVAILABLE_HEALTH_POINTS;
    }

    @Override
    protected int getReduceHealthPointsIfFoodNotFound() {
        return REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND;
    }

    @Override
    protected Class<?> getTypeOfFood() {
        return TYPE_OF_FOOD;
    }

}

