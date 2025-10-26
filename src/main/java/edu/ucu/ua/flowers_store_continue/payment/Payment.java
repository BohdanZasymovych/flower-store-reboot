package edu.ucu.ua.flowers_store_continue.payment;

public interface Payment {
    public String pay(double price);

    public String getPaymentStrategy();
}
