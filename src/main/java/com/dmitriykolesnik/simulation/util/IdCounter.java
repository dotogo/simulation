package com.dmitriykolesnik.simulation.util;

public final class IdCounter {
    private static long nextId;

    static {
        nextId = -1L;
    }

    private IdCounter() {
    }

    public static long getNextId() {
        return ++nextId;
    }
}
