package com.meri.todoly;

public class Task {
    private String name;
    private String date;
    private String projectName;
    private String status;

    public Task(String name, String date, String projectName){
        this.name = name;
        this.date = date;
        this.projectName = projectName;
        this.status = "To do";

    }
}
