package seedu.duke.model.component;

/**
 * The Resistor class inherits from the LoadComponent class
 * and is used to create Resistor objects.
 */
public class Resistor extends LoadComponent {
    private static final String SI_UNIT = "Ω";

    public Resistor(double value) {
        super(value);
        siUnit = SI_UNIT;
        isDirectSeries = true;
    }
}
