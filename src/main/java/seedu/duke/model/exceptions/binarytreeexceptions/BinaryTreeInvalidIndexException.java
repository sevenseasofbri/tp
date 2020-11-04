package seedu.duke.model.exceptions.binarytreeexceptions;

public class BinaryTreeInvalidIndexException extends BinaryTreeException {
    public BinaryTreeInvalidIndexException() {
        super("Index specified is out of bounds!");
    }
}
