package com.dmitriykolesnik.simulation.util;


public class GameSettings {
    private static final int MIN_HORIZONTAL_WORLD_SIZE = 5;
    private static final int MAN_HORIZONTAL_WORLD_SIZE = 50;
    private static final int MIN_VERTICAL_WORLD_SIZE = 5;
    private static final int MAN_VERTICAL_WORLD_SIZE = 35;
    private static final int MIN_HEALTH_POINTS = 0;
    private static final int MAX_HEALTH_POINTS = 100;
    private static final int MIN_SPEED = 1;
    private static final int MAX_SPEED = 10;
    private static final int MIX_ATTACK_FORCE = 5;
    private static final int MAX_ATTACK_FORCE = 500;
    private static final int MIN_FOOD_VALUE = 5;
    private static final int MAX_FOOD_VALUE = 50;

    public static boolean checkForGlobalSettings(int healthPoints, int speed, int attackForce, int foodValue) {
        return true;
    }

    public static boolean checkForGlobalSettings(int healthPoints, int speed, int attackForce) {
        return true;
    }

    public static boolean checkForGlobalSettings(int healthPoints, int speed) {
        return true;
    }

    public static boolean checkForGlobalSettings(int foodValue) {
        return true;
    }

//    public static boolean checkWorldSize(int horizontalSize, int verticalSize) {
//        if (horizontalSize >= MIN_HORIZONTAL_WORLD_SIZE && )
//    }
}
