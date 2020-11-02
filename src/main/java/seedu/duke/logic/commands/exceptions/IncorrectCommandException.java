package seedu.duke.logic.commands.exceptions;

public class IncorrectCommandException extends CommandException {
    public IncorrectCommandException() {
        super("Bad Command! Please follow the instructions carefully.\n"
                + "To exit Tutorial Mode, simply type 'exit' and press Enter.");
    }
}
