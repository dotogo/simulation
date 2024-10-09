package com.dmitriykolesnik.simulation.world_map;
/*
import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Wolf;
import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.entities.static_entities.Rock;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;
import com.dmitriykolesnik.simulation.entity_factories.impl.RabbitFactoryRandom;
import com.dmitriykolesnik.simulation.entity_factories.impl.WolfFactoryRandom;

import java.util.Random;

public class TestWorldMapFactory implements WorldMapFactory{
    private final static int X_SIZE = 5;
    private final static int Y_SIZE = 5;
    private final static int MIN_EMPTY_SPACE_PERCENT = 70;
    private final static Random RANDOM = new Random();

    private final EntityFactory<Rabbit> rabbitFactory = new RabbitFactoryRandom();
    private final EntityFactory<Wolf> wolfFactory = new WolfFactoryRandom();


    @Override
    public WorldMap create() {
        WorldMap worldMap = new WorldMap(X_SIZE, Y_SIZE);

//        worldMap.setEntity(new Coordinates(3,4), rabbitFactory.create(new Coordinates(3,4)));
//        worldMap.setEntity(new Coordinates(0,2), rabbitFactory.create(new Coordinates(0,2)));
//        //worldMap.setEntity(new Coordinates(1,3), rabbitFactory.create(new Coordinates(1,3)));
//        worldMap.setEntity(new Coordinates(1,0), rabbitFactory.create(new Coordinates(1,0)));
//
//
//        worldMap.setEntity(new Coordinates(2,2), wolfFactory.create(new Coordinates(2,2)));
//        worldMap.setEntity(new Coordinates(4,0), wolfFactory.create(new Coordinates(4,0)));

        //worldMap.setEntity(new Coordinates(3,4), new Rabbit(new Coordinates(3,4), 50, 4));
        //worldMap.setEntity(new Coordinates(0,2), new Rabbit(new Coordinates(0,2), 50, 4));
        //worldMap.setEntity(new Coordinates(1,0), new Rabbit(new Coordinates(1,0), 50, 4));
        worldMap.setEntity(new Coordinates(0,0), new Rabbit(new Coordinates(0,0), 50, 3));


        //worldMap.setEntity(new Coordinates(2,2), new Wolf(new Coordinates(2, 2), 80, 4, 70));
        worldMap.setEntity(new Coordinates(4,0), new Wolf(new Coordinates(4, 0), 80, 3, 40));

        //worldMap.setEntity(new Coordinates(1,1), new Grass(new Coordinates(1,1), 20));
        worldMap.setEntity(new Coordinates(2,0), new Grass(new Coordinates(2,0), 10));
        //worldMap.setEntity(new Coordinates(3,3), new Grass(new Coordinates(3,3), 25));
        //worldMap.setEntity(new Coordinates(3,0), new Grass(new Coordinates(3,0)));
        //worldMap.setEntity(new Coordinates(0,4), new Grass(new Coordinates(0,4), 30));
        //worldMap.setEntity(new Coordinates(4,4), new Grass(new Coordinates(4,4), 15));
        //worldMap.setEntity(new Coordinates(1,0), new Grass(new Coordinates(1,0), 20));
        //worldMap.setEntity(new Coordinates(1,2), new Grass(new Coordinates(1,2), 20));

        worldMap.setEntity(new Coordinates(2,2), new Rock(new Coordinates(2,2)));
        worldMap.setEntity(new Coordinates(1,2), new Rock(new Coordinates(1,2)));
        worldMap.setEntity(new Coordinates(1,0), new Rock(new Coordinates(1,0)));
        worldMap.setEntity(new Coordinates(1,1), new Rock(new Coordinates(1,1)));
        worldMap.setEntity(new Coordinates(0,4), new Rock(new Coordinates(0,4)));
        worldMap.setEntity(new Coordinates(3,3), new Rock(new Coordinates(3,3)));
        worldMap.setEntity(new Coordinates(4,4), new Rock(new Coordinates(4,4)));

//        worldMap.setEntity(new Coordinates(0,1), new Grass(new Coordinates(0,1)));
//        worldMap.setEntity(new Coordinates(3,1), new Grass(new Coordinates(3,1)));
//        worldMap.setEntity(new Coordinates(4,1), new Grass(new Coordinates(4,1)));
//        worldMap.setEntity(new Coordinates(3,0), new Grass(new Coordinates(3,0)));
//        worldMap.setEntity(new Coordinates(3,1), new Grass(new Coordinates(3,1)));

        return worldMap;
    }

    private boolean isCreatingEmptyCell() {
//        if (WorldMapFactory.EMPTY_SPACE_PERCENT < 0 || WorldMapFactory.EMPTY_SPACE_PERCENT > 100) {
//            throw new IllegalArgumentException("Empty space percent should be an integer between 0 and 100");
//        }

        //Random random = new Random();
        return RANDOM.nextInt(101) <= TestWorldMapFactory.MIN_EMPTY_SPACE_PERCENT;
    }
}

 */
