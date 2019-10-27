package com.meri.todoly.core;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @org.junit.jupiter.api.Test
    void setStatus() {
        Task task = new Task("testName", new Date(),"testProjectName");
        assertEquals(task.getStatus(), Task.Status.inProgress);
        task.setStatus(Task.Status.done);
        assertEquals(task.getStatus(), Task.Status.done);
    }

    @org.junit.jupiter.api.Test
    void details() {
        Date date = new Date(19, 9, 9);
        Task task = new Task("testName", date,"testProjectName");
        assertEquals(task.details(), "testName | Thu Oct 09 00:00:00 CET 1919 | testProjectName | In progress");
    }
}