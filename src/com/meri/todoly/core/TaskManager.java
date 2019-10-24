package com.meri.todoly.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class TaskManager {
    private Storage storage;
    private ArrayList<Task> taskList = new ArrayList<>();
    private UserInput userInput = new UserInput();

    public TaskManager(String fileName) {
        storage = new Storage(fileName);
        taskList = storage.load();
        System.out.println("Task List " + taskList.size());
    }

    public void saveTaskList() {
        storage.save(taskList);
    }

    public ArrayList<Task> sortedByDate() {
        ArrayList<Task> list = taskList;
        Comparator<Task> comparator = (t1, t2) -> t1.getDate().compareTo(t2.getDate());
        list.sort(comparator);
        return list;
    }

    public ArrayList<Task> sortedByProject() {
        ArrayList<Task> list = taskList;
        Comparator<Task> comparator = (t1, t2) -> t1.getProjectName().compareTo(t2.getProjectName());
        list.sort(comparator);
        return list;
    }

    public void removeTask() {
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

    public void updateName(Task task) {
        System.out.println("Please enter new name");
        String name = userInput.waitForString();
        task.setName(name);
    }

    public void markAsDone() {
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

    public void updateTask() {
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

    public void addNewTask() {
        System.out.println("Please enter name");
        String name = userInput.waitForString();

        System.out.println("Please enter date in the following format (yyyy-MM-dd)");
        Date date = userInput.waitForDate("yyyy-MM-dd");

        System.out.println("Please enter project name");
        String projectName = userInput.waitForString();

        Task task = new Task(name, date, projectName);
        taskList.add(task);
    }

    private int findTask(String taskName) {
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getName().equals(taskName)) {
                return i;
            }
        }
        return -1;
    }
}
