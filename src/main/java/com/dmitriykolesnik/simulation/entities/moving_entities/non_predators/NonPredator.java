package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.MovementLogger;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.entities.static_entities.EdiblePlant;
import com.dmitriykolesnik.simulation.pathfinder.BreadthFirstSearch;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.List;

public abstract class NonPredator extends Creature {
    public NonPredator(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

    public NonPredator() {
    }

    @Override
    public void makeMove(WorldMap worldMap) {
        PathFinder pathFinder = new BreadthFirstSearch(worldMap);
        Coordinates entityCoordinates = worldMap.getEntityCoordinates(this);
        List<Coordinates> pathToTarget = pathFinder.find(entityCoordinates, this.getSpeed(), getTypeOfFood());
        Coordinates targetCoordinates = pathToTarget.get(pathToTarget.size() - 1);
        boolean isTargetFound = isFoodWasFound(worldMap, targetCoordinates, getTypeOfFood());

        MovementLogger logger = new MovementLogger(worldMap);
        boolean isPrintEnable = true;

        if (isTargetFound) {
            eatFood(worldMap, entityCoordinates, pathToTarget,targetCoordinates, getMaxAvailableHealthPoints(), logger, isPrintEnable);
            return;
        }

        // If no food is found, reduce the nonPredator's health
        this.setHealthPoints(this.getHealthPoints() - getReduceHealthPointsIfFoodNotFound());
        boolean isCreatureDied = this.getHealthPoints() <= 0;

        removeDeadCreature(worldMap, isCreatureDied);
        moveLivingCreature(worldMap, pathToTarget, entityCoordinates, isCreatureDied);

        logger.printCreatureDead(this, isCreatureDied, isPrintEnable);
        logger.printFoodNotFound(this, isCreatureDied, isPrintEnable);
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
