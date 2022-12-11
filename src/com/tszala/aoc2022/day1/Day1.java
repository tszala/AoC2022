package com.tszala.aoc2022.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/com/tszala/aoc2022/day1/input.txt"));

        problemOne(lines);

        problemTwo(lines);
    }

    private static void problemTwo(List<String> lines) {
        int caloriesCounter = 0;
        List<Integer> elfsWithCalories = new ArrayList<>();
        for (String line : lines) {
            if (line.isBlank()) {
                elfsWithCalories.add(caloriesCounter);
                caloriesCounter = 0;
            } else {
                caloriesCounter += Long.parseLong(line);
            }
        }
        elfsWithCalories.sort((c1, c2) -> c2 - c1);
        System.out.printf("Calories count from first three elves: %d, %d, %d%n", elfsWithCalories.get(0),elfsWithCalories.get(1),elfsWithCalories.get(2));
        System.out.printf("Calories count from first three elves: %d%n", elfsWithCalories.get(0)+elfsWithCalories.get(1)+elfsWithCalories.get(2));
    }

    private static void problemOne(List<String> lines) {
        long highestCalories = 0L;
        long caloriesCounter = 0L;
        for (String line : lines) {
            if (line.isBlank()) {
                if (caloriesCounter > highestCalories) {
                    highestCalories = caloriesCounter;
                }
                caloriesCounter = 0L;
            } else {
                caloriesCounter += Long.parseLong(line);
            }
        }
        System.out.printf("Highest calories: %d%n", highestCalories);
    }

}
