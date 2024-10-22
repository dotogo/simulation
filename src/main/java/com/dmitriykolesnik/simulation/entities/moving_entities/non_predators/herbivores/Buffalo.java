package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores;

import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForBigPredators;
import com.dmitriykolesnik.simulation.entities.static_entities.FoodForHerbivores;


public class Buffalo extends Herbivore implements PreyForBigPredators {
    private static final int MAX_AVAILABLE_HEALTH_POINTS = 300;
    private static final int REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND = 15;
    private static final Class<?> TYPE_OF_FOOD = FoodForHerbivores.class;

    public Buffalo(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.BUFFALO;
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



