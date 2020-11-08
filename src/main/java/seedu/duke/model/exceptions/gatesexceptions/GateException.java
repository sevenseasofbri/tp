package seedu.duke.model.exceptions.gatesexceptions;

import seedu.duke.DukeException;

/**
 * The GateException class inherits from the DukeException class and
 * is the exception class for handling gate-related exceptions.
 */
public abstract class GateException extends DukeException {
    public GateException(String s) {
        super(s);
    }
}
