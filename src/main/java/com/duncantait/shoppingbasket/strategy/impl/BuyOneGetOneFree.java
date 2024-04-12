package com.duncantait.shoppingbasket.strategy.impl;

import com.duncantait.shoppingbasket.strategy.PricingStrategy;

public class BuyOneGetOneFree implements PricingStrategy {
    private final int pricePerUnit;

    public BuyOneGetOneFree(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public int calculateCost(int quantity) {
        return (quantity / 2 + quantity % 2) * pricePerUnit;
    }
}