package dev.naymyohtet.practice.designpatterns.factory2;

public class PaymentProcessorFactory {
    public static PaymentProcessor createProcessor(String type) {
        switch (type.toLowerCase()) {
            case "paypal":
                return new PayPalProcessor();
            case "stripe":
                return new StripeProcessor();
            default:
                throw new IllegalArgumentException("Unsupported payment type: " + type);
        }
    }
}
