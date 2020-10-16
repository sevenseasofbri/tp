package seedu.duke.ui;

import java.util.Scanner;

public class Ui {
    //Running into issues with runtest.bat with the following LOGO. Using regular text for now.
    private static final String LOGO = " _____ _      _____                _ _                      _  "
            + "   _              _   \n"
            + "/ ____| |    |_   _|              (_) |       /\\           (_)   | |            | |\n"
            + "| |    | |      | |  _ __ ___ _   _ _| |_     /  \\   ___ ___ _ ___| |_ __ _ _ __ | |_\n"
            + "| |    | |      | | | '__/ __| | | | | __|   / /\\ \\ / __/ __| / __| __/ _` | '_ \\| __|\n"
            + "| |____| |____ _| |_| | | (__| |_| | | |_   / ____ \\\\__ \\__ \\ \\__ \\ || (_| | | | | |_\n"
            + "\\_____|______|_____|_|  \\___|\\__,_|_|\\__| /_/    \\_\\___/___/_|___/\\__\\__,_|_| |_|\\__|";

    private static final String TUTORIAL = "  _______    _             _       _   __  __           _      _ \n"
            + " |__   __|  | |           (_)     | | |  \\/  |         | |    | |\n"
            + "    | |_   _| |_ ___  _ __ _  __ _| | | \\  / | ___   __| | ___| |\n"
            + "    | | | | | __/ _ \\| '__| |/ _` | | | |\\/| |/ _ \\ / _` |/ _ \\ |\n"
            + "    | | |_| | || (_) | |  | | (_| | | | |  | | (_) | (_| |  __/_|\n"
            + "    |_|\\__,_|\\__\\___/|_|  |_|\\__,_|_| |_|  |_|\\___/ \\__,_|\\___(_)\n";

    public static final String[] INSTRUCTIONS = {"Lets get started! First choose a template you want to work with."
            + "You can choose from rc, rl, lc and r templates." + System.lineSeparator()
            + "eg. To select the Resistor-Capacitor circuit template, enter 'template rc.'",
        "Lets set a value to our power source! Type in 'set v VALUE' , where VALUE is a +ve number in volts.",
        "Lets set a value to resistor/capacitor/inductor! To do so, type 'set' followed by 'r' OR 'c' OR 'l'"
            + " followed by a numeric VALUE. eg. 'set r 500' will set the resistor to 500Ω",
        "Lets set another value in our template! Here's the syntax for reference 'set r/l/c/v VALUE'.",
        "Want to add a component in parallel/series to your current component? Lets do that! "
            + "Type in 'add' followed by 'series/parallel' then 'r'/'c'/'l' and a numeric VALUE.\n"
            + "eg. 'add parallel c 500' will add a capacitor in parallel to the capacitor in your circuit (if any).",
        "Great! Say, do you think we could find effective power/current consumed by the circuit?"
            + "Or even effective resistance/inductance/capacitance? Yes!\n"
            + "Lets try it out. Type 'calc' followed by 'ceff'/'leff'/'reff'/'power'/'current' and enter. :D",
        "Great! You're set to use\n" + "CLIrcuit Assistant" + "Enjoy! :)\n type 'exit' to exit this mode.\n"};


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
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints an error message.
     *
     * @param message Error message.
     */
    public void showError(String message) {
        printMessage(message);
    }

    /**
     * Prints the welcome message for the tutorial mode.
     */
    public void printWelcomeTutorial() {
        System.out.println("You have entered Tutorial Mode!" + System.lineSeparator()
                + "Type 'exit' if you want to leave this mode and go back to the application.");
    }

    /**
     * Prints the instruction at the specified index from the array.
     *
     * @param numOfCommandsDone Type int specifies index number.
     */
    public void printInstruction(int numOfCommandsDone) {
        System.out.println(INSTRUCTIONS[numOfCommandsDone]);
    }
}
