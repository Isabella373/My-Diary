package persistence;

import model.Category;
import model.PreviousDiary;
import model.TodayDiary;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            PreviousDiary pd = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPreviousDiary() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyDiaries.txt");
        try {
            PreviousDiary pd = reader.read();
            assertEquals("My Diary", pd.getName());
            assertEquals(0, pd.numDiaries());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralDiaries() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralDiaries.txt");
        try {
            PreviousDiary pd = reader.read();
            assertEquals("My Diary", pd.getName());
            List<TodayDiary> diaries = pd.getPreviousDiary();
            assertEquals(2, diaries.size());
            checkThingy("Monday", Category.HAPPY, diaries.get(0));
            checkThingy("Tuesday", Category.SAD, diaries.get(1));

        } catch (IOException e) {
            fail("Couldn't read from the file");
        }
    }





}
