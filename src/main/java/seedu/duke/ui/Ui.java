package seedu.duke.ui;

import seedu.duke.logic.commands.SummaryCommand;

import java.util.Scanner;

/**
 * The UI class handles the user interface, reads user input and
 * prints messages to the user.
 */
public class Ui {
    private static final String LOGO = "\t  _____ _      _____                _ _                      _  "
            + "   _              _   \n"
            + "\t / ____| |    |_   _|              (_) |       /\\           (_)   | |            | |\n"
            + "\t| |    | |      | |  _ __ ___ _   _ _| |_     /  \\   ___ ___ _ ___| |_ __ _ _ __ | |_\n"
            + "\t| |    | |      | | | '__/ __| | | | | __|   / /\\ \\ / __/ __| / __| __/ _` | '_ \\| __|\n"
            + "\t| |____| |____ _| |_| | | (__| |_| | | |_   / ____ \\\\__ \\__ \\ \\__ \\ || (_| | | | | |_\n"
            + "\t \\_____|______|_____|_|  \\___|\\__,_|_|\\__| /_/    \\_\\___/___/_|___/\\__\\__,_|_| |_|\\__|";

    private static final String TUTORIAL = "\t  _______    _             _       _   __  __           _      _ \n"
            + "\t |__   __|  | |           (_)     | | |  \\/  |         | |    | |\n"
            + "\t    | |_   _| |_ ___  _ __ _  __ _| | | \\  / | ___   __| | ___| |\n"
            + "\t    | | | | | __/ _ \\| '__| |/ _` | | | |\\/| |/ _ \\ / _` |/ _ \\ |\n"
            + "\t    | | |_| | || (_) | |  | | (_| | | | |  | | (_) | (_| |  __/_|\n"
            + "\t    |_|\\__,_|\\__\\___/|_|  |_|\\__,_|_| |_|  |_|\\___/ \\__,_|\\___(_)\n";

    // The instructions to the circuit tutorial.
    public static final String[] CIRCUIT_INSTRUCTIONS = {"Lets get started! First we will choose a template to work "
            + "with.\n\tIn the app you can choose from rc, rl, lc and r templates\n\tHowever,"
            + " for this tutorial, we will use a Resistor-Capacitor template."
            + "\n\tTo select the Resistor-Capacitor circuit template, enter 'template rc'",
        "Let's set a value to our power source! Type in 'set v VALUE' , where VALUE is a +ve\n\tnumber in volts."
            + "\n\teg. set v 220 will set the power source to 220 volts.",
        "Let's set a value to the resistor! To do so, type 'set r VALUE' , where VALUE is a +ve\n\tnumber in ohms(Ω)."
            + "\n\teg. 'set r 500' will set the resistor to 500Ω.",
        "Let's set a value to the capacitor! To do so, type 'set c VALUE' , where VALUE is a +ve\n\tnumber in "
            + "microfarads(µF).\n\teg. 'set c 900' will set the capacitor to 900µF.",
        "Want to add a component in parallel to your current component? Lets do that with the\n\tcapacitor! "
            + "Type in 'add parallel c VALUE', where VALUE is a +ve number in microfarads (µF)."
            + "\n\teg. 'add parallel c 500' will add a capacitor in parallel to the capacitor in your circuit."
            + "\n\tDo remember though, this can be done with resistors, capacitors and"
            + " inductors and\n\tdifferent configurations (series/parallel) in the application based on the template"
            + " chosen!",
        "Great! Say, do you think we could find effective power consumed by the circuit?\n\tYes!"
            + "\n\tType in 'calc power' to calculate total power dissipated in watts(W)."
            + "\n\tDo remember, you can calculate a variety of other effective values\n\tin the application too!",
        "Hooray! You're set to use the circuit builder of \n" + LOGO + "\n\tEnjoy! :) type 'exit' to exit this mode."
            + "\n"};

    public static final String[] BOOLEAN_INSTRUCTIONS = {"Let's get started! First chose a template you want to work "
            + "with.\n\tYou can chose from and, or, nand, nor, xor and xnor gate templates." + System.lineSeparator()
            + "\tHowever for this tutorial, we will use an and gate template.\n\tTo select the and gate, "
            + "enter 'template and'.",
        "Let's set a value to the input B!\n\tType in 'set B BOOLVALUE' where BOOLVALUE is either a 1 or a 0. ",
        "Now let's set a value to the input C!\n\tType in 'set C BOOLVLAUE' where BOOLVALUE is again either a 1 or 0.",
        "Now let's calculate the output of B GATE C.\n\tGATE here is the template you typed out earlier. Enter 'calc'.",
        "Voila! Now you can see the output to your gate! Let's add another gate now.\n\tAgain, you can choose from the "
            + "gate templates list we gave you earlier.\n\tJust to recap, the available gates are and, or, nand, nor, "
            + "xor, and xnor gate templates.\n\tWe are now going to connect the output of the GATE you've decided to"
            + " input B.\n\tEnter 'add C GATE' where GATE can be one of the following: and, or, nand, nor, xor, xnor.",
        "Now a new gate has been added! Let us assign the other variables.\n\tSet input F by entering 'set F BOOLVALUE'"
            + " where BOOLVALUE is either 1 or 0.",
        "Now a new gate has been added! Let us assign the other variables.\n\tSet input G by entering 'set G BOOLVALUE'"
            + " where BOOLVALUE is either 1 or 0.",
        "Now let's calculate the output of the whole configuration. Enter 'calc'.",
        "Great! You're set to use the boolean builder of \n" + LOGO
            + "\n\tEnjoy! :)\n\t type 'exit' to exit this mode.\n"
    };

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
        System.out.println("\tHello from\n" + LOGO);
    }

    /**
     * Prints greeting to Duke.
     */
    private void printGreeting() {
        System.out.println("\t ");
        System.out.println("\tI am a desktop app that implements and solves simple electronic and logic "
                + "\n\tcircuits, optimized for use via the Command Line Interface (CLI)! :D \n");
        System.out.println(new SummaryCommand());
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
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("\t" + message);
        System.out.println("-----------------------------------------------------------------------------------------");
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
        printMessage("You have entered\n" + TUTORIAL + System.lineSeparator()
                + "\tType 'exit' if you want to leave this mode and go back to the application.");
    }

    /**
     * Prints the instruction at the specified index from the array.
     *
     * @param numOfCommandsDone Type int specifies index number.
     */
    public void printCircuitInstruction(int numOfCommandsDone) {
        printMessage(CIRCUIT_INSTRUCTIONS[numOfCommandsDone]);
    }

    /**
     * Prints the instruction at the specified index from the array.
     *
     * @param numOfCommandsDone Type int specifies index number.
     */
    public void printBooleanInstruction(int numOfCommandsDone) {
        printMessage(BOOLEAN_INSTRUCTIONS[numOfCommandsDone]);
    }

    /**
     * Prompts the user to start the CLIrcuit Assistant.
     */
    public void promptForIntro() {
        System.out.println("Hello! Type 'start' to start the CLIrcuit Assistant");
        String userLine = readLine();
        boolean isNotStart = true;
        while (isNotStart) {
            if (userLine.equals("start")) {
                showWelcome();
                isNotStart = false;
            } else {
                printMessage("Invalid Command! Type in start to begin using Circuit Assistant!");
                userLine = IN.nextLine();
            }
        }
    }
}
