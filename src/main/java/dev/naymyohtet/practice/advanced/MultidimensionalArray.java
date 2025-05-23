package dev.naymyohtet.practice.advanced;

import java.util.Arrays;

public class MultidimensionalArray {
    public static void main(String[] args) {
        // Creating a 2D array
        int[][] array = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // Printing the 2D array
        System.out.println(Arrays.deepToString(array)); // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

        // Accessing an element
        System.out.println(array[1][0]); // 4

        // Updating an element
        array[0][1] = 10;

        // Finding the number of row
        System.out.println("Number of row: " + array.length);

        // Finding the number of column
        System.out.println("Number of column: " + array[0].length);

        // Adding a new row to existing array
        int[][] newArray = new int[array.length + 1][3];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = Arrays.copyOf(array[i], array[i].length);
        }
        newArray[3] = new int[] { 10, 11, 12 };
        System.out.println("New array: " + Arrays.deepToString(newArray));

        // Columnar ZigZag Traversal of Matrix
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        // Loop the 2D array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }

        System.out.println("Zigzag Traversal: " + Arrays.toString(zigzagTraverse(matrix)));
        System.out.println("Reverse Traversal: " + Arrays.toString(reverseTraverse(matrix)));
        System.out.println("Transform matrix: " + Arrays.deepToString(transformMatrix(matrix)));

    }

    public static int[][] transformMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[] zigzagTraverse(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        String direction = "up";
        int row = rows - 1;
        int col = cols - 1;
        int[] output = new int[rows * cols];
        int index = 0;

        while (index < rows * cols) {
            output[index++] = matrix[row][col];

            if (direction.equals("up")) {
                if (row - 1 < 0) {
                    direction = "down";
                    col -= 1;
                } else {
                    row -= 1;
                }
            } else {
                if (row + 1 == rows) {
                    direction = "up";
                    col -= 1;
                } else {
                    row += 1;
                }
            }
        }

        return output;
    }

    public static int[] reverseTraverse(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] output = new int[rows * cols];

        int index = 0;

        for (int row = rows - 1; row >= 0; --row) {
            for (int col = cols - 1; col >= 0; --col) {
                output[index++] = matrix[row][col];
            }
        }

        return output;
    }
}
