package seedu.duke.model.exceptions.templateexceptions;

import seedu.duke.DukeException;

/**
 * The TemplateException class inherits from the DukeException class and
 * is the exception class for handling template-related exceptions.
 */
public abstract class TemplateException extends DukeException {
    public TemplateException(String s) {
        super(s);
    }
}
