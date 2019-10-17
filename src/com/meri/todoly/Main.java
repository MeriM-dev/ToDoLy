package com.meri.todoly;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Main {
    private static final String FILE_NAME = "TaskList.dat";
    private static ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(">> Welcome to ToDoLy <<");
        loadFromFile();
        displayMainMenu();
        System.out.println("Task List " + taskList.size());
    }

    private static void displayMainMenu() {
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
        mainMenuAction(optionNumber);
    }

    private static void removeTask() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter existing name");
        String name = userInput.nextLine();
        int taskIndex = findTask(name);
        if (taskIndex >= 0) {
            taskList.remove(taskIndex);
            System.out.println("Task deleted");
        } else {
            System.out.println("Couldn't find task: " + name);
        }
    }
    private static void markAsDone() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter existing name");
        String name = userInput.nextLine();
        int taskIndex = findTask(name);
        if (taskIndex >= 0) {
            taskList.get(taskIndex).setStatus(Task.Status.done);
            System.out.println("Done");
        } else {
            System.out.println("Couldn't find task: " + name);
        }
    }

    private static int findTask(String taskName) {
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getName().equals(taskName)) {
                return i;
            }
        }
        return -1;
    }

    private static void displayShowMenu() {
        System.out.println("Order by:");
        System.out.println("1) Date");
        System.out.println("2) Project Name");
        System.out.println("3) Return to main menu");

        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNextInt()) {
            System.out.println(">> Enter a number");
            userInput.next();
        }
        int optionNumber = userInput.nextInt();
        showMenuAction(optionNumber);
    }
    private static void displayEditMenu() {
        System.out.println("Choose an option:");
        System.out.println("1) Edit");
        System.out.println("2) Remove");
        System.out.println("3) Mark as done");
        System.out.println("4) Return to main menu");

        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNextInt()) {
            System.out.println(">> Enter a number");
            userInput.next();
        }
        int optionNumber = userInput.nextInt();
        editMenuAction(optionNumber);
    }

    private static void mainMenuAction(int optionNumber) {
        if (optionNumber == 1) {
            displayShowMenu();
            displayMainMenu();
        } else if (optionNumber == 2) {
            addNewTask();
            displayMainMenu();
        } else if (optionNumber == 3) {
            displayEditMenu();
            displayMainMenu();
        } else if (optionNumber == 4) {
            saveToFile();
            System.out.println(">> Thank you. Next!");
        } else {
            System.out.println(">> Invalid option");
            displayMainMenu();
        }
    }
    private static void editMenuAction(int optionNumber) {
        if (optionNumber == 1) {
            System.out.println(">> Not implemented 1");
        }
        else if (optionNumber == 2) {
            removeTask();
        } else if (optionNumber == 3) {
            markAsDone();
        }
        else if (optionNumber == 4) {
            return;
        }else{
            System.out.println(">> Invalid option");
            return;
        }
    }

    private static void showMenuAction(int optionNumber) {
        ArrayList<Task> list = taskList;
        if (optionNumber == 1) {
            Comparator<Task> comparator = (t1, t2) -> t1.getDate().compareTo(t2.getDate());
            list.sort(comparator);
        } else if (optionNumber == 2) {
            Comparator<Task> comparator = (t1, t2) -> t1.getProjectName().compareTo(t2.getProjectName());
            list.sort(comparator);
        } else if (optionNumber == 3) {
            return;
        } else {
            System.out.println(">> Invalid option");
            return;
        }
        for (Task task : list) {
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
        } catch (IOException exc) {
            System.err.println("Error saving to file");
            exc.printStackTrace();
        }
    }

    public static void loadFromFile() {
        Path destination = Paths.get(FILE_NAME).toAbsolutePath();
        try {
            File file = destination.toFile();
            if (file.exists()) {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
                taskList = (ArrayList<Task>) is.readObject();
                is.close();
            }
        } catch (Exception e) {
            System.err.println("Error when loading file");
            e.printStackTrace();
        }
    }
}
