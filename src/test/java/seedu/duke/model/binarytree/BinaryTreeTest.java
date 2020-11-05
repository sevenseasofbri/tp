package seedu.duke.model.binarytree;

import org.junit.jupiter.api.Test;
import seedu.duke.model.exceptions.binarytreeexceptions.BinaryTreeInvalidIndexException;
import seedu.duke.model.gates.AndGate;
import seedu.duke.model.gates.Gate;
import seedu.duke.model.gates.OrGate;
import seedu.duke.model.gates.XorGate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BinaryTreeTest {

    @Test
    void isEmpty_emptyTree_returnsTrue() {
        BinaryTree<Gate> tree = new BinaryTree();
        assertTrue(tree.isEmpty());
    }

    @Test
    void isEmpty_nonEmptyTree_returnsFalse() {
        BinaryTree<Gate> tree = new BinaryTree(new OrGate());
        assertFalse(tree.isEmpty());
    }


    @Test
    void getRoot_emptyTree_returnsNull() {
        BinaryTree<Gate> tree = new BinaryTree();
        assertNull(tree.getRoot());
    }

    @Test
    void getRoot_nonEmptyTree_returnsRoot() {
        AndGate gate = new AndGate();
        BinaryTree<Gate> tree = new BinaryTree(gate);
        assertEquals(gate, tree.getRoot());
    }

    @Test
    void getT_emptyTree_throwException() {
        BinaryTree<Gate> tree = new BinaryTree();
        assertThrows(BinaryTreeInvalidIndexException.class, () -> tree.getT(1));
    }

    @Test

    void getT_nonEmptyTree_returnsValueAtIndex() {
        BinaryTree<Gate> tree = new BinaryTree(new OrGate());
        assertDoesNotThrow(() -> tree.getT(0));
    }

    @Test
    void insert_valueAtIndex_updatesValueAtIndex() {
        BinaryTree<Gate> tree = new BinaryTree(new OrGate());
        AndGate gate = new AndGate();
        assertDoesNotThrow(() -> tree.insert(2, gate));
    }

    @Test
    void insert_valueAtInvalidIndex_throwsException() {
        BinaryTree<Gate> tree = new BinaryTree<>(new OrGate());
        AndGate gate = new AndGate();
        assertThrows(BinaryTreeInvalidIndexException.class, () -> tree.insert(4, gate));
    }

    @Test
    void getParentIndex_childIndex_returnsIndexOfParent() {
        BinaryTree<Gate> tree = new BinaryTree(new OrGate());
        assertEquals(1,tree.getParentIndex(3));
    }

    @Test
    void getLeftIndex_parentIndex_returnsIndexOfLeftChild() {
        BinaryTree<Gate> tree = new BinaryTree(new OrGate());
        assertEquals(3, tree.getLeftIndex(1));
    }

    @Test
    void getRightIndex_parentIndex_returnsIndexOfRightChild() {
        BinaryTree<Gate> tree = new BinaryTree(new OrGate());
        assertEquals(4, tree.getRightIndex(1));
    }

    @Test
    void isNullAtIndex_Index_returnsTrue() {
        BinaryTree<Gate> tree = new BinaryTree();
        assertTrue(tree.isNullAtIndex(0));
    }

    @Test
    void isNullAtIndex_Index_returnsFalse() {
        BinaryTree<Gate> tree = new BinaryTree(new OrGate());
        assertFalse(tree.isNullAtIndex(0));
    }

    @Test
    void isLeaf_Index_returnsTrue() {
        BinaryTree<Gate> tree = new BinaryTree(new OrGate());
        assertTrue(tree.isLeaf(0));
    }

    @Test
    void isLeaf_Index_returnsFalse() {
        BinaryTree<Gate> tree = new BinaryTree(new OrGate());
        assertDoesNotThrow(() -> tree.insert(1, new AndGate()));
        assertFalse(tree.isLeaf(0));
    }

}
