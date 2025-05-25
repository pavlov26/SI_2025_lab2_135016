import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testCheckCart_everyStatementCoverage() {
        // 1. allItems == null -> should throw RuntimeException
        Exception ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        // 2. allItems with invalid item (name null)
        List<Item> itemsInvalidName = new ArrayList<>();
        itemsInvalidName.add(new Item(null, 1, 100, 0));
        Exception ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(itemsInvalidName, "1234567890123456"));
        assertEquals("Invalid item!", ex2.getMessage());

        // 3. item with discount > 0 triggers sum -= 30 and discounted sum addition
        List<Item> itemsWithDiscount = new ArrayList<>();
        itemsWithDiscount.add(new Item("itemDiscount", 2, 100, 0.1));
        double result2 = SILab2.checkCart(itemsWithDiscount, "1234567890123456");
        // sum = 0-30 + 100*(1-0.1)*2 = -30 + 180 = 150
        assertEquals(150, result2, 0.0001);


        // 4. valid items, no discount, price <= 300, quantity <= 10
        List<Item> validItems = new ArrayList<>();
        validItems.add(new Item("itemA", 5, 50, 0));
        double result4 = SILab2.checkCart(validItems, "1234567890123456");
        // sum = 0 + 50*5 = 250
        assertEquals(250, result4, 0.0001);


        // 5. cardNumber length != 16 -> exception
        Exception ex5 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(someItems, "12345"));
        assertEquals("Invalid card number!", ex5.getMessage());

        // 6. cardNumber with invalid character -> exception
        Exception ex6 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(someItems, "12345678901234AB"));
        assertEquals("Invalid character in card number!", ex6.getMessage());
    }

    @Test
    void testShouldSubtract_MultipleConditionCoverage() {
        // A = false, B = false, C = false -> F
        Item case1 = new Item("A", 10, 300, 0.0);
        assertFalse(SILab2.shouldSubtract(case1));

        // A = false, B = false, C = true -> T
        Item case2 = new Item("B", 11, 300, 0.0);
        assertTrue(SILab2.shouldSubtract(case2));

        // A = false, B = true, C = false -> T
        Item case3 = new Item("C", 10, 300, 0.1);
        assertTrue(SILab2.shouldSubtract(case3));

        // A = false, B = true, C = true -> T
        Item case4 = new Item("D", 11, 300, 0.1);
        assertTrue(SILab2.shouldSubtract(case4));

        // A = true, B = false, C = false -> T
        Item case5 = new Item("E", 10, 301, 0.0);
        assertTrue(SILab2.shouldSubtract(case5));

        // A = true, B = false, C = true -> T
        Item case6 = new Item("F", 11, 301, 0.0);
        assertTrue(SILab2.shouldSubtract(case6));

        // A = true, B = true, C = false -> T
        Item case7 = new Item("G", 10, 301, 0.1);
        assertTrue(SILab2.shouldSubtract(case7));

        // A = true, B = true, C = true -> T
        Item case8 = new Item("H", 11, 301, 0.1);
        assertTrue(SILab2.shouldSubtract(case8));
    }
}