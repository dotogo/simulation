package com.dmitriykolesnik.simulation.menu;

import com.dmitriykolesnik.simulation.util.UtilSimulation;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String title;
    private final String makeSelection;
    private final String errorText;
    private int idCounter;
    private List<Item> items = new ArrayList<>();

    public Menu(String title, String makeSelection, String errorText) {
        this.title = title;
        this.makeSelection = makeSelection;
        this.errorText = errorText;
    }

    public void addItem(String name, Runnable action) {
        items.add(new Item(++idCounter, name, action));
    }

    public void show() {
        System.out.println(title);
        items.forEach(item -> System.out.println(item.getId() + ") " + item.getName()));
        System.out.println();
    }

    public void execute() {
        System.out.println(makeSelection);
        while (true) {
            int itemId = UtilSimulation.getPositiveIntFromKeyboard();

            if (isCorrectItemId(itemId)) {
                runItemAction(itemId);
                break;
            }
            System.out.println(errorText);
        }
    }

    private boolean isCorrectItemId(int itemId) {
        return (itemId > 0) && (itemId <= items.size());
    }

    private void runItemAction(int itemId) {
        items.get(itemId - 1).getAction().run();
    }


    private class Item {
        private final int id;
        private final String name;
        private final Runnable action;

        private Item(int id, String name, Runnable action) {
            this.id = id;
            this.name = name;
            this.action = action;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Runnable getAction() {
            return action;
        }
    }
}
