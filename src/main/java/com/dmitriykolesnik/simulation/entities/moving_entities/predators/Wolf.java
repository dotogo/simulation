package com.dmitriykolesnik.simulation.entities.moving_entities.predators;

import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForMediumPredators;

public class Wolf extends Predator {
    private static final int MAX_AVAILABLE_HEALTH_POINTS = 200;
    private static final int REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND = 10;
    private static final Class<?> TYPE_OF_FOOD = PreyForMediumPredators.class;

    public Wolf(int healthPoints, int speed, int attackForce) {
        super(healthPoints, speed, attackForce);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.WOLF;
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
