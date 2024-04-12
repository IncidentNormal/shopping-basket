package com.duncantait.shoppingbasket.service.impl;

import com.duncantait.shoppingbasket.model.ItemType;
import com.duncantait.shoppingbasket.service.ShoppingBasketService;
import com.duncantait.shoppingbasket.strategy.PricingStrategy;
import com.duncantait.shoppingbasket.strategy.impl.BuyOneGetOneFree;
import com.duncantait.shoppingbasket.strategy.impl.RegularPricing;
import com.duncantait.shoppingbasket.strategy.impl.ThreeForTwo;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.duncantait.shoppingbasket.model.ItemType.*;

@Slf4j
public class ShoppingBasketServiceImpl implements ShoppingBasketService {

    private static final Map<ItemType, PricingStrategy> itemPricing = new HashMap<>();
    static {
        // Prices can be configured here
        itemPricing.put(APPLE, new RegularPricing(35));
        itemPricing.put(BANANA, new RegularPricing(20));
        itemPricing.put(MELON, new BuyOneGetOneFree(50));
        itemPricing.put(LIME, new ThreeForTwo(15));
    }

    @Override
    public int calculateTotalCost(String[] basket) {
        if (basket == null) {
            log.warn("input is null, returning 0");
            return 0;
        }
        return Arrays.stream(basket)
                .map(ItemType::from)
                .filter(isHandled())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .mapToInt(entry -> itemPricing.get(entry.getKey()).calculateCost(entry.getValue().intValue()))
                .sum();
    }

    private static Predicate<ItemType> isHandled() {
        return item -> {
            if (item == UNKNOWN) {
                log.warn("Unhandled item: {}", item.getValue());
                return false;
            }
            return true;
        };
    }

}
