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

    public static final String[] CIRCUIT_INSTRUCTIONS = {"Lets get started! First choose a template you want to work "
            + "with. You can choose from rc, rl, lc and r templates." + System.lineSeparator()
            + "eg. To select the Resistor-Capacitor circuit template, enter 'template rc'",
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
        "Great! You're set to use the circuit builder of \n" + LOGO + "Enjoy! :)\n type 'exit' to exit this mode.\n"};

    public static final String[] BOOLEAN_INSTRUCTIONS = {"Lets get started! First chose a template you want to work "
            + "with. You can chose from and, or, nand, nor, xor and xnor gate templates." + System.lineSeparator()
            + "eg. To select the and gate template, enter 'template and'",
        "Lets set a value to the input B! Type in 'set B BOOLVALUE' where BOOLVALUE is either a 1 or a 0. ",
        "Now lets set a value to the input C! Type in 'set C BOOLVLAUE' where BOOLVALUE is again either a 1 or 0.",
        "Now lets calculate the output of B GATE C. GATE here is the template you typed out earlier. Enter 'calc'.",
        "Voila! Now you can see the output to your gate! Lets add another gate now.\n Again, you can choose from the "
            + "gate templates list we gave you earlier.\n Just to recap the available gates are and, or, nand, nor"
            + ",xor and xnor gate templates.\n We are now going to connect the output of ths GATE you've decided to "
            + "input B. Enter 'add C GATE'.",
        "Now a new gate has been added let us assign the other variables. Set input F by entering 'set F BOOLVALUE' "
            + "where BOOLVALUE is either 1 or 0.",
        "Now a new gate has been added let us assign the other variables. Set input G by entering 'set G BOOLVALUE' "
            + "where BOOLVALUE is either 1 or 0.",
        "Now lets calculate the output of F GATE G. GATE here is the template you typed out earlier. Enter 'calc'.",
        "Great! You're set to use the boolean builder of \n" + LOGO + "Enjoy! :)\n type 'exit' to exit this mode.\n"
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
    public void printCircuitInstruction(int numOfCommandsDone) {
        System.out.println(CIRCUIT_INSTRUCTIONS[numOfCommandsDone]);
    }

    /**
     * Prints the instruction at the specified index from the array.
     *
     * @param numOfCommandsDone Type int specifies index number.
     */
    public void printBooleanInstruction(int numOfCommandsDone) {
        System.out.println(BOOLEAN_INSTRUCTIONS[numOfCommandsDone]);
    }
}
