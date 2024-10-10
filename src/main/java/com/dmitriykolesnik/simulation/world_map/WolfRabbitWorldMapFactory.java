package com.dmitriykolesnik.simulation.world_map;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Mouse;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Cat;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Wolf;
import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.entities.static_entities.Rock;
import com.dmitriykolesnik.simulation.entities.static_entities.Tree;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;
import com.dmitriykolesnik.simulation.entity_factories.impl.*;

import java.util.Random;

public class WolfRabbitWorldMapFactory implements WorldMapFactory{
    private final int X_SIZE;
    private final int Y_SIZE;
    private final static int AVERAGE_EMPTY_SPACE_PERCENT = 85;
    private final static Random RANDOM = new Random();

    private final EntityFactory<Rabbit> rabbitFactory = new RabbitFactoryRandom();
    private final EntityFactory<Wolf> wolfFactory = new WolfFactoryRandom();
    private final EntityFactory<Mouse> mouseFactoryRandom = new MouseFactoryRandom();
    private final EntityFactory<Cat> catFactoryRandom = new CatFactoryRandom();
    private final EntityFactory<Grass> grassFactory = new GrassFactoryRandom();

    public WolfRabbitWorldMapFactory(int xSize, int ySize) {
        X_SIZE = xSize;
        Y_SIZE = ySize;
    }


    @Override
    public WorldMap create() {
        WorldMap worldMap = new WorldMap(X_SIZE, Y_SIZE);

        for (int y = Y_SIZE - 1; y >= 0; y--) {
            for (int x = 0; x < X_SIZE; x++) {
                Coordinates coordinates = new Coordinates(x, y);

//                if (x == 10 && y == 5) {
//                    Entity rabbit = rabbitFactory.create();
//                    worldMap.setEntity(coordinates, rabbit);
//                    continue;
//                }
//
//                if (x == 2 && y == 1) {
//                    Entity rabbit = rabbitFactory.create();
//                    worldMap.setEntity(coordinates, rabbit);
//                    continue;
//                }

                if (isCreatingEmptyCell()) {
                    continue;
                }

                int choice = RANDOM.nextInt(100) + 1;



                if (choice <= 7 ) {
                    Entity rabbit = rabbitFactory.create();
                    worldMap.setEntity(coordinates, rabbit);
                }
                if (choice > 7 && choice <= 14) {
                    Entity mouse = mouseFactoryRandom.create();
                    worldMap.setEntity(coordinates, mouse);
                }

                if (choice > 14 && choice <= 17) {
                    Entity cat = catFactoryRandom.create();
                    worldMap.setEntity(coordinates, cat);
                }

                if (choice > 17 && choice <= 20) {
                    Entity tree = new Tree();
                    worldMap.setEntity(coordinates, tree);
                }

                if (choice > 20 && choice <= 24) {
                    Entity wolf = wolfFactory.create();
                    worldMap.setEntity(coordinates, wolf);
                }

                if (choice > 24 && choice < 80) {
                    Entity grass = grassFactory.create();
                    worldMap.setEntity(coordinates, grass);
                }

                if (choice > 80) {
                    Entity rock = new Rock();
                    worldMap.setEntity(coordinates, rock);
                }

            }
        }
        return worldMap;
    }

    private boolean isCreatingEmptyCell() {
//        if (WorldMapFactory.EMPTY_SPACE_PERCENT < 0 || WorldMapFactory.EMPTY_SPACE_PERCENT > 100) {
//            throw new IllegalArgumentException("Empty space percent should be an integer between 0 and 100");
//        }

        //Random random = new Random();
        return RANDOM.nextInt(101) <= WolfRabbitWorldMapFactory.AVERAGE_EMPTY_SPACE_PERCENT;
    }
}
