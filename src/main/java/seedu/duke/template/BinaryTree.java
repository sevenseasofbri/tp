package seedu.duke.template;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTree<T> {
    private final ArrayList<T> arrayList = new ArrayList<>(Collections.nCopies(16, null));
    private String TREE = "";

    public BinaryTree(T root) {
        arrayList.set(0, root);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public T getRoot() {
        return arrayList.get(0);
    }

    public void insert(int idx, T t) {
        if (idx <= 0 || idx >= arrayList.size() || isNullAtIndex(getParentIndex(idx))) {
            return;
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
            isNull = arrayList.get(idx) == null ? true : false;
        } catch (IndexOutOfBoundsException e) {
            isNull = true;
        }
        return isNull;
    }

    private void printTree(int index, int space) {
        if(isNullAtIndex(index)){
            return;
        }
        //Process the right subtree, if it exists.
        if (!isNullAtIndex(getRightIndex(index))) {
            printTree(getRightIndex(index), space + 4);
        }

        for(int i = 0; i < space; i++) {
            TREE = TREE + " ";
        }
        TREE = TREE + arrayList.get(index) + System.lineSeparator();

        //Process the the left subtree , if it exists.
        if (!isNullAtIndex(getLeftIndex(index))) {
            printTree(getLeftIndex(index), space + 4);
        }
    }

    @Override
    public String toString() {
        printTree(0, 0);
        return TREE;
    }
}
