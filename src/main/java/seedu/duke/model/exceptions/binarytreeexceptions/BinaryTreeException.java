package seedu.duke.model.exceptions.binarytreeexceptions;

import seedu.duke.DukeException;

/**
 * The BinaryTreeException class inherits from the DukeException class and
 * is the exception class for handling exceptions concerning the BinaryTree class.
 */
public abstract class BinaryTreeException extends DukeException {
    public BinaryTreeException(String s) {
        super(s);
    }
}
