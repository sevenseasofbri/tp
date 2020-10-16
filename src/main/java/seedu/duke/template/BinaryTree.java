package seedu.duke.template;

import java.util.ArrayList;

public class BinaryTree<T> {
    private final ArrayList<T> arrayList = new ArrayList<>();

    public BinaryTree(T root) {
        arrayList.add(root);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public T getRoot() {
        return arrayList.get(0);
    }

    public void insert(int idx, T t) {
        if (idx <= 0 || idx >= arrayList.size() || arrayList.get(getParentIndex(idx)) == null) {
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
}
