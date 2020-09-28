package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.ui.Ui;

public class Command {
    /** boolean whether the command is to exit **/
    protected boolean isExit;

    /**
     * Executes appropriate methods based on the given command.
     *
     * @param ui Ui object.
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
