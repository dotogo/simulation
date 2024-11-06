package com.dmitriykolesnik.simulation.menu;

import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.EntitySelectionManager;

public class CustomWorldMenu extends Menu {
    private static final String ITEM_NAME_PART = "Specify quantity for ";
    private final EntitySelectionManager selectionManager;

    public CustomWorldMenu(EntitySelectionManager selectionManager) {
        super("Custom World Configuration", "Choose entities and their quantities:", "Invalid choice. Try again.");
        this.selectionManager = selectionManager;
        selectionManager.printNumberOfEntitiesInfo();
        addEntitySelectionOptions();
    }

    private void addEntitySelectionOptions() {
        for (Class<? extends Entity> entityClass : selectionManager.getAvailableEntities()) {
            addItem(ITEM_NAME_PART + entityClass.getSimpleName(),
                    () -> selectionManager.runAction(entityClass));
        }
        addItem("Confirm Selection", selectionManager::finalizeSelection);
    }
}
