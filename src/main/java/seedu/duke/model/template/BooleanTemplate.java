package seedu.duke.model.template;

import seedu.duke.DukeException;
import seedu.duke.model.binarytree.BinaryTree;
import seedu.duke.model.gates.Gate;

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

    public void addGate(Gate gate, int index) throws DukeException {
        circuit.insert(index, gate);
    }

    private void buildTopDown() {
        currentConfig = FULL_TREE;
        for (int i = 0; i < circuit.arrayList.size(); i++) {
            if (i != 0 && circuit.isNullAtIndex(circuit.getParentIndex(i))) { // i == 0
                currentConfig = currentConfig.replace((char)(65 + i), ' ');
            }
        }
    }

    @Override
    public String toString() {
        buildTopDown();
        return currentConfig;
    }
}
