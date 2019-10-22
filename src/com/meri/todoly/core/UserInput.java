package com.meri.todoly.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInput {
    public int waitForInt() {
        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNextInt()) {
            System.out.println(">> Enter a number");
            userInput.next();
        }
        return userInput.nextInt();
    }

    public String waitForString() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    public Date waitForDate(String format) {
        Scanner userInput = new Scanner(System.in);
        String dateString = userInput.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = null;
        while (date == null) {
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                System.out.println("Please enter a valid date");
            }
        }
        return date;
    }
}
