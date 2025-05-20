package dev.naymyohtet.codesignal;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        // int h = 3;
        // int w = 5;
        // String[] queries = { "v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "<
        // 2 0" };
        // Timestamp startTime = new Timestamp(System.currentTimeMillis());
        // int[][] result = solution(h, w, queries);
        // Timestamp endTime = new Timestamp(System.currentTimeMillis());
        // System.out.println("Time taken:" + (endTime.getTime() - startTime.getTime())
        // + "ms");
        // System.out.println("Result: ");
        // for (int[] row : result) {
        // System.out.println(Arrays.toString(row));
        // }

        int[] sizes = { 10, 50, 100, 200, 1_000};
        String[] ops = { "x", ">", "<", "^", "v" };
        Random rand = new Random();

        for (int size : sizes) {
            int h = size;
            int w = size;
            int numQueries = size * 1_000;
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

            System.out.println("Grid: " + h + "x" + w + ", Queries: " + numQueries + ", Time: " + (end - start)
                    + "ms, Results: " + result.length);
        }
    }

    public static int[][] solution(int h, int w, String[] queries) {
        List<int[]> resultList = new ArrayList<>();
        int[][] cells = new int[h][w];

        // System.out.println("Queries: " + Arrays.toString(queries));
        for (String q : queries) {
            // Split the query
            String[] parts = q.split(" ");
            String op = parts[0];
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            // System.out.println(op + " " + x + " " + y);

            int[] index = new int[] { -1, -1 };
            // Process the query
            switch (op) {
                case "x":
                    cells[x][y] = 1;
                    break;
                case ">":
                    index = findRight(cells, x, y);
                    break;
                case "<":
                    index = findLeft(cells, x, y);
                    break;
                case "^":
                    index = findUp(cells, x, y);
                    break;
                case "v":
                    index = findDown(cells, x, y);
                    break;
            }

            // System.out.println("Found at :" + Arrays.toString(index));
            if (!"x".equals(op)) {
                resultList.add(index);
            }

            // for (int i = 0; i < h; i++) {
            // for (int j = 0; j < w; j++) {
            // System.out.print(cells[i][j] + "\t");
            // }
            // System.out.println();
            // }

        }
        return resultList.toArray(new int[0][]);
    }

    private static int[] findDown(int[][] cells, int x, int y) {
        for (int i = x + 1; i < cells.length; i++) {
            if (cells[i][y] == 0) {
                return new int[] { i, y };
            }
        }
        return new int[] { -1, -1 };
    }

    private static int[] findUp(int[][] cells, int x, int y) {
        for (int i = x - 1; i > 0; i--) {
            if (cells[i][y] == 0) {
                return new int[] { i, y };
            }
        }
        return new int[] { -1, -1 };
    }

    private static int[] findLeft(int[][] cells, int x, int y) {
        for (int j = y - 1; j > 0; j--) {
            if (cells[x][j] == 0) {
                return new int[] { x, j };
            }
        }
        return new int[] { -1, -1 };
    }

    private static int[] findRight(int[][] cells, int x, int y) {
        for (int j = y + 1; j < cells[0].length; j++) {
            if (cells[x][j] == 0) {
                return new int[] { x, j };
            }
        }
        return new int[] { -1, -1 };
    }

}
