package ui;
//DiaryApp

import model.PreviousDiary;
import model.Spending;
import model.TodayDiary;


import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Long.valueOf;
import static org.omg.CORBA.ORB.init;


public class DiaryApplication {
    private Scanner input;
    PreviousDiary previousDiary;
    TodayDiary newDiary;

    //EFFECTS: runs the diary application
    public DiaryApplication() {
        runDiary();
    }

    //MODIFIES: this
    //EFFECTS: process user input
    private void runDiary() {
        boolean keepGoing = true;
        String command = null;

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
        if (command.equals("c")) {
            viewPastDiary();
        } else if (command.equals("w")) {
            addStories();
        } else if (command.equals("s")) {
            addSpending();
        } else if (command.equals("a")) {
            calculateSum();
        } else {
            System.out.println("Selection not valid...\n");
        }
    }

    private void init() {
        previousDiary = new PreviousDiary();
        newDiary = new TodayDiary();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // MODIFIES: this
    //EFFECTS: display menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tc -> View a past diary");
        System.out.println("\tw -> Add Your Story");
        System.out.println("\ts -> Add New Spending");
        System.out.println("\ta -> Total Spending");

    }

    //MODIFIES: this
    //EFFECTS: create a new diary
    private void viewPastDiary() {
        System.out.println("Please enter the number of that diary");
        int num = input.nextInt();
        if (num > 0) {
            previousDiary.getDiary(num);
        } else {
            System.out.println("Invalid Number!\n");
        }


    }

    //MODIFIES: this
    //EFFECTS: add a story to a new diary
    private void addStories() {
        System.out.println("Please add your stories");
        String str = input.next();

        if (str.length() > 0) {
            newDiary.addWords(str);
        } else {
            System.out.println("What is your story today?\n");

        }

    }


    private void addSpending() {
        Spending sp = new Spending();
        System.out.println("Please add your tag, You may want to choose from" + ":Food,Clothes,Books");
        String str = input.next();
        if (str.length() > 0 && str.length() < 10) {
            sp.addTag(str);
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
        System.out.println("Successfully added");
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

