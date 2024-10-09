package com.dmitriykolesnik.simulation.entities;

import com.dmitriykolesnik.simulation.util.IdCounter;

public abstract class Entity {
    private final Long id;

    public Entity() {
        this.id = IdCounter.getNextId();
    }

    public long getId() {
        return id;
    }

    public abstract EntityType getEntityType();
}
