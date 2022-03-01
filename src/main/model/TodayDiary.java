package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TodayDiary implements Writable {
    Number date;
    String words;
    ArrayList<Spending> spending;
    private List<Thingy> thingies;


    public TodayDiary(Number n) {
        n = LocalDate.now().getDayOfYear();
        this.date = n;
        this.words = "";
        this.spending = new ArrayList<>();
        thingies = new ArrayList<>();


    }


    //EFFECTS: get the date
    public Number getDate() {
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

    // MODIFIES: this
    // EFFECTS: add thingy to this TodayDiary
    public void addThingy(Thingy thingy) {
        thingies.add(thingy);
    }

    // EFFECTS: return an unmodifiable list of thingies in the TodayDiary
    public List<Thingy> getThingies() {
        return Collections.unmodifiableList(thingies);
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("number", date);
        json.put("thingies", thingiesTOJson());
        return null;
    }

    private JSONArray thingiesTOJson() {
        JSONArray jsonArray = new JSONArray();

        for (Thingy t : thingies) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }
}
