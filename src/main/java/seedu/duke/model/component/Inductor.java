package seedu.duke.model.component;

public class Inductor extends LoadComponent {
    private static final String SI_UNIT = "µH";

    public Inductor(double value) {
        super(value);
        siUnit = SI_UNIT;
        isDirectSeries = true;
    }
}
