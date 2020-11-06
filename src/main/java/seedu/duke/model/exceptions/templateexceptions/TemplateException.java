package seedu.duke.model.exceptions.templateexceptions;

import seedu.duke.DukeException;

public abstract class TemplateException extends DukeException {
    public TemplateException(String s) {
        super(s);
    }
}
