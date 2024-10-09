package com.dmitriykolesnik.simulation.entities.moving_entities.predators;

import com.dmitriykolesnik.simulation.MovementLogger;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.pathfinder.BreadthFirstSearch;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.List;

public abstract class Predator extends Creature {
    private int attackForce;

    public Predator(int healthPoints, int speed, int attackForce) {
        super(healthPoints, speed);
        this.attackForce = attackForce;
    }

    public Predator() {

    }

    public int getAttackForce() {
        return attackForce;
    }

    public void makeMove(WorldMap worldMap) {
        PathFinder pathFinder = new BreadthFirstSearch(worldMap);
        Coordinates entityCoordinates = worldMap.getEntityCoordinates(this);
        List<Coordinates> pathToTarget = pathFinder.find(entityCoordinates, this.getSpeed(), getTypeOfFood());
        Coordinates targetCoordinates = pathToTarget.get(pathToTarget.size() - 1);
        boolean isTargetFound = isFoodWasFound(worldMap, targetCoordinates, getTypeOfFood());

        MovementLogger logger = new MovementLogger(worldMap);
        boolean isPrintEnable = true;

        if (isTargetFound) {
            attackPrey(worldMap, entityCoordinates, pathToTarget, targetCoordinates, logger, isPrintEnable);
            return;
        }

        // If no prey is found, reduce the predator's health
        this.setHealthPoints(this.getHealthPoints() - getReduceHealthPointsIfFoodNotFound());
        boolean isCreatureDied = this.getHealthPoints() <= 0;

        removeDeadCreature(worldMap,isCreatureDied);
        moveLivingCreature(worldMap, pathToTarget, entityCoordinates, isCreatureDied);

        logger.printPreyNotFound(this, isCreatureDied, isPrintEnable);
        logger.printCreatureDead(this, isCreatureDied, isPrintEnable);
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

    private void calculateHealthAfterAttack(Creature prey, int maxHealth) {
        int newPreyHealthPoints = Math.max((prey.getHealthPoints() - this.getAttackForce()), 0);
        int preyHealthPointsDecreased = prey.getHealthPoints() - newPreyHealthPoints;
        int newPredatorHeathPoints = Math.min(this.getHealthPoints() + preyHealthPointsDecreased, maxHealth);

        prey.setHealthPoints(newPreyHealthPoints);
        this.setHealthPoints(newPredatorHeathPoints);
    }

    protected void moveCloseToPrey(WorldMap worldMap, List<Coordinates> pathToTarget, Coordinates entityCoordinates) {
        if (pathToTarget.size() >= 2) {
            Coordinates destination = pathToTarget.get(pathToTarget.size() - 2);
            worldMap.moveEntity(entityCoordinates, destination);
        }
    }
}
