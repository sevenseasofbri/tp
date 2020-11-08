package seedu.duke.model.exceptions.componentexceptions;

import seedu.duke.DukeException;

/**
 * The ComponentException class inherits from the DukeException class and
 * is the exception class for handling exceptions concerning the Component class.
 */
public abstract class ComponentException extends DukeException {
    public ComponentException(String s) {
        super(s);
    }
}
