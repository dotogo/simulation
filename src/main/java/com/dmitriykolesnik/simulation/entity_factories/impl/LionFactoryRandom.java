package com.dmitriykolesnik.simulation.entity_factories.impl;
/*
import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Lion;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;
import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public class LionFactoryRandom implements EntityFactory<Lion> {
    private static final int MIN_HEALTH_POINTS = 80;
    private static final int MAX_HEALTH_POINTS = 100;
    private static final int MIN_SPEED = 4;
    private static final int MAX_SPEED = 5;
    private static final int MIN_ATTACK_FORCE = 5;
    private static final int MAX_ATTACK_FORCE = 10;

    @Override
    public Lion create(Coordinates coordinates) {
        int healthPoints = UtilSimulation.getRandomNumberBetween(MIN_HEALTH_POINTS, MAX_HEALTH_POINTS);
        int speed = UtilSimulation.getRandomNumberBetween(MIN_SPEED, MAX_SPEED);
        int attackForce = UtilSimulation.getRandomNumberBetween(MIN_ATTACK_FORCE, MAX_ATTACK_FORCE);

        if (GameSettings.checkForGlobalSettings(healthPoints, speed, attackForce)) {
            return new Lion(coordinates, healthPoints, speed, attackForce);
        } else {
            throw new IllegalArgumentException("Lion entity creation failed");
        }


    }
}

 */
