package dev.naymyohtet.practice.designpatterns.factory2;

public class PayPalProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of " + amount);
    }

}
