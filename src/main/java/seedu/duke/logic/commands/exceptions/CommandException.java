package seedu.duke.logic.commands.exceptions;

import seedu.duke.DukeException;

/**
 * The CommandException class inherits from the DukeException class and
 * is the exception class for handling exceptions concerning the Command class.
 */
public abstract class CommandException extends DukeException {
    public CommandException(String s) {
        super(s);
    }
}
