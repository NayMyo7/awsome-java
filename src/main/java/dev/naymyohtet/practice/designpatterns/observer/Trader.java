package dev.naymyohtet.practice.designpatterns.observer;

public class Trader implements Observer {

    @Override
    public void update(String stock, double price) {
        System.out.println("Trader notified: " + stock + " price is $" + price);
    }

}
