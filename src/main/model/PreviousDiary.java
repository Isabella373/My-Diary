package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistance.Writable;

import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreviousDiary implements Writable {
    String name;
    private List<TodayDiary> diaries;


    public PreviousDiary(String name) {
        diaries = new ArrayList<>();
        this.name = name;


    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds diaries to previous diary
    public void addDiary(TodayDiary td) {
        diaries.add(td);
    }


    //EFFECTS: return an unmodifiable list of diaries in this previous diaries
    public List<TodayDiary> getPreviousDiary() {
        return Collections.unmodifiableList(diaries);
    }

    // EFFECTS: returns number of diaries in this previous diaries
    public int numDiaries() {
        return diaries.size();
    }

    private JSONArray diariesTOJson() {
        JSONArray jsonArray = new JSONArray();

        for (TodayDiary td : diaries) {
            jsonArray.put(td.toJson());
        }

        return jsonArray;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("diaries", diariesTOJson());
        return json;
    }
}

