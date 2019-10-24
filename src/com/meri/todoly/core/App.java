package com.meri.todoly.core;

import com.meri.todoly.core.Task;
import com.meri.todoly.core.TaskManager;
import com.meri.todoly.core.UserInput;
import java.util.ArrayList;

    public class App {
        private final String FILE_NAME = "TaskList.dat";
        private  TaskManager taskManager = new TaskManager(FILE_NAME);
        private  UserInput userInput = new UserInput();

        public void displayMainMenu() {
            System.out.println("Choose an option:");
            System.out.println("1) Show");
            System.out.println("2) Add");
            System.out.println("3) Edit");
            System.out.println("4) Save and Quit");

            mainMenuAction(userInput.waitForInt());
        }

        private void displayShowMenu() {
            System.out.println("Order by:");
            System.out.println("1) Date");
            System.out.println("2) Project Name");
            System.out.println("3) Return to main menu");

            showMenuAction(userInput.waitForInt());
        }
        private void displayEditMenu() {
            System.out.println("Choose an option:");
            System.out.println("1) Update");
            System.out.println("2) Remove");
            System.out.println("3) Mark as done");
            System.out.println("4) Return to main menu");

            editMenuAction(userInput.waitForInt());
        }
        private void mainMenuAction(int optionNumber) {
            if (optionNumber == 1) {
                displayShowMenu();
                displayMainMenu();
            } else if (optionNumber == 2) {
                taskManager.addNewTask();
                displayMainMenu();
            } else if (optionNumber == 3) {
                displayEditMenu();
                displayMainMenu();
            } else if (optionNumber == 4) {
                taskManager.saveTaskList();
                System.out.println(">> Thank you. Next!");
            } else {
                System.out.println(">> Invalid option");
                displayMainMenu();
            }
        }
        private void editMenuAction(int optionNumber) {
            if (optionNumber == 1) {
                taskManager.updateTask();
            }
            else if (optionNumber == 2) {
                taskManager.removeTask();
            } else if (optionNumber == 3) {
                taskManager.markAsDone();
            }
            else if (optionNumber == 4) {
                return;
            }else{
                System.out.println(">> Invalid option");
                return;
            }
        }
        private void showMenuAction(int optionNumber) {
            ArrayList<Task> list;
            if (optionNumber == 1) {
                list = taskManager.sortedByDate();
            } else if (optionNumber == 2) {
                list = taskManager.sortedByProject();
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
    }

