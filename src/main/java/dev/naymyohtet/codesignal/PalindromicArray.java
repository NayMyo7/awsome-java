package dev.naymyohtet.codesignal;

import java.util.*;

/**
 An array is called palindromic if it remains the same after reversing the order of its elements.
You have an array of strings arr. For each i, arr[i] consists of at least two characters. For each pair of consecutive elements arr [i] and arr[i + 1] , you can:
• Move the rightmost character of arr[i] to the leftmost position in arr[i + 1] . For instance, "abc" and "def" wil become "ab" and "cdef". This operation can be applied only once to any pair of consecutive elements.
• Move the leftmost character of arr[i + 1] to the rightmost position in arr [i]. For instance, "abc" and "def" wil become "abcd" and "ef", Again, this operation can be applied only once to any pair of consecutive elements.
• Do nothing to the pair of consecutive elements.
Is it possible to obtain a palindromic array from arr by performing these operations?
Example 1:
• For arr = ["aa", "bab", "cde", "aba", "ab"], the output should be true.
• Apply the second operation to "aa" and "bab" .
• Apply the first operation to "aba" and "ab".
• This gives us the following array: ['"aab", "ab", "cde", "ab", "aab"], which is palindromic.
Example 2:
• For arr = ["palindrome"], the output should be true.
The given array is already palindromic, so no operations are needed.
Example 3:
• For arr = ["aaaaaa", "aa"], the output should be false.
If moving two characters between two consecutive array elements was allowed, the array could have been made palindromic, but this is impossible given the actual rules.
 */

public class PalindromicArray {

    public static void main(String[] args) {
        List<String[]> testCases = List.of(
                new String[] { "aa", "bab", "cde", "aba", "ab" },
                new String[] { "palindrome" },
                new String[] { "aaaaaa", "aa" },
                new String[] { "a", "ba", "c", "ab", "a" });

        for (String[] arr : testCases) {
            System.out.println("Input: " + Arrays.toString(arr));
            System.out.println("Can become palindromic: " + canBecomePalindromic(arr));
            System.out.println("----------");
        }
    }

    // Checks if array is a palindrome
    private static boolean isPalindromic(String[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (!arr[left].equals(arr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Recursive DFS to try all combinations of operations
    private static boolean dfs(String[] arr, int index) {
        if (index == arr.length - 1) {
            return isPalindromic(arr);
        }

        String originalLeft = arr[index];
        String originalRight = arr[index + 1];

        // Option 1: Do nothing
        if (dfs(arr, index + 1))
            return true;

        // Option 2: Move last char of arr[index] to beginning of arr[index + 1]
        if (originalLeft.length() > 1) {
            String newLeft = originalLeft.substring(0, originalLeft.length() - 1);
            String movedChar = originalLeft.substring(originalLeft.length() - 1);
            String newRight = movedChar + originalRight;
            arr[index] = newLeft;
            arr[index + 1] = newRight;
            if (dfs(arr, index + 1))
                return true;
            arr[index] = originalLeft;
            arr[index + 1] = originalRight;
        }

        // Option 3: Move first char of arr[index + 1] to end of arr[index]
        if (originalRight.length() > 1) {
            String movedChar = originalRight.substring(0, 1);
            String newRight = originalRight.substring(1);
            String newLeft = originalLeft + movedChar;
            arr[index] = newLeft;
            arr[index + 1] = newRight;
            if (dfs(arr, index + 1))
                return true;
            arr[index] = originalLeft;
            arr[index + 1] = originalRight;
        }

        return false;
    }

    public static boolean canBecomePalindromic(String[] arr) {
        // Copy the array to avoid modifying original
        String[] arrCopy = Arrays.copyOf(arr, arr.length);
        return dfs(arrCopy, 0);
    }
}
