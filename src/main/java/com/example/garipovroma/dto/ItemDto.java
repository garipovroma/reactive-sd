package com.example.garipovroma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDto {
    private final String name;
    private final long rublePrice;

    public ItemDto(@JsonProperty("name") String name, @JsonProperty("rublePrice") long rublePrice) {
        this.name = name;
        this.rublePrice = rublePrice;
    }

    public String getName() {
        return name;
    }

    public long getRublePrice() {
        return rublePrice;
    }
}
