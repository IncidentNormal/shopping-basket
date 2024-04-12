package com.duncantait.shoppingbasket.strategy.impl;

import com.duncantait.shoppingbasket.strategy.PricingStrategy;

public class BuyOneGetOneFree implements PricingStrategy {
    private final int pricePerUnit;

    public BuyOneGetOneFree(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    /**
     * Calculate the cost of the items based on the buy-one-get-one-free pricing strategy
     * 1. `quantity / 2`: Calculate the number of sets of 2 items
     * 3. `+ quantity % 2`: Add the cost of the remaining items (i.e. if there is 1 item left after all the sets of 2 have been accounted for, add the cost of 1 item)
     * 4. `* pricePerUnit`: Multiply by the price per unit to get the total cost
     * @param quantity The number of items
     * @return The total cost of the items
     */
    @Override
    public int calculateCost(int quantity) {
        return (quantity / 2 + quantity % 2) * pricePerUnit;
    }
}