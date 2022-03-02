package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreviousDiaryTest {
    private PreviousDiary testDiaryList;
    private TodayDiary testDiary1;
    private TodayDiary testDiary2;


    @BeforeEach
    void runBefore() {
        testDiaryList = new PreviousDiary("Bella's Diary");
    }

    @Test
    void testConstructor() {
        assertEquals("Bella's Diary", testDiaryList.getName());
        assertEquals(0, testDiaryList.getPreviousDiary().size());
    }

    @BeforeEach
    void runBefore2() {
        testDiary1 = new TodayDiary("Tuesday", Category.SAD);
        testDiary1.addWords("Not Happy!");
        testDiary2 = new TodayDiary("Wednesday", Category.ANGRY);
        testDiary2.addWords("OMG!So much homework today!!");
    }

    @Test
    void testAddDiary() {
        testDiaryList.addDiary(testDiary1);
        assertEquals(testDiary1,testDiaryList.getPreviousDiary().get(0));
        testDiaryList.addDiary(testDiary2);
        assertEquals(testDiary2,testDiaryList.getPreviousDiary().get(1));



    }


}
