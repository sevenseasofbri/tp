package seedu.duke.model.template;

import seedu.duke.DukeException;
import seedu.duke.model.binarytree.BinaryTree;
import seedu.duke.model.gates.Gate;

public class BooleanTemplate {
    private final BinaryTree<Gate> circuit;

    public BooleanTemplate(Gate gate) {
        circuit = new BinaryTree<>(gate);
    }

    public void addGate(Gate gate, int index) throws DukeException {
        circuit.insert(index, gate);
    }

}
