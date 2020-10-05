package seedu.duke.ui;

import java.util.Scanner;

public class Ui {
    private static final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";


    private static final Scanner IN = new Scanner(System.in);

    /**
     * Returns the next line of user input.
     *
     * @return String of user input.
     */
    public String readLine() {
        return IN.nextLine().strip();
    }

    /**
     * Prints Duke logo.
     */
    private void printLogo() {
        System.out.println("Hello from\n" + LOGO);
    }

    /**
     * Prints greeting to Duke.
     */
    private void printGreeting() {
        System.out.println("What is your name?");
        System.out.println("Hello " + readLine());
    }

    /**
     * Prints logo and greeting for Duke.
     */
    public void showWelcome() {
        printLogo();
        printGreeting();
    }

    /**
     * Prints a message.
     *
     * @param message Message.
     */
    public void showError(String message) {
        System.out.println(message);
    }
}
