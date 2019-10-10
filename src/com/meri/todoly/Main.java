package com.meri.todoly;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main {
    private static ArrayList<Task> taskList = new ArrayList<Task>();

    public static void main(String[] args) {
        System.out.println(">> Welcome to ToDoLy");
        System.out.println("Choose option: 1) Show 2) Add 3) Edit 4) Save and Quit");

        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNextInt()) {
            System.out.println(">> Enter a number");
            userInput.next();
        }
        int optionNumber = userInput.nextInt();

        if (optionNumber == 1) {
            System.out.println(">> Not implemented 1");
        } else if (optionNumber == 2) {
            addNewTask();

        } else if (optionNumber == 3) {
            System.out.println(">> Not implemented 3");
        } else if (optionNumber == 4) {
            System.out.println(">> Thank you. Next!");
        } else {
            System.out.println(">> Invalid option");
        }

        System.out.println("Task List " + taskList.size());
    }

    public static void addNewTask() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter name");
        String name = userInput.next();

        System.out.println("Please enter date in the following format (yyyy-MM-dd)");
        String dateString = userInput.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date;

        try {
            date = dateFormat.parse(dateString);
            System.out.println(date);

        } catch (ParseException e) {

        }


        System.out.println("Please enter project name");
        String projectName = userInput.next();

        Task task = new Task(name, dateString, projectName);
        taskList.add(task);

    }
}
