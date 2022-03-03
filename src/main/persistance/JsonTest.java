package persistance;

import model.Category;
import model.TodayDiary;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkThingy(String title, Category category, TodayDiary td) {
        assertEquals(title, td.getTitle());
        assertEquals(category, td.getCategory());

    }
}
