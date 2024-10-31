package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.exceptions.EntityNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class WorldMap {
    private final int width;
    private final int height;
    private Map<Coordinates, Entity> entities = new HashMap<>();

    public WorldMap(int width, int height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException("Width and height of the WorldMap must be greater than 0");
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        if (isWithinWorldMap(coordinates)) {
            entities.put(coordinates, entity);
        } else {
            throw new IllegalArgumentException("The Entity must have positive coordinates within WorldMap " +
                    "(less than width and height)");
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

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = getEntity(from);

        removeEntity(from);
        setEntity(to, entity);
    }

    public boolean isNotEmptyCell(Coordinates coordinates) {
        return entities.containsKey(coordinates);
    }

    public boolean isWithinWorldMap(Coordinates coordinates) {
        boolean checkX = (coordinates.getX() >= 0) && (coordinates.getX() < width);
        boolean checkY = (coordinates.getY() >= 0) && (coordinates.getY() < height);
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
//                .filter(entry -> entity.equals(entry.getValue()))
//                .map(Map.Entry::getKey)
//                .findFirst()
//                .orElseThrow(() -> new EntityNotFoundException("The entity not found in the WorldMap"));
//    }

    public List<Coordinates> getAllCoordinates() {
        List<Coordinates> coordinates = new ArrayList<>();

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
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
