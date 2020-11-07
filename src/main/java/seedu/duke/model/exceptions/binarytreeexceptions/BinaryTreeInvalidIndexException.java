package seedu.duke.model.exceptions.binarytreeexceptions;

/**
 * The BinaryTreeInvalidIndexException class inherits from the BinaryTreeException class and
 * is thrown when the index entered is out of bounds.
 */
public class BinaryTreeInvalidIndexException extends BinaryTreeException {
    public BinaryTreeInvalidIndexException() {
        super("Position specified is out of bounds!");
    }
}
