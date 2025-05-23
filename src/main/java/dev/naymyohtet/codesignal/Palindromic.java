package dev.naymyohtet.codesignal;

public class Palindromic {
    public static void main(String[] args) {

        String[] arr = { "aa", "bab", "cde", "aba", "ab" }; // true
        // String[] arr = { "aab", "ab", "cde", "cde", "aba", "ab" }; // true
        // String[] arr1 = {"a", "ba", "c", "ab", "a"};
        // String[] arr = { "a", "ba", "ca", "b", "a" };
        // String[] arr3 = {"a", "b", "ac", "ab", "a"};
        // String[] arr = { "palindrome" };
        // String[] arr = { "aaaaaa", "aa" };
        boolean isPalindromic = solution(arr);
        System.out.println("Palindromic: " + isPalindromic);
    }

    private static boolean solution(String[] arr) {
        int size = arr.length;
        int mid = size / 2;
        boolean alreadyMovedRight = false, alreadyMoveLeft = false;

        if (size <= 1)
            return true;

        for (int i = 0; i < mid; i++) {
            String leftPart = arr[i];
            String rightPart = arr[size - i - 1];

            // same value
            if (leftPart.equals(rightPart)) {
                continue;
            }

            int leftSize = leftPart.length();
            int rightSize = rightPart.length();
            // same length different value
            if (leftSize == rightSize) {
                if (alreadyMoveLeft || alreadyMovedRight)
                    return false;

                // Move left
                moveLeft(arr, i);
                alreadyMoveLeft = true;

                // Move right
                moveRight(arr, size - i - 2);
                alreadyMovedRight = true;

            } else if (leftSize > rightSize) {

                if (leftSize - rightSize == 1 && !alreadyMovedRight) {
                    // Move right
                    moveRight(arr, size - i - 2);
                    alreadyMovedRight = true;

                } else {
                    return false;
                }

            } else {
                if (rightSize - leftSize == 1 && !alreadyMoveLeft) {
                    // Move left
                    moveLeft(arr, i);
                    alreadyMoveLeft = true;

                } else {
                    return false;
                }

            }

            leftPart = arr[i];
            rightPart = arr[size - i - 1];
            if (leftPart.equals(rightPart)) {
                continue;
            } else {
                return false;
            }

        }

        return true;
    }

    private static void moveLeft(String[] arr, int i) {
        arr[i] = arr[i] + arr[i + 1].substring(0, 1);
        arr[i + 1] = arr[i + 1].substring(1);
    }

    private static void moveRight(String[] arr, int i) {
        arr[i + 1] = arr[i].substring(0, 1) + arr[i + 1];
        arr[i] = arr[i].substring(0, arr[i].length() - 1);
    }
}
