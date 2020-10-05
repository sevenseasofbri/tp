package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class Command {
    /** Boolean whether the command is to exit. **/
    protected boolean isExit;

    /**
     * Executes appropriate methods based on the given command.
     *
     * @param ui Ui object.
     * @param template Template object.
     * @return Template object.
     * @throws DukeException If an execution error occurs.
     */
    public Template execute(Ui ui, Template template) throws DukeException {
        return template;
    }

    /**
     * Returns boolean isExit.
     *
     * @return boolean isExit whether the command is to exit.
     */
    public boolean isExit() {
        return isExit;
    }
}
