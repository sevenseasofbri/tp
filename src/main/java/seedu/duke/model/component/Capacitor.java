package seedu.duke.model.component;

/**
 * The Capacitor class inherits from the LoadComponent class
 * and is used to create Capacitor objects.
 */
public class Capacitor extends LoadComponent {
    private static final String SI_UNIT = "µF";

    public Capacitor(double value) {
        super(value);
        siUnit = SI_UNIT;
        isDirectSeries = false;
    }
}