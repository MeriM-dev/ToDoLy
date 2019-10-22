package com.meri.todoly;

import com.meri.todoly.core.Storage;
import com.meri.todoly.core.UserInput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Main {
    private static final String FILE_NAME = "TaskList.dat";
    private static Storage storage = new Storage(FILE_NAME);
    private static ArrayList<Task> taskList = new ArrayList<>();
    private static UserInput userInput = new UserInput();

    public static void main(String[] args) {
        System.out.println(">> Welcome to ToDoLy <<");
        taskList = storage.load();
        displayMainMenu();
        System.out.println("Task List " + taskList.size());
    }

    private static void displayMainMenu() {
        System.out.println("Choose an option:");
        System.out.println("1) Show");
        System.out.println("2) Add");
        System.out.println("3) Edit");
        System.out.println("4) Save and Quit");

        mainMenuAction(userInput.waitForInt());
    }

    private static void removeTask() {
        System.out.println("Please enter existing name");
        String name = userInput.waitForString();
        int taskIndex = findTask(name);
        if (taskIndex >= 0) {
            taskList.remove(taskIndex);
            System.out.println("Task deleted");
        } else {
            System.out.println("Couldn't find task: " + name);
        }
    }
    private static void markAsDone() {
        System.out.println("Please enter existing name");
        String name = userInput.waitForString();
        int taskIndex = findTask(name);
        if (taskIndex >= 0) {
            taskList.get(taskIndex).setStatus(Task.Status.done);
            System.out.println("Done");
        } else {
            System.out.println("Couldn't find task: " + name);
        }
    }
    private static void updateTask() {
        System.out.println("Please enter existing name");
        String name = userInput.waitForString();
        int taskIndex = findTask(name);
        if (taskIndex >= 0) {
            updateName(taskList.get(taskIndex));

            System.out.println("Updated");
        } else {
            System.out.println("Couldn't find task: " + name);
        }
    }
    private static void updateName(Task task) {
        System.out.println("Please enter new name");
        String name = userInput.waitForString();
        task.setName(name);
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

        showMenuAction(userInput.waitForInt());
    }
    private static void displayEditMenu() {
        System.out.println("Choose an option:");
        System.out.println("1) Update");
        System.out.println("2) Remove");
        System.out.println("3) Mark as done");
        System.out.println("4) Return to main menu");

        editMenuAction(userInput.waitForInt());
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
            storage.save(taskList);
            System.out.println(">> Thank you. Next!");
        } else {
            System.out.println(">> Invalid option");
            displayMainMenu();
        }
    }
    private static void editMenuAction(int optionNumber) {
        if (optionNumber == 1) {
           updateTask();
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
        System.out.println("Please enter name");
        String name = userInput.waitForString();

        System.out.println("Please enter date in the following format (yyyy-MM-dd)");
        Date date = userInput.waitForDate("yyyy-MM-dd");

        System.out.println("Please enter project name");
        String projectName = userInput.waitForString();

        Task task = new Task(name, date, projectName);
        taskList.add(task);
    }
}
