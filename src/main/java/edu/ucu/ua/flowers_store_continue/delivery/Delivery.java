package edu.ucu.ua.flowers_store_continue.delivery;


import java.util.List;
import edu.ucu.ua.flowers_store_continue.item.Item;

public interface Delivery {
    public String deliver(List<Item> items);   

    public String getDeliveryStrategy();
}
