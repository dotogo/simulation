package com.dmitriykolesnik.simulation.entities;

import com.dmitriykolesnik.simulation.entities.static_entities.Rock;
import com.dmitriykolesnik.simulation.entities.static_entities.Tree;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EntitySelectionManager {
    private final EntityFactoryRegistry factoryRegistry;
    private final Map<Class<? extends Entity>, Integer> entityCounts = new HashMap<>();
    private final int minNumberOfEntities;
    private final int maxNumberOfEntities;
    private boolean isSelectionFinished;
    private int totalNumberOfEntities;
    private int specifiedNumberOfEntities;

    public EntitySelectionManager(EntityFactoryRegistry factoryRegistry, int minNumberOfEntities, int maxNumberOfEntities) {
        this.factoryRegistry = factoryRegistry;
        this.minNumberOfEntities = minNumberOfEntities;
        this.maxNumberOfEntities = maxNumberOfEntities;
    }

    public Map<Class<? extends Entity>, Integer> getEntityCounts() {
        return new HashMap<>(entityCounts);
    }

    public void runAction(Class<? extends Entity> entityClass) {
        specifyEntityQuantity(entityClass);

        if (isNewTotalNumberOfEntitiesValid()) {
            setTotalNumberOfEntities(totalNumberOfEntities + specifiedNumberOfEntities);
            setEntityCount(entityClass, specifiedNumberOfEntities);
            printAvailableEntitiesLeft();
        } else {
            printMaxNumberError();
        }

        if (isNeedAddMoreEntities()) {
            printMinNumberEntitiesWarning();
        }

        if (isTotalEqualMax()) {
            finalizeSelection();
        }
    }

    public Set<Class<? extends Entity>> getAvailableEntities() {
        Set<Class<? extends Entity>> availableEntities = new HashSet<>(factoryRegistry.getFactoryMap().keySet());
        availableEntities.add(Tree.class);
        availableEntities.add(Rock.class);
        return availableEntities;
    }

    public void printNumberOfEntitiesInfo() {
        System.out.printf("MIN number of entities for the current World Map size is: %s \n" +
                "MAX number of entities is: %s \n" +
                "Current total number of specified entities is: %s \n\n", minNumberOfEntities, maxNumberOfEntities, totalNumberOfEntities);
    }

    public void finalizeSelection() {
        if (totalNumberOfEntities >= minNumberOfEntities) {
            isSelectionFinished = true;
            System.out.println("Selection confirmed.");
        } else {
            printMinNumberEntitiesWarning();
        }
    }

    public boolean isSelectionFinished() {
        return isSelectionFinished;
    }

    private void specifyEntityQuantity(Class<? extends Entity> entityClass) {
        System.out.println("Enter quantity for " + entityClass.getSimpleName() + ": ");
        int quantity = UtilSimulation.getPositiveIntFromKeyboard();
        setSpecifiedNumberOfEntities(quantity);
    }

    private void setEntityCount(Class<? extends Entity> entityClass, int count) {
        entityCounts.put(entityClass, count);
    }

    private void setTotalNumberOfEntities(int totalNumberOfEntities) {
        this.totalNumberOfEntities = totalNumberOfEntities;
    }

    private void setSpecifiedNumberOfEntities(int specifiedNumberOfEntities) {
        this.specifiedNumberOfEntities = specifiedNumberOfEntities;
    }

    private boolean isNewTotalNumberOfEntitiesValid() {
        int newTotalNumber = totalNumberOfEntities + specifiedNumberOfEntities;
        return newTotalNumber <= maxNumberOfEntities;
    }

    private boolean isTotalEqualMax() {
        return totalNumberOfEntities == maxNumberOfEntities;
    }

    private void printMinNumberEntitiesWarning() {
        System.out.printf("Add some more entities.\n" +
                "MIN available number is %s \n" +
                "Current total number of specified entities is: %s\n\n", minNumberOfEntities, totalNumberOfEntities);
    }

    private void printMaxNumberError() {
        System.out.printf("Sorry, but the total number of entities you specified is out of range. Try again.\n" +
                "MAX available number is %s \n" +
                "Current total number of specified entities is: %s\n\n", maxNumberOfEntities, totalNumberOfEntities);
    }

    private void printAvailableEntitiesLeft() {
        System.out.printf("You can still add a maximum of %s entities.\n\n", maxNumberOfEntities - totalNumberOfEntities);
    }

    private boolean isNeedAddMoreEntities() {
        return totalNumberOfEntities < minNumberOfEntities;
    }

}
