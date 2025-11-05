package edu.ucu.ua.flowers_store_continue.flower;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class Flower {
    @Id
    private long id;
    private double sepalLength;
    // private FlowerColor color;
    private String color;
    private double price;
    // private FlowerType flowerType;

    public Flower(Flower other) {
        this(other.id, other.sepalLength, other.color, other.price);
    }

    // public String getColor() {
    //     return color == null ? null : color.getHexColor();
    // }
}
