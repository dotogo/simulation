package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.exceptions.EntityNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class WorldMap {
    private final int xSize; // 0...x_Size
    private final int ySize; // 0...y_Size

    private Map<Coordinates, Entity> entities = new HashMap<>();

    public int getXsize() {
        return xSize;
    }

    public int getYsize() {
        return ySize;
    }

    public WorldMap(int xSize, int ySize) {
        if (xSize > 0 && ySize > 0) {
            this.xSize = xSize;
            this.ySize = ySize;
        } else {
            throw new IllegalArgumentException("x_Size and y_Size of the WorldMap must be greater than 0");
        }

    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        if (isWithinWorldMap(coordinates)) {
            entities.put(coordinates, entity);
        } else {
            throw new IllegalArgumentException("The Entity must have positive coordinates within WorldMap " +
                    "(less than xSize and ySize)");
        }
    }

    public Entity getEntity(Coordinates coordinates) {
        if (isNotEmptyCell(coordinates)) {
            return entities.get(coordinates);
        } else {
            throw new IllegalArgumentException("Getting entity failed");
        }
    }

    public void removeEntity(Coordinates coordinates) {
        if (isNotEmptyCell(coordinates)) {
            entities.remove(coordinates);
        } else {
            throw new IllegalArgumentException("Removing entity failed");
        }
    }

//    public void removeEntity(Entity entity) {
//
//    }


    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = getEntity(from);

        removeEntity(from);
        setEntity(to, entity);
    }

    public boolean isNotEmptyCell(Coordinates coordinates) {
        return entities.containsKey(coordinates);
    }

    public boolean isWithinWorldMap(Coordinates coordinates) {
        boolean checkX = (coordinates.getX() >= 0) && (coordinates.getX() < xSize);
        boolean checkY = (coordinates.getY() >= 0) && (coordinates.getY() < ySize);
        return checkX && checkY;
    }

    public boolean isContainEntity(Entity entity) {
        return entities.containsValue(entity);
    }

    public Coordinates getEntityCoordinates(Entity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Getting entity coordinates failed. An entity can not be null.");
        }

        Set<Map.Entry<Coordinates, Entity>> entrySet = entities.entrySet();
        for(Map.Entry<Coordinates, Entity> pair : entrySet) {
            if (entity.equals(pair.getValue())) {
                return pair.getKey();
            }
        }
        throw new EntityNotFoundException("The entity not found in the WorldMap");
    }

//    public Coordinates getEntityCoordinates(Entity entity) {
//        if (entity == null) {
//            throw new IllegalArgumentException("Getting entity coordinates failed. An entity cannot be null.");
//        }
//
//        return entities.entrySet().stream()
//                .filter(entry -> entity.equals(entry.getValue())) // фильтруем по значению
//                .map(Map.Entry::getKey) // отображаем в ключ (Coordinates)
//                .findFirst() // получаем первый элемент, соответствующий условию
//                .orElseThrow(() -> new EntityNotFoundException("The entity not found in the WorldMap"));
//    }

    public List<Coordinates> getAllCoordinatesList() {
        List<Coordinates> coordinates = new ArrayList<>();

        for (int i = 0; i < this.xSize; i++) {
            for (int j = 0; j < this.ySize; j++) {
                coordinates.add(new Coordinates(i, j));
            }
        }
        return coordinates;
    }

    public List<Entity> getAllEntities() {
        Set<Map.Entry<Coordinates, Entity>> entrySet = entities.entrySet();
        return entrySet.stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }


}
