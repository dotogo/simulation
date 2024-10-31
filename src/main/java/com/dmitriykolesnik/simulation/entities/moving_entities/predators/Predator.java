package com.dmitriykolesnik.simulation.entities.moving_entities.predators;

import com.dmitriykolesnik.simulation.logger.MovementLogger;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.Coordinates;
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

    @Override
    protected void handleFoundFood(WorldMap worldMap, Coordinates entityCoordinates, List<Coordinates> pathToTarget,
                                   Coordinates targetCoordinates, MovementLogger logger, boolean isLoggingEnabled) {
        attackPrey(worldMap, entityCoordinates, pathToTarget, targetCoordinates, logger, isLoggingEnabled);
    }

    @Override
    protected void reduceHealthIfFoodNotFound() {
        this.setHealthPoints(this.getHealthPoints() - getReduceHealthPointsIfFoodNotFound());
    }

    protected void attackPrey(WorldMap worldMap, Coordinates entityCoordinates, List<Coordinates> pathToTarget,
                            Coordinates targetCoordinates, MovementLogger logger, boolean isPrintEnable) {
        Creature prey = (Creature) worldMap.getEntity(targetCoordinates);

        logger.printBeforeAttack(this, pathToTarget, prey, isPrintEnable);
        refreshHealthAfterAttack(prey, getMaxAvailableHealthPoints());
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

    private void refreshHealthAfterAttack(Creature prey, int maxHealth) {
        int newPreyHealthPoints = Math.max((prey.getHealthPoints() - this.getAttackForce()), 0);
        int preyHealthPointsDecreased = prey.getHealthPoints() - newPreyHealthPoints;
        int newPredatorHeathPoints = Math.min(this.getHealthPoints() + preyHealthPointsDecreased, maxHealth);

        prey.setHealthPoints(newPreyHealthPoints);
        this.setHealthPoints(newPredatorHeathPoints);
    }

}
