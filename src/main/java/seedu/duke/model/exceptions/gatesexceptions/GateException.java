package seedu.duke.model.exceptions.gatesexceptions;

import seedu.duke.DukeException;

public abstract class GateException extends DukeException {
    public GateException(String s) {
        super(s);
    }
}
