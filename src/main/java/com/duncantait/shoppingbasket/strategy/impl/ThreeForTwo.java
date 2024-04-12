package com.duncantait.shoppingbasket.strategy.impl;

import com.duncantait.shoppingbasket.strategy.PricingStrategy;

public class ThreeForTwo implements PricingStrategy {
    private final int pricePerUnit;

    public ThreeForTwo(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    /**
     * Calculate the cost of the items based on the 3 for 2 pricing strategy
     * 1. `quantity / 3`: Calculate the number of sets of 3 items
     * 2. `* 2` : Multiply by 2 to get the cost of 2 items (remember it's 3 for 2, and this is the cost of 2)
     * 3. `+ quantity % 3`: Add the cost of the remaining items (e.g. if there are 2 items left, add the cost of 2 items)
     * 4. `* pricePerUnit`: Multiply by the price per unit to get the total cost
     * @param quantity The number of items
     * @return The total cost of the items
     */
    @Override
    public int calculateCost(int quantity) {
        return (quantity / 3 * 2 + quantity % 3) * pricePerUnit;
    }
}