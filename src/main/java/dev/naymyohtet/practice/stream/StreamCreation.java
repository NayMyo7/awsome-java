package dev.naymyohtet.practice.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        // Creating streams from collections
        var set1 = Set.of(1, 2, 3, 4);
        var stream1 = set1.stream();
        stream1.forEach(System.out::println);

        Arrays.asList("one", "two", "three", "four").stream()
                .forEach(System.out::println);

        // Using stream builder
        Stream.Builder<Double> streamBuilder = Stream.builder();
        streamBuilder.add(1.2);
        streamBuilder.add(2.3).add(3.4);
        Stream<Double> stream2 = streamBuilder.build();
        stream2.forEach(System.out::println);

        // Range
        System.out.println("Using range ...");
        IntStream.range(1, 5).forEach(System.out::println);

        // Iterate
        System.out.println("Using iterate ...");
        IntStream.iterate(2, a -> a < 10, a -> a + 2).forEach(System.out::println);
        IntStream.iterate(2, a -> a + 2).takeWhile(a -> a < 15).forEach(System.out::println);

        // Generate
        Random random = new Random();
        Stream.generate(() -> random.nextDouble()).takeWhile(a -> a > 0.1).forEach(System.out::println);
    }
}
