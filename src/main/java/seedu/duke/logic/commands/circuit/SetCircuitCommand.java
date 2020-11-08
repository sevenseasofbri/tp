package seedu.duke.logic.commands.circuit;

import seedu.duke.DukeException;
import seedu.duke.model.component.Capacitor;
import seedu.duke.model.component.Component;
import seedu.duke.model.component.Inductor;
import seedu.duke.model.component.Resistor;
import seedu.duke.model.component.VoltageSource;
import seedu.duke.model.template.CircuitTemplate;

/**
 * The SetCircuitCommand class inherits from the CircuitCommand class
 * and allows the user to set values of the circuit components.
 */
public class SetCircuitCommand extends CircuitCommand {
    public static final String COMMAND_WORD = "set";
    protected final String component;
    protected double value;
    protected Component componentObject;

    public SetCircuitCommand(CircuitTemplate template, String component, double value) {
        super(template);
        this.component = component;
        this.value = value;
    }

    /**
     * Executes set command.
     *
     * @throws DukeException If execution error occurs.
     */
    @Override
    public void execute() throws DukeException {
        if (component.equals("v")) {
            template.setInitialPowerSupply(value);
            componentObject = template.getInitialPowerSupply();
            return;
        }
        componentObject = template.getComponent(component);

        componentObject.setValue(value);
    }

    /**
     * String representation of the Command.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        String componentName = getComponentString(componentObject);

        return "The " + componentName + " was set to " + componentObject + "\n\t" + template;
    }

    /**
     * Returns the componentObject as a String.
     *
     * @return String type representation of the componentObject
     */
    protected String getComponentString(Component componentObject) {
        String componentName = "";
        if (componentObject instanceof VoltageSource) {
            componentName = "voltage source";
        } else if (componentObject instanceof Resistor) {
            componentName = "resistor";
        } else if (componentObject instanceof Capacitor) {
            componentName = "capacitor";
        } else if (componentObject instanceof Inductor) {
            componentName = "inductor";
        }
        return componentName;
    }
}
