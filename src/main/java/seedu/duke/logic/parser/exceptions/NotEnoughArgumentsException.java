package seedu.duke.logic.parser.exceptions;

/**
 * The NotEnoughArgumentsException class inherits from the ParserException class
 * and is thrown if the number of arguments entered is insufficient to parse.
 */
public class NotEnoughArgumentsException extends ParserException {
    public NotEnoughArgumentsException(int n) {
        super("Not enough arguments! The command used needs " + n + " arguments.");
    }
}
