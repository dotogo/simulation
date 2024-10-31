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
    private static final int MAX_WORLD_MAP_AREA_FOR_USING_DEFAULT_ENTITIES_AMOUNT = 144;

    private final int horizontalSize;
    private final int verticalSize;
    private final int occupancyRate;

    private final EntityFactory<Rabbit> rabbitFactory = new RabbitFactoryRandom();
    private final EntityFactory<Wolf> wolfFactory = new WolfFactoryRandom();
    private final EntityFactory<Cat> catFactory = new CatFactoryRandom();
    private final EntityFactory<Mouse> mouseFactory = new MouseFactoryRandom();
    private final EntityFactory<Grass> grassFactory = new GrassFactoryRandom();
    private final EntityFactory<Grain> grainFactory = new GrainFactoryRandom();

    private int rabbitsAmount;
    private int wolfsAmount;
    private int catsAmount;
    private int miceAmount;
    private int grassAmount;
    private int grainAmount;
    private int treesAmount;
    private int rockAmount;

    public BasicWorldMapFactory(int horizontalSize, int verticalSize, int occupancyRate) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
        this.occupancyRate = occupancyRate;
    }

    @Override
    public WorldMap create() {
        WorldMap worldMap = new WorldMap(horizontalSize, verticalSize);
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
        return horizontalSize * verticalSize;
    }

    private int calculateTotalEntities() {
        return calculateWorldMapArea() * occupancyRate / 100;
    }

    private void calculateNumberOfEachCreature() {
        if (calculateWorldMapArea() <= MAX_WORLD_MAP_AREA_FOR_USING_DEFAULT_ENTITIES_AMOUNT) {
            rabbitsAmount = 2;
            wolfsAmount = 1;
            catsAmount = 1;
            miceAmount = 2;
            grassAmount = 5;
            grainAmount = 5;
            treesAmount = 2;
            rockAmount = 2;
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
