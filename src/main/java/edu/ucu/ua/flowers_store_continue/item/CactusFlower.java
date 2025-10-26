package edu.ucu.ua.flowers_store_continue.item;

public class CactusFlower extends Item {
    public CactusFlower() {
        description = "cactus flower";
    }

    public boolean equals(Item other) {
        return other.description == description;
    }

    public double price() {return 13;}
}
