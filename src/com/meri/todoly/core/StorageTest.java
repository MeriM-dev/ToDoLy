package com.meri.todoly.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StorageTest {
    private String fileName = "testFileName-Storage";

    @Test
    void save() {
        ArrayList<Task> taskList = new ArrayList<>();
        Storage storage = new Storage(fileName);
        storage.save(taskList);
        
        ArrayList<Task> loaded = storage.load();
        assertEquals(loaded.size(), 0);

        Task task1 = new Task("testName1", new Date(),"testProjectName1");
        Task task2 = new Task("testName2", new Date(),"testProjectName2");
        Task task3 = new Task("testName3", new Date(),"testProjectName3");

        taskList.add(task1);
        taskList.add(task2);
        taskList.add(task3);

        storage.save(taskList);

        loaded = storage.load();
        assertEquals(loaded.size(), 3);
    }
}