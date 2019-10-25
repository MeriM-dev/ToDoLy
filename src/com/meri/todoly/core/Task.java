package com.meri.todoly.core;

import java.io.Serializable;
import java.util.Date;
/**
 * This class stores all the information about a task.
 * Details are shown by task title, due date, completion, and project name.
 */
public class Task implements Serializable {
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    Task(String name, Date date, String projectName) {
        this.name = name;
        this.date = date;
        this.projectName = projectName;
        this.status = Status.inProgress;
    }

    /**
     * Returns a string with task properties which are converted into human readable form.
     *
     * @return String with task properties which are converted into human readable form.
     */
    public String details() {
        return name + " | " + date.toString() + " | " + projectName + " | " + status.details();
    }
}
