package seedu.duke.model.binarytree;

import seedu.duke.DukeException;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTree<T> {
    public final ArrayList<T> arrayList = new ArrayList<>(Collections.nCopies(15, null));

    public BinaryTree(T root) {
        arrayList.set(0, root);
    }

    public BinaryTree() {
        this(null);
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
        if (idx < 0 || idx >= arrayList.size() || isNullAtIndex(getParentIndex(idx))) {
            throw new DukeException("Index specified is out of bounds!");
        }
        arrayList.set(idx, t);
    }

    public int getParentIndex(int idx) {
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

    public boolean isNullAtIndex(int idx) {
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

}
