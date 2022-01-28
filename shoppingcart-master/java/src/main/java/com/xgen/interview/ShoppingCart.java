package com.xgen.interview;

import java.util.*;


/**
 * This is the standard implementation of IShoppingCart. When receipts are printed the item type
 * comes first followed by quantity and price.
 */
public class ShoppingCart implements IShoppingCart {
    LinkedHashMap<String, Integer> contents = new LinkedHashMap<>();
    Pricer pricer;

    public ShoppingCart(Pricer pricer) {
        this.pricer = pricer;
    }

    public void addItem(String itemType, int number) {
        if (!contents.containsKey(itemType)) {
            contents.put(itemType, number);
        } else {
            int existing = contents.get(itemType);
            contents.put(itemType, existing + number);
        }
    }

    public void printReceipt() {
        Set<String> keys = contents.keySet();
        float totalPrice = 0;

        for (String key : keys) {
            float priceFloat = getPrice(key);
            printItem(key, priceFloat);
            totalPrice += priceFloat;
        }
        printTotal(totalPrice);
    }

    protected float getPrice(String key) {
        int price = pricer.getPrice(key) * contents.get(key);
        return (float) price / 100;
    }

    protected void printItem(String key, float price) {
        String priceString = String.format("€%.2f", price);
        System.out.println(key + "\t" + contents.get(key) + "\t" + priceString);
    }

    protected void printTotal(float totalPrice) {
        String totalPriceString = String.format("€%.2f", totalPrice);
        System.out.println("TOTAL\t\t" + totalPriceString);
    }
}
