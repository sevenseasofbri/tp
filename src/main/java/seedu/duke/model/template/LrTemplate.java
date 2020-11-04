package seedu.duke.model.template;

import seedu.duke.model.component.Inductor;
import seedu.duke.model.component.LoadComponent;
import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;
import seedu.duke.model.exceptions.templateexceptions.InvalidComponentException;
import seedu.duke.model.exceptions.templateexceptions.TemplateComponentsNotSetException;

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
     * @throws TemplateComponentsNotSetException If component values are not yet set.
     */
    @Override
    public double calcImpedance() throws TemplateComponentsNotSetException {
        double resistance = super.calcImpedance();
        double inductance = inductor.getValue() * Math.pow(10, -6);
        if (inductance == 0) {
            throw new TemplateComponentsNotSetException();
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
    protected void setInductor(double value) throws ZeroComponentException {
        inductor.setValue(value);
    }

    /**
     * Sets the value of the inductor in the Lr Template circuit to the value specified.
     *
     * @param s String corresponding to component type.
     * @param value double type value to be set to the resistor in the circuit.
     */
    @Override
    public void setComponent(String s, double value) throws ZeroComponentException {
        assert s.equals("l") || s.equals("r");
        if (s.equals("l")) {
            setInductor(value);
        } else {
            super.setComponent(s, value);
        }
    }

    protected boolean isSetInductor() {
        return inductor.getValue() != 0;
    }

    protected String inductorToString() {
        return "Total Inductance: " + (isSetInductor() ? inductor : NOT_SET) + System.lineSeparator();
    }


    /**
     * Returns String consisting of total inductance and resistance values of the LrTemplate object.
     *
     * @return String representation of LrTemplate object.
     */
    @Override
    public String toString() {
        return RL_TEMPLATE + voltageToString() + resistorToString() + inductorToString();
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
        if (component.equals("l")) {
            return getInductor();
        }
        return super.getComponent(component);
    }
}
