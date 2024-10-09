package com.dmitriykolesnik.simulation.world_map;
/*
import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;
import com.dmitriykolesnik.simulation.entity_factories.impl.*;

import java.util.Random;

public class RandomWorldMapFactory implements WorldMapFactory {
    private final static int X_SIZE = 10;
    private final static int Y_SIZE = 10;
    private final static int MIN_EMPTY_SPACE_PERCENT = 80;
    private final static Random RANDOM = new Random();

    private final EntityFactory<Entity> entityFactory = new RandomEntityFactory();
    //private final EntityFactory<Cat> entityFactory = new CatFactoryRandom();

    public WorldMap create() {
        WorldMap worldMap = new WorldMap(X_SIZE, Y_SIZE);

        for (int y = Y_SIZE - 1; y >= 0; y--) {
            for (int x = 0; x < X_SIZE; x++) {
                Coordinates coordinates = new Coordinates(x, y);

                if (isCreatingEmptyCell()) {
                    continue;
                }
                Entity randomEntity = entityFactory.create(coordinates);
                worldMap.setEntity(coordinates, randomEntity);
            }
        }
        return worldMap;
    }

    private Entity createRandomEntity(Coordinates coordinates) {
        int randomEntityTypeNumberRepresentation = RANDOM.nextInt(EntityType.values().length);

        switch (randomEntityTypeNumberRepresentation) {
            case 0 :
                //return new Cat(coordinates);
                return new CatFactoryRandom().create(coordinates);
            case 1 :
                return new LionFactoryRandom().create(coordinates);
            case 2 :
                return new WolfFactoryRandom().create(coordinates);
            case 3 :
                return new T_RexFactory().create(coordinates);

            case 4 :
                return new BuffaloFactory().create(coordinates);
            case 5 :
                return new SheepFactory().create(coordinates);
            case 6 :
                return new ZebraFactory().create(coordinates);

            case 7 :
                return new GrassFactoryRandom().create(coordinates);
            case 8 :
                return new RockFactory().create(coordinates);
            case 9 :
                return new TreeFactory().create(coordinates);
            default :
                throw new RuntimeException("Random entity creation failed");

        }
    }

    private boolean isCreatingEmptyCell() {
//        if (WorldMapFactory.EMPTY_SPACE_PERCENT < 0 || WorldMapFactory.EMPTY_SPACE_PERCENT > 100) {
//            throw new IllegalArgumentException("Empty space percent should be an integer between 0 and 100");
//        }

        Random random = new Random();
        return random.nextInt(101) <= RandomWorldMapFactory.MIN_EMPTY_SPACE_PERCENT;
    }




}

 */
