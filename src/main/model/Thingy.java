package model;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.json.JSONObject;
import persistence.Writable;

public class Thingy implements Writable {
    private Number number;
    private String story;
    private Spending spending;

    public Thingy(Number number, String story) {
        this.number = number;
        this.story = story;




    }

    public Number getNumber() {
        return number;
    }

    public String getStory() {
        return story;
    }



    // EFFECTS: return string representation of this thingy
    public String toString() {
        return number + ": " + story;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("number", number);
        json.put("story", story);
        json.put("spending", spending);
        return json;
    }
}
