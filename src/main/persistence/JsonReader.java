package persistence;


import model.Category;
import model.Thingy;
import model.TodayDiary;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;



// Represent a reader that reads TodayDiary from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: construct readers to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads TodayDiaries from the file and returns it;
    // throws IOException if an error occurs reading data from file
    public TodayDiary read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTodayDiary(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses TodayDiary from JSon object and returns it
    private TodayDiary parseTodayDiary(JSONObject jsonObject) {
        Number number = jsonObject.getNumber("number");
        TodayDiary td = new TodayDiary(number);
        addThingies(td, jsonObject);
        return td;

    }


    // MODIFIES: td
    // EFFECTS: parses things from JSON object and adds them to TodayDiary
    private void addThingies(TodayDiary td, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("thingies");
        for (Object json: jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addToDiaries(td, nextThingy);
        }
    }

    // MODIFIES: td
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addToDiaries(TodayDiary td, JSONObject jsonObject) {
        Number number = jsonObject.getNumber("number");
        Category category = Category.valueOf(jsonObject.getString("category"));
        Thingy thingy = new Thingy(number, category);
        td.addThingy(thingy);
    }

}
