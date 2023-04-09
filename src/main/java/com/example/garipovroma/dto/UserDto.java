package com.example.garipovroma.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    private final String name;
    private final String currencyType;

    public UserDto(@JsonProperty("name") String name,
                   @JsonProperty("currencyType") String currencyType) {
        this.name = name;
        this.currencyType = currencyType;
    }

    public String getName() {
        return name;
    }

    public String getCurrencyType() {
        return currencyType;
    }
}

