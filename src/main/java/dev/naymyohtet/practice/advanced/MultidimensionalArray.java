package dev.naymyohtet.practice.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // Matrix Traversal
        System.out.println("Zigzag Traversal: " + Arrays.toString(zigzagTraverse(matrix)));
        System.out.println("Reverse Traversal: " + Arrays.toString(reverseTraverse(matrix)));
        System.out.println("Transform matrix: " + Arrays.deepToString(transformMatrix(matrix)));

        // Matrix Adjacent
        char[][] board = {
                { 'P', 'E', 'E', 'P' },
                { 'E', 'P', 'E', 'P' },
                { 'P', 'E', 'P', 'P' },
                { 'P', 'E', 'P', 'E' }
        };
        System.out.println("Original board: ");
        for (char[] b : board) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println("Finding positions in game board: ");
        List<int[]> positions = findPositions(board);
        for (int[] pos : positions) {
            System.out.println("(" + pos[0] + ", " + pos[1] + ")");
        }

        // Grid Traversal: Finding Ascending Paths in 2D Arrays
        int[][] grid = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Original grid:");
        for (int[] g : grid) {
            System.out.println(Arrays.toString(g));
        }
        List<Integer> res = pathTraverse(grid, 1, 1);
        for (int val : res) {
            System.out.print(val + " ");
        }

    }

    public static List<Integer> pathTraverse(int[][] grid, int startRow, int startCol) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check the validity of the input
        if (startRow < 0 || startRow >= rows || startCol < 0 || startCol >= cols) {
            return new ArrayList<>();
        }

        // Define all possible directions of movement
        int[][] directions = { // pair of rowOffset and colOffset
                { -1, 0 }, // Up
                { 1, 0 }, // Down
                { 0, -1 }, // Left
                { 0, 1 } // Right
        };

        // Start with the value at the starting cell
        List<Integer> visited = new ArrayList<>();
        visited.add(grid[startRow][startCol]);

        while (true) {
            // Initialize the current maximum as negative one
            int currMax = -1;
            int nextRow = -1, nextCol = -1;

            // Loop over each adjacent cell in all the directions
            for (int[] dir : directions) {
                // Calculate the new cell's row and column indices
                int newRow = startRow + dir[0];
                int newCol = startCol + dir[1];

                // If the new cell is out of the grid boundary, ignore it
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                    continue;
                }

                // If the new cell's value is greater than the current maximum
                if (grid[newRow][newCol] > currMax) {
                    // Save it as the next cell to visit
                    nextRow = newRow;
                    nextCol = newCol;
                    currMax = grid[newRow][newCol];
                }
            }

            // If we don't have any valid cell to visit, break from the loop
            if (currMax <= grid[startRow][startCol]) {
                break;
            }

            // Otherwise, go to the next cell
            startRow = nextRow;
            startCol = nextCol;

            // Append the cell's value to the result list;
            visited.add(currMax);
        }

        return visited;
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

    public static List<int[]> findPositions(char[][] board) {
        List<int[]> positions = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'E') {
                    if ((i > 0 && board[i - 1][j] == 'E') ||
                            (i < rows - 1 && board[i + 1][j] == 'E') ||
                            (j > 0 && board[i][j - 1] == 'E') ||
                            (j < cols - 1 && board[i][j + 1] == 'E')) {
                        positions.add(new int[] { i, j });
                    }
                }
            }
        }
        return positions;
    }
}
