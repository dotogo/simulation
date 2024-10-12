package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.world_map.WorldMap;

public abstract class TurnAction implements Actions {
    protected WorldMap worldMap;

    public TurnAction(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
}
