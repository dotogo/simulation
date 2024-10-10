package com.dmitriykolesnik.simulation.util;


import java.util.Random;
import java.util.Scanner;

public class UtilSimulation {
    private static final Random RANDOM = new Random();

    public static int getRandomNumberBetween(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("min must be less than or equal to max");
        }

        return UtilSimulation.RANDOM.nextInt((max - min) + 1) + min;
    }

    public static int getPositiveIntFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        String input;
        int number;

        while (true) {
            System.out.print("Enter a positive integer: ");
            input = scanner.nextLine().trim();

            if (input.matches("\\d+")) {
                number = Integer.parseInt(input);
                break;
            } else {
                System.out.println("This is not a positive integer. Try again.");
            }
        }

        return number;
    }
}
