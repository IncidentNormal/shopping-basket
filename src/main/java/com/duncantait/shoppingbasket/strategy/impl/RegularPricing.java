package com.duncantait.shoppingbasket.strategy.impl;

import com.duncantait.shoppingbasket.strategy.PricingStrategy;

public class RegularPricing implements PricingStrategy {
    private final int pricePerUnit;

    public RegularPricing(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public int calculateCost(int quantity) {
        return quantity * pricePerUnit;
    }
}