package seedu.duke.model.template;

import seedu.duke.model.component.LoadComponent;
import seedu.duke.model.component.Resistor;
import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;
import seedu.duke.model.exceptions.templateexceptions.InvalidComponentException;
import seedu.duke.model.exceptions.templateexceptions.TemplateComponentsNotSetException;

/**
 * The RTemplate class inherits from the CircuitTemplate class
 * and is used to create RTemplate objects.
 */
public class RTemplate extends CircuitTemplate {
    private static final String R_TEMPLATE =
              "+---R---------+\n"
            + "\t|             |\n"
            + "\t|             |\n"
            + "\t+----+V_ac+---+\n";
    protected Resistor resistor;

    public RTemplate(double resistance, double powerSupply) {
        super(powerSupply);
        resistor = new Resistor(resistance);
    }

    public RTemplate() {
        this(0,0);
    }

    /**
     * Returns impedance of Resistor.
     *
     * @return impedance of Resistor.
     * @throws TemplateComponentsNotSetException If component values are not yet set.
     */
    @Override
    public double calcImpedance() throws TemplateComponentsNotSetException {
        if (resistor.getValue() == 0) {
            throw new TemplateComponentsNotSetException();
        }
        return resistor.getValue();
    }

    /**
     * Returns resistor object, an attribute of the instance of LrTemplate.
     *
     * @return resistor, an instance of the Resistor class.
     */
    public Resistor getResistor() {
        return resistor;
    }

    /**
     * Sets the value of the resistor in the circuit to the value specified.
     *
     * @param value double type value to be set to the resistor in the circuit.
     */
    protected void setResistor(double value) throws ZeroComponentException {
        resistor.setValue(value);
    }

    protected boolean isSetResistor() {
        return resistor.getValue() != 0;
    }

    /**
     * Sets the value of the resistor in the circuit to the value specified.
     *
     * @param s String corresponding to component type.
     * @param value double type value to be set to the resistor in the circuit.
     */
    @Override
    public void setComponent(String s, double value) throws ZeroComponentException {
        setResistor(value);
    }

    protected String resistorToString() {
        return "\tTotal Resistance: " + (isSetResistor() ? resistor : NOT_SET) + System.lineSeparator();
    }

    /**
     * Returns String consisting of total inductance and resistance values of the LrTemplate object.
     *
     * @return String representation of LrTemplate object.
     */
    @Override
    public String toString() {
        return R_TEMPLATE + voltageToString() + resistorToString();
    }


    /**
     * Returns LoadComponent object depending on input String.
     *
     * @param component String representing the component.
     * @return LoadComponent object.
     * @throws InvalidComponentException If input String does not match a component.
     */
    @Override
    public LoadComponent getComponent(String component) throws InvalidComponentException {
        if (!component.equals("r")) {
            throw new InvalidComponentException(component);
        }
        return getResistor();
    }
}

