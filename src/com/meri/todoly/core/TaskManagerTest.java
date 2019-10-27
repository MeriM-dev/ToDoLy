package com.meri.todoly.core;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    private String fileName = "testFileName";

    @Test
    void updateName() {
        TaskManager butler = new TaskManager(fileName);
        Task task1 = new Task("testName1", new Date(),"testProjectName1");

        String newName = "testName1-new";
        InputStream in = new ByteArrayInputStream(newName.getBytes());
        System.setIn(in);

        butler.updateName(task1);

        assertEquals(task1.getName(), newName);
    }
}