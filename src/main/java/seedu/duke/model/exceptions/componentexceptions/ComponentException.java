package seedu.duke.model.exceptions.componentexceptions;

import seedu.duke.DukeException;

public abstract class ComponentException extends DukeException {
    public ComponentException(String s) {
        super(s);
    }
}
