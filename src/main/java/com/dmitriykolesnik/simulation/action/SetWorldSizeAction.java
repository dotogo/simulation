package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.util.GameSettings;
import com.dmitriykolesnik.simulation.util.UtilSimulation;


public class SetWorldSizeAction extends InitAction {
    private static final String INPUT_ERROR = "You have entered a number outside the valid range.";
    private static final String ENTER_X_SIZE;
    private static final String ENTER_Y_SIZE;
    static {
        ENTER_X_SIZE = "Specify the horizontal size of the WorldMap (MIN = " + GameSettings.getMinHorizontalWorldSize() +
                ", MAX = " + GameSettings.getMaxHorizontalWorldSize() + ")";
        ENTER_Y_SIZE = "Specify the vertical size of the WorldMap (MIN = " + GameSettings.getMinVerticalWorldSize() +
                ", MAX = " + GameSettings.getMaxVerticalWorldSize() + ")";
    }

    @Override
    public void perform() {
        System.out.println(ENTER_X_SIZE);
        setHorizontalSize();

        System.out.println();

        System.out.println(ENTER_Y_SIZE);
        setVerticalSize();
    }

    private static void setHorizontalSize() {
        while (true) {
            int number = UtilSimulation.getPositiveIntFromKeyboard();

            if(checkHorizontalWorldSize(number)) {
                ActionsDataSingleton.getInstance().setX_SizeWorldMap(number);
                break;
            }
            printInputError();
        }
    }

    private static void setVerticalSize() {
        while (true) {
            int number = UtilSimulation.getPositiveIntFromKeyboard();

            if(checkVerticalWorldSize(number)) {
                ActionsDataSingleton.getInstance().setY_SizeWorldMap(number);
                break;
            }
            printInputError();
        }
    }

    private static boolean checkHorizontalWorldSize(int horizontalSize) {
        return (horizontalSize >= GameSettings.getMinHorizontalWorldSize()) &&
                (horizontalSize <= GameSettings.getMaxHorizontalWorldSize());
    }

    private static boolean checkVerticalWorldSize(int verticalSize) {
        return (verticalSize >= GameSettings.getMinVerticalWorldSize()) &&
                (verticalSize <= GameSettings.getMaxHorizontalWorldSize());
    }

    private static void printInputError() {
        System.out.println(INPUT_ERROR);
    }
}
