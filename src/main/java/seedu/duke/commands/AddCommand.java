package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.component.LoadComponent;
import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class AddCommand extends Command {
    private final String config;
    private final String component;
    private final double value;

    public AddCommand(Template template, String config, String component, double value) {
        super(template);
        this.config = config;
        this.component = component;
        this.value = value;
    }

    /**
     * Executes appropriate methods based on the given command.
     *
     * @param ui Ui object.
     */
    public void execute(Ui ui) throws DukeException {
        LoadComponent c = template.getComponent(component);
        double newValue;

        if (config.equals("series")) {
            newValue = c.addSeries(value);
        } else {
            newValue = c.addParallel(value);
        }

        c.setValue(value);
        ui.printAddComponent(c);

        template.setComponent(component, newValue);
        ui.printTemplate(template);
    }

}
