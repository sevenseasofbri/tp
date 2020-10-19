package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.component.Capacitor;
import seedu.duke.component.Component;
import seedu.duke.component.Inductor;
import seedu.duke.component.Resistor;
import seedu.duke.component.VoltageSource;
import seedu.duke.template.Template;

public class SetCommand extends Command {
    protected final String component;
    protected final double value;
    protected Component componentObject;

    public SetCommand(Template template, String component, double value) {
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

        template.setComponent(component, value);
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
