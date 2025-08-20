package dev.naymyohtet.practice.designpatterns.strategy;

import java.util.Arrays;

public class SelectionSort implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println("Selection sort: " + Arrays.toString(arr));
    }

}
