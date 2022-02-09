package test;

import model.Spending;
import model.TodayDiary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodayDiaryTest {
    private TodayDiary testDiary;
    private Spending testSp1;
    private Spending testSp2;
    private Spending testSp3;

    @BeforeEach
    void runBefore() {
        testDiary = new TodayDiary();
        testSp1 = new Spending();
        testSp1.addAmount(200);
        testSp2 = new Spending();
        testSp1.addAmount(20);
        testSp3 = new Spending();
        testSp1.addAmount(1);

    }

    @Test
    void testConstructor() {
        assertEquals("", testDiary.getWords());
        assertEquals(LocalDate.now(), testDiary.getDate());
        assertEquals(0, testDiary.getSpendingList().size());
    }

    @Test
    void testAddWords() {
        testDiary.addWords("I am Happy today!");
        assertEquals("I am Happy today!", testDiary.getWords());
        testDiary.addWords("Because today is my birthday!!");
        assertEquals("I am Happy today!Because today is my birthday!!", testDiary.getWords());

    }

    @Test
    void testAddSpending() {
        testDiary.addSpending(testSp1);
        testDiary.addSpending(testSp2);
        assertEquals(testSp1, testDiary.getSpending(1));
        assertEquals(testSp2, testDiary.getSpending(2));

    }

    @Test
    void testSpendingPerDay() {
        testDiary.addSpending(testSp1);
        testDiary.addSpending(testSp2);
        testDiary.addSpending(testSp3);
        assertEquals(221, testDiary.spendingPerDay());


    }
}
