package com.duncantait.shoppingbasket.service;

import com.duncantait.shoppingbasket.service.impl.ShoppingBasketServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class ShoppingBasketServiceTest {

    private ShoppingBasketService underTest;

    @BeforeEach
    void setup() {
        underTest = new ShoppingBasketServiceImpl();
    }

    static Stream<Arguments> happyPathParams() {
        return Stream.of(
                Arguments.of(new String[]{"Apple", "Apple", "Banana", "Melon", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime"}, 235), // Assorted
                Arguments.of(new String[]{"Apple", "Melon", "Melon"}, 85), // Buy one, get one free
                Arguments.of(new String[]{"Apple", "Melon", "Melon", "Melon"}, 135), // Buy one, get one free (2nd pair is incomplete)
                Arguments.of(new String[]{"Apple", "Melon", "Melon", "Melon", "Melon"}, 135), // Buy one, get one free (x2)
                Arguments.of(new String[]{"Lime", "Lime", "Lime"}, 30), // Three for two
                Arguments.of(new String[]{"Lime", "Lime", "Lime", "Lime"}, 45), // Three for two (2nd set is incomplete: has 1 of 3)
                Arguments.of(new String[]{"Lime", "Lime", "Lime", "Lime", "Lime"}, 60), // Three for two (2nd set is incomplete: has 2 of 3)
                Arguments.of(new String[]{"Lime", "Lime", "Lime", "Lime", "Lime", "Lime"}, 60), // Three for two (x2)
                Arguments.of(new String[]{"Unknown"}, 0), // Includes unhandled item by itself
                Arguments.of(new String[]{"Apple", "Melon", "Melon", "Unknown"}, 85), // Includes unhandled item with others
                Arguments.of(new String[]{}, 0), // Empty basket
                Arguments.of(null, 0) // null basket
        );
    }

    @ParameterizedTest
    @MethodSource("happyPathParams")
    void testCalculateTotalCost(String[] items, int expectedTotal) {
        // Given: String[] items provided

        // When:
        int totalCost = underTest.calculateTotalCost(items);

        // Then:
        assertThat(totalCost).isEqualTo(expectedTotal);
    }

    @Test
    void testLargeNumberOfItems() {
        // Given
        List<String> items = new ArrayList<>();
        items.addAll(Collections.nCopies(1000000, "Apple"));
        items.addAll(Collections.nCopies(2000000, "Banana"));
        items.addAll(Collections.nCopies(3000000, "Melon"));
        items.addAll(Collections.nCopies(4000000, "Lime"));

        Collections.shuffle(items); // randomise order
        String[] basket = items.toArray(new String[0]);

        // When:
        int totalCost = underTest.calculateTotalCost(basket);

        // Then:
        assertThat(totalCost).isEqualTo(190000005);
    }

}