package seedu.duke.logic.commands.exceptions;

/**
 * The IncorrectCommandException class inherits from CommandException
 * and is thrown if the command entered is invalid.
 */
public class IncorrectCommandException extends CommandException {
    public IncorrectCommandException() {
        super("Bad Command! Please follow the instructions carefully.\n"
                + "\tTo exit Tutorial Mode, simply type 'exit' and press Enter.");
    }
}
