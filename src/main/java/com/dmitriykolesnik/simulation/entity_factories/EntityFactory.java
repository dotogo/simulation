package com.dmitriykolesnik.simulation.entity_factories;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;

public interface EntityFactory <T extends Entity> {
    T create();
}
