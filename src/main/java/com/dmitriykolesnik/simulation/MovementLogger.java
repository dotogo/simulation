package com.dmitriykolesnik.simulation;

import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.NonPredator;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Predator;
import com.dmitriykolesnik.simulation.entities.static_entities.EdiblePlant;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.List;

public class MovementLogger {
    private final static String SPACE = "   ";
    private final static String FORCE = "   Attack Force: ";
    private final static String SPEED = "   Speed: ";
    private final static String COORDINATES = " Coordinates: ";
    private final static String HEALTH = " Health Points: ";
    private final static String ID = " ID: ";
    private final static String FOOD_VALUE = " Food Value ";
    private WorldMap worldMap;

    public MovementLogger(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void printBeforeAttack(Predator predator, List<Coordinates> pathToPrey,
                                   Creature prey, boolean isPrintEnable) {
        Coordinates predatorCoordinates = worldMap.getEntityCoordinates(predator);
        Coordinates preyCoordinates = worldMap.getEntityCoordinates(prey);

        if (isPrintEnable) {
            String predatorClassName = predator.getClass().getSimpleName();
            String preyClassName = prey.getClass().getSimpleName();

            System.out.println("\nBefore attack: \n" +
                    SPACE + predatorClassName + COORDINATES + predatorCoordinates + SPACE +
                    SPACE + predatorClassName + ID + predator.getId() + SPACE + FORCE + predator.getAttackForce() +
                    SPACE + SPEED + predator.getSpeed() + SPACE +
                    SPACE + predatorClassName + HEALTH + predator.getHealthPoints() + "\n" +
                    SPACE + preyClassName + COORDINATES + preyCoordinates + SPACE +
                    SPACE + preyClassName + ID + prey.getId() + SPACE +
                    SPACE+ preyClassName + HEALTH + prey.getHealthPoints() + "\n");

            System.out.print("Path to " + preyClassName + ": ");
            pathToPrey.forEach(e -> System.out.print(e + "  "));
            System.out.println();
        }
    }

    public void printAfterAttack(Predator predator, Creature prey, boolean isPrintEnable) {
        if (isPrintEnable) {
            String predatorClassName = predator.getClass().getSimpleName();
            String preyClassName = prey.getClass().getSimpleName();

            System.out.println("\nAfter attack: \n" +
                    SPACE + preyClassName + HEALTH + prey.getHealthPoints() + SPACE +
                    SPACE + predatorClassName + HEALTH + predator.getHealthPoints() + "\n");
        }
    }

    public void printPreyEaten(Predator predator, Creature prey, boolean isPrintEnable) {
        Coordinates predatorCoordinates = worldMap.getEntityCoordinates(predator);
        if (isPrintEnable) {
            String predatorClassName = predator.getClass().getSimpleName();
            String preyClassName = prey.getClass().getSimpleName();

            System.out.println("- - - " + preyClassName + " was eaten - - -\n\n" +
                    SPACE + predatorClassName + COORDINATES + predatorCoordinates + SPACE +
                    SPACE + predatorClassName + ID + predator.getId() + "\n"
            );
            System.out.println();
        }
    }

    public void printPreyNotFound(Predator predator, boolean isCreatureDied, boolean isPrintEnable) {
        if (isCreatureDied) {
            return;
        }

        Coordinates predatorCoordinates = worldMap.getEntityCoordinates(predator);
        if (isPrintEnable) {

            String predatorClassName = predator.getClass().getSimpleName();

            System.out.println("Prey is not found, health decreased  \n" +
                    SPACE + predatorClassName + COORDINATES + predatorCoordinates + SPACE +
                    SPACE + predatorClassName + ID + predator.getId() + SPACE +
                    SPACE + predatorClassName + HEALTH + predator.getHealthPoints() + "\n");
        }

    }

    public void printPreyStillAlive(Creature prey, boolean isPrintEnable) {
        if (isPrintEnable) {

            String preyClassName = prey.getClass().getSimpleName();
            System.out.println(" <<< " + preyClassName + " is still alive >>> \n" );
        }
    }

    public void printBeforeMeal(NonPredator nonPredator, List<Coordinates> pathToTarget,
                                EdiblePlant target, boolean isPrintEnable) {
        Coordinates nonPredatorCoordinates = worldMap.getEntityCoordinates(nonPredator);
        Coordinates targetCoordinates = worldMap.getEntityCoordinates(target);

        if (isPrintEnable) {

            String nonPredatorClassName = nonPredator.getClass().getSimpleName();
            String ediblePlantClassName = target.getClass().getSimpleName();

            System.out.println("\nBefore meal: \n" +
                    SPACE + nonPredatorClassName + COORDINATES + nonPredatorCoordinates + SPACE +
                    SPACE + nonPredatorClassName + ID + nonPredator.getId() + SPACE +
                    SPACE + SPEED + nonPredator.getSpeed() + SPACE +
                    SPACE + nonPredatorClassName + HEALTH + nonPredator.getHealthPoints() + "\n" +
                    SPACE + ediblePlantClassName + COORDINATES + targetCoordinates + SPACE +
                    SPACE + ediblePlantClassName + ID + target.getId() + SPACE +
                    SPACE + ediblePlantClassName + FOOD_VALUE + target.getFoodValue() + "\n");

            System.out.print("Path to " + ediblePlantClassName + ": ");
            pathToTarget.forEach(e -> System.out.print(e + "  "));
            System.out.println();
        }
    }

    public void printAfterMeal(NonPredator nonPredator, boolean isPrintEnable) {
        Coordinates nonPredatorCoordinates = worldMap.getEntityCoordinates(nonPredator);

        if (isPrintEnable) {
            String nonPredatorClassName = nonPredator.getClass().getSimpleName();
            System.out.println("\nAfter meal: \n" +
                    SPACE + nonPredatorClassName + HEALTH + nonPredator.getHealthPoints() + "\n" +
                    SPACE + nonPredatorClassName + COORDINATES + nonPredatorCoordinates + "\n");
        }
    }

    public void printFoodNotFound(NonPredator nonPredator, boolean isCreatureDied, boolean isPrintEnable) {
        if (isCreatureDied) {
            return;
        }

        Coordinates nonPredatorCoordinates = worldMap.getEntityCoordinates(nonPredator);
        if (isPrintEnable) {

            String nonPredatorClassName = nonPredator.getClass().getSimpleName();
            System.out.println("Food is not found, health decreased  \n" +
                    SPACE + nonPredatorClassName + COORDINATES + nonPredatorCoordinates + SPACE +
                    SPACE + nonPredatorClassName + ID + nonPredator.getId() + SPACE +
                    SPACE + nonPredatorClassName + HEALTH + nonPredator.getHealthPoints() + "\n");
        }
    }

    public void printCreatureDead(Creature creature, boolean isCreatureDied, boolean isPrintEnable) {
        if (isCreatureDied) {
            String creatureClassName = creature.getClass().getSimpleName();
            System.out.println("No food was found, that's the end. \n" +
                    creatureClassName + ID + creature.getId() + " is dead. \n");
        }
    }
}
