package seedu.duke.model.binarytree;

import seedu.duke.model.exceptions.binarytreeexceptions.BinaryTreeInvalidIndexException;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A Binary Tree-like structure (Heap) is used for implementing the Boolean Commands.
 *
 * The BinaryTree class is used to create BinaryTree objects.
 * When an object of the BinaryTree class is created,
 * it initialises the ArrayList instance to 15 null values.
 *
 */
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
     * Returns whether the index is out of bound of the range of the tree.
     *
     * @param idx int type input index
     * @return boolean value true if out of bounds otherwise false.
     */
    private boolean isOutOfBounds(int idx) {
        return idx < 0 || idx >= arrayList.size();
    }

    /**
     * Returns T object at index of tree.
     *
     * @param idx Index in tree.
     * @return T object.
     * @throws BinaryTreeInvalidIndexException If the index specified is invalid.
     */
    public T getT(int idx) throws BinaryTreeInvalidIndexException {
        int parentIndex = getParentIndex(idx);

        boolean hasParent = !isNullAtIndex(parentIndex);
        boolean isRoot = idx == 0;

        // Not the root or has no parent
        boolean isExisting = isRoot || (hasParent);

        // If out of bounds or does not exist currently
        if (isOutOfBounds(idx) || !isExisting) {
            throw new BinaryTreeInvalidIndexException();
        }
        return arrayList.get(idx);
    }

    /**
     * Inserts T type value at specified position in the tree.
     *
     * @param idx int type specifies position to insert element.
     * @param t T type value to be inserted.
     * @throws BinaryTreeInvalidIndexException If the index specified is invalid.
     */
    public void insert(int idx, T t) throws BinaryTreeInvalidIndexException {
        if (isOutOfBounds(idx) || isNullAtIndex(getParentIndex(idx))) {
            throw new BinaryTreeInvalidIndexException();
        }
        arrayList.set(idx, t);
    }

    /**
     * Returns the index of the parent.
     *
     * @param idx Index of child.
     * @return int Index of parent.
     */
    public int getParentIndex(int idx) {
        if (idx % 2 == 0) {
            return idx / 2 - 1;
        } else {
            return idx / 2;
        }
    }

    /**
     * Returns left child index.
     *
     * @param idx Index of parent.
     * @return int Index of left child.
     */
    public int getLeftIndex(int idx) {
        return 2 * idx + 1;
    }

    /**
     * Returns right child index.
     *
     * @param idx Index of parent.
     * @return int Index of right child.
     */
    public int getRightIndex(int idx) {
        return 2 * idx + 2;
    }

    private int getHeight(int idx) {
        return (int) (Math.log(idx + 1) / Math.log(2));
    }

    /**
     * Returns whether an index is null in the tree.
     *
     * @param idx Index in tree.
     * @return boolean whether index is null.
     */
    public boolean isNullAtIndex(int idx) {
        boolean isNull;
        try {
            isNull = arrayList.get(idx) == null;
        } catch (IndexOutOfBoundsException e) {
            isNull = true;
        }
        return isNull;
    }

    private boolean hasLeftChild(int index) {
        return !isNullAtIndex(getLeftIndex(index));
    }

    private boolean hasRightChild(int index) {
        return !isNullAtIndex(getRightIndex(index));
    }

    /**
     * Returns whether node at specified index is a leaf node or not.
     *
     * @param index int type specifying index of node.
     * @return boolean value, true if node is a leaf, else false.
     */
    public boolean isLeaf(int index) {
        boolean hasNoChildren = !hasLeftChild(index) && !hasRightChild(index);
        return !isNullAtIndex(index) && hasNoChildren;
    }

}
