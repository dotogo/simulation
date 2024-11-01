package com.dmitriykolesnik.simulation.entity_factories.impl;
/*
import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.EntityType;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;

import java.util.Random;

public class RandomEntityFactory implements EntityFactory<Entity> {

    private static final int PREDATORS_TOTAL_MAX_NUMBER = 15;
    private static final int T_REX_MAX_NUMBER = 1;
    private static final int LION_MAX_NUMBER = 5;
    private static final int WOLF_MAX_NUMBER = 12;
    //private static final int CAT_MAX_NUMBER = 10;

    private static final int HERBIVORE_MAX_NUMBER = 35;
    private static final int BUFFALO_MAX_NUMBER = 5;
    private static final int SHEEP_MAX_NUMBER = 25;
    private static final int ZEBRA_MAX_NUMBER = 25;

    private final Random random = new Random();


    public Entity create(Coordinates coordinates) {
        int randomEntityTypeNumberRepresentation = random.nextInt(EntityType.values().length);

        switch (randomEntityTypeNumberRepresentation) {
            case 0 :
                //return new Cat(coordinates);
                return new CatFactory().create(coordinates);
            case 1 :
                return new LionFactory().create(coordinates);
            case 2 :
                return new WolfFactory().create(coordinates);
            case 3 :
                return new TyrannosaurusRexFactory().create(coordinates);

            case 4 :
                return new BuffaloFactory().create(coordinates);
            case 5 :
                return new SheepFactory().create(coordinates);
            case 6 :
                return new ZebraFactory().create(coordinates);

            case 7 :
                return new GrassFactory().create(coordinates);
            case 8 :
                return new RockFactory().create(coordinates);
            case 9 :
                return new TreeFactory().create(coordinates);
            default :
                throw new RuntimeException("Random entity creation failed");

            }
    }


}

 */
