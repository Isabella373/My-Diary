package model;




import org.json.JSONObject;
import persistance.Writable;




public class TodayDiary implements Writable {
    private String title;
    private String words;
    private Category category;


    public TodayDiary(String t, Category category,String words) {
        this.title = t;
        this.words = words;
        this.category = category;
        EventLog.getInstance().logEvent(new Event("New Category " + category + " was added to the diary"));
        EventLog.getInstance().logEvent(new Event("New time " + t + " was added to the diary"));


    }


    //EFFECTS: get the title
    public String getTitle() {
        return this.title;
    }


    //EFFECTS: get the word
    public String getWords() {
        return this.words;
    }

    //EFFECTS: get the category
    public Category getCategory() {
        return this.category;
    }

    //REQUIRES: str is not empty sentence
    //MODIFIES: this
    //EFFECTS: add new sentences to the diary
    public void addWords(String str) {
        this.words = this.getWords() + str;
        EventLog.getInstance().logEvent((new Event("str " + " was added to the diary")));
    }

    // EFFECTS: structure string representation of the thingy
    public String toString() {
        return category + ": " + title + "---" + words;
    }




    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title",title);
        json.put("story", words);
        json.put("category", category);
        return json;
    }

}
