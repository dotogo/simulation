package com.dmitriykolesnik.simulation.pathfinder;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

import java.util.*;
import java.util.stream.Collectors;

public class BreadthFirstSearch implements PathFinder{
    private final WorldMap worldMap;

    public BreadthFirstSearch(WorldMap worldMap) {
        this.worldMap = worldMap;
    }


    @Override
    public List<Coordinates> find(Coordinates startCell, int depthOfSearch, Class<?> classToBeFound) {
        List<Coordinates> checked = new ArrayList<>();
        Queue<Coordinates> queue = new LinkedList<>();
        Map<Coordinates, Coordinates> cameFrom = new HashMap<>();
        Map<Coordinates, Integer> levelMap = new HashMap<>();

        List<Coordinates> freeCells = new ArrayList<>();

        queue.add(startCell);
        levelMap.put(startCell, 0);
        cameFrom.put(startCell, null);

        while (!queue.isEmpty()) {
            Coordinates cellToLookAround = queue.poll();
            int currentLevel = levelMap.get(cellToLookAround);

            if (currentLevel >= depthOfSearch) {
                continue;
            }

            List<Coordinates> cellsAround = getAvailableCellsAround(worldMap, cellToLookAround);

            for (Coordinates coordinates : cellsAround) {
                if (checked.contains(coordinates)) {
                    continue;
                }
                if (hasTargetEntity(coordinates, classToBeFound)) {
                    cameFrom.put(coordinates, cellToLookAround);
                    return reconstructPath(cameFrom, coordinates);
                }

                checked.add(coordinates);
                if (!worldMap.isNotEmptyCell(coordinates)) {
                    queue.add(coordinates);

                    levelMap.put(coordinates, currentLevel + 1);

                    if (!cameFrom.containsKey(coordinates)) {
                        cameFrom.put(coordinates, cellToLookAround);
                    }

                    if (!freeCells.contains(coordinates)) {
                        freeCells.add(coordinates);
                    }
                }
            }
        }
        return  freeCells;
    }

    private List<Coordinates> reconstructPath(Map<Coordinates, Coordinates> cameFrom, Coordinates target) {
        List<Coordinates> path = new ArrayList<>();
        Coordinates current = target;

        while (current != null) {
            path.add(current);
            current = cameFrom.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    private boolean checkEntityClass(Entity entity, Class<?> classToBeFound) {
        return classToBeFound.isInstance(entity);
    }

    private List<Coordinates> getAvailableCellsAround(WorldMap worldMap, Coordinates startCell) {
        int x = startCell.getX();
        int y = startCell.getY();

        List<Coordinates> allCellsAround = List.of(
                new Coordinates(x + 1, y), new Coordinates(x + 1, y - 1),
                new Coordinates(x, y - 1), new Coordinates(x - 1, y - 1),
                new Coordinates(x - 1, y), new Coordinates(x - 1, y + 1),
                new Coordinates(x, y + 1), new Coordinates(x + 1, y + 1) );

        return allCellsAround.stream()
                .filter(worldMap::isWithinWorldMap).collect(Collectors.toList());
    }

    private boolean hasTargetEntity(Coordinates coordinates, Class<?> classToBeFound) {
        if (worldMap.isNotEmptyCell(coordinates)) {
            Entity entity = worldMap.getEntity(coordinates);
            return checkEntityClass(entity, classToBeFound);
        }
        return false;
    }
}
