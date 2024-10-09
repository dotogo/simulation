package com.dmitriykolesnik.simulation.view;

import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.world_map.WorldMap;

public class ConsoleWorldMapRenderer implements WorldMapRenderer {

    public void render(WorldMap worldMap) {
        for (int y = worldMap.getYsize() - 1; y >= 0; y--) {
            StringBuilder line = new StringBuilder();

            for (int x = 0; x < worldMap.getXsize(); x++) {
                Coordinates coordinates = new Coordinates(x, y);

                if (!worldMap.isCellContainingEntity(coordinates)) {
                    line.append(" .. ");

                } else {
                    String entitySprite = worldMap.getEntity(coordinates).getEntityType().getEntitySprite();
                    if (entitySprite != null) {
                        line.append(entitySprite);
                    } else {
                        throw new RuntimeException("Failed to find the entity sprite");
                    }
                }
            }

            if (y < 10) {
                System.out.println(" " + y + line);
            } else {
                System.out.print(y);
                System.out.println(line);
            }
        }

        System.out.print("  ");
        for (int i = 0; i < worldMap.getXsize(); i++) {
            if (i < 10) {
                System.out.print("  " + i + " ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
        System.out.println("\n\n");
    }


}
