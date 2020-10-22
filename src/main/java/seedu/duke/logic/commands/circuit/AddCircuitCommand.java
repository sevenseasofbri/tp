package seedu.duke.logic.commands.circuit;

import seedu.duke.DukeException;
import seedu.duke.model.component.LoadComponent;
import seedu.duke.model.template.CircuitTemplate;

public class AddCircuitCommand extends SetCircuitCommand {
    public static final String COMMAND_WORD = "add";
    private final String config;
    private LoadComponent loadComponent;

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
        value = getNewValue();
        super.execute();
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
        return "Nice, added a " + loadComponent + '\n' + template;
    }
}
