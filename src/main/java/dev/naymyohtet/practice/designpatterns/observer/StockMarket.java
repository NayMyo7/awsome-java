package dev.naymyohtet.practice.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

    private List<Observer> observers = new ArrayList<>();
    private String stock;
    private double price;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stock, price);
        }
    }

    public void setPrice(String stock, double price) {
        this.stock = stock;
        this.price = price;
        notifyObservers();
    }

}
