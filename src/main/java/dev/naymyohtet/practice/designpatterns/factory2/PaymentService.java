package dev.naymyohtet.practice.designpatterns.factory2;

public class PaymentService {
    public void executePayment(String paymentType, double amount) {
        PaymentProcessor processor = PaymentProcessorFactory.createProcessor(paymentType);
        processor.processPayment(amount);
    }

    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.executePayment("PayPal", 1000d);
        service.executePayment("Stripe", 2000d);
        service.executePayment("MPU", 1200d);
    }
}
