package seedu.duke.model.template;

import seedu.duke.DukeException;
import seedu.duke.model.component.gates.Gate;

public class BooleanTemplate {
    private BinaryTree<Gate> circuit;

    public BooleanTemplate(Gate gate) {
        circuit = new BinaryTree<>(gate);
    }

    public void addGate(Gate gate, int index) throws DukeException {
        circuit.insert(index, gate);
    }

}
