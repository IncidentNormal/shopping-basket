package com.duncantait.shoppingbasket;

import com.duncantait.shoppingbasket.service.ShoppingBasketService;
import com.duncantait.shoppingbasket.service.impl.ShoppingBasketServiceImpl;

public class ShoppingBasket {

    public static void main(String[] args) {

        ShoppingBasketService shoppingBasketService = new ShoppingBasketServiceImpl();
        int totalCost = shoppingBasketService.calculateTotalCost(args);
        System.out.println("Total cost of the basket: " + totalCost + "p");
    }
}
