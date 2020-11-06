package seedu.duke.model.exceptions.binarytreeexceptions;

import seedu.duke.DukeException;

public abstract class BinaryTreeException extends DukeException {
    public BinaryTreeException(String s) {
        super(s);
    }
}
