package seedu.duke.logic.commands.circuit;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.exceptions.ComponentNotSetException;
import seedu.duke.model.component.Capacitor;
import seedu.duke.model.component.Inductor;
import seedu.duke.model.component.LoadComponent;
import seedu.duke.model.component.Resistor;
import seedu.duke.model.template.CircuitTemplate;

/**
 * The AddCircuitCommand class inherits from the SetCircuitCommand class
 * and is used to add components to the current circuit.
 */
public class AddCircuitCommand extends SetCircuitCommand {
    public static final String COMMAND_WORD = "add";
    private final String config;
    private LoadComponent loadComponent;
    private LoadComponent oldLoadComponent;
    private double oldValue;

    public AddCircuitCommand(CircuitTemplate template, String config, String component, double value) {
        super(template, component, value);
        this.config = config;
    }

    /**
     * Executes appropriate methods based on the given command.
     *
     */
    @Override
    public void execute() throws DukeException {
        loadComponent = template.getComponent(component);
        if (loadComponent.getValue() == 0) {
            throw new ComponentNotSetException();
        }
        oldValue = value;
        oldLoadComponent = createCopyComponent();
        value = getNewValue();
        super.execute();
    }

    private LoadComponent createCopyComponent() {
        if (loadComponent instanceof Resistor) {
            return new Resistor(oldValue);
        } else if (loadComponent instanceof Inductor) {
            return new Inductor(oldValue);
        } else {
            return new Capacitor(oldValue);
        }
    }

    private double getNewValue() throws DukeException {
        assert config.equals("series") || config.equals("parallel");
        if (config.equals("series")) {
            return loadComponent.addSeries(value);
        } else {
            return loadComponent.addParallel(value);
        }
    }

    /**
     * String representation of the Command.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return "Nice, added a " + oldLoadComponent + "\n\t" + template;
    }
}
