package com.example.store.item;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ITEM")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    public Long id;
    public String model;
    public String brand;
    public Integer price;
    public Integer quantity;
    public Category category;

    public Item(String model, String brand, Integer price, Integer quantity, Category category) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Item() {
    }
}
