package edu.ucu.ua.flowers_store_continue.payment;

public class CreditCardPaymentStrategy implements Payment {
    public String pay(double price) {
        return "Payment with credit card";
    }

    @Override
    public String getPaymentStrategy() {
        return "Credit card payment";
    }
}
