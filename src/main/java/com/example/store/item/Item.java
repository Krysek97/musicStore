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
    public String name;
    public Integer price;
    public Integer value;
    public String category;

    public Item(String name, Integer price, Integer value, String category) {
        this.name = name;
        this.price = price;
        this.value = value;
        this.category = category;
    }

    public Item() {
    }
}
