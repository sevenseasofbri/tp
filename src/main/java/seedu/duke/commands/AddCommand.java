package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.component.Capacitor;
import seedu.duke.component.Inductor;
import seedu.duke.component.LoadComponent;
import seedu.duke.component.Resistor;
import seedu.duke.ui.Ui;

public class AddCommand extends Command {
    private final String config;
    private final String component;
    private final double value;

    public AddCommand(String config, String component, double value) {
        this.config = config;
        this.component = component;
        this.value = value;
    }

    /**
     * Executes appropriate methods based on the given command.
     *
     * @param ui Ui object.
     */
    @Override
    public void execute(Ui ui) throws DukeException {
        // Placeholder, to be replaced with Template.getComponent
        LoadComponent c = getComponent(component);
        if (config.equals("series")) {
            System.out.println(c.addSeries(value));
        } else {
            System.out.println(c.addParallel(value));
        }
    }

    // Placeholder, getComponent would come from Template class instead
    private LoadComponent getComponent(String component) throws DukeException {
        switch (component) {
        case "r":
            return new Resistor(1);
        case "c":
            return new Capacitor(1);
        case "l":
            return new Inductor(1);
        default:
            throw new DukeException("Invalid component");
        }
    }
}
