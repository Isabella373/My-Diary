package ui;
//DiaryApp

import model.Category;
import model.PreviousDiary;
import model.TodayDiary;
import persistence.JsonReader;
import persistence.JsonWriter;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class DiaryApplication {
    private static final String JSON_STONE = "./data/todaydiary.json";
    private Scanner input;
    private PreviousDiary previousDiary;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: runs the diary application
    public DiaryApplication() throws FileNotFoundException {
        input = new Scanner(System.in);
        previousDiary = new PreviousDiary("My Diaries");
        jsonWriter = new JsonWriter(JSON_STONE);
        jsonReader = new JsonReader(JSON_STONE);
        runDiary();
    }

    //MODIFIES: this
    //EFFECTS: process user input
    private void runDiary() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        init();


        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("Do you want to save diaries? enter yes or no");
        String ip = input.next();
        if (ip == "yes") {
            savePreviousDiaries();
        }


        System.out.println("\nThanks for using!");
    }

    // MODIFIES: this
    //EFFECTS: display menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add a dairy");
        System.out.println("\tp -> print diaries");
        System.out.println("\ts -> save all the diaries to file");
        System.out.println("\tl -> load all the diaries from file");
        System.out.println("\tq -> quit");

    }

    //MODIFIES: this
    //EFFECTS: process user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addDiaries();
        } else if (command.equals("p")) {
            printDiaries();
        } else if (command.equals("s")) {
            savePreviousDiaries();
        } else if (command.equals("l")) {
            loadDiaries();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    private void init() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    // EFFECTS: loads previous diaries from the file
    private void loadDiaries() {
        try {
            previousDiary = jsonReader.read();
            System.out.println("Loaded " + previousDiary.getName() + " from " + JSON_STONE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STONE);

        }
    }

    // EFFECTS: saves all the diaries to file
    private void savePreviousDiaries() {
        try {
            jsonWriter.open();
            jsonWriter.write(previousDiary);
            jsonWriter.close();
            System.out.println("Saved" + previousDiary.getName() + "to " + JSON_STONE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STONE);
        }
    }


    //MODIFIES: this
    //EFFECTS: create a new diary
    private void addDiaries() {
        Category category = readCategory();
        System.out.println("Please enter the time right now");
        String title = input.next();
        TodayDiary td;
        td = new TodayDiary(title, category);
        System.out.println("Please enter your story");
        String story = input.next();
        td.addWords(story);
        previousDiary.addDiary(td);
        System.out.println("Added Successfully!!!");
    }


    // EFFECTS: prompts user to select category and returns it
    private Category readCategory() {
        System.out.println("Please select a category for your diary");

        int menuLabel = 1;
        for (Category c : Category.values()) {
            System.out.println(menuLabel + ": " + c);
            menuLabel++;
        }

        int menuSelection = input.nextInt();
        return Category.values()[menuSelection - 1];
    }


    // EFFECTS: prints all the diaries in the previous diaries to the console
    private void printDiaries() {
        List<TodayDiary> diaries = previousDiary.getPreviousDiary();

        for (TodayDiary td : diaries) {
            System.out.println(td);
        }
    }
}

