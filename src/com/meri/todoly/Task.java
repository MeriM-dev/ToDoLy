package com.meri.todoly;

import java.util.Date;

class Task {
    enum Status {
        inProgress, done;

        public String details() {
            switch (this) {
                case inProgress:
                    return "In progress";
                case done:
                    return "Done";
            }
            return "";
        }
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

    public String details() {
        return name + " | " + date.toString() + " | " + projectName + " | " + status.details();
    }
}
