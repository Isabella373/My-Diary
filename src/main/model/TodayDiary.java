package model;


import java.time.LocalDate;
import java.util.ArrayList;



public class TodayDiary {
    LocalDate date;
    String words;
    ArrayList<Spending> spending;


    public TodayDiary() {
        this.date = LocalDate.now();
        this.words = "";
        this.spending = new ArrayList<>();


    }


    //EFFECTS: get the date
    public LocalDate getDate() {
        return this.date;
    }

    //EFFECTS: get the words
    public String getWords() {
        return this.words;
    }

    //REQUIRES: str is not empty sentence
    //MODIFIES: this
    //EFFECTS: add new sentences to the diary
    public void addWords(String str) {
        this.words = this.getWords() + str;
    }

    //MODIFIES:this
    //EFFECTS: add a new spending entry to the diary
    public void addSpending(Spending sp) {
        this.getSpendingList().add(sp);
    }


    //MODIFIES:this
    //EFFECTS: get a spending entry to the diary
    public Spending getSpending(int x) {
        int y = x - 1;
        return this.getSpendingList().get(y);

    }

    //MODIFIES:this
    //EFFECTS: get a spending list to the diary
    public ArrayList<Spending> getSpendingList() {
        return this.spending;
    }

    public int spendingPerDay() {
        ArrayList<Integer> list = new ArrayList<>();

        for (Spending sp : this.getSpendingList()) {
            list.add(sp.getAmount());
        }
        int sum = 0;
        for (Integer num : list) {
            sum = sum + num;
        }
        return sum;

    }


}
