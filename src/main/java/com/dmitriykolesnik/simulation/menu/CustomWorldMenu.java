package com.dmitriykolesnik.simulation.menu;

import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.EntitySelectionManager;
import com.dmitriykolesnik.simulation.util.UtilSimulation;

public class CustomWorldMenu extends Menu {
    private static final String ITEM_NAME_PART = "Specify quantity for ";
    private final EntitySelectionManager selectionManager;

    public CustomWorldMenu(EntitySelectionManager selectionManager) {
        super("Custom World Configuration", "Choose entities and their quantities:", "Invalid choice. Try again.");
        this.selectionManager = selectionManager;

        addEntitySelectionOptions();
    }

    private void addEntitySelectionOptions() {
        for (Class<? extends Entity> entityClass : selectionManager.getAvailableEntities()) {
            addItem(ITEM_NAME_PART + entityClass.getSimpleName(),
                    () -> specifyEntityQuantity(entityClass));
        }
        addItem("Confirm Selection", selectionManager::finalizeSelection);
    }

    private void specifyEntityQuantity(Class<? extends Entity> entityClass) {
        System.out.println("Enter quantity for " + entityClass.getSimpleName() + ": ");
        int quantity = UtilSimulation.getPositiveIntFromKeyboard();
        selectionManager.setEntityCount(entityClass, quantity);
    }

}
