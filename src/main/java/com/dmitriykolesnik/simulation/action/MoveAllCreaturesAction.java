package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class MoveAllCreaturesAction implements Actions {
    private final WorldMap worldMap;
    PathFinder pathFinder;
    boolean isLoggingEnabled;

    public MoveAllCreaturesAction(WorldMap worldMap, PathFinder pathFinder, boolean isLoggingEnabled) {
        this.worldMap = worldMap;
        this.pathFinder = pathFinder;
        this.isLoggingEnabled = isLoggingEnabled;
    }

    @Override
    public void perform() {
        List<Creature> creaturesToMove = new ArrayList<>();

        for (int y = worldMap.getYsize() - 1; y >= 0; y--) {
            for (int x = 0; x < worldMap.getXsize(); x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (worldMap.isNotEmptyCell(coordinates)) {
                    Entity entity = worldMap.getEntity(coordinates);
                    if (entity instanceof Creature) {
                        creaturesToMove.add((Creature) entity);
                    }
                }
            }
        }

        for (Creature creature : creaturesToMove) {
            if (worldMap.isContainEntity(creature)) {
                creature.makeMove(worldMap, pathFinder, isLoggingEnabled);
            }
        }
    }
}
