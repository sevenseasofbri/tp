package seedu.duke.model.template;

import seedu.duke.DukeException;
import seedu.duke.model.component.Inductor;
import seedu.duke.model.component.LoadComponent;

public class LrTemplate extends RTemplate {
    private static final String RL_TEMPLATE = "\t+---R-----L---+\n"
                                            + "\t|             |\n"
                                            + "\t|             |\n"
                                            + "\t+----+V_ac+---+\n";

    private final Inductor inductor;

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
     * @throws DukeException If component values are not yet set.
     */
    @Override
    public double calcImpedance() throws DukeException {
        double resistance = super.calcImpedance();
        double inductance = inductor.getValue() * Math.pow(10, -6);
        if (inductance == 0) {
            throw new DukeException("Component(s) not set yet.");
        }
        return Math.sqrt(Math.pow(resistance, 2)
                + Math.pow(inductance * ANGULAR_FREQUENCY, 2));
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
        assert s.equals("l") || s.equals("r");
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
        return RL_TEMPLATE
                + "Current Voltage: " + initialPowerSupply + System.lineSeparator()
                + "Total Resistance: " + getResistor() + System.lineSeparator()
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
