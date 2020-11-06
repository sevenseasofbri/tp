package seedu.duke.model.exceptions.binarytreeexceptions;

public class BinaryTreeInvalidIndexException extends BinaryTreeException {
    public BinaryTreeInvalidIndexException() {
        super("Position specified is out of bounds!");
    }
}
