package com.dmitriykolesnik.simulation.entities.moving_entities.non_predators;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.logger.MovementLogger;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.entities.moving_entities.CreatureLifecycleManager;
import com.dmitriykolesnik.simulation.entities.static_entities.EdiblePlant;
import com.dmitriykolesnik.simulation.pathfinder.BreadthFirstSearch;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import java.util.List;


public abstract class NonPredator extends Creature {
    public NonPredator(int healthPoints, int speed) {
        super(healthPoints, speed);
    }

    @Override
    public void makeMove(WorldMap worldMap, boolean isLoggingEnabled) {
        PathFinder pathFinder = new BreadthFirstSearch(worldMap);
        CreatureLifecycleManager creatureLifecycleManager = new CreatureLifecycleManager();

        Coordinates entityCoordinates = worldMap.getEntityCoordinates(this);
        List<Coordinates> pathToTarget = pathFinder.find(entityCoordinates, this.getSpeed(), getTypeOfFood());
        Coordinates targetCoordinates = pathToTarget.get(pathToTarget.size() - 1);
        boolean isTargetFound = creatureLifecycleManager.isFoodWasFound(worldMap, targetCoordinates, getTypeOfFood());

        MovementLogger logger = new MovementLogger(worldMap);

        if (isTargetFound) {
            eatFood(worldMap, entityCoordinates, pathToTarget,targetCoordinates, getMaxAvailableHealthPoints(), logger, isLoggingEnabled);
            return;
        }

        // If no food is found, reduce the nonPredator's health
        this.setHealthPoints(this.getHealthPoints() - getReduceHealthPointsIfFoodNotFound());
        boolean isCreatureDied = this.getHealthPoints() <= 0;

        creatureLifecycleManager.removeDeadCreature(worldMap, this,  isCreatureDied);
        creatureLifecycleManager.moveLivingCreature(worldMap, pathToTarget, entityCoordinates, isCreatureDied);

        logger.printCreatureDead(this, isCreatureDied, isLoggingEnabled);
        logger.printFoodNotFound(this, isCreatureDied, isLoggingEnabled);
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
