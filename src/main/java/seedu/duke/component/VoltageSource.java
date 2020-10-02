package seedu.duke.component;

public class VoltageSource extends Component  {
    private static final String SI_UNIT = "V";

    public VoltageSource(double value) {
        super(value);
    }
    /**
     * Returns String constituting value and unit of voltage source of circuit.
     *
     * @return String representation of VoltageSource object.
     */

    @Override
    public String toString() {
        return (value) + SI_UNIT;
    }
}
