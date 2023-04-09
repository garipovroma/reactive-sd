package com.example.garipovroma.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Item")
public class Item {
    @Id
    private String id;
    private final String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Item getItemWithPriceInCurrency(User.CurrencyType type) {
        switch (type) {
            case USD -> Item.setPrice(Item.getPrice() / 81.10);
            case EUR -> Item.setPrice(Item.getPrice() / 89.17);
        }

        return Item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item Item = (Item) o;
        return (price == Item.price) && (Objects.equals(id, Item.id)) && (Objects.equals(name, Item.name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
