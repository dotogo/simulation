package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.logger.MovementLogger;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.entities.static_entities.EdiblePlant;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import java.util.List;


public abstract class NonPredator extends Creature {
    public NonPredator(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

    @Override
    protected void handleFoundFood(WorldMap worldMap, Coordinates entityCoordinates, List<Coordinates> pathToTarget,
                                   Coordinates targetCoordinates, MovementLogger logger, boolean isLoggingEnabled) {
        eatFood(worldMap, entityCoordinates, pathToTarget, targetCoordinates, getMaxAvailableHealthPoints(), logger, isLoggingEnabled);
    }

    @Override
    protected void reduceHealthIfFoodNotFound() {
        this.setHealthPoints(this.getHealthPoints() - getReduceHealthPointsIfFoodNotFound());
    }

    protected void eatFood(WorldMap worldMap, Coordinates entityCoordinates, List<Coordinates> pathToTarget,
                         Coordinates targetCoordinates, int maxAvailablePredatorHealth, MovementLogger logger, boolean isPrintEnable) {
        EdiblePlant target = (EdiblePlant) worldMap.getEntity(targetCoordinates);
        int newHealthPoints = Math.min(this.getHealthPoints() + target.getFoodValue(), maxAvailablePredatorHealth);

        logger.printBeforeMeal(this, pathToTarget, target, isPrintEnable);
        this.setHealthPoints(newHealthPoints);
        worldMap.moveEntity(entityCoordinates, targetCoordinates);
        logger.printAfterMeal(this, isPrintEnable);
    }
}
