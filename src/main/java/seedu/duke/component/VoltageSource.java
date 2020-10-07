package seedu.duke.component;

public class VoltageSource extends Component {
    private static final String SI_UNIT = "V";

    public VoltageSource(double value) {
        super(value);
        siUnit = SI_UNIT;
    }

    /**
     * Sets the value of the voltage source.
     *
     * @param value Value of Component.
     */
    @Override
    public void setValue(double value) {
        super.setValue(value);
    }
}