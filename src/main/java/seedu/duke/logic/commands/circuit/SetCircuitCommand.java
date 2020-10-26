package seedu.duke.logic.commands.circuit;

import seedu.duke.DukeException;
import seedu.duke.model.component.Capacitor;
import seedu.duke.model.component.Component;
import seedu.duke.model.component.Inductor;
import seedu.duke.model.component.Resistor;
import seedu.duke.model.component.VoltageSource;
import seedu.duke.model.template.CircuitTemplate;

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
        if (componentObject instanceof VoltageSource) {
            return "The voltage source was changed to: " + componentObject;
        }

        String componentName = "";

        if (componentObject instanceof Resistor) {
            componentName = "resistor";
        } else if (componentObject instanceof Capacitor) {
            componentName = "capacitor";
        } else if (componentObject instanceof Inductor) {
            componentName = "inductor";
        }

        return "The " + componentName + " was set to " + componentObject + '\n' + template;
    }
}
