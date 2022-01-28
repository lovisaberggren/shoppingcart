package com.xgen.interview;

/**
 * This is an alternate shopping cart with a different print item implementation. When receipts are
 * printed the price comes first followed by quantity and item. Here, I assumed that the total is
 * also formatted as price first.
 *
 * More shopping carts with other formatting can be created in the same way, extending ShoppingCart.
 */
public class SCPriceFirst extends ShoppingCart{

    public SCPriceFirst(Pricer pricer) {
        super(pricer);
    }

    protected void printItem(String key, float price) {
        String priceString = String.format("€%.2f", price);
        System.out.println(priceString + "\t" + contents.get(key) + "\t" + key);
    }

    protected void printTotal(float totalPrice) {
        String totalPriceString = String.format("€%.2f", totalPrice);
        System.out.println(totalPriceString + "\t\tTOTAL");
    }
}
