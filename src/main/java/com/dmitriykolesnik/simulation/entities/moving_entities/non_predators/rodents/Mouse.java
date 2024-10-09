package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents;

import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForSmallPredators;
import com.dmitriykolesnik.simulation.entities.static_entities.FoodForRodents;

public class Mouse extends Rabbit implements PreyForSmallPredators {
    private static final int MAX_AVAILABLE_HEALTH_POINTS = 80;
    private static final int REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND = 4;
    private static final Class<?> TYPE_OF_FOOD = FoodForRodents.class;

    public Mouse(int healthPoints, int speed) {
        super(healthPoints, speed);
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

    @Override
    public EntityType getEntityType() {
        return EntityType.MOUSE;
    }
}

