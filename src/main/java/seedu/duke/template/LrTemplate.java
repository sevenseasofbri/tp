package seedu.duke.template;

import seedu.duke.component.Inductor;
import seedu.duke.component.Resistor;

public class LrTemplate extends RTemplate {
    private static final String RL_TEMPLATE = "\t+---R-----L---+\n"
                                            + "\t|             |\n"
                                            + "\t|             |\n"
                                            + "\t+----+V_ac+---+\n";

    private Inductor inductor;

    public LrTemplate(double resistance, double inductance, double powerSupply) {
        super(resistance, powerSupply);
        inductor = new Inductor(inductance);
    }

    public LrTemplate() {
        this(0,0,0);
    }

    /**
     * Returns inductor object, an attribute of the instance of LrTemplate.
     *
     * @return inductor, an instance of the Inductor class.
     */
    public Inductor getInductor() {
        return inductor;
    }

    /**
     * Returns calculated impedance of the LrTemplate circuit.
     *
     * @return double type calculated Impedance.
     */
    public double getImpedance() {
        double z = Math.sqrt(Math.pow(getResistor().getValue(), 2)
                    + Math.pow(inductor.getValue() * angularFrequency, 2));
        return z;
    }

    /**
     * Sets the value of the inductor in the Lr Template circuit to the value specified.
     *
     * @param value double type value to be set to the inductor in the circuit.
     */
    public void setInductor(double value) {
        inductor.setValue(value);
    }

    /**
     * Returns String consisting of total inductance and resistance values of the LrTemplate object.
     *
     * @return String representation of LrTemplate object.
     */
    @Override
    public String toString() {
        return RL_TEMPLATE + "Total Resistance: " + getResistor() + System.lineSeparator()
                           + "Total Inductance: " + inductor + System.lineSeparator();
    }
}
