package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Category.HAPPY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodayDiaryTest {
    private TodayDiary testDiary;

    @BeforeEach
    void runBefore() {
        testDiary = new TodayDiary("Monday", HAPPY);


    }

    @Test
    void testConstructor() {
        assertEquals("Monday", testDiary.getTitle());
        assertEquals("", testDiary.getWords());
        assertEquals(HAPPY, testDiary.getCategory());

    }

    @Test
    void testAddWords() {
        testDiary.addWords("I am Happy today!");
        assertEquals("I am Happy today!", testDiary.getWords());
        testDiary.addWords("Because today is my birthday!!");
        assertEquals("I am Happy today!Because today is my birthday!!", testDiary.getWords());

    }

    @Test
    void testToString() {
        testDiary.addWords("I am Happy today!");
        assertEquals("HAPPY: Monday---I am Happy today!", testDiary.toString());
    }


}
