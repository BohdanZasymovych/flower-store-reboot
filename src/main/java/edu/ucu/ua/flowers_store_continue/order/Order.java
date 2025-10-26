package edu.ucu.ua.flowers_store_continue.order;

import java.util.LinkedList;

import org.springframework.stereotype.Component;

import edu.ucu.ua.flowers_store_continue.delivery.Delivery;
import edu.ucu.ua.flowers_store_continue.item.Item;
import edu.ucu.ua.flowers_store_continue.payment.Payment;
import lombok.Getter;


@Component
@Getter
public class Order {
    LinkedList<Item> items = new LinkedList<>();
    Payment payment;
    Delivery delivery;

    public void setPaymentStrategy(Payment payment) {
        this.payment = payment;
    }

    public void setDeliveryStrategy(Delivery delivery) {
        this.delivery = delivery;
    }

    public double calculateTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.price())
                .sum();
    }

    public String processOrder() {
        return "Order processed";
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public String getDeliveryStrategy() {
        if (delivery == null) {
            return "No strategy set";
        }

        return delivery.getDeliveryStrategy();
    }

    public String getPaymentStrategy() {
        if (payment == null) {
            return "No strategy set";
        }

        return payment.getPaymentStrategy();
    }
}
