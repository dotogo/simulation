package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.util.UtilSimulation;


public class SetWorldSizeAction extends InitAction {
    private static final String ENTER_X_SIZE = "Specify the horizontal size of the WorldMap.";
    private static final String ENTER_Y_SIZE = "Specify the vertical size of the WorldMap.";

    @Override
    public void perform() {
        System.out.println(ENTER_X_SIZE);
        int xSize = UtilSimulation.getPositiveIntFromKeyboard();
        System.out.println();

        System.out.println(ENTER_Y_SIZE);
        int ySize = UtilSimulation.getPositiveIntFromKeyboard();

        ActionsDataSingleton.getInstance().setX_SizeWorldMap(xSize);
        ActionsDataSingleton.getInstance().setY_SizeWorldMap(ySize);
    }
}
