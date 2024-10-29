package com.dmitriykolesnik.simulation.entities;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class EntitiesCounterRepository {
    private static final EntitiesCounterRepository instance = new EntitiesCounterRepository();
    private Map<Class<? extends Entity>, Integer> currentNumberOfEntitiesOfEachClass;
    private Map<Class<? extends Entity>, Integer> initialNumberOfEntitiesOfEachClass;
    private boolean isSimulationStarted = false;

    private EntitiesCounterRepository() {

    }

    public static EntitiesCounterRepository getInstance() {
        return instance;
    }

    public Map<Class<? extends Entity>, Integer> getCurrentNumberOfEntitiesOfEachClass() {
        return Objects.requireNonNullElse(currentNumberOfEntitiesOfEachClass, Collections.emptyMap());
    }

    public void setCurrentNumberOfEntitiesOfEachClass(Map<Class<? extends Entity>, Integer> currentNumberOfEntitiesOfEachClass) {
        this.currentNumberOfEntitiesOfEachClass = currentNumberOfEntitiesOfEachClass;

        if (!isSimulationStarted) {
            initialNumberOfEntitiesOfEachClass = currentNumberOfEntitiesOfEachClass;
            isSimulationStarted = true;
        }
    }

    public Map<Class<? extends Entity>, Integer> getInitialNumberOfEntitiesOfEachClass() {
        return initialNumberOfEntitiesOfEachClass;
    }
}
