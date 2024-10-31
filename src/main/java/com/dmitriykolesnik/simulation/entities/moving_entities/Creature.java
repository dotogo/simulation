package com.dmitriykolesnik.simulation.entities.moving_entities;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.NonPredator;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Predator;
import com.dmitriykolesnik.simulation.logger.MovementLogger;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.List;


public abstract class Creature extends Entity {
    private int healthPoints;
    private int speed;

    public Creature(int healthPoints, int speed) {
        this.healthPoints = healthPoints;
        this.speed = speed;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void makeMove(WorldMap worldMap, PathFinder pathFinder, boolean isLoggingEnabled) {
        CreatureLifecycleManager creatureLifecycleManager = new CreatureLifecycleManager();
        MovementLogger logger = new MovementLogger(worldMap);

        Coordinates entityCoordinates = worldMap.getEntityCoordinates(this);
        List<Coordinates> pathToTarget = pathFinder.find(entityCoordinates, this.getSpeed(), getTypeOfFood());
        Coordinates targetCoordinates;

        if (!pathToTarget.isEmpty()) {
            targetCoordinates = pathToTarget.get(pathToTarget.size() - 1);
        } else {
            targetCoordinates = entityCoordinates;
        }

        boolean isTargetFound = creatureLifecycleManager.isFoodWasFound(worldMap, targetCoordinates, getTypeOfFood());

        if (isTargetFound) {
            handleFoundFood(worldMap, entityCoordinates, pathToTarget, targetCoordinates, logger, isLoggingEnabled);
        } else {
            reduceHealthIfFoodNotFound();
            boolean isCreatureDied = this.getHealthPoints() <= 0;
            creatureLifecycleManager.removeDeadCreature(worldMap, this, isCreatureDied);
            creatureLifecycleManager.moveLivingCreature(worldMap, pathToTarget, entityCoordinates, isCreatureDied);
            logger.printCreatureDead(this, isCreatureDied, isLoggingEnabled);

            if(this instanceof NonPredator) {
                logger.printFoodNotFound((NonPredator) this, isCreatureDied, isLoggingEnabled);
            } else {
                logger.printPreyNotFound((Predator) this, isCreatureDied, isLoggingEnabled);
            }
        }
    }

    protected abstract void handleFoundFood(WorldMap worldMap, Coordinates entityCoordinates, List<Coordinates> pathToTarget,
                                            Coordinates targetCoordinates, MovementLogger logger, boolean isLoggingEnabled);
    protected abstract void reduceHealthIfFoodNotFound();
    protected abstract int getMaxAvailableHealthPoints();
    protected abstract int getReduceHealthPointsIfFoodNotFound();
    protected abstract Class<?> getTypeOfFood();
}
