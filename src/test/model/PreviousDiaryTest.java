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
        testDiaryList = new PreviousDiary();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testDiaryList.getPreviousDiary().size());
    }

    @BeforeEach
    void runBefore2() {
        testDiary1 = new TodayDiary(0);
        testDiary1.addWords("Happy!");
        testDiary2 = new TodayDiary(0);
        testDiary2.addWords("OMG!So much homework today!!");
    }

    @Test
    void testGetDiary() {
        testDiaryList.getPreviousDiary().add(testDiary1);
        assertEquals(testDiary1,testDiaryList.getDiary(1));
        testDiaryList.getPreviousDiary().add(testDiary2);
        assertEquals(testDiary2,testDiaryList.getDiary(2));



    }


}
