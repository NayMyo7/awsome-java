package dev.naymyohtet.practice.designpatterns.strategy;

public class QuickSort implements SortStrategy{

    @Override
    public void sort(int[] arr) {
        System.out.println("Quick sort");
    }

}
