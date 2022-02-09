package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SpendingTest {
    private Spending testSpending;


    @BeforeEach
    void runBefore() {
        testSpending = new Spending();

    }

    @Test
    void testConstructor() {
        assertEquals(0, testSpending.getAmount());
        assertEquals("", testSpending.getTag());
        assertEquals("", testSpending.getDescription());
    }


    @Test
    void testAddTag() {
        testSpending.addTag("Food");
        assertEquals("Food", testSpending.getTag());


    }

    @Test
    void testAddAmount() {
        testSpending.addAmount(200);
        assertEquals(200, testSpending.getAmount());

    }

    @Test
    void testAddDescription() {
        testSpending.addDescription("Fresh milk");
        assertEquals("Fresh milk", testSpending.getDescription());

    }


}


