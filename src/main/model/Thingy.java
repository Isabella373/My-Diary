package model;

import org.json.JSONObject;
import persistence.Writable;

public class Thingy implements Writable {
    private Number number;
    private Category category;

    public Thingy(Number number, Category category) {
        this.number = number;
        this.category = category;

    }

    public Number getNumber() {
        return number;
    }

    public Category getCategory() {
        return category;
    }

    // EFFECTS: return string representation of this thingy
    public String toString() {
        return category + ": " + number;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("number", number);
        json.put("category", category);
        return json;
    }
}
