package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.world_map.WorldMap;

public abstract class TurnAction extends Actions {
    protected WorldMap worldMap;

    public TurnAction(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
}
