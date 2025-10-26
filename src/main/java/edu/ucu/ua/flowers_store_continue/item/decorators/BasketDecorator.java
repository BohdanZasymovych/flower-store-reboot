package edu.ucu.ua.flowers_store_continue.item.decorators;


import edu.ucu.ua.flowers_store_continue.item.Item;
import edu.ucu.ua.flowers_store_continue.item.ItemDecorator;

public class BasketDecorator extends ItemDecorator {
    private Item item;

    public BasketDecorator(Item item) {
        this.item = item;
        this.description = item.description + " basket decorated";
    }

    public boolean equals(Item other) {
        return other.description == description;
    }

    public String getDescription() {return description;}

    public double price() {return getPrice();}

    public double getPrice() {return 4 + item.price();}
}
