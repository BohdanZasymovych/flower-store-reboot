package edu.ucu.ua.flowers_store_continue.item.decorators;


import edu.ucu.ua.flowers_store_continue.item.Item;
import edu.ucu.ua.flowers_store_continue.item.ItemDecorator;

public class PaperDecorator extends ItemDecorator {
    private Item item;

    public PaperDecorator(Item item) {
        this.item = item;
        this.description = item.description + " paper decorated";
    }

    public boolean equals(Item other) {
        return other.description == description;
    }

    public String getDescription() {return description;}

    public double price() {return getPrice();}

    public double getPrice() {return 13 + item.price();}
}
