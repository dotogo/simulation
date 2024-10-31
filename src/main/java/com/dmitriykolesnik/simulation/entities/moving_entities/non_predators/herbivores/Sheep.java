package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores;

import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForBigPredators;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForMediumPredators;

public class Sheep extends Herbivore implements PreyForBigPredators, PreyForMediumPredators {
    private static final int MAX_AVAILABLE_HEALTH_POINTS = 200;
    private static final int REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND = 7;

    public Sheep(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.SHEEP;
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