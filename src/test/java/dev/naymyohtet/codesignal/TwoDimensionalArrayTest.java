package dev.naymyohtet.codesignal;

import org.junit.jupiter.api.Test;

import java.util.Random;

class TwoDimensionalArrayTest {

    @Test
    void testVariousGridSizesAndRandomOperations() {
        int[] sizes = {10, 50, 100, 200, 500};
        String[] ops = {"x", ">", "<", "^", "v"};
        Random rand = new Random();

        for (int size : sizes) {
            int h = size;
            int w = size;
            int numQueries = size * 2;
            String[] queries = new String[numQueries];

            for (int i = 0; i < numQueries; i++) {
                String op = ops[rand.nextInt(ops.length)];
                int x = rand.nextInt(h);
                int y = rand.nextInt(w);
                queries[i] = op + " " + x + " " + y;
            }

            long start = System.currentTimeMillis();
            int[][] result = TwoDimensionalArray.solution(h, w, queries);
            long end = System.currentTimeMillis();

            System.out.println("Grid: " + h + "x" + w + ", Queries: " + numQueries + ", Time: " + (end - start) + "ms, Results: " + result.length);
        }
    }
}