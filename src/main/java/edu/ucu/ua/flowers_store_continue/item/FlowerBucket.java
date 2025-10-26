package edu.ucu.ua.flowers_store_continue.item;

public class FlowerBucket extends Item {
    public FlowerBucket() {
        description = "flower bucket";
    }

    public boolean equals(Item other) {
        return other.description == description;
    }

    public double price() {return 20;}
    
    public void addFlowers() {}

    public void searchFlower() {}
}
