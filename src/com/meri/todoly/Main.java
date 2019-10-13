package com.meri.todoly;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main {
    private static final String FILE_NAME = "TaskList.dat";
    private static ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(">> Welcome to ToDoLy");
        loadFromFile();
        showMenu();
        System.out.println("Task List " + taskList.size());
    }

    private static void showMenu() {
        System.out.println("Choose an option:");
        System.out.println("1) Show");
        System.out.println("2) Add");
        System.out.println("3) Edit");
        System.out.println("4) Save and Quit");

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
            showAllTasks();
            showMenu();
        } else if (optionNumber == 2) {
            addNewTask();
            showMenu();
        } else if (optionNumber == 3) {
            System.out.println(">> Not implemented 3");
            showMenu();
        } else if (optionNumber == 4) {
            saveToFile();
            System.out.println(">> Thank you. Next!");
        } else {
            System.out.println(">> Invalid option");
            showMenu();
        }
    }
    private static void showAllTasks() {
        for (Task task: taskList) {
            System.out.println(task.details());
        }
        System.out.println("\n");
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
            try {
                date = dateFormat.parse(dateString);
                System.out.println(date);
            } catch (ParseException e1) {
                System.out.println("Invalid date");
                return;
            }
        }


        System.out.println("Please enter project name");
        String projectName = userInput.nextLine();

        Task task = new Task(name, date, projectName);
        taskList.add(task);

    }
    public static void saveToFile() {
        Path destination = Paths.get(FILE_NAME).toAbsolutePath();
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(destination.toString()));
            os.writeObject(taskList);
            os.close();
        }
        catch (IOException exc) {
            System.err.println("Error saving to file" );
            exc.printStackTrace();
        }
    }

    public static void loadFromFile() {
        Path destination = Paths.get(FILE_NAME).toAbsolutePath();
        try {
            File file = destination.toFile();
            if (file.exists())
            {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
                taskList = (ArrayList<Task>)is.readObject();
                is.close();
            }
        }
        catch (Exception e) {
            System.err.println("Error when loading file");
            e.printStackTrace();
        }
    }
}
