package dev.naymyohtet.practice.designpatterns.factory2;

public class StripeProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Stripe payment of " + amount);
    }

}
