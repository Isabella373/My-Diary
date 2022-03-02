package ui;
//DiaryApp

import model.PreviousDiary;
import model.Spending;
import model.Thingy;
import model.TodayDiary;
import persistence.JsonReader;
import persistence.JsonWriter;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;


public class DiaryApplication {
    private static final String JSON_STONE = "./data/todaydiary.json";
    private Scanner input;
    private PreviousDiary previousDiary;
    private TodayDiary newDiary;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //EFFECTS: runs the diary application
    public DiaryApplication() throws FileNotFoundException {
        input = new Scanner(System.in);
        newDiary = new TodayDiary(0);
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

        System.out.println("\nThanks for using!");
    }

    //MODIFIES: this
    //EFFECTS: process user command
    private void processCommand(String command) {
        if (command.equals("v")) {
            viewPastDiary();
        } else if (command.equals("c")) {
            addDiary();
        } else if (command.equals("l")) {
            load();
        } else if (command.equals("a")) {
            calculateSum();
        } else {
            System.out.println("Selection not valid...\n");
        }
    }

    private void init() {
        previousDiary = new PreviousDiary();
        newDiary = new TodayDiary(0);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    //EFFECTS: display menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tv -> View a past diary");
        System.out.println("\tc -> Create a new Diary");
        System.out.println("\tl -> Load a previous diary");
        System.out.println("\ta -> Calculate Total Spending");
        System.out.println("\tq -> quit");

    }

    //MODIFIES: this
    //EFFECTS: create a new diary
    private void viewPastDiary() {

        List<Thingy> thingies = newDiary.getThingies();

        for (Thingy t : thingies) {
            System.out.println(t);
        }


    }


    //MODIFIES: this
    //EFFECTS: add a story to a new diary
    private void addDiary() {
        System.out.println("Please add your stories");
        String str = input.next();
        while (str.length() == 0) {
            System.out.println("What is your story today?\n");
        }
        newDiary.addWords(str);
        System.out.println("Please add your Spending");
        addSpending();
        System.out.println("Enter 'save' if you want to save the diary, Enter 'Quit' to quit it");
        String str3 = input.next();
        if (str3.equals("save")) {
            save();
            System.out.println("Saved successfully");
        } else {
            System.out.println("Not saved");
        }

    }

    private void addSpending() {
        Spending sp = new Spending();
        System.out.println("Please add your tag, You may want to choose from" + ":Food,Clothes,Books");
        String str4 = input.next();
        if (str4.length() > 0 && str4.length() < 10) {
            sp.addTag(str4);
        } else {
            System.out.println("Please have a brief tag");
        }
        String amount;
        System.out.println("Please add an amount");
        amount = input.next();
        if (Integer.parseInt(amount) > 0) {
            sp.addAmount(Integer.parseInt(amount));
        } else {
            System.out.println("Please have valid number\n");
        }
        String description;
        System.out.println("Please add a brief description");
        description = input.next();
        sp.addDescription(description);
        newDiary.addSpending(sp);
        System.out.println("Successfully add the Spending");
    }


    private void load() {
        try {
            newDiary = jsonReader.read();
            System.out.println("Loaded " + newDiary.getWords() + " from" + JSON_STONE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STONE);
        }

    }

    private void save() {
        try {
            jsonWriter.open();
            jsonWriter.write(newDiary);
            jsonWriter.close();
            System.out.println("Saved the diary " + "to " + JSON_STONE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STONE);
        }
    }


    private void calculateSum() {
        System.out.println("Enter the number of the diary you want to check");
        int num = input.nextInt();
        if (num >= 0) {
            System.out.println("Your spent" + " " + newDiary.spendingPerDay());
        } else {
            System.out.println("Please select a valid diary\n");
        }
    }


}

