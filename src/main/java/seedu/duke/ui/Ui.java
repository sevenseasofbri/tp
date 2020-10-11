package seedu.duke.ui;

import seedu.duke.component.Capacitor;
import seedu.duke.component.Inductor;
import seedu.duke.component.LoadComponent;
import seedu.duke.component.Resistor;
import seedu.duke.component.VoltageSource;
import seedu.duke.template.Template;

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
}
