package seedu.duke.logic.parser.exceptions;

public class InvalidCommandException extends ParserException {
    public InvalidCommandException() {
        super("Invalid Command! Use the command 'summary' to take a look at all the available commands.");
    }
}
