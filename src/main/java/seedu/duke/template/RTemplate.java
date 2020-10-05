package seedu.duke.template;

import seedu.duke.component.Inductor;
import seedu.duke.component.Resistor;
import seedu.duke.component.VoltageSource;

public class RTemplate extends Template {
    private static final String R_TEMPLATE =
              "\t+---R---------+\n"
            + "\t|             |\n"
            + "\t|             |\n"
            + "\t+----+V_ac+---+\n";
    private Resistor resistor;

    public RTemplate(double resistance, double powerSupply) {
        super(powerSupply);
        resistor = new Resistor(resistance);
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
     * Returns String consisting of total inductance and resistance values of the LrTemplate object.
     *
     * @return String representation of LrTemplate object.
     */
    @Override
    public String toString() {
        return R_TEMPLATE + "Total Resistance: " + resistor + System.lineSeparator();
    }

}

