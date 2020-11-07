package seedu.duke.model.component;

/**
 * The VoltageSource class inherits from the Component class
 * and is used to create VoltageSource objects.
 */
public class VoltageSource extends Component {
    private static final String SI_UNIT = "V";

    public VoltageSource(double value) {
        super(value);
        siUnit = SI_UNIT;
    }
}
