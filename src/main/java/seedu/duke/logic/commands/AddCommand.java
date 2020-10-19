package seedu.duke.logic.commands;

import seedu.duke.DukeException;
import seedu.duke.model.component.LoadComponent;
import seedu.duke.model.template.Template;

public class AddCommand extends SetCommand {
    private final String config;
    private LoadComponent loadComponent;

    public AddCommand(Template template, String config, String component, double value) {
        super(template, component, value);
        this.config = config;
    }

    /**
     * Executes appropriate methods based on the given command.
     *
     */
    @Override
    public void execute() throws DukeException {
        LoadComponent c = template.getComponent(component);
        double newValue = getNewValue();

        c.setValue(value);
        loadComponent = c;

        template.setComponent(component, newValue);
    }

    private double getNewValue() throws DukeException {
        LoadComponent c = template.getComponent(component);
        assert config.equals("series") || config.equals("parallel");
        if (config.equals("series")) {
            return c.addSeries(value);
        } else {
            return c.addParallel(value);
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
