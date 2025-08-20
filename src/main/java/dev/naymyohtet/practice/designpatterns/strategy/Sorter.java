package dev.naymyohtet.practice.designpatterns.strategy;

public class Sorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] arr){
        if(strategy==null){
            throw new IllegalArgumentException("Sort strategy not set!");
        }

        strategy.sort(arr);
    }
}
