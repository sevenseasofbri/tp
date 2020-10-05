package seedu.duke.template;

import seedu.duke.component.Capacitor;
import seedu.duke.component.Resistor;


public class RcTemplate extends Template {
    private static final String RC_TEMPLATE = "\t+---R-----C---+\n"
            + "\t|             |\n"
            + "\t|             |\n"
            + "\t+----+V_ac+---+\n";

    private Resistor resistor;
    private Capacitor capacitor;

    public RcTemplate(double resistance, double capacitance, double powerSupply) {
        super(powerSupply);
        capacitor = new Capacitor(capacitance);
        resistor = new Resistor(resistance);
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
     * Returns impedance value of circuit.
     *
     * @return Z, a double representation of the impedance value of circuit.
     */
    public double getImpedance() {
        double z = Math.sqrt(Math.pow(resistor.getValue(), 2)
                + (1 / Math.pow((angularFrequency * capacitor.getValue()), 2)));
        return z;
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

}
