package com.dmitriykolesnik.simulation.action;

public class ActionsDataSingleton {
    private static final ActionsDataSingleton instance = new ActionsDataSingleton();
    private int x_SizeWorldMap;
    private int y_SizeWorldMap;

    private ActionsDataSingleton(){

    }

    public static ActionsDataSingleton getInstance() {
        return instance;
    }

    public void setX_SizeWorldMap(int x_SizeWorldMap) {
        this.x_SizeWorldMap = x_SizeWorldMap;
    }

    public void setY_SizeWorldMap(int y_SizeWorldMap) {
        this.y_SizeWorldMap = y_SizeWorldMap;
    }

    public int getX_SizeWorldMap() {
        return x_SizeWorldMap;
    }

    public int getY_SizeWorldMap() {
        return y_SizeWorldMap;
    }





}
