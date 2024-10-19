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
    private static final int RABBIT_AMOUNT = 7;
    private static final int WOLF_AMOUNT = 2;
    private static final int CAT_AMOUNT = 2;
    private static final int MOUSE_AMOUNT = 12;
    private static final int GRASS_AMOUNT = 25;
    private static final int GRAIN_AMOUNT = 20;
    private static final int TREE_AMOUNT = 15;
    private static final int ROCK_AMOUNT = 10;
    private final int HORIZONTAL_SIZE;
    private final int VERTICAL_SIZE;

    private final EntityFactory<Rabbit> rabbitFactory = new RabbitFactoryRandom();
    private final EntityFactory<Wolf> wolfFactory = new WolfFactoryRandom();
    private final EntityFactory<Cat> catFactory = new CatFactoryRandom();
    private final EntityFactory<Mouse> mouseFactory = new MouseFactoryRandom();
    private final EntityFactory<Grass> grassFactory = new GrassFactoryRandom();
    private final EntityFactory<Grain> grainFactory = new GrainFactoryRandom();

    public BasicWorldMapFactory(int horizontalSize, int verticalSize) {
        HORIZONTAL_SIZE = horizontalSize;
        VERTICAL_SIZE = verticalSize;
    }

    @Override
    public WorldMap create() {
        WorldMap worldMap = new WorldMap(HORIZONTAL_SIZE, VERTICAL_SIZE);
        List<Coordinates> allCoordinates = worldMap.getAllCoordinatesList();

        List<Entity> rabbits = getEntitiesToBePopulated(rabbitFactory, RABBIT_AMOUNT);
        List<Entity> wolfs = getEntitiesToBePopulated(wolfFactory, WOLF_AMOUNT);
        List<Entity> cats = getEntitiesToBePopulated(catFactory, CAT_AMOUNT);
        List<Entity> mice = getEntitiesToBePopulated(mouseFactory, MOUSE_AMOUNT);
        List<Entity> grass = getEntitiesToBePopulated(grassFactory, GRASS_AMOUNT);
        List<Entity> grain = getEntitiesToBePopulated(grainFactory, GRAIN_AMOUNT);
        List<Entity> trees = getEntitiesToBePopulated(new Tree(), TREE_AMOUNT);
        List<Entity> rocks = getEntitiesToBePopulated(new Rock(), ROCK_AMOUNT);

        List<Entity> allEntities = Stream.of(rabbits, wolfs, cats, mice, grass, grain, trees, rocks)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Collections.shuffle(allCoordinates);

        for (int i = 0; i < allEntities.size(); i++) {
            worldMap.setEntity(allCoordinates.get(i), allEntities.get(i));
        }
        return worldMap;
    }


}
