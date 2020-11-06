package seedu.duke.logic.commands.exceptions;

import seedu.duke.DukeException;

public abstract class CommandException extends DukeException {
    public CommandException(String s) {
        super(s);
    }
}
