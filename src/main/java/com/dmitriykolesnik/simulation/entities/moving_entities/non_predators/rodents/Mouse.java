package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents;

import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForSmallPredators;

public class Mouse extends Rodent implements PreyForSmallPredators {
    private static final int MAX_AVAILABLE_HEALTH_POINTS = 80;
    private static final int REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND = 4;

    public Mouse(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.MOUSE;
    }

    @Override
    protected int getMaxAvailableHealthPoints() {
        return MAX_AVAILABLE_HEALTH_POINTS;
    }

    @Override
    protected int getReduceHealthPointsIfFoodNotFound() {
        return REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND;
    }

}

