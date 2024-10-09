package com.dmitriykolesnik.simulation.entities.moving_entities.predators;

import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entities.moving_entities.PreyForMediumPredators;


public class Wolf extends Predator {
    private static final int MAX_AVAILABLE_HEALTH_POINTS = 200;
    private static final int REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND = 10;
    private static final Class<?> TYPE_OF_FOOD = PreyForMediumPredators.class;

    public Wolf(int healthPoints, int speed, int attackForce) {
        super(healthPoints, speed, attackForce);
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


    @Override
    public EntityType getEntityType() {
        return EntityType.WOLF;
    }
}






//public class Wolf extends Predator {
//    private static final int MAX_AVAILABLE_HEALTH_POINTS = 200;
//    private static final int REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND = 10;
//    private static final Class<?> TYPE_OF_FOOD = PreyForMediumPredators.class;
//
//    public Wolf(int healthPoints, int speed, int attackForce) {
//        super(healthPoints, speed, attackForce);
//    }
//
//    @Override
//    public void makeMove(WorldMap worldMap) {
//        PathFinder pathFinder = new BreadthFirstSearch(worldMap);
//        Coordinates entityCoordinates = worldMap.getEntityCoordinates(this);
//        List<Coordinates> pathToTarget = pathFinder.find(entityCoordinates, this.getSpeed(), TYPE_OF_FOOD);
//        Coordinates targetCoordinates = pathToTarget.get(pathToTarget.size() - 1);
//        boolean isTargetFound = isFoodWasFound(worldMap, targetCoordinates, TYPE_OF_FOOD);
//
//        MovementLogger logger = new MovementLogger(worldMap);
//        boolean isPrintEnable = true;
//
//        if (isTargetFound) {
//            attackPrey(worldMap, entityCoordinates, pathToTarget, targetCoordinates, logger, isPrintEnable);
//            return;
//        }
//
//        // If no prey is found, reduce the predator's health
//        this.setHealthPoints(this.getHealthPoints() - REDUCE_HEALTH_POINTS_IF_FOOD_NOT_FOUND);
//        boolean isCreatureDied = this.getHealthPoints() <= 0;
//
//        removeDeadCreature(worldMap,isCreatureDied);
//        moveLivingCreature(worldMap, pathToTarget, entityCoordinates, isCreatureDied);
//
//        logger.printPreyNotFound(this, isCreatureDied, isPrintEnable);
//        logger.printCreatureDead(this, isCreatureDied, isPrintEnable);
//    }
//
//    private void attackPrey(WorldMap worldMap, Coordinates entityCoordinates, List<Coordinates> pathToTarget,
//                            Coordinates targetCoordinates, MovementLogger logger, boolean isPrintEnable) {
//        Creature prey = (Creature) worldMap.getEntity(targetCoordinates);
//
//        int newPreyHealthPoints = Math.max((prey.getHealthPoints() - this.getAttackForce()), 0);
//        int preyHealthPointsDecreased = prey.getHealthPoints() - newPreyHealthPoints;
//        int newPredatorHeathPoints = Math.min(this.getHealthPoints() + preyHealthPointsDecreased, MAX_AVAILABLE_HEALTH_POINTS);
//
//        logger.printBeforeAttack(this, pathToTarget, prey, isPrintEnable);
//
//        prey.setHealthPoints(newPreyHealthPoints);
//        this.setHealthPoints(newPredatorHeathPoints);
//
//        logger.printAfterAttack(this, prey, isPrintEnable);
//
//        // if prey was eaten
//        if (prey.getHealthPoints() <= 0) {
//            worldMap.moveEntity(entityCoordinates, targetCoordinates);
//
//            logger.printPreyEaten(this, prey, isPrintEnable);
//
//        } else {
//            // Prey is still alive. The predator must move to the cell closest to the prey.
//            moveCloseToPrey(worldMap, pathToTarget, entityCoordinates);
//            logger.printPreyStillAlive(prey, isPrintEnable);
//        }
//    }
//
//    @Override
//    public EntityType getEntityType() {
//        return EntityType.WOLF;
//    }
//}
