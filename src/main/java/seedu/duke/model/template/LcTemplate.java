package seedu.duke.model.template;

import seedu.duke.DukeException;
import seedu.duke.model.component.Capacitor;
import seedu.duke.model.component.Inductor;
import seedu.duke.model.component.LoadComponent;

public class LcTemplate extends CircuitTemplate {

    private static final String LC_TEMPLATE = "\t+---L-----C---+\n"
                                                + "\t|             |\n"
                                                + "\t|             |\n"
                                                + "\t+----+V_ac+---+\n";
    private final Inductor inductor;
    private final Capacitor capacitor;


    public LcTemplate(double capacitance, double inductance, double powerSupply) {
        super(powerSupply);
        inductor = new Inductor(inductance);
        capacitor = new Capacitor(capacitance);
    }

    public LcTemplate() {
        this(0,0,0);
    }

    /**
     * Returns the impedance of LC circuit.
     *
     * @return Impedance of LC circuit
     * @throws DukeException If component values are not yet set.
     */
    @Override
    public double calcImpedance() throws DukeException {
        double inductance = inductor.getValue() * Math.pow(10, -6);
        double capacitance = capacitor.getValue() * Math.pow(10, -6);
        if (inductance == 0 || capacitance == 0) {
            throw new DukeException("Component(s) not set yet.");
        }
        return ANGULAR_FREQUENCY * Math.abs(inductance - (1 / capacitance));
    }

    /**
     * Returns inductor object, an attribute of the instance of LcTemplate.
     *
     * @return inductor, an instance of the Inductor class.
     */
    public Inductor getInductor() {
        return inductor;
    }

    /**
     * Returns capacitor object, an attribute of the instance of LcTemplate.
     *
     * @return capacitor, an instance of the Capacitor class.
     */
    public Capacitor getCapacitor() {
        return capacitor;
    }

    /**
     * Sets the value of the inductor in the Lc Template circuit to the value specified.
     *
     * @param value double type value to be set to the inductor in the circuit.
     */
    protected void setInductor(double value) {
        inductor.setValue(value);
    }

    /**
     * Sets the value of the capacitor in the Lc Template circuit to the value specified.
     *
     * @param value double type value to be set to the capacitor in the circuit.
     */
    protected void setCapacitor(double value) {
        capacitor.setValue(value);
    }

    /**
     * Sets the value of the inductor in the Lc Template circuit to the value specified.
     *
     * @param s String corresponding to component type.
     * @param value double type value to be set to the resistor in the circuit.
     */
    @Override
    public void setComponent(String s, double value) {
        assert s.equals("l") || s.equals("c");
        if (s.equals("l")) {
            setInductor(value);
        } else {
            setCapacitor(value);
        }
    }

    /**
     * Returns String consisting of total inductance and capacitance values of the LcTemplate object.
     *
     * @return String representation of LcTemplate object.
     */
    @Override
    public String toString() {
        return LC_TEMPLATE
                + "Current Voltage: " + initialPowerSupply + System.lineSeparator()
                + "Total Capacitance: " + capacitor + System.lineSeparator()
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
        } else if (component.equals("c")) {
            return getCapacitor();
        } else {
            throw new DukeException("Invalid component");
        }
    }
}



