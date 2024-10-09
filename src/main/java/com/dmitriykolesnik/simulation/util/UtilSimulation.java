package com.dmitriykolesnik.simulation.util;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.Random;

public class UtilSimulation {
    private static final Random RANDOM = new Random();

    public static int getRandomNumberBetween(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("min must be less than or equal to max");
        }

        return UtilSimulation.RANDOM.nextInt((max - min) + 1) + min;
    }

//    public static boolean isCreatureDiedAndRemoved(Creature creature, WorldMap worldMap) {
//        if (creature.getHealthPoints() <= 0) {
//            Coordinates coordinates = creature.getCoordinates();
//            worldMap.removeEntity(coordinates);
//            return true;
//
//        } else {
//            return false;
//        }
//    }



}
