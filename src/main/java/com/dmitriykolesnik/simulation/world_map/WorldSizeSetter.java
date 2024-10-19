package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public class WorldSizeSetter {
    private static final String INPUT_ERROR = "You have entered a number outside the valid range.";
    private static final String ENTER_HORIZONTAL_SIZE;
    private static final String ENTER_VERTICAL_SIZE;
    private int horizontalSize;
    private int verticalSize;

    static {
        ENTER_HORIZONTAL_SIZE = "Specify the horizontal size of the WorldMap (MIN = " + GameSettings.getMinHorizontalWorldSize() +
                ", MAX = " + GameSettings.getMaxHorizontalWorldSize() + ")";
        ENTER_VERTICAL_SIZE = "Specify the vertical size of the WorldMap (MIN = " + GameSettings.getMinVerticalWorldSize() +
                ", MAX = " + GameSettings.getMaxVerticalWorldSize() + ")";
    }

    public void perform() {
        System.out.println(ENTER_HORIZONTAL_SIZE);
        setHorizontalSize();

        System.out.println();

        System.out.println(ENTER_VERTICAL_SIZE);
        setVerticalSize();
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

    public int getHorizontalSize() {
        return horizontalSize;
    }

    public int getVerticalSize() {
        return verticalSize;
    }

    private boolean checkHorizontalWorldSize(int horizontalSize) {
        return (horizontalSize >= GameSettings.getMinHorizontalWorldSize()) &&
                (horizontalSize <= GameSettings.getMaxHorizontalWorldSize());
    }

    private boolean checkVerticalWorldSize(int verticalSize) {
        return (verticalSize >= GameSettings.getMinVerticalWorldSize()) &&
                (verticalSize <= GameSettings.getMaxHorizontalWorldSize());
    }

    private void printInputError() {
        System.out.println(INPUT_ERROR);
    }
}
