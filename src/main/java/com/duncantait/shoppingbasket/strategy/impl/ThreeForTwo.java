package com.duncantait.shoppingbasket.strategy.impl;

import com.duncantait.shoppingbasket.strategy.PricingStrategy;

public class ThreeForTwo implements PricingStrategy {
    private final int pricePerUnit;

    public ThreeForTwo(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public int calculateCost(int quantity) {
        return (quantity / 3 * 2 + quantity % 3) * pricePerUnit;
    }
}