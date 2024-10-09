package com.dmitriykolesnik.simulation.action;


import java.util.Scanner;

public class SetWorldSizeAction extends InitAction {
    private static final String ENTER_X_SIZE = "Enter xSize (horizontal) of the WorldMap";
    private static final String ENTER_Y_SIZE = "Enter ySize (vertical) of the WorldMap";


    @Override
    public void perform() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_X_SIZE);
        int xSize = scanner.nextInt();

        System.out.println(ENTER_Y_SIZE);
        int ySize = scanner.nextInt();

        ActionsDataSingleton.getInstance().setX_SizeWorldMap(xSize);
        ActionsDataSingleton.getInstance().setY_SizeWorldMap(ySize);
    }




}
