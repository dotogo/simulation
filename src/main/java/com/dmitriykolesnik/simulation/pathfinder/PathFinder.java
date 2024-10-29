package com.dmitriykolesnik.simulation.pathfinder;

import com.dmitriykolesnik.simulation.Coordinates;
import java.util.List;

public interface PathFinder {
    List<Coordinates> find(Coordinates startCell, int depthOfSearch, Class<?> classToBeFound);
}
