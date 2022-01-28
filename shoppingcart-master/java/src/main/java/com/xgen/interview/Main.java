package com.xgen.interview;

public class Main {
    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart(new Pricer());

        sc.addItem("apple", 2);
        sc.addItem("banana", 1);
        sc.addItem("apple", 2);
        sc.addItem("corn", 1);
        sc.printReceipt();

        SCPriceFirst sc2 = new SCPriceFirst(new Pricer());

        sc2.addItem("apple", 2);
        sc2.addItem("banana", 1);
        sc2.addItem("apple", 2);
        sc2.addItem("corn", 1);
        sc2.printReceipt();
    }

}
