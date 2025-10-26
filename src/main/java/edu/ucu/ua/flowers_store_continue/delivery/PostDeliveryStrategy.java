package edu.ucu.ua.flowers_store_continue.delivery;


import java.util.List;
import edu.ucu.ua.flowers_store_continue.item.Item;

public class PostDeliveryStrategy implements Delivery {
    public String deliver(List<Item> items) {
        return "Post delivery";        
    }

    @Override
    public String getDeliveryStrategy() {
        return "Post delivery";
    }
}
