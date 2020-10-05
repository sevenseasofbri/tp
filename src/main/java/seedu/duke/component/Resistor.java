package seedu.duke.component;

public class Resistor extends LoadComponent {
    private static final String SI_UNIT = "Ω";

    public Resistor(double value) {
        super(value);
        siUnit = SI_UNIT;
        isDirectSeries = true;
    }
}
