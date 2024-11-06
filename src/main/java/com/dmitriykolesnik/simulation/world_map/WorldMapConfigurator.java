package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public class WorldMapConfigurator {
    private static final String INPUT_ERROR = "You have entered a number outside the valid range.";
    private static final String ENTER_OCCUPANCY_RATE;
    private static final String ENTER_HORIZONTAL_SIZE;
    private static final String ENTER_VERTICAL_SIZE;
    private int width;
    private int height;
    private int occupancyRate;

    static {
        ENTER_HORIZONTAL_SIZE = "Specify the horizontal size of the World (integer, MIN = " + GameSettings.MIN_WIDTH_OF_WORLD +
                ", MAX = " + GameSettings.MAX_WIDTH_OF_WORLD + ")";
        ENTER_VERTICAL_SIZE = "Specify the vertical size of the World (integer, MIN = " + GameSettings.MIN_HEIGHT_OF_WORLD +
                ", MAX = " + GameSettings.MAX_HEIGHT_OF_WORLD + ")";
        ENTER_OCCUPANCY_RATE = "Specify the occupancy rate of the World (integer, MIN = " + GameSettings.MIN_OCCUPANCY_RATE +
                ", MAX = " + GameSettings.MAX_OCCUPANCY_RATE + ")";
    }

    public void setSizes() {
        System.out.println(ENTER_HORIZONTAL_SIZE);
        setWidth();

        System.out.println();

        System.out.println(ENTER_VERTICAL_SIZE);
        setHeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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

    public int getMinAvailableNumberOfEntities() {
        return width * height * GameSettings.MIN_OCCUPANCY_RATE / 100;
    }

    public int getMaxAvailableNumberOfEntities() {
        return width * height * GameSettings.MAX_OCCUPANCY_RATE / 100;
    }

    private void setWidth() {
        while (true) {
            int number = UtilSimulation.getPositiveIntFromKeyboard();

            if(checkWidth(number)) {
                width = number;
                break;
            }
            printInputError();
        }
    }

    private void setHeight() {
        while (true) {
            int number = UtilSimulation.getPositiveIntFromKeyboard();

            if(checkHeight(number)) {
                height = number;
                break;
            }
            printInputError();
        }
    }

    private boolean checkWidth(int width) {
        return (width >= GameSettings.MIN_WIDTH_OF_WORLD) &&
                (width <= GameSettings.MAX_WIDTH_OF_WORLD);
    }

    private boolean checkHeight(int height) {
        return (height >= GameSettings.MIN_HEIGHT_OF_WORLD) &&
                (height <= GameSettings.MAX_HEIGHT_OF_WORLD);
    }

    private boolean checkOccupancyRate(int occupancyRate) {
        return (occupancyRate >= GameSettings.MIN_OCCUPANCY_RATE) &&
                (occupancyRate <= GameSettings.MAX_OCCUPANCY_RATE);
    }

    private void printInputError() {
        System.out.println(INPUT_ERROR);
    }
}
