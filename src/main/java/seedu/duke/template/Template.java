package seedu.duke.template;

import seedu.duke.DukeException;
import seedu.duke.component.LoadComponent;
import seedu.duke.component.VoltageSource;

public abstract class Template {
    protected VoltageSource initialPowerSupply;
    protected static final double angularFrequency = 100 * Math.PI;

    public Template(double powerSupply) {
        initialPowerSupply = new VoltageSource(powerSupply);
    }

    /**
     * Returns the initialPowerSupply as specified at the instantiation of Template.
     *
     * @return initialPowerSupply, an instance of VoltageSource.
     */
    public VoltageSource getInitialPowerSupply() {
        return initialPowerSupply;
    }

    protected abstract double calcImpedance();

    public abstract void setComponent(String s, double value);

    /**
     * Returns the current of the circuit.
     *
     * @return double of the current value.
     */
    public double getCurrent() {
        return initialPowerSupply.getValue() / calcImpedance();
    }

    /**
     * Returns the power of the circuit.
     *
     * @return double of the power value.
     */
    public double getPower() {
        double voltage = initialPowerSupply.getValue();
        return voltage * voltage / calcImpedance();
    }

    public abstract LoadComponent getComponent(String component) throws DukeException;
}
