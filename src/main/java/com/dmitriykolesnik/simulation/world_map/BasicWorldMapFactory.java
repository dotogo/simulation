package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Mouse;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Cat;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Wolf;
import com.dmitriykolesnik.simulation.entities.static_entities.Grain;
import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.entities.static_entities.Rock;
import com.dmitriykolesnik.simulation.entities.static_entities.Tree;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;
import com.dmitriykolesnik.simulation.entity_factories.impl.*;
import com.dmitriykolesnik.simulation.util.GameSettings;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicWorldMapFactory implements WorldMapFactory {
    private static final int RABBITS_PERCENT_FROM_TOTAL_ENTITIES = 10;
    private static final int WOLFS_PERCENT_FROM_TOTAL_ENTITIES = 2;
    private static final int CATS_PERCENT_FROM_TOTAL_ENTITIES = 2;
    private static final int MICE_PERCENT_FROM_TOTAL_ENTITIES = 10;
    private static final int GRASS_PERCENT_FROM_TOTAL_ENTITIES = 28;
    private static final int GRAIN_PERCENT_FROM_TOTAL_ENTITIES = 25;
    private static final int TREES_PERCENT_FROM_TOTAL_ENTITIES = 13;
    private static final int ROCK_PERCENT_FROM_TOTAL_ENTITIES = 10;

    private final int width;
    private final int height;
    private int occupancyRate;

    private final EntityFactory<Rabbit> rabbitFactory = new RabbitFactory();
    private final EntityFactory<Wolf> wolfFactory = new WolfFactory();
    private final EntityFactory<Cat> catFactory = new CatFactory();
    private final EntityFactory<Mouse> mouseFactory = new MouseFactory();
    private final EntityFactory<Grass> grassFactory = new GrassFactory();
    private final EntityFactory<Grain> grainFactory = new GrainFactory();

    private int rabbitsAmount = 2;
    private int wolfsAmount = 1;
    private int catsAmount = 1;
    private int miceAmount = 2;
    private int grassAmount = 5;
    private int grainAmount = 5;
    private int treesAmount = 2;
    private int rockAmount = 2;

    public BasicWorldMapFactory(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public BasicWorldMapFactory(int width, int height, int occupancyRate ) {
        this.width = width;
        this.height = height;
        this.occupancyRate = occupancyRate;
    }

    @Override
    public WorldMap create() {
        WorldMap worldMap = new WorldMap(width, height);
        List<Coordinates> allCoordinates = worldMap.getAllCoordinates();

        calculateNumberOfEachCreature();

        List<Entity> rabbits = getEntitiesToBePopulated(rabbitFactory, rabbitsAmount);
        List<Entity> wolfs = getEntitiesToBePopulated(wolfFactory, wolfsAmount);
        List<Entity> cats = getEntitiesToBePopulated(catFactory, catsAmount);
        List<Entity> mice = getEntitiesToBePopulated(mouseFactory, miceAmount);
        List<Entity> grass = getEntitiesToBePopulated(grassFactory, grassAmount);
        List<Entity> grain = getEntitiesToBePopulated(grainFactory, grainAmount);
        List<Entity> trees = getEntitiesToBePopulated(new Tree(), treesAmount);
        List<Entity> rocks = getEntitiesToBePopulated(new Rock(), rockAmount);

        List<Entity> allEntities = Stream.of(rabbits, wolfs, cats, mice, grass, grain, trees, rocks)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Collections.shuffle(allCoordinates);

        for (int i = 0; i < allEntities.size(); i++) {
            worldMap.setEntity(allCoordinates.get(i), allEntities.get(i));
        }
        return worldMap;
    }

    private int calculateWorldMapArea() {
        return width * height;
    }

    private int calculateTotalEntities() {
        return calculateWorldMapArea() * occupancyRate / 100;
    }

    private void calculateNumberOfEachCreature() {
        if (GameSettings.isDefaultEntitiesAmount(width, height)) {
            return;
        }

        int totalEntities = calculateTotalEntities();

        rabbitsAmount = totalEntities * RABBITS_PERCENT_FROM_TOTAL_ENTITIES / 100;
        wolfsAmount = totalEntities * WOLFS_PERCENT_FROM_TOTAL_ENTITIES / 100;
        catsAmount = totalEntities * CATS_PERCENT_FROM_TOTAL_ENTITIES / 100;
        miceAmount = totalEntities * MICE_PERCENT_FROM_TOTAL_ENTITIES / 100;
        grassAmount = totalEntities * GRASS_PERCENT_FROM_TOTAL_ENTITIES / 100;
        grainAmount = totalEntities * GRAIN_PERCENT_FROM_TOTAL_ENTITIES / 100;
        treesAmount = totalEntities * TREES_PERCENT_FROM_TOTAL_ENTITIES / 100;
        rockAmount = totalEntities * ROCK_PERCENT_FROM_TOTAL_ENTITIES / 100;
    }
}
