package com.dmitriykolesnik.simulation.world_map;

public class CustomWorldMapFactory implements WorldMapFactory {
    private final int horizontalSize;
    private final int verticalSize;

    public CustomWorldMapFactory(int horizontalSize, int verticalSize) {
        this.horizontalSize = horizontalSize;
        this.verticalSize = verticalSize;
    }

    @Override
    public WorldMap create() {
        return null;
    }
}
