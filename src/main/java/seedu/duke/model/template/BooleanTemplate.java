package seedu.duke.model.template;

import seedu.duke.DukeException;
import seedu.duke.model.binarytree.BinaryTree;
import seedu.duke.model.gates.Gate;
import seedu.duke.model.gates.TwoInputGate;

public class BooleanTemplate {
    private static String FULL_TREE = "          0UT \n"
            + "           |     \n"
            + "     B           C\n"
            + "                     \n"
            + "  D     E     F     G\n"
            + "                      \n"
            + "H   I J   K L   M N   O";
    private BinaryTree<Gate> circuit;
    private String currentConfig = "";


    public BooleanTemplate(Gate gate) {
        circuit = new BinaryTree<>(gate);
    }

    /**
     * Adds a gate at a specified index.
     *
     * @param gate Gate object.
     * @param index Index in tree.
     * @throws DukeException If index specified is out of bounds.
     */
    public void addGate(Gate gate, int index) throws DukeException {
        circuit.insert(index, gate);
    }

    /**
     * Sets the input of a specified index.
     *
     * @param value Input value.
     * @param index Index in tree.
     */
    public void setInput(int value, int index) {
        int parentIdx = circuit.getParentIndex(index);
        TwoInputGate parentGate = (TwoInputGate) circuit.getT(parentIdx);
        if (index % 2 == 1) {
            parentGate.setInput(value);
        } else {
            parentGate.setSecondInput(value);
        }
    }

    private void buildTopDown() {
        currentConfig = FULL_TREE;
        for (int i = 0; i < circuit.arrayList.size(); i++) {
            if (i != 0 && circuit.isNullAtIndex(circuit.getParentIndex(i))) { // i == 0
                currentConfig = currentConfig.replace((char)(65 + i), ' ');
            }
        }
    }

    /**
     * Returns the string representation of the BooleanTemplate.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        buildTopDown();
        return currentConfig;
    }
}
