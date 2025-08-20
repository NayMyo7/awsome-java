package dev.naymyohtet.practice.designpatterns.strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        int[] numbers = { 12, 10, 4, 8, 7, 3, 9, 2 };

        Sorter sorter = new Sorter();

        // Selection Sort 
        sorter.setStrategy(new SelectionSort());
        sorter.sort(numbers.clone());

        // Quick Sort
        sorter.setStrategy(new QuickSort());
        sorter.sort(numbers.clone());

        // Merge Sort
        sorter.setStrategy(new MergeSort());
        sorter.sort(numbers.clone());
        
    }
}
