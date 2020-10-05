package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class ExitCommand extends Command {
    public ExitCommand() {
        isExit = true;
    }

    /**
     * Executes the exit command message.
     *
     * @param ui Ui object.
     * @param template Template object.
     * @return Template object.
     */
    @Override
    public Template execute(Ui ui, Template template) throws DukeException {
        ui.printFarewell();
        return super.execute(ui, template);
    }
}
