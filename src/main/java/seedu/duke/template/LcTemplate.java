package seedu.duke.template;

import seedu.duke.component.Capacitor;
import seedu.duke.component.Inductor;

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
     * Returns the impedance of LC circuit.
     *
     * @return Impedance of LC circuit
     */
    public double getImpedance() {
        double z = angularFrequency * Math.abs(inductor.getValue() - (1 / capacitor.getValue()));
        return z;
    }

    /**
     * Sets the value of the inductor in the Lc Template circuit to the value specified.
     *
     * @param value double type value to be set to the inductor in the circuit.
     */
    public void setInductor(double value) {
        inductor.setValue(value);
    }

    /**
     * Sets the value of the capacitor in the Lc Template circuit to the value specified.
     *
     * @param value double type value to be set to the capacitor in the circuit.
     */
    public void setCapacitor(double value) {
        capacitor.setValue(value);
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

}



