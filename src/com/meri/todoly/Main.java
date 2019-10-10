package com.meri.todoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main {
    private static ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(">> Welcome to ToDoLy");
        showMenu();
        System.out.println("Task List " + taskList.size());
    }

    private static void showMenu() {
        System.out.println("Choose option: 1) Show 2) Add 3) Edit 4) Save and Quit");

        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNextInt()) {
            System.out.println(">> Enter a number");
            userInput.next();
        }

        int optionNumber = userInput.nextInt();
        userAction(optionNumber);
    }

    private static void userAction(int optionNumber) {
        if (optionNumber == 1) {
            System.out.println(">> Not implemented 1");
            showMenu();
        } else if (optionNumber == 2) {
            addNewTask();
            showMenu();
        } else if (optionNumber == 3) {
            System.out.println(">> Not implemented 3");
            showMenu();
        } else if (optionNumber == 4) {
            System.out.println(">> Thank you. Next!");
        } else {
            System.out.println(">> Invalid option");
            showMenu();
        }
    }

    private static void addNewTask() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter name");
        String name = userInput.nextLine();

        System.out.println("Please enter date in the following format (yyyy-MM-dd)");
        String dateString = userInput.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date;

        try {
            date = dateFormat.parse(dateString);
            System.out.println(date);

        } catch (ParseException e) {
            System.out.println("Please enter a valid date");
            return;
        }


        System.out.println("Please enter project name");
        String projectName = userInput.nextLine();

        Task task = new Task(name, date, projectName);
        taskList.add(task);

    }
}
