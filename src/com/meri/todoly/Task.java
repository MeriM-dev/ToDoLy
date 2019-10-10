package com.meri.todoly;

import java.util.Date;

class Task {
    enum Status {
        inProgress, done
    }

    private String name;
    private Date date;
    private String projectName;
    private Status status;

    Task(String name, Date date, String projectName) {
        this.name = name;
        this.date = date;
        this.projectName = projectName;
        this.status = Status.inProgress;

    }
}
