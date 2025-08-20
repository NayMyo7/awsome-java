package dev.naymyohtet.practice.designpatterns.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Trader trader = new Trader();
        stockMarket.addObserver(trader);
        stockMarket.setPrice("BitCoin", 100000);

        stockMarket.removeObserver(trader);
        stockMarket.setPrice("BitCoin", 2000);
    }
}
