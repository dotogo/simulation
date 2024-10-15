package com.dmitriykolesnik.simulation.entities.moving_entities;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.util.UtilSimulation;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.List;

public class CreatureLifecycleManager {

    public boolean isFoodWasFound(WorldMap worldMap, Coordinates targetCoordinates, Class<?> clazz) {
        if (worldMap.isNotEmptyCell(targetCoordinates)) {
            Entity entity = worldMap.getEntity(targetCoordinates);
            Class<?> entityClass = entity.getClass();
            return clazz.isAssignableFrom(entityClass);
        }
        return false;
    }

    public void removeDeadCreature(WorldMap worldMap, Creature creature, boolean isCreatureDied) {
        if (isCreatureDied) {
            Coordinates coordinates = worldMap.getEntityCoordinates(creature);
            worldMap.removeEntity(coordinates);
        }
    }

    public void moveLivingCreature(WorldMap worldMap, List<Coordinates> pathToTarget,
                                      Coordinates entityCoordinates, boolean isCreatureDied) {
        if (!isCreatureDied) {
            int randomNumberFromPath = UtilSimulation.getRandomNumberBetween(0, pathToTarget.size() - 1);
            Coordinates randomCoordinatesFromPath = pathToTarget.get(randomNumberFromPath);

            worldMap.moveEntity(entityCoordinates, randomCoordinatesFromPath);
        }
    }
}
