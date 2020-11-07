package seedu.duke.logic.commands;

import seedu.duke.DukeException;

import java.util.logging.Logger;

/**
 *  The Command class is used to create Command objects.
 */
public abstract class Command {
    protected static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    /** Boolean whether the command is to exit. **/
    protected boolean isExit;

    /**
     * Executes appropriate methods based on the given command.
     */
    public abstract void execute() throws DukeException;


    /**
     * Returns boolean isExit.
     *
     * @return boolean isExit whether the command is to exit.
     */
    public boolean isExit() {
        return isExit;
    }
}
