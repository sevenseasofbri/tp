package seedu.duke.model.component;

public class VoltageSource extends Component {
    private static final String SI_UNIT = "V";

    public VoltageSource(double value) {
        super(value);
        siUnit = SI_UNIT;
    }
}
