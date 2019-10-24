package com.meri.todoly;

import com.meri.todoly.core.App;
public class Main {
    private static App app = new App();

    public static void main(String[] args) {
        System.out.println(">> Welcome to ToDoLy <<");
        app.displayMainMenu();
    }
}

