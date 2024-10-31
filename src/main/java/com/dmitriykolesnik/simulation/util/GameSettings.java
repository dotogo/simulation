package com.dmitriykolesnik.simulation.util;


public class GameSettings {
    private static final int MIN_HEALTH_POINTS = 0;
    private static final int MAX_HEALTH_POINTS = 100;
    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 10;
    private static final int MIX_ATTACK_FORCE = 5;
    private static final int MAX_ATTACK_FORCE = 500;

    public static final int MIN_HORIZONTAL_WORLD_SIZE = 10;
    public static final int MAX_HORIZONTAL_WORLD_SIZE = 50;
    public static final int MIN_VERTICAL_WORLD_SIZE = 10;
    public static final int MAX_VERTICAL_WORLD_SIZE = 35;
    public static final int MIN_OCCUPANCY_RATE = 5;
    public static final int MAX_OCCUPANCY_RATE = 30;
    public static final int MIN_FOOD_VALUE = 5;
    public static final int MAX_FOOD_VALUE = 50;


    public static boolean checkForGlobalSettings(int healthPoints, int speed, int attackForce) {
        boolean checkHealthPoints = healthPoints >= MIN_HEALTH_POINTS && healthPoints <= MAX_HEALTH_POINTS;
        boolean checkSpeed = speed >= MIN_SPEED && speed <= MAX_SPEED;
        boolean checkAttack = attackForce >= MIX_ATTACK_FORCE && attackForce <= MAX_ATTACK_FORCE;

        return checkHealthPoints && checkSpeed && checkAttack;
    }

    public static boolean checkForGlobalSettings(int healthPoints, int speed) {
        boolean checkHealthPoints = healthPoints >= MIN_HEALTH_POINTS && healthPoints <= MAX_HEALTH_POINTS;
        boolean checkSpeed = speed >= MIN_SPEED && speed <= MAX_SPEED;
        return checkHealthPoints && checkSpeed;
    }

    public static boolean checkForGlobalSettings(int foodValue) {
        return foodValue >= MIN_FOOD_VALUE && foodValue <= MAX_FOOD_VALUE;
    }

}
