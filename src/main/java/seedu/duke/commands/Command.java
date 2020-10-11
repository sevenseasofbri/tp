package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class Command {
    /** Boolean whether the command is to exit. **/
    protected boolean isExit;
    protected Template template;

    public Command(Template template) {
        this.template = template;
    }

    public Command() {
        this(null);
    }

    /**
     * Executes appropriate methods based on the given command.
     *
     * @param ui Ui object.
     * @throws DukeException If an execution error occurs.
     */
    public void execute(Ui ui) throws DukeException {
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
