package com.meri.todoly.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * This class is used to process all user input
 */
public class UserInput {
    /**
     * Waits for a valid user input of a number.
     * If the user enters anything else than
     * a number they will be prompted over and over again
     * until they enter a number.
     *
     * @return the number the user entered
     */
    public int waitForInt() {
        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNextInt()) {
            System.out.println(">> Enter a number");
            userInput.next();
        }
        return userInput.nextInt();
    }

    /**
     * Waits for a user input.
     * Anything entered by the user will be treated as string.
     *
     * @return the string the user entered
     */
    public String waitForString() {
        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine();
    }

    /**
     * Waits for a valid user input of a date in a given format.
     * If the user enters anything else than
     * a valid date they will be prompted over and over again
     * until they do so.
     *
     * @return the date that the user entered
     */
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
