package com.duncantait.shoppingbasket.model;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ItemType {
    APPLE("Apple"),
    BANANA("Banana"),
    MELON("Melon"),
    LIME("Lime"),

    UNKNOWN("Unknown");

    private final String value;

    ItemType(String value) {
        this.value = value;
    }

    public static ItemType from(String item) {
        return Arrays.stream(ItemType.values())
                .filter(value -> value.getValue().equalsIgnoreCase(item))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
