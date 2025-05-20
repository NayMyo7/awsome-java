package dev.naymyohtet.codesignal;

import java.util.*;

public class TwoDimensionalArr {

    public static void main(String[] args) {
        runTest(3, 3, 100);
        runTest(10, 10, 10_000);
        runTest(100, 100, 1_000_000);
    }

    private static void runTest(int height, int width, int numQueries) {
        long start = System.currentTimeMillis();

        Map<Integer, Set<Integer>> blacklist = new HashMap<>();
        for (int h = 0; h < height; h++) {
            blacklist.put(h, new HashSet<>());
        }

        List<List<Integer>> result = new ArrayList<>();
        String[] directions = {"x", ">", "<", "^", "v"};
        Random random = new Random();

        for (int i = 0; i < numQueries; i++) {
            String op = directions[random.nextInt(directions.length)];
            int h = random.nextInt(height);
            int w = random.nextInt(width);

            switch (op) {
                case "x" -> blacklist.get(h).add(w);
                case ">" -> moveRight(blacklist, h, w + 1, width, result);
                case "<" -> moveLeft(blacklist, h, w - 1, result);
                case "^" -> moveUp(blacklist, h - 1, w, result);
                case "v" -> moveDown(blacklist, h + 1, w, height, result);
            }
        }

        long end = System.currentTimeMillis();
        System.out.printf("Grid %dx%d, Queries: %d, Time taken: %d ms%n",
                height, width, numQueries, (end - start));
    }

    private static void moveRight(Map<Integer, Set<Integer>> blacklist, int h, int w, int width, List<List<Integer>> result) {
        if (w == width) {
            result.add(List.of(-1, -1));
            return;
        }

        if (hitBlackList(blacklist, h, w)) {
            w = w + 1;
        } else {
            result.add(List.of(h, w));
            return;
        }

        moveRight(blacklist, h, w, width, result);
    }

    private static void moveLeft(Map<Integer, Set<Integer>> blacklist, int h, int w, List<List<Integer>> result) {
        if (w < 0) {
            result.add(List.of(-1, -1));
            return;
        }

        if (hitBlackList(blacklist, h, w)) {
            w = w - 1;
        } else {
            result.add(List.of(h, w));
            return;
        }

        moveLeft(blacklist, h, w, result);
    }

    private static void moveUp(Map<Integer, Set<Integer>> blacklist, int h, int w, List<List<Integer>> result) {
        if (h < 0) {
            result.add(List.of(-1, -1));
            return;
        }

        if (hitBlackList(blacklist, h, w)) {
            h = h - 1;
        } else {
            result.add(List.of(h, w));
            return;
        }

        moveUp(blacklist, h, w, result);
    }

    private static void moveDown(Map<Integer, Set<Integer>> blacklist, int h, int w, int height, List<List<Integer>> result) {
        if (h == height) {
            result.add(List.of(-1, -1));
            return;
        }

        if (hitBlackList(blacklist, h, w)) {
            h = h + 1;
        } else {
            result.add(List.of(h, w));
            return;
        }

        moveDown(blacklist, h, w, height, result);
    }

    private static boolean hitBlackList(Map<Integer, Set<Integer>> blacklist, int h, int w) {
        return blacklist.get(h) != null && blacklist.get(h).contains(w);
    }
}
