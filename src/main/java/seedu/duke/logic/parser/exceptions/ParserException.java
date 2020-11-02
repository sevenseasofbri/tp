package seedu.duke.logic.parser.exceptions;

import seedu.duke.DukeException;

public abstract class ParserException extends DukeException {
    public ParserException(String s) {
        super(s);
    }


}
