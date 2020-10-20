package seedu.duke.model.template;

import seedu.duke.DukeException;
import seedu.duke.model.component.LoadComponent;
import seedu.duke.model.component.VoltageSource;

public abstract class CircuitTemplate {
    protected VoltageSource initialPowerSupply;
    protected static final double ANGULAR_FREQUENCY = 100 * Math.PI;

    public CircuitTemplate(double powerSupply) {
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

    /**
     * Sets value of the voltage source.
     *
     * @param value double value to be set to the component.
     */
    public void setInitialPowerSupply(double value) {
        initialPowerSupply.setValue(value);
    }

    protected abstract double calcImpedance() throws DukeException;

    public abstract void setComponent(String s, double value);

    /**
     * Returns the current of the circuit.
     *
     * @return double of the current value.
     */
    public double getCurrent() throws DukeException {
        return initialPowerSupply.getValue() / calcImpedance();
    }

    /**
     * Returns the power of the circuit.
     *
     * @return double of the power value.
     */
    public double getPower() throws DukeException {
        double voltage = initialPowerSupply.getValue();
        return voltage * voltage / calcImpedance();
    }

    public abstract LoadComponent getComponent(String component) throws DukeException;
}
