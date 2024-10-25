package com.dmitriykolesnik.simulation.entities;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class EntitiesCounterRepository {
    private static final EntitiesCounterRepository instance = new EntitiesCounterRepository();
    private Map<Class<? extends Entity>, Integer> numberOfEntitiesOfEachClass;

    private EntitiesCounterRepository() {

    }

    public static EntitiesCounterRepository getInstance() {
        return instance;
    }

    public Map<Class<? extends Entity>, Integer> getNumberOfEntitiesOfEachClass() {
        return Objects.requireNonNullElse(numberOfEntitiesOfEachClass, Collections.emptyMap());
    }

    public void setNumberOfEntitiesOfEachClass(Map<Class<? extends Entity>, Integer> numberOfEntitiesOfEachClass) {
        this.numberOfEntitiesOfEachClass = numberOfEntitiesOfEachClass;
    }
}
