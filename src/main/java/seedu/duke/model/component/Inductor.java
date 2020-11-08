package seedu.duke.model.component;

/**
 * The Inductor class inherits from the LoadComponent class
 * and is used to create Inductor objects.
 */
public class Inductor extends LoadComponent {
    private static final String SI_UNIT = "µH";

    public Inductor(double value) {
        super(value);
        siUnit = SI_UNIT;
        isDirectSeries = true;
    }
}
