package seedu.duke.template;

import seedu.duke.DukeException;
import seedu.duke.component.Capacitor;
import seedu.duke.component.Inductor;
import seedu.duke.component.LoadComponent;

public class LcTemplate extends Template {

    private static final String LC_TEMPLATE = "\t+---L-----C---+\n"
                                                + "\t|             |\n"
                                                + "\t|             |\n"
                                                + "\t+----+V_ac+---+\n";
    private Inductor inductor;
    private Capacitor capacitor;


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
        double inductance = inductor.getValue();
        double capacitance = capacitor.getValue();
        if (inductance == 0 || capacitance == 0) {
            throw new DukeException("Component(s) not set yet.");
        }
        return angularFrequency * Math.abs(inductance - (1 / capacitance));
    }

    /**
     * Returns inductor object, an attribute of the instance of LcTemplate.
     *
     * @return inductor, an instance of the Inductor class.
     */
    protected Inductor getInductor() {
        return inductor;
    }

    /**
     * Returns capacitor object, an attribute of the instance of LcTemplate.
     *
     * @return capacitor, an instance of the Capacitor class.
     */
    protected Capacitor getCapacitor() {
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


    @Override
    public void setComponent(String s, double value) {
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
        return LC_TEMPLATE + "Total Capacitance: " + capacitor + System.lineSeparator()
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



