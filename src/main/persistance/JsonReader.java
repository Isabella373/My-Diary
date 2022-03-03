package persistance;


import model.Category;
import model.PreviousDiary;
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
    public PreviousDiary read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePreviousDiary(jsonObject);
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
    private PreviousDiary parsePreviousDiary(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        PreviousDiary pd = new PreviousDiary(name);
        addDiaries(pd, jsonObject);
        return pd;

    }

    // MODIFIES: pd
    // EFFECTS: parses diaries from JSON object and adds them to the previous diary
    private void addDiaries(PreviousDiary pd, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("diaries");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addDiary(pd, nextThingy);

        }
    }

    // MODIFIES: this
    // EFFECTS: add the previous diary to the file
    private void addDiary(PreviousDiary pd, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        Category category = Category.valueOf(jsonObject.getString("category"));
        TodayDiary td = new TodayDiary(title, category);
        pd.addDiary(td);
    }

}
