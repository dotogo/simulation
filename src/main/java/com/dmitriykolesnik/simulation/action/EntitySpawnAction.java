package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.EntitiesCounterRepository;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.static_entities.EdiblePlant;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import java.util.*;

public class EntitySpawnAction implements Actions {
    private static final int CRITICALLY_LOW_PERCENTAGE_OF_ENTITIES = 30;
    private final WorldMap worldMap;
    private final Map<Class<? extends Entity>, EntityFactory<? extends Entity>> classWithItsFactory;

    public EntitySpawnAction(WorldMap worldMap, Map<Class<? extends Entity>, EntityFactory<? extends Entity>> classWithItsFactory) {
        this.worldMap = worldMap;
        this.classWithItsFactory = classWithItsFactory;
    }

    @Override
    public void perform() {
        EntitiesCounterRepository instance = EntitiesCounterRepository.getInstance();
        var initialNumberOfEntities = instance.getInitialNumberOfEntitiesOfEachClass();
        var currentNumberOfEntities = instance.getCurrentNumberOfEntitiesOfEachClass();

        for (var entry : initialNumberOfEntities.entrySet()) {
            Class<? extends Entity> entityClass = entry.getKey();
            Integer initialValue = entry.getValue();
            Integer currentValue = 0;

            if (isAtLeastOneEntityExist(currentNumberOfEntities, entityClass)) {
                currentValue = currentNumberOfEntities.get(entityClass);
            }

            if (Objects.equals(initialValue, currentValue)) {
                continue;
            }

            if (currentValue == 0) {
                spawnToInitialValues(initialValue, entityClass);
            }

            if (isPartialSpawnNeeded(initialValue, currentValue)) {
                partialSpawn(initialValue, currentValue, entityClass);
            }
        }
    }

    private void spawnToInitialValues(Integer initialValue, Class<? extends Entity> key) {
        List<Coordinates> coordinatesToSpawn;
        coordinatesToSpawn = getAllFreeCoordinates();
        spawn(coordinatesToSpawn, initialValue, key);
    }

    private void partialSpawn(Integer initialValue, Integer currentValue, Class<? extends Entity> key) {
        List<Coordinates> coordinatesToSpawn;
        int numberOfEntitiesToSpawn;
        numberOfEntitiesToSpawn = calculateEntityToSpawn(initialValue, currentValue);

        if (isSpawnEdiblePlant(key)) {
            coordinatesToSpawn = getAllFreeCoordinates();
        } else {
            coordinatesToSpawn = getFreeCoordinatesOnPerimeter();
        }

        if (isPerimeterCoordinatesEnoughForSpawn(coordinatesToSpawn, numberOfEntitiesToSpawn)) {
            spawn(coordinatesToSpawn, numberOfEntitiesToSpawn, key);
            return;
        }

        coordinatesToSpawn = getAllFreeCoordinates();
        spawn(coordinatesToSpawn, numberOfEntitiesToSpawn, key);
    }

    private boolean isPartialSpawnNeeded(int initialValue, int currentValue) {
        return (double) currentValue / initialValue * 100 <= CRITICALLY_LOW_PERCENTAGE_OF_ENTITIES;
    }

    private List<Coordinates> getAllFreeCoordinates() {
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

    private List<Coordinates> getFreeCoordinatesOnPerimeter() {
        List<Coordinates> allCoordinates = worldMap.getAllCoordinates();
        List<Coordinates> freePerimeterCoordinates = new ArrayList<>();

        for (var coordinates : allCoordinates) {
            if (!worldMap.isNotEmptyCell(coordinates) && isPerimeterCoordinates(coordinates)) {
                freePerimeterCoordinates.add(coordinates);
            }
        }
        Collections.shuffle(freePerimeterCoordinates);
        return freePerimeterCoordinates;
    }

    private boolean isPerimeterCoordinates(Coordinates coordinates) {
        int leftmostValue = 0;
        int rightmostValue = worldMap.getWidth() - 1;
        int bottommostValue = 0;
        int uppermostValue = worldMap.getHeight() - 1;

        if (coordinates.getX() == leftmostValue || coordinates.getX() == rightmostValue) {
            return true;
        }

        return coordinates.getY() == bottommostValue || coordinates.getY() == uppermostValue;
    }

    private boolean isPerimeterCoordinatesEnoughForSpawn(List<Coordinates> perimeterCoordinates, int numberOfEntities) {
        return perimeterCoordinates.size() >= numberOfEntities;
    }

    private boolean isSpawnEdiblePlant(Class<? extends Entity> entityClass) {
         return EdiblePlant.class.isAssignableFrom(entityClass);
    }

    private void spawn(List<Coordinates> coordinates, int entityAmount, Class<? extends Entity> entityClass) {
        EntityFactory<? extends Entity> factory = classWithItsFactory.get(entityClass);
        if (factory == null) {
            throw new IllegalArgumentException("No factory found for class: " + entityClass);
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
    private boolean isAtLeastOneEntityExist(Map<Class<? extends Entity>, Integer> currentNumberOfEntities,
                                            Class<? extends Entity> entityClass) {
        return currentNumberOfEntities.containsKey(entityClass);
    }

}
