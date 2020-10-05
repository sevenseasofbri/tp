package seedu.duke.template;

import seedu.duke.DukeException;
import seedu.duke.component.Capacitor;
import seedu.duke.component.LoadComponent;
import seedu.duke.component.Resistor;


public class RcTemplate extends RTemplate {
    private static final String RC_TEMPLATE = "\t+---R-----C---+\n"
            + "\t|             |\n"
            + "\t|             |\n"
            + "\t+----+V_ac+---+\n";

    private Capacitor capacitor;

    public RcTemplate(double resistance, double capacitance, double powerSupply) {
        super(resistance, powerSupply);
        capacitor = new Capacitor(capacitance);
    }

    /**
     * Returns impedance value of circuit.
     *
     * @return impedance, a double representation of the impedance value of circuit.
     */
    @Override
    public double calcImpedance() {
        return Math.sqrt(Math.pow(resistor.getValue(), 2)
                + (1 / Math.pow((angularFrequency * capacitor.getValue()), 2)));
    }

    /**
     * Returns capacitor object, an attribute of the instance of RcTemplate.
     *
     * @return capacitor, an instance of the Capacitor class.
     */
    public Capacitor getCapacitor() {
        return capacitor;
    }

    /**
     * Returns resistor object, an attribute of the instance of LrTemplate.
     *
     * @return resistor, an instance of the Resistor class.
     */
    public Resistor getResistor() {
        return resistor;
    }

    /**
     * Returns String consisting of total capacitance and resistance values of the RcTemplate object.
     *
     * @return String representation of RcTemplate object.
     */
    @Override
    public String toString() {
        return RC_TEMPLATE + "Total Resistance: " + resistor + System.lineSeparator()
                + "Total Capacitance: " + capacitor + System.lineSeparator();
    }

    /**
     * Returns LoadComponent object depending on input String.
     *
     * @param component String representing the component.
     * @return LoadComponent object.
     * @throws DukeException If input String does not match a component.
     */
    @Override
    public LoadComponent getComponent(String component) throws DukeException {
        if (component.equals("c")) {
            return capacitor;
        }
        return super.getComponent(component);
    }
}
