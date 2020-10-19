package seedu.duke.template;

import seedu.duke.DukeException;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTree<T> {
    private final ArrayList<T> arrayList = new ArrayList<>(Collections.nCopies(16, null));
    private static final int SPACES_OF_FOUR = 4;
    private String tree = "";

    public BinaryTree(T root) {
        arrayList.set(0, root);
    }

    /**
     * Checks if the tree is empty.
     *
     * @return boolean value, true if the tree is empty, otherwise false.
     */
    public boolean isEmpty() {
        return isNullAtIndex(0);
    }

    /**
     * Returns the root of the tree.
     *
     * @return T type value, root of the tree.
     */
    public T getRoot() {
        return arrayList.get(0);
    }

    /**
     * Inserts T type value at specified position in the tree.
     *
     * @param idx int type specifies position to insert element.
     * @param t T type value to be inserted.
     * @throws DukeException If the index specified is invalid.
     */
    public void insert(int idx, T t) throws DukeException {
        if (idx <= 0 || idx >= arrayList.size() || isNullAtIndex(getParentIndex(idx))) {
            throw new DukeException("Index specified is out of bounds!");
        }
        arrayList.set(idx, t);
    }

    private int getParentIndex(int idx) {
        if (idx % 2 == 0) {
            return idx / 2 - 1;
        } else {
            return idx / 2;
        }
    }

    private int getLeftIndex(int idx) {
        return 2 * idx + 1;
    }

    private int getRightIndex(int idx) {
        return 2 * idx + 2;
    }

    private int getHeight(int idx) {
        return (int) (Math.log(idx + 1) / Math.log(2));
    }

    private boolean isNullAtIndex(int idx) {
        boolean isNull;
        try {
            isNull = arrayList.get(idx) == null;
        } catch (IndexOutOfBoundsException e) {
            isNull = true;
        }
        return isNull;
    }

    /**
     * Returns whether node at specified index is a leaf node or not.
     *
     * @param index int type specifying index of node.
     * @return boolean value, true if node is a leaf, else false.
     */
    public boolean isLeaf(int index) {
        boolean hasNoChildren = isNullAtIndex(getLeftIndex(index)) && isNullAtIndex(getRightIndex(index));
        return !isNullAtIndex(index) && hasNoChildren;
    }

    /**
     * Manipulates the instance variable String tree to produce a tree-like structure String output.
     * Example of manipulated tree String with Integer type values stored in arrayList = {1,2,3,4,5,6,7}:
     *         7
     *     3
     *         6
     * 1
     *         5
     *     2
     *         4
     *
     * @param index int type specifying which node to process.
     * @param space int type determining number of spaces to make tree-like output.
     */
    private void buildTreeString(int index, int space) {
        if (isNullAtIndex(index)) {
            return;
        }
        //Process the right subtree, if it exists.
        if (!isNullAtIndex(getRightIndex(index))) {
            buildTreeString(getRightIndex(index), space + SPACES_OF_FOUR);
        }

        for (int i = 0; i < space; i++) {
            tree = tree + " ";
        }
        tree = tree + arrayList.get(index) + System.lineSeparator();

        //Process the the left subtree , if it exists.
        if (!isNullAtIndex(getLeftIndex(index))) {
            buildTreeString(getLeftIndex(index), space + SPACES_OF_FOUR);
        }
    }

    /**
     * Returns a String after formatting with the function buildTreeString().
     *
     * @return String type instance variable tree.
     */
    @Override
    public String toString() {
        buildTreeString(0, 0);
        return tree;
    }
}
