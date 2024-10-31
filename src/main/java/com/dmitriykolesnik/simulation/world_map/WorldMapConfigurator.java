package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public class WorldMapConfigurator {
    private static final String INPUT_ERROR = "You have entered a number outside the valid range.";
    private static final String ENTER_OCCUPANCY_RATE;
    private static final String ENTER_HORIZONTAL_SIZE;
    private static final String ENTER_VERTICAL_SIZE;
    private int horizontalSize;
    private int verticalSize;
    private int occupancyRate;

    static {
        ENTER_HORIZONTAL_SIZE = "Specify the horizontal size of the WorldMap (integer, MIN = " + GameSettings.MIN_HORIZONTAL_WORLD_SIZE +
                ", MAX = " + GameSettings.MAX_HORIZONTAL_WORLD_SIZE + ")";
        ENTER_VERTICAL_SIZE = "Specify the vertical size of the WorldMap (integer, MIN = " + GameSettings.MIN_VERTICAL_WORLD_SIZE +
                ", MAX = " + GameSettings.MAX_VERTICAL_WORLD_SIZE + ")";
        ENTER_OCCUPANCY_RATE = "Specify the occupancy rate of the WorldMap (integer, MIN = " + GameSettings.MIN_OCCUPANCY_RATE +
                ", MAX = " + GameSettings.MAX_OCCUPANCY_RATE + ")";
    }

    public void setSizes() {
        System.out.println(ENTER_HORIZONTAL_SIZE);
        setHorizontalSize();

        System.out.println();

        System.out.println(ENTER_VERTICAL_SIZE);
        setVerticalSize();
    }

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    public void setEntityOccupancyRate() {
        System.out.println(ENTER_OCCUPANCY_RATE);

        while (true) {
            int number = UtilSimulation.getPositiveIntFromKeyboard();

            if(checkOccupancyRate(number)) {
                occupancyRate = number;
                break;
            }
            printInputError();
        }
        System.out.println();
    }

    public int getOccupancyRate() {
        return occupancyRate;
    }

    private void setHorizontalSize() {
        while (true) {
            int number = UtilSimulation.getPositiveIntFromKeyboard();

            if(checkHorizontalWorldSize(number)) {
                horizontalSize = number;
                break;
            }
            printInputError();
        }
    }

    private void setVerticalSize() {
        while (true) {
            int number = UtilSimulation.getPositiveIntFromKeyboard();

            if(checkVerticalWorldSize(number)) {
                verticalSize = number;
                break;
            }
            printInputError();
        }
    }

    private boolean checkHorizontalWorldSize(int horizontalSize) {
        return (horizontalSize >= GameSettings.MIN_HORIZONTAL_WORLD_SIZE) &&
                (horizontalSize <= GameSettings.MAX_HORIZONTAL_WORLD_SIZE);
    }

    private boolean checkVerticalWorldSize(int verticalSize) {
        return (verticalSize >= GameSettings.MIN_VERTICAL_WORLD_SIZE) &&
                (verticalSize <= GameSettings.MAX_VERTICAL_WORLD_SIZE);
    }

    private boolean checkOccupancyRate(int occupancyRate) {
        return (occupancyRate >= GameSettings.MIN_OCCUPANCY_RATE) &&
                (occupancyRate <= GameSettings.MAX_OCCUPANCY_RATE);
    }

    private void printInputError() {
        System.out.println(INPUT_ERROR);
    }
}
