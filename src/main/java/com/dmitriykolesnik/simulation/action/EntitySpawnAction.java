package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.EntitiesCounterRepository;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Mouse;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Cat;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Wolf;
import com.dmitriykolesnik.simulation.entities.static_entities.Grain;
import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;
import com.dmitriykolesnik.simulation.entity_factories.impl.*;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import java.util.*;

public class EntitySpawnAction implements Actions {
    private static final int CRITICALLY_LOW_PERCENTAGE_OF_ENTITIES = 30;
    private final WorldMap worldMap;
    private final Map<Class<? extends Entity>, EntityFactory<? extends Entity>> factoryMap = Map.of(
            Wolf.class, new WolfFactoryRandom(),
            Rabbit.class, new RabbitFactoryRandom(),
            Cat.class, new CatFactoryRandom(),
            Mouse.class, new MouseFactoryRandom(),
            Grass.class, new GrassFactoryRandom(),
            Grain.class, new GrainFactoryRandom()
    );

    public EntitySpawnAction(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public void perform() {
        var initialNumberOfEntities =
                EntitiesCounterRepository.getInstance().getInitialNumberOfEntitiesOfEachClass();
        var currentNumberOfEntities =
                EntitiesCounterRepository.getInstance().getCurrentNumberOfEntitiesOfEachClass();

        for (var entry : initialNumberOfEntities.entrySet()) {
            Class<? extends Entity> key = entry.getKey();
            Integer initialValue = entry.getValue();
            Integer currentValue = 0;
            int numberOfEntitiesToSpawn = 0;
            List<Coordinates> freeCoordinates;


            if (currentNumberOfEntities.containsKey(key)) {
                currentValue = currentNumberOfEntities.get(key);

                if (Objects.equals(initialValue, currentValue)) {
                    continue;
                }

                // add entities if there are none left at all
            } else {
                freeCoordinates = getFreeCoordinates();
                spawn(freeCoordinates, initialValue, key);
            }

            // add some entities if the number of entities is less than a critical minimum
            if (isPartialSpawnNeeded(initialValue, currentValue)) {
                freeCoordinates = getFreeCoordinates();
                numberOfEntitiesToSpawn = calculateEntityToSpawn(initialValue, currentValue);
                spawn(freeCoordinates, numberOfEntitiesToSpawn, key);
            }
        }
    }

    private boolean isPartialSpawnNeeded(int initialValue, int currentValue) {
        return (double) currentValue / initialValue * 100 <= CRITICALLY_LOW_PERCENTAGE_OF_ENTITIES;
    }

    private List<Coordinates> getFreeCoordinates() {
        List<Coordinates> allCoordinates = worldMap.getAllCoordinates();
        List<Coordinates> freeCoordinates = new ArrayList<>();

        for (var coordinate : allCoordinates) {
            if (!worldMap.isNotEmptyCell(coordinate)) {
                freeCoordinates.add(coordinate);
            }
        }
        Collections.shuffle(freeCoordinates);
        return freeCoordinates;
    }

    private void spawn(List<Coordinates> coordinates, int entityAmount, Class<? extends Entity> clazz) {
        EntityFactory<? extends Entity> factory = factoryMap.get(clazz);
        if (factory == null) {
            throw new IllegalArgumentException("No factory found for class: " + clazz);
        }

        for (int i = 0; i < entityAmount; i++) {
            Entity entity = factory.create();
            worldMap.setEntity(coordinates.get(0), entity);
            coordinates.remove(0);
        }
    }

    private int calculateEntityToSpawn(int initialValue, int currentValue) {
        Random random = new Random();
        int lackOfEntities = initialValue - currentValue;
        return random.nextInt(lackOfEntities) + 1;
    }

}
