package dev.naymyohtet.practice.designpatterns.strategy;

public class MergeSort implements SortStrategy {

    @Override
    public void sort(int[] arr) {
        System.out.println("Merge sort");
    }

}
