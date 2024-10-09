package com.dmitriykolesnik.simulation.world_map;
/*
import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Wolf;
import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;
import com.dmitriykolesnik.simulation.entity_factories.impl.GrassFactoryRandom;
import com.dmitriykolesnik.simulation.entity_factories.impl.RabbitFactoryRandom;
import com.dmitriykolesnik.simulation.entity_factories.impl.WolfFactoryRandom;

import java.util.Random;

public class TestWorldMapFactory_2 implements WorldMapFactory {
    private final static int X_SIZE = 15;
    private final static int Y_SIZE = 15;
    private final static int MIN_EMPTY_SPACE_PERCENT = 70;
    private final static Random RANDOM = new Random();

    private final EntityFactory<Rabbit> rabbitFactory = new RabbitFactoryRandom();
    private final EntityFactory<Wolf> wolfFactory = new WolfFactoryRandom();
    private final EntityFactory<Grass> grassFactory = new GrassFactoryRandom();


    @Override
    public WorldMap create() {
        WorldMap worldMap = new WorldMap(X_SIZE, Y_SIZE);

//        Rabbit rabbit_1 = rabbitFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(rabbit_1.getCoordinates().getX(), rabbit_1.getCoordinates().getY()), rabbit_1);
//
//        Rabbit rabbit_2 = rabbitFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(rabbit_2.getCoordinates().getX(), rabbit_2.getCoordinates().getY()), rabbit_2);
//
//        Rabbit rabbit_3 = rabbitFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(rabbit_3.getCoordinates().getX(), rabbit_3.getCoordinates().getY()), rabbit_3);
//
//        Rabbit rabbit_4 = rabbitFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(rabbit_4.getCoordinates().getX(), rabbit_4.getCoordinates().getY()), rabbit_4);
//
//        Rabbit rabbit_5 = rabbitFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(rabbit_5.getCoordinates().getX(), rabbit_5.getCoordinates().getY()), rabbit_5);
//
//        Rabbit rabbit_6 = rabbitFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(rabbit_6.getCoordinates().getX(), rabbit_6.getCoordinates().getY()), rabbit_6);
//
//
//
//        Grass grass_1 = grassFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(grass_1.getCoordinates().getX(), grass_1.getCoordinates().getY()), grass_1);
//
//        Grass grass_2 = grassFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(grass_2.getCoordinates().getX(), grass_2.getCoordinates().getY()), grass_2);
//
//        Grass grass_3 = grassFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(grass_3.getCoordinates().getX(), grass_3.getCoordinates().getY()), grass_3);
//
//        Grass grass_4 = grassFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(grass_4.getCoordinates().getX(), grass_4.getCoordinates().getY()), grass_4);
//
//        Grass grass_5 = grassFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(grass_5.getCoordinates().getX(), grass_5.getCoordinates().getY()), grass_5);
//
//        Grass grass_6 = grassFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(grass_6.getCoordinates().getX(), grass_6.getCoordinates().getY()), grass_6);
//
//        Grass grass_7 = grassFactory.create(new Coordinates(RANDOM.nextInt(X_SIZE), RANDOM.nextInt(Y_SIZE)));
//        worldMap.setEntity(new Coordinates(grass_7.getCoordinates().getX(), grass_7.getCoordinates().getY()), grass_7);


        Rabbit rabbit_1 = rabbitFactory.create(new Coordinates(0, 7));
        worldMap.setEntity(new Coordinates(rabbit_1.getCoordinates().getX(), rabbit_1.getCoordinates().getY()), rabbit_1);

        Rabbit rabbit_2 = rabbitFactory.create(new Coordinates(10, 2));
        worldMap.setEntity(new Coordinates(rabbit_2.getCoordinates().getX(), rabbit_2.getCoordinates().getY()), rabbit_2);

        Rabbit rabbit_3 = rabbitFactory.create(new Coordinates(5, 5));
        worldMap.setEntity(new Coordinates(rabbit_3.getCoordinates().getX(), rabbit_3.getCoordinates().getY()), rabbit_3);

        Rabbit rabbit_4 = rabbitFactory.create(new Coordinates(3, 12));
        worldMap.setEntity(new Coordinates(rabbit_4.getCoordinates().getX(), rabbit_4.getCoordinates().getY()), rabbit_4);

        Rabbit rabbit_5 = rabbitFactory.create(new Coordinates(13, 4));
        worldMap.setEntity(new Coordinates(rabbit_5.getCoordinates().getX(), rabbit_5.getCoordinates().getY()), rabbit_5);

        Rabbit rabbit_6 = rabbitFactory.create(new Coordinates(9, 10));
        worldMap.setEntity(new Coordinates(rabbit_6.getCoordinates().getX(), rabbit_6.getCoordinates().getY()), rabbit_6);



        Grass grass_1 = grassFactory.create(new Coordinates(1,7));
        worldMap.setEntity(new Coordinates(grass_1.getCoordinates().getX(), grass_1.getCoordinates().getY()), grass_1);

        Grass grass_2 = grassFactory.create(new Coordinates(7,8));
        worldMap.setEntity(new Coordinates(grass_2.getCoordinates().getX(), grass_2.getCoordinates().getY()), grass_2);

        Grass grass_3 = grassFactory.create(new Coordinates(0,13));
        worldMap.setEntity(new Coordinates(grass_3.getCoordinates().getX(), grass_3.getCoordinates().getY()), grass_3);

        Grass grass_4 = grassFactory.create(new Coordinates(2,3));
        worldMap.setEntity(new Coordinates(grass_4.getCoordinates().getX(), grass_4.getCoordinates().getY()), grass_4);

        Grass grass_5 = grassFactory.create(new Coordinates(7,10));
        worldMap.setEntity(new Coordinates(grass_5.getCoordinates().getX(), grass_5.getCoordinates().getY()), grass_5);

        Grass grass_6 = grassFactory.create(new Coordinates(4, 12));
        worldMap.setEntity(new Coordinates(grass_6.getCoordinates().getX(), grass_6.getCoordinates().getY()), grass_6);

        Grass grass_7 = grassFactory.create(new Coordinates(14, 7));
        worldMap.setEntity(new Coordinates(grass_7.getCoordinates().getX(), grass_7.getCoordinates().getY()), grass_7);



//        worldMap.setEntity(new Coordinates(3,4), rabbitFactory.create(new Coordinates(3,4)));
//        worldMap.setEntity(new Coordinates(0,2), rabbitFactory.create(new Coordinates(0,2)));
//        worldMap.setEntity(new Coordinates(1,0), rabbitFactory.create(new Coordinates(1,0)));
//
//
//        worldMap.setEntity(new Coordinates(14,12), wolfFactory.create(new Coordinates(14,12)));
//        worldMap.setEntity(new Coordinates(5,0), wolfFactory.create(new Coordinates(5,0)));




//        worldMap.setEntity(new Coordinates(3,4), new Rabbit(new Coordinates(3,4), 50, 4));
//        worldMap.setEntity(new Coordinates(0,2), new Rabbit(new Coordinates(0,2), 50, 4));
//        worldMap.setEntity(new Coordinates(1,0), new Rabbit(new Coordinates(1,0), 50, 4));
//
//
        worldMap.setEntity(new Coordinates(14,12), new Wolf(new Coordinates(14, 12), 80, 4, 70));
        worldMap.setEntity(new Coordinates(5,0), new Wolf(new Coordinates(5, 0), 80, 4, 40));
//
//        worldMap.setEntity(new Coordinates(1,1), new Grass(new Coordinates(1,1)));
//        worldMap.setEntity(new Coordinates(2,1), new Grass(new Coordinates(2,1)));
//        worldMap.setEntity(new Coordinates(3,3), new Grass(new Coordinates(3,3)));
//        worldMap.setEntity(new Coordinates(3,0), new Grass(new Coordinates(3,0)));
//        worldMap.setEntity(new Coordinates(0,4), new Grass(new Coordinates(0,4)));
//        worldMap.setEntity(new Coordinates(4,4), new Grass(new Coordinates(4,4)));

        return worldMap;
    }

    private boolean isCreatingEmptyCell() {
//        if (WorldMapFactory.EMPTY_SPACE_PERCENT < 0 || WorldMapFactory.EMPTY_SPACE_PERCENT > 100) {
//            throw new IllegalArgumentException("Empty space percent should be an integer between 0 and 100");
//        }

        //Random random = new Random();
        return RANDOM.nextInt(101) <= TestWorldMapFactory_2.MIN_EMPTY_SPACE_PERCENT;
    }
}

 */
