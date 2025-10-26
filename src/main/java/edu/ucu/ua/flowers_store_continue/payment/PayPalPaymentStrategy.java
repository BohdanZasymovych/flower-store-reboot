package edu.ucu.ua.flowers_store_continue.payment;

public class PayPalPaymentStrategy implements Payment {
    public String pay(double price) {
        return "Payment with PayPal";
    }

    @Override
    public String getPaymentStrategy() {
        return "PayPal payment";
    }
}
