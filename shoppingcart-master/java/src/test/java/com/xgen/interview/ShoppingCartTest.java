package com.xgen.interview;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * @NOTE The tests could probably be better and refactored so that they are easier to maintain.
 */
public class ShoppingCartTest {
    Pricer pricer;
    ShoppingCart sc;
    final ByteArrayOutputStream myOut = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        pricer = new Pricer();
        sc = new ShoppingCart(pricer);
        System.setOut(new PrintStream(myOut));
    }

    @Test
    public void canAddAnItem() {
        String expectedResult = "apple\t1\t€1,00\nTOTAL\t\t€1,00\n";

        sc.addItem("apple", 1);
        sc.printReceipt();

        assertEquals(expectedResult, myOut.toString());
    }

    @Test
    public void canAddMoreThanOneItem() {
        String expectedResult = "apple\t2\t€2,00\nTOTAL\t\t€2,00\n";

        sc.addItem("apple", 2);
        sc.printReceipt();

        assertEquals(expectedResult, myOut.toString());
    }

    @Test
    public void canAddSameItemTwice() {
        String expectedResult = "apple\t2\t€2,00\nTOTAL\t\t€2,00\n";

        sc.addItem("apple", 1);
        sc.addItem("apple", 1);
        sc.printReceipt();

        assertEquals(expectedResult, myOut.toString());
    }

    @Test
    public void canAddSameItemTwiceWithOtherItemInBetween() {
        String expectedResult = "apple\t2\t€2,00\nbanana\t1\t€2,00\nTOTAL\t\t€4,00\n";

        sc.addItem("apple", 1);
        sc.addItem("banana", 1);
        sc.addItem("apple", 1);
        sc.printReceipt();

        assertEquals(expectedResult, myOut.toString());
    }

    @Test
    public void canAddDifferentItems() {
        String expectedResult = "apple\t2\t€2,00\nbanana\t1\t€2,00\nTOTAL\t\t€4,00\n";

        sc.addItem("apple", 2);
        sc.addItem("banana", 1);
        sc.printReceipt();

        assertEquals(expectedResult, myOut.toString());
    }

    @Test
    public void canAddNoItems() {
        String expectedResults = "TOTAL\t\t€0,00\n";

        sc.printReceipt();

        assertEquals(expectedResults, myOut.toString());
    }

    @Test
    public void doesntExplodeOnMysteryItem() {
        String expectedResult = "crisps\t2\t€0,00\nTOTAL\t\t€0,00\n";

        sc.addItem("crisps", 2);
        sc.printReceipt();

        assertEquals(expectedResult, myOut.toString());
    }

    @Test
    public void priceFirstFormatPrintsPriceFirst() {
        SCPriceFirst scPriceFirst = new SCPriceFirst(pricer);

        String expectedResult = "€1,00\t1\tapple\n€1,00\t\tTOTAL\n";

        scPriceFirst.addItem("apple", 1);
        scPriceFirst.printReceipt();

        assertEquals(expectedResult, myOut.toString());
    }
}


