package com.example.store.item;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "ITEM")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    public Long id;
    public String brand;
    public String model;
    public Integer price;
    public Integer quantity;
    public Category category;
    public String description;


    public Item(String brand, String model, Integer price, Integer quantity, Category category, String description) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.description = description;
    }

    public Item() {
    }
}
