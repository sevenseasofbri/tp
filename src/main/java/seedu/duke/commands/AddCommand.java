package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.component.LoadComponent;
import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class AddCommand extends SetCommand {
    private final String config;

    public AddCommand(Template template, String config, String component, double value) {
        super(template, component, value);
        this.config = config;
    }

    /**
     * Executes appropriate methods based on the given command.
     *
     * @param ui Ui object.
     */
    @Override
    public void execute(Ui ui) throws DukeException {
        LoadComponent c = template.getComponent(component);
        double newValue = getNewValue();

        c.setValue(value);
        ui.printAddComponent(c);

        template.setComponent(component, newValue);
        ui.printTemplate(template);
    }

    private double getNewValue() throws DukeException {
        LoadComponent c = template.getComponent(component);
        if (config.equals("series")) {
            return c.addSeries(value);
        } else {
            return c.addParallel(value);
        }
    }

}
