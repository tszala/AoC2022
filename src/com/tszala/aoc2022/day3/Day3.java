package com.tszala.aoc2022.day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day3 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/com/tszala/aoc2022/day3/input.txt"));

        System.out.printf("Sum of rucksack priorities %d%n", getRucksackPrioritySum(lines));

        System.out.printf("Sum of group priorities %d%n", getGroupPrioritiesSum(lines));
    }

    public static Integer getGroupPrioritiesSum(List<String> lines) {
        return split(lines, 3).stream()
                .map(Group::new).peek(System.out::println)
                .map(Group::commonType).peek(System.out::println)
                .map(Day3::getPriority).reduce(0, Integer::sum);
    }

    public static Integer getRucksackPrioritySum(List<String> input) {
        Integer priority = input.stream().map(Rucksack::new).
                peek(System.out::println).map(Rucksack::commonType).
                peek(System.out::println).map(Day3::getPriority).
                peek(System.out::println).reduce(0, Integer::sum);
        return priority;
    }

    static int getPriority(char item) {
        int startingValue = Character.isLowerCase(item) ? 96 : 64;
        int intValue =  (int) (item) - startingValue;
        return Character.isLowerCase(item) ? intValue : intValue + 26;
    }

    private static List<Character> getCollect(String items) {
        return items.chars().mapToObj(s -> (char) s).collect(Collectors.toList());
    }

    static class Rucksack {
        private final List<Character> c1;
        private final List<Character> c2;

        public Rucksack(String items) {
            c1 = getCollect(items.substring(0, items.length() / 2));
            c2 = getCollect(items.substring(items.length() / 2, items.length()));
        }

        @Override
        public String toString() {
            return String.format("R(c1(%s), c2(%s)", c1.stream().map(String::valueOf).collect(Collectors.joining()), c2.stream().map(String::valueOf).collect(Collectors.joining()));
        }

        public Character commonType() {
            for(Character c : c2) {
                Set<Character> c1Items = new HashSet<>(c1);
                if(!c1Items.add(c)) {
                    return c;
                }
            }
            throw new IllegalStateException("Incorrect rucksack: " + this.toString());
        }
    }

    static class Group {
        private final List<Character> t1;
        private final List<Character> t2;
        private final List<Character> t3;
        public Group(List<String> e) {
            t1 = getCollect(e.get(0));
            t2 = getCollect(e.get(1));
            t3 = getCollect(e.get(2));
        }

        public Character commonType() {
            for(Character c : t1) {
                Set<Character> t2Items = new HashSet<>(t2);
                Set<Character> t3Items = new HashSet<>(t3);

                if(!t2Items.add(c) && !t3Items.add(c)) {
                    return c;
                }
            }
            throw new IllegalStateException("Incorrect rucksack: " + this);
        }

        public String toString() {
            return String.format("G(t1(%s), t2(%s), t3(%s)", t1.toString(), t2.toString(), t3.toString());
        }
    }

    public static <T> List<List<T>> split(List<T> list, int size) {
        final AtomicInteger counter = new AtomicInteger();
        return new ArrayList<>(
                list.stream()
                        .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                        .values());
    }

}
