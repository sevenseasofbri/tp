package seedu.duke.logic.parser.exceptions;

import seedu.duke.DukeException;

/**
 * The CommandException class is the exception class for exceptions involving the Parser class.
 */
public abstract class ParserException extends DukeException {
    public ParserException(String s) {
        super(s);
    }
}
