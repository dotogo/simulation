package com.dmitriykolesnik.simulation.entities;

public enum EntityType {

    CAT(" \uD83D\uDC08 "),
    LION(" \uD83E\uDD81 "),
    WOLF(" \uD83D\uDC3A "),
    T_REX(" \uD83E\uDD96 "),

    BUFFALO(" \uD83D\uDC03 "),
    SHEEP(" \uD83D\uDC11 "),
    ZEBRA(" \uD83E\uDD93 "),

    RABBIT(" \uD83D\uDC07 "),
    MOUSE(" \uD83D\uDC01 "),

    GRASS(" \uD83C\uDF31 "),
    GRAIN(" \uD83C\uDF3E "),

    ROCK(" \uD83E\uDDF1 "),
    TREE(" \uD83C\uDF33 ");

    private final String entitySprite;

    EntityType(String entitySprite) {
        this.entitySprite = entitySprite;
    }

    public String getEntitySprite() {
        return entitySprite;
    }

}
