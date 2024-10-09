package com.dmitriykolesnik.simulation.pathfinder;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.List;

public interface PathFinder {
    //Coordinates find(Entity e);
    //<T extends Entity> Coordinates find(Coordinates startCell, T entityToBeFound);
    //<T extends Entity> Coordinates find(WorldMap worldMap, Coordinates startCell, Class<T> tClass, int depthOfSearch);
    List<Coordinates> find(Coordinates startCell, int depthOfSearch, Class<?> classToBeFound);
}
