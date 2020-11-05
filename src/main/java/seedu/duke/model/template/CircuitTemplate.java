package seedu.duke.model.template;

import seedu.duke.model.component.LoadComponent;
import seedu.duke.model.component.VoltageSource;
import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;
import seedu.duke.model.exceptions.templateexceptions.InvalidComponentException;
import seedu.duke.model.exceptions.templateexceptions.TemplateComponentsNotSetException;

public abstract class CircuitTemplate {
    protected VoltageSource initialPowerSupply;
    protected static final double ANGULAR_FREQUENCY = 100 * Math.PI;
    protected static final String NOT_SET = "not set";

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

    protected boolean isSetPowerSupply() {
        return initialPowerSupply.getValue() != 0;
    }

    /**
     * Sets value of the voltage source.
     *
     * @param value double value to be set to the component.
     */
    public void setInitialPowerSupply(double value) throws ZeroComponentException {
        initialPowerSupply.setValue(value);
    }

    protected abstract double calcImpedance() throws TemplateComponentsNotSetException;

    public abstract void setComponent(String s, double value) throws ZeroComponentException;

    /**
     * Returns the current of the circuit.
     *
     * @return double of the current value.
     */
    public double getCurrent() throws TemplateComponentsNotSetException {
        return initialPowerSupply.getValue() / calcImpedance();
    }

    /**
     * Returns the power of the circuit.
     *
     * @return double of the power value.
     */
    public double getPower() throws TemplateComponentsNotSetException {
        double voltage = initialPowerSupply.getValue();
        return voltage * voltage / calcImpedance();
    }

    public abstract LoadComponent getComponent(String component) throws InvalidComponentException;

    protected String voltageToString() {
        return "\tCurrent Voltage: " + (isSetPowerSupply() ? initialPowerSupply : NOT_SET) + System.lineSeparator();
    }

}
