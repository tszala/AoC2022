package com.tszala.aoc2022.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day2 {

    //A Rock
    //B Paper
    //C Scissors
    //X Rock (1)
    //Y Paper (2)
    //Z Scissors (3)
    //win - 6
    //draw - 3
    private static final Map<String, Integer> SCORE_BOARD_PROBLEM_ONE = Map.of(
            "A X", 4,// draw 3 + 1
            "A Y", 8, // win 6 + 2
            "A Z", 3, // lost 0 + 3
            "B X", 1, // lost 0 + 1
            "B Y", 5, // draw 3 + 2
            "B Z", 9, // won 6 + 3
            "C X", 7, // won 6 + 1
            "C Y", 2, // lost 0 + 2
            "C Z", 6); // draw 3 + 3

    private static final Map<String, Integer> SCORE_BOARD_PROBLEM_TWO = Map.of(
            "A X", 3,// lose 0 + 3
            "A Y", 4, // draw 3 + 1
            "A Z", 8, // win 6 + 2
            "B X", 1, // lose 0 + 1
            "B Y", 5, // draw 3 + 2
            "B Z", 9, // win 6 + 3
            "C X", 2, // lose 0 + 2
            "C Y", 6, // draw 3 + 3
            "C Z", 7); // win 6 + 1

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/com/tszala/aoc2022/day2/input.txt"));
        System.out.printf("Problem 1 score is %d%n", lines.stream().map(SCORE_BOARD_PROBLEM_ONE::get).reduce(0, Integer::sum));
        System.out.printf("Problem 2 score is %d%n", lines.stream().map(SCORE_BOARD_PROBLEM_TWO::get).reduce(0, Integer::sum));



    }

    public static <T> List<List<T>> split(List<T> list, int size) {
        final AtomicInteger counter = new AtomicInteger();
        return new ArrayList<>(
                list.stream()
                        .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                        .values());
    }

}

