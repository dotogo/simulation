package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class MoveAllCreaturesAction extends TurnAction{
    boolean isLoggingEnabled;

    public MoveAllCreaturesAction(WorldMap worldMap, boolean isLoggingEnabled) {
        super(worldMap);
        this.isLoggingEnabled = isLoggingEnabled;
    }

    @Override
    public void perform() {
        //Set<Creature> creaturesToMove = new HashSet<>();
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
                creature.makeMove(worldMap, isLoggingEnabled);
            }
        }
    }
}
