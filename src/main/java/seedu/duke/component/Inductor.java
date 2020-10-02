package seedu.duke.component;

public class Inductor extends Component {
    private static final String SI_UNIT = "µH";

    public Inductor(double value) {
        super(value);
        siUnit = SI_UNIT;
        isDirectSeries = true;
    }
}
