package seedu.duke.ui;

import seedu.duke.component.Capacitor;
import seedu.duke.component.Inductor;
import seedu.duke.component.LoadComponent;
import seedu.duke.component.Resistor;
import seedu.duke.component.VoltageSource;
import seedu.duke.template.Template;

import java.util.Scanner;

public class Ui {
    //Running into issues with runtest.bat with the following LOGO. Using regular text for now.
    private static final String LOGO = "   _____ _      _____                _ _                      _  "
            + "   _              _   \n"
            + "  / ____| |    |_   _|              (_) |       /\\           (_)   | |            | |  \n"
            + " | |    | |      | |  _ __ ___ _   _ _| |_     /  \\   ___ ___ _ ___| |_ __ _ _ __ | |_ \n"
            + " | |    | |      | | | '__/ __| | | | | __|   / /\\ \\ / __/ __| / __| __/ _` | '_ \\| __|\n"
            + " | |____| |____ _| |_| | | (__| |_| | | |_   / ____ \\\\__ \\__ \\ \\__ \\ || (_| | | | | |_ \n"
            + "  \\_____|______|_____|_|  \\___|\\__,_|_|\\__| /_/    \\_\\___/___/_|___/\\__\\__,_|_| |_|\\__|\n";

    private static final String TUTORIAL = "  _______    _             _       _   __  __           _      _ \n"
            + " |__   __|  | |           (_)     | | |  \\/  |         | |    | |\n"
            + "    | |_   _| |_ ___  _ __ _  __ _| | | \\  / | ___   __| | ___| |\n"
            + "    | | | | | __/ _ \\| '__| |/ _` | | | |\\/| |/ _ \\ / _` |/ _ \\ |\n"
            + "    | | |_| | || (_) | |  | | (_| | | | |  | | (_) | (_| |  __/_|\n"
            + "    |_|\\__,_|\\__\\___/|_|  |_|\\__,_|_| |_|  |_|\\___/ \\__,_|\\___(_)\n";

    public static final String[] INSTRUCTIONS = {"Lets get started! First choose a template you want to work with."
            + "You can choose from rc, rl, lc and r templates.\n"
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
        "Great! You're set to use\n" + LOGO + "Enjoy! :)\n type 'exit' to exit this mode.\n"};

    private static final String COMMAND_SUMMARY = "\n"
            + "+-----------+----------------------------+--------------------+\n"
            + "|  Action   |           Format           |      Examples      |\n"
            + "+-----------+----------------------------+--------------------+\n"
            + "| Help      | help                       | help               |\n"
            + "| Template  | template TEMPLATE          | template rc        |\n"
            + "| Set       | set COMPONENT VALUE        | set r 500          |\n"
            + "| Add       | add CONFIG COMPONENT VALUE | add parallel c 500 |\n"
            + "| Calculate | calc EFF_VALUE             | calc ceff          |\n"
            + "+-----------+----------------------------+--------------------+\n"
            + "\n";

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
        System.out.println("Hello from\n" + "CLIrcuit Assistant!");
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
     * Prints farewell message after exiting Duke.
     */
    public void printFarewell() {
        System.out.println(" Bye. See you next time!");
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
     * Prints that a component has been set.
     *
     * @param component LoadComponent object set.
     */
    public void printSetComponent(LoadComponent component) {
        System.out.println("Set " + component);
    }


    /**
     * Prints that a component has been added.
     *
     * @param component LoadComponent object added.
     */
    public void printAddComponent(LoadComponent component) {
        System.out.println("Nice, added a " + component);
    }

    /**
     * Prints the template that was chosen.
     *
     * @param template Template object.
     */
    public void printTemplate(Template template) {
        System.out.println(template);
    }

    /**
     * Prints the effective resistance that was calculated.
     *
     * @param resistor Resistor object.
     */
    public void printCalculatedResistance(Resistor resistor) {
        System.out.println("The effective resistance calculated is " + resistor);
    }

    /**
     * Prints the effective capacitance that was calculated.
     *
     * @param capacitor Capacitor object.
     */
    public void printCalculatedCapacitance(Capacitor capacitor) {
        System.out.println("The effective capacitance calculated is " + capacitor);
    }

    /**
     * Prints the effective inductance that was calculated.
     *
     * @param inductor Inductor object.
     */
    public void printCalculatedInductance(Inductor inductor) {
        System.out.println("The effective inductance calculated is " + inductor);
    }

    /**
     * Prints the power dissipated in the circuit.
     *
     * @param power double value.
     */
    public void printCalculatedPower(double power) {
        System.out.println("The power dissipated in the circuit is " + power + "W");
    }

    /**
     * Prints the current drawn by the circuit.
     *
     * @param current double value.
     */
    public void printCalculatedCurrent(double current) {
        System.out.println("The total rms current flowing through the circuit is " + current + "A");
    }

    /**
     * Prints the value of the voltage source after setting voltage.
     *
     * @param voltageSource VoltageSource object.
     */
    public void printSetVoltageSource(VoltageSource voltageSource) {
        System.out.println("The voltage source was changed to: " + voltageSource);
    }

    /**
     * Prints the welcome message for the tutorial mode.
     */
    public void printWelcomeTutorial() {
        System.out.println("You have entered\n" + TUTORIAL + "Type 'exit' if you want to leave"
                + " this mode and go back to the application.");
    }


    /**
     * Prints command summary.
     */
    public void printCommandSummary() {
        System.out.print(COMMAND_SUMMARY);
    }

    /**
     * Prints exit statement for the help mode.
     */
    public void printExitHelp() {
        System.out.println(":) Have fun using \n" + LOGO);
    }
}
