package seedu.duke.logic.parser.exceptions;

public class NotEnoughArgumentsException extends ParserException {
    public NotEnoughArgumentsException(int n) {
        super("Not enough arguments! The command used needs " + n + " arguments.");
    }
}
