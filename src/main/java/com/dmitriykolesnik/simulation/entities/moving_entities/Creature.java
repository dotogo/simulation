package com.dmitriykolesnik.simulation.entities.moving_entities;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.util.UtilSimulation;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.List;

public abstract class Creature extends Entity {
    private int healthPoints;
    private int speed;

    public Creature(int healthPoints, int speed) {
        this.healthPoints = healthPoints;
        this.speed = speed;
    }

    public Creature() {

    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void makeMove(WorldMap worldMap);
    protected abstract int getMaxAvailableHealthPoints();
    protected abstract int getReduceHealthPointsIfFoodNotFound();
    protected abstract Class<?> getTypeOfFood();
}
