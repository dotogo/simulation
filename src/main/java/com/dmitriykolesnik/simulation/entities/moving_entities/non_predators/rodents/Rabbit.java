package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents;

import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForBigPredators;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForMediumPredators;
import com.dmitriykolesnik.simulation.entities.static_entities.FoodForRodents;


public class Rabbit extends Rodent implements PreyForMediumPredators, PreyForBigPredators {
    private static final int MAX_AVAILABLE_HEALTH_POINTS = 150;
    private static final int REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND = 10;
    private static final Class<?> TYPE_OF_FOOD = FoodForRodents.class;

    public Rabbit(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.RABBIT;
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
