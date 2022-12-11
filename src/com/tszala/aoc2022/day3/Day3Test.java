package com.tszala.aoc2022.day3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day3Test {

    public static final List<String> INPUT = List.of(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw");

    @Test
    public void shouldSumRucksackPriorities() {
        Integer prioritySum = Day3.getRucksackPrioritySum(INPUT);
        Assertions.assertEquals(157, prioritySum);
    }

    @Test
    public void shouldSumGroupPriorities() {
        Integer prioritySum = Day3.getGroupPrioritiesSum(INPUT);
        Assertions.assertEquals(70, prioritySum);
    }

}
