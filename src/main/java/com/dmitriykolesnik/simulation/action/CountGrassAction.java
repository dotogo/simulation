package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.world_map.WorldMap;


public class CountGrassAction extends TurnAction{

    public CountGrassAction(WorldMap worldMap) {
        super(worldMap);
    }

    @Override
    public void perform() {
        System.out.println("Counting Grass before new turn...");
        int grassCounter = 0;

        if(worldMap == null) {
            System.out.println("worldMap == null");
        }

        for (int y = worldMap.getYsize() - 1; y >= 0; y--) {
            for (int x = 0; x < worldMap.getXsize(); x++) {
                Coordinates coordinates = new Coordinates(x, y);
                Entity entity = null;

                if (worldMap.isCellContainingEntity(coordinates)) {
                    entity = worldMap.getEntity(coordinates);
                }

                if (entity instanceof Grass) {
                    grassCounter++;
                }
            }
        }

        System.out.println("Grass total: " + grassCounter);

//        Reflections reflections = new Reflections("com.dmitriykolesnik.simulation");
//        Set<Class<? extends Creature>> subclasses = reflections.getSubTypesOf(Creature.class);
//        subclasses.forEach(subclass -> System.out.println(subclass.getSimpleName()));
//        System.out.println();

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
    }
}
