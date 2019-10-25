package com.meri.todoly;
import com.meri.todoly.core.App;

/**
 * This is the Main class it is the app starting point
 */
public class Main {
    private static App app = new App();

    public static void main(String[] args) {
        System.out.println(">> Welcome to ToDoLy <<");
        app.displayMainMenu();
    }
}

