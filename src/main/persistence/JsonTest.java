package persistence;

import model.Category;
import model.Thingy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkThingy(Number number, Category category, Thingy thingy) {
        assertEquals(number, thingy.getNumber());
        assertEquals(category, thingy.getCategory());

    }
}
