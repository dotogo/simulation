package com.dmitriykolesnik.simulation.util;


public class GameSettings {
    private static final int MIN_HORIZONTAL_WORLD_SIZE = 10;
    private static final int MAX_HORIZONTAL_WORLD_SIZE = 50;
    private static final int MIN_VERTICAL_WORLD_SIZE = 10;
    private static final int MAX_VERTICAL_WORLD_SIZE = 35;
    private static final int MIN_OCCUPANCY_RATE = 5;
    private static final int MAX_OCCUPANCY_RATE = 30;
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
//        boolean checkHorizontalSize =  (horizontalSize >= MIN_HORIZONTAL_WORLD_SIZE && horizontalSize <= MAX_HORIZONTAL_WORLD_SIZE);
//        boolean checkVerticalSize =  (verticalSize >= MIN_VERTICAL_WORLD_SIZE && verticalSize <= MAX_VERTICAL_WORLD_SIZE);
//        return checkHorizontalSize && checkVerticalSize;
//    }

    public static int getMinHorizontalWorldSize() {
        return MIN_HORIZONTAL_WORLD_SIZE;
    }

    public static int getMaxHorizontalWorldSize() {
        return MAX_HORIZONTAL_WORLD_SIZE;
    }

    public static int getMinVerticalWorldSize() {
        return MIN_VERTICAL_WORLD_SIZE;
    }

    public static int getMaxVerticalWorldSize() {
        return MAX_VERTICAL_WORLD_SIZE;
    }

    public static int getMinOccupancyRate() {
        return MIN_OCCUPANCY_RATE;
    }

    public static int getMaxOccupancyRate() {
        return MAX_OCCUPANCY_RATE;
    }


}
