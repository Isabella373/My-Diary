package persistence;

import model.Thingy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkThingy(Number number, Thingy thingy, String story) {
        assertEquals(number, thingy.getNumber());
        assertEquals(story, thingy.getStory());

    }
}
