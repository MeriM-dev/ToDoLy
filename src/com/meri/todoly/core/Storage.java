package com.meri.todoly.core;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Storage {
    private String fileName;

    public Storage(String fileName){
        this.fileName = fileName;
    }

    public void save(ArrayList<Task> taskList) {
        Path destination = Paths.get(fileName).toAbsolutePath();
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(destination.toString()));
            os.writeObject(taskList);
            os.close();
        } catch (IOException exc) {
            System.err.println("Error saving to file");
            exc.printStackTrace();
        }
    }

    public ArrayList<Task> load() {
        ArrayList<Task> taskList = new ArrayList<>();
        Path destination = Paths.get(fileName).toAbsolutePath();
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
        return taskList;
    }
}

