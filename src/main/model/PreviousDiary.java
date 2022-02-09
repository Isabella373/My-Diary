package model;

import java.util.ArrayList;

public class PreviousDiary {
    ArrayList<TodayDiary> previousDiary;


    public PreviousDiary() {
        previousDiary = new ArrayList<>();


    }

    //REQUIRES
    //MODIFIES
    //EFFECTS
    public TodayDiary getDiary(int x) {
        int y = x - 1;
        return this.getPreviousDiary().get(y);
    }

    public ArrayList<TodayDiary> getPreviousDiary() {
        return this.previousDiary;
    }

}

