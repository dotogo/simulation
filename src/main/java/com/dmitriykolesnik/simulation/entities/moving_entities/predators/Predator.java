package com.dmitriykolesnik.simulation.entities.moving_entities.predators;

import com.dmitriykolesnik.simulation.logger.MovementLogger;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.moving_entities.CreatureLifecycleManager;
import com.dmitriykolesnik.simulation.pathfinder.BreadthFirstSearch;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.List;

public abstract class Predator extends Creature {
    private final int attackForce;

    public Predator(int healthPoints, int speed, int attackForce) {
        super(healthPoints, speed);
        this.attackForce = attackForce;
    }

    public int getAttackForce() {
        return attackForce;
    }

    public void makeMove(WorldMap worldMap, boolean isLoggingEnabled) {
        PathFinder pathFinder = new BreadthFirstSearch(worldMap);
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
            attackPrey(worldMap, entityCoordinates, pathToTarget, targetCoordinates, logger, isLoggingEnabled);
            return;
        }

        // If no prey is found, reduce the predator's health
        this.setHealthPoints(this.getHealthPoints() - getReduceHealthPointsIfFoodNotFound());
        boolean isCreatureDied = this.getHealthPoints() <= 0;

        creatureLifecycleManager.removeDeadCreature(worldMap, this, isCreatureDied);
        creatureLifecycleManager.moveLivingCreature(worldMap, pathToTarget, entityCoordinates, isCreatureDied);

        logger.printPreyNotFound(this, isCreatureDied, isLoggingEnabled);
        logger.printCreatureDead(this, isCreatureDied, isLoggingEnabled);
    }

    protected void attackPrey(WorldMap worldMap, Coordinates entityCoordinates, List<Coordinates> pathToTarget,
                            Coordinates targetCoordinates, MovementLogger logger, boolean isPrintEnable) {
        Creature prey = (Creature) worldMap.getEntity(targetCoordinates);

        logger.printBeforeAttack(this, pathToTarget, prey, isPrintEnable);
        calculateHealthAfterAttack(prey, getMaxAvailableHealthPoints());
        logger.printAfterAttack(this, prey, isPrintEnable);

        // if prey was eaten
        if (prey.getHealthPoints() <= 0) {
            worldMap.moveEntity(entityCoordinates, targetCoordinates);
            logger.printPreyEaten(this, prey, isPrintEnable);
            return;
        }
        // Prey is still alive. The predator must move to the cell closest to the prey.
        moveCloseToPrey(worldMap, pathToTarget, entityCoordinates);
        logger.printPreyStillAlive(prey, isPrintEnable);
    }

    protected void moveCloseToPrey(WorldMap worldMap, List<Coordinates> pathToTarget, Coordinates entityCoordinates) {
        if (pathToTarget.size() >= 2) {
            Coordinates destination = pathToTarget.get(pathToTarget.size() - 2);
            worldMap.moveEntity(entityCoordinates, destination);
        }
    }

    private void calculateHealthAfterAttack(Creature prey, int maxHealth) {
        int newPreyHealthPoints = Math.max((prey.getHealthPoints() - this.getAttackForce()), 0);
        int preyHealthPointsDecreased = prey.getHealthPoints() - newPreyHealthPoints;
        int newPredatorHeathPoints = Math.min(this.getHealthPoints() + preyHealthPointsDecreased, maxHealth);

        prey.setHealthPoints(newPreyHealthPoints);
        this.setHealthPoints(newPredatorHeathPoints);
    }

}
