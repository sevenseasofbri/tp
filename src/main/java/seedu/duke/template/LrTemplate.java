package seedu.duke.template;

import seedu.duke.DukeException;
import seedu.duke.component.Inductor;
import seedu.duke.component.LoadComponent;

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
     * Returns calculated impedance of the LrTemplate circuit.
     *
     * @return double type calculated Impedance.
     */
    @Override
    public double calcImpedance() {
        return Math.sqrt(Math.pow(getResistor().getValue(), 2)
                + Math.pow(inductor.getValue() * angularFrequency, 2));
    }

    /**
     * Returns inductor object, an attribute of the instance of LrTemplate.
     *
     * @return inductor, an instance of the Inductor class.
     */
    protected Inductor getInductor() {
        return inductor;
    }

    /**
     * Sets the value of the inductor in the Lr Template circuit to the value specified.
     *
     * @param value double type value to be set to the inductor in the circuit.
     */
    protected void setInductor(double value) {
        inductor.setValue(value);
    }

    /**
     * Sets the value of the inductor in the Lr Template circuit to the value specified.
     *
     * @param s String corresponding to component type.
     * @param value double type value to be set to the resistor in the circuit.
     */
    @Override
    public void setComponent(String s, double value) {
        if (s.equals("l")) {
            setInductor(value);
        } else {
            super.setComponent(s, value);
        }
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

    /**
     * Returns LoadComponent object depending on input String.
     *
     * @param component String representing the component.
     * @return LoadComponent object.
     * @throws DukeException If input String does not match a component.
     */
    @Override
    public LoadComponent getComponent(String component) throws DukeException {
        if (component.equals("l")) {
            return getInductor();
        }
        return super.getComponent(component);
    }
}
