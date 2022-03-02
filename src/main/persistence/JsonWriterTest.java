package persistence;

import model.Category;
import model.PreviousDiary;
import model.TodayDiary;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static model.Category.HAPPY;
import static model.Category.SAD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            PreviousDiary pd = new PreviousDiary("My Diary");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:filename.txt");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyDiary() {
        try {
            PreviousDiary pd = new PreviousDiary("My diary");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyDiaries.txt");
            writer.open();
            writer.write(pd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyDiaries.txt");
            pd = reader.read();
            assertEquals("My diary", pd.getName());
            assertEquals(0, pd.numDiaries());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }

    }

    @Test
    void testWriterGeneralDiary() {
        try {
            PreviousDiary pd = new PreviousDiary("My diary");
            pd.addDiary(new TodayDiary("Monday", HAPPY));
            pd.addDiary(new TodayDiary("Tuesday", SAD));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralDiary.txt");
            writer.open();
            writer.write(pd);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralDiary.txt");
            pd = reader.read();
            assertEquals("My diary", pd.getName());
            List<TodayDiary> diaries = pd.getPreviousDiary();
            assertEquals(2, diaries.size());
            checkThingy("Monday", HAPPY, diaries.get(0));
            checkThingy("Tuesday", SAD, diaries.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
