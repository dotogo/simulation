package com.dmitriykolesnik.simulation.util;


public class GameSettings {
    private static final int MIN_HEALTH_POINTS = 0;
    private static final int MAX_HEALTH_POINTS = 100;
    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 10;
    private static final int MIX_ATTACK_FORCE = 5;
    private static final int MAX_ATTACK_FORCE = 500;

    public static final int MIN_WIDTH_OF_WORLD = 10;
    public static final int MAX_WIDTH_OF_WORLD = 50;
    public static final int MIN_HEIGHT_OF_WORLD = 10;
    public static final int MAX_HEIGHT_OF_WORLD = 35;
    public static final int MIN_OCCUPANCY_RATE = 5;
    public static final int MAX_OCCUPANCY_RATE = 30;
    public static final int MIN_FOOD_VALUE = 5;
    public static final int MAX_FOOD_VALUE = 50;
    public static final int MAX_WORLD_AREA_TO_USE_DEFAULT_ENTITIES_AMOUNT = 144;

    public static boolean checkEntitySettings(int healthPoints, int speed, int attackForce) {
        boolean checkHealthPoints = healthPoints >= MIN_HEALTH_POINTS && healthPoints <= MAX_HEALTH_POINTS;
        boolean checkSpeed = speed >= MIN_SPEED && speed <= MAX_SPEED;
        boolean checkAttack = attackForce >= MIX_ATTACK_FORCE && attackForce <= MAX_ATTACK_FORCE;

        return checkHealthPoints && checkSpeed && checkAttack;
    }

    public static boolean checkEntitySettings(int healthPoints, int speed) {
        boolean checkHealthPoints = healthPoints >= MIN_HEALTH_POINTS && healthPoints <= MAX_HEALTH_POINTS;
        boolean checkSpeed = speed >= MIN_SPEED && speed <= MAX_SPEED;
        return checkHealthPoints && checkSpeed;
    }

    public static boolean checkEntitySettings(int foodValue) {
        return foodValue >= MIN_FOOD_VALUE && foodValue <= MAX_FOOD_VALUE;
    }

    public static boolean isDefaultEntitiesAmount(int width, int height) {
        return width * height <= GameSettings.MAX_WORLD_AREA_TO_USE_DEFAULT_ENTITIES_AMOUNT;
    }

}
