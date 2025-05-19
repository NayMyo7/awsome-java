package dev.naymyohtet.codesignal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        System.out.println("Two Dimensional Array");

        int h = 3;
        int w = 5;
        String[] queries = { "v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0" };
        int[][] result = solution(h, w, queries);
        System.out.println("Result: ");
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] solution(int h, int w, String[] queries) {
        List<int[]> resultList = new ArrayList<>();

        // Initialize two dimensional array
        int[][] cells = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                cells[i][j] = 0;
            }
        }

        System.out.println("Queries: " + Arrays.toString(queries));
        for (int k = 0; k < queries.length; k++) {
            // Split the query
            String[] query = queries[k].split(" ");
            String operation = query[0];
            int x = Integer.parseInt(query[1]);
            int y = Integer.parseInt(query[2]);
            System.out.println(operation + " " + x + " " + y);

            int[] index = new int[] { -1, -1 };
            // Process the query
            switch (operation) {
                // Fill with back represented value 1
                case "x":
                    cells[x][y] = 1;
                    break;
                // Find the rightmost white cell
                case ">":
                    for (int j = y + 1; j < w; j++) {
                        if (cells[x][j] == 0) {
                            index = new int[] { x, j };
                            break;
                        }
                    }
                    break;
                // Find the leftmost white cell
                case "<":
                    for (int j = y - 1; j > 0; j--) {
                        if (cells[x][j] == 0) {
                            index = new int[] { x, j };
                            break;
                        }
                    }
                    break;
                // Find the upward white cell
                case "^":
                    for (int i = x - 1; i > 0; i--) {
                        if (cells[i][y] == 0) {
                            index = new int[] { i, y };
                            break;
                        }
                    }
                    break;

                // Find the downward white cell
                case "v":
                    for (int i = x + 1; i < h; i++) {
                        if (cells[i][y] == 0) {
                            index = new int[] { i, y };
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }

            System.out.println("Found at :" + Arrays.toString(index));
            if (!"x".equals(operation)) {
                resultList.add(index);
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(cells[i][j] + "\t");
                }
                System.out.println();
            }

        }
        return resultList.toArray(new int[0][]);
    }

}
