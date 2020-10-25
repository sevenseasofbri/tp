package seedu.duke.model.template;

import seedu.duke.DukeException;
import seedu.duke.model.binarytree.BinaryTree;
import seedu.duke.model.gates.Gate;

public class BooleanTemplate {
    private static final String FULL_TREE = "          0UT \n"
            + "           |     \n"
            + "     B           C\n"
            + "                     \n"
            + "  D     E     F     G\n"
            + "                      \n"
            + "H   I J   K L   M N   O";
    private static final int ASCII_A = 65;
    /** BinaryTree object to represent the logic circuit. **/
    private final BinaryTree<Gate> circuit;
    /** String representation of the template. **/
    private String currentConfig = "";

    public BooleanTemplate(Gate gate) throws DukeException {
        circuit = new BinaryTree<>(gate);
        buildTopDown();
    }

    /**
     * Adds a gate at a specified index.
     *
     * @param gate Gate object.
     * @param index Index in tree.
     * @throws DukeException If index specified is out of bounds.
     */
    public void addGate(Gate gate, int index) throws DukeException {
        if(index > 6) {
            throw new DukeException("Cannot add gates to channels H, I, J, K, L, M, N, O! Try setting them instead.");
        }
        circuit.insert(index, gate);
        buildTopDown();
    }

    /**
     * Sets the input of a specified index.
     *
     * @param value Input value.
     * @param index Index in tree.
     * @throws DukeException If index specified is out of bounds.
     */
    public void setInput(int value, int index) throws DukeException {
        int parentIdx = circuit.getParentIndex(index);
        Gate parentGate = circuit.getT(parentIdx);

        //Prevent accessing null gate.
        if (parentGate == null) {
            throw new DukeException("Parent gate not set yet!");
        }

        if (index % 2 == 1) {
            parentGate.setInput(value);
        } else {
            parentGate.setSecondInput(value);
        }
        buildTopDown();
    }

    private boolean isInputOutput(int index) {
        return !circuit.isNullAtIndex(circuit.getParentIndex(index));
    }

    private boolean isOutput(int index) {
        return isInputOutput(index) && !circuit.isNullAtIndex(index);
    }

    private boolean isInput(int index) {
        return isInputOutput(index) && circuit.isNullAtIndex(index);
    }

    /**
     * Builds currentConfig, the String representation of the template.
     *
     * @throws DukeException If index error occurs.
     */
    private void buildTopDown() throws DukeException {
        currentConfig = FULL_TREE;
        int treeSize = circuit.arrayList.size();

        // Clear empty indices first
        for (int i = 1; i < treeSize; i++) {
            if (!isInputOutput(i)) { // i == 0
                currentConfig = currentConfig.replace((char) (ASCII_A + i), ' ');
            }
        }

        // Get all equations
        StringBuilder equations = new StringBuilder();
        equations.append(System.lineSeparator()).append(System.lineSeparator());
        equations.append("OUT = B ").append(circuit.getRoot()).append(" C").append(System.lineSeparator());
        for (int i = 1; i < treeSize; i++) {
            if (isOutput(i)) {
                equations.append(getGateEquation(i)).append(System.lineSeparator());
            } else if (isInput(i)) {
                equations.append(getInputEquation(i)).append(System.lineSeparator());
            }
        }
        currentConfig = currentConfig.stripTrailing() + equations;
    }

    /**
     * Returns the String representation of a gate equation.
     *
     * @param index Index of gate chosen.
     * @return String equation of gate.
     * @throws DukeException If index error occurs.
     */
    private String getGateEquation(int index) throws DukeException {
        Gate gate = circuit.getT(index);

        char letter = (char) (index + ASCII_A);

        String leftLetter = String.valueOf((char) (circuit.getLeftIndex(index) + ASCII_A));
        String rightLetter = String.valueOf((char) (circuit.getRightIndex(index) + ASCII_A));
        return letter + " = " + leftLetter + " " + gate + " " + rightLetter;
    }

    /**
     * Returns the String representation of an input.
     *
     * @param index Index of input chosen.
     * @return String equation of input.
     * @throws DukeException If index error occurs.
     */
    private String getInputEquation(int index) throws DukeException {
        int parentIndex = circuit.getParentIndex(index);

        Gate gate = circuit.getT(parentIndex);

        char letter = (char) (index + ASCII_A);
        String equation = letter + " = ";

        // Odd index - first input, even index, 2nd input
        if (index % 2 == 1) {
            equation += gate.isSetInput() ? gate.getInput() : "?";
        } else {
            equation += gate.isSetSecondInput() ? gate.getSecondInput() : "?";
        }

        return equation;
    }

    public int calculateOutput(int idx) throws DukeException {
        if (circuit.isNullAtIndex(idx)) {
            throw new DukeException("Oops! Nothing set yet.");
        }

        boolean isNullAtRight = circuit.isNullAtIndex(circuit.getRightIndex(idx));
        boolean isNullAtLeft = circuit.isNullAtIndex(circuit.getLeftIndex(idx));

        if (!isNullAtLeft) {
            circuit.getT(idx).setInput(calculateOutput(circuit.getLeftIndex(idx)));
        }
        if (!isNullAtRight) {
            circuit.getT(idx).setSecondInput(calculateOutput(circuit.getRightIndex(idx)));
        }

        return circuit.getT(idx).getOutput();
    }

    /**
     * Returns the string representation of the BooleanTemplate.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return currentConfig;
    }
}
