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

    /**
     * Returns the impedance of LC circuit.
     *
     * @return Impedance of LC circuit
     */
    @Override
    public double calcImpedance() {
        return angularFrequency * Math.abs(inductor.getValue() - (1 / capacitor.getValue()));
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
            return inductor;
        } else if (component.equals("c")) {
            return capacitor;
        } else {
            throw new DukeException("Invalid component");
        }
    }
}



