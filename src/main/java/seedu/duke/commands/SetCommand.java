package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.component.LoadComponent;
import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class SetCommand extends Command {
    protected final String component;
    protected final double value;

    public SetCommand(Template template, String component, double value) {
        super(template);
        this.component = component;
        this.value = value;
    }

    /**
     * Executes set command.
     *
     * @param ui Ui object.
     * @throws DukeException If execution error occurs.
     */
    @Override
    public void execute(Ui ui) throws DukeException {
        LoadComponent c = template.getComponent(component);

        c.setValue(value);
        ui.printSetComponent(c);

        template.setComponent(component, value);
        ui.printTemplate(template);
    }

}
