package com.dmitriykolesnik.simulation.entities;

import com.dmitriykolesnik.simulation.entities.static_entities.Rock;
import com.dmitriykolesnik.simulation.entities.static_entities.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EntitySelectionManager {
    private boolean isSelectionFinished;
    private final EntityFactoryRegistry factoryRegistry;
    private final Map<Class<? extends Entity>, Integer> entityCounts = new HashMap<>();

    public EntitySelectionManager(EntityFactoryRegistry factoryRegistry) {
        this.factoryRegistry = factoryRegistry;
    }

    public Set<Class<? extends Entity>> getAvailableEntities() {
        Set<Class<? extends Entity>> availableEntities = new HashSet<>(factoryRegistry.getFactoryMap().keySet());
        availableEntities.add(Tree.class);
        availableEntities.add(Rock.class);
        return availableEntities;
    }

    public void setEntityCount(Class<? extends Entity> entityClass, int count) {
        entityCounts.put(entityClass, count);
    }

    public Map<Class<? extends Entity>, Integer> getEntityCounts() {
        return new HashMap<>(entityCounts);
    }

    public void finalizeSelection() {
        isSelectionFinished = true;
        System.out.println("Selection confirmed.");
    }

    public boolean isSelectionFinished() {
        return isSelectionFinished;
    }
}
