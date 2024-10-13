package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.view.ConsoleWorldMapRenderer;
import com.dmitriykolesnik.simulation.view.WorldMapRenderer;
import com.dmitriykolesnik.simulation.world_map.WolfRabbitWorldMapFactory;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import com.dmitriykolesnik.simulation.world_map.WorldMapFactory;

public class CreateWorldMapAction extends InitAction {

    private WorldMap createWorldMap(/*WorldMapFactory worldMapFactory, WorldMap worldMap*/) {
        int x_Size = ActionsDataSingleton.getInstance().getX_SizeWorldMap();
        int y_Size = ActionsDataSingleton.getInstance().getY_SizeWorldMap();
        WorldMapFactory worldMapFactory = new WolfRabbitWorldMapFactory(x_Size, y_Size);
        return worldMapFactory.create();
    }

    @Override
    public void perform() {
        WorldMap worldMap = createWorldMap();
        WorldMapRenderer renderer = new ConsoleWorldMapRenderer();
        renderer.render(worldMap);

    }
}
