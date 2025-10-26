package edu.ucu.ua.flowers_store_continue.delivery;


import java.util.List;
import edu.ucu.ua.flowers_store_continue.item.Item;

public class DHLDeliveryStrategy implements Delivery {
    public String deliver(List<Item> items) {
        return "DHL delivery";        
    }

    @Override
    public String getDeliveryStrategy() {
        return "DHL delivery";
    }
}
