package com.dmitriykolesnik.simulation.entities;

public enum EntityType {

    CAT(" \uD83D\uDC08 "),
    LION(" \uD83E\uDD81 "),
    WOLF(" \uD83D\uDC3A "),
    T_REX(" \uD83E\uDD96 "),

    BUFFALO(" \uD83D\uDC03 "),
    SHEEP(" \uD83D\uDC11 "),
    ZEBRA(" \uD83E\uDD93 "),

    GRASS(" \uD83C\uDF31 "),
    //ROCK("\uD83E\uDEA8"),
    // ROCK(" □ "),
    ROCK(" \uD83E\uDDF1 "),
    //ROCK("    "),
    TREE(" \uD83C\uDF33 "),
    RABBIT(" \uD83D\uDC07 "),
    GRAIN(" \uD83C\uDF3E "),
    MOUSE(" \uD83D\uDC01 ");

    private final String entitySprite;


    EntityType(String entitySprite) {
        this.entitySprite = entitySprite;
    }

    public String getEntitySprite() {
        return entitySprite;
    }
}
