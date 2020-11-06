package seedu.duke.model.template;

import seedu.duke.DukeException;
import seedu.duke.model.binarytree.BinaryTree;
import seedu.duke.model.exceptions.binarytreeexceptions.BinaryTreeInvalidIndexException;
import seedu.duke.model.exceptions.gatesexceptions.InputsNotSetException;
import seedu.duke.model.exceptions.templateexceptions.GateSetException;
import seedu.duke.model.exceptions.templateexceptions.GatesToChannelsException;
import seedu.duke.model.exceptions.templateexceptions.InputNotSetException;
import seedu.duke.model.exceptions.templateexceptions.ParentGateNotSetException;
import seedu.duke.model.exceptions.templateexceptions.TemplateException;
import seedu.duke.model.gates.Gate;

public class BooleanTemplate {
    private static final String FULL_TREE = "          0UT \n"
            + "\t           |     \n"
            + "\t     B           C\n"
            + "\t                     \n"
            + "\t  D     E     F     G\n"
            + "\t                      \n"
            + "\tH   I J   K L   M N   O";
    private static final int ASCII_A = 65;
    /** BinaryTree object to represent the logic circuit. **/
    private final BinaryTree<Gate> circuit;
    /** String representation of the template. **/
    private String currentConfig = "";

    public BooleanTemplate(Gate gate) throws BinaryTreeInvalidIndexException {
        circuit = new BinaryTree<>(gate);
        buildTopDown();
    }

    /**
     * Adds a gate at a specified index.
     *
     * @param gate Gate object.
     * @param index Index in tree.
     * @throws TemplateException If index specified cannot be assigned to a Gate.
     * @throws BinaryTreeInvalidIndexException If index specified is out of bounds.
     */
    public void addGate(Gate gate, int index) throws TemplateException, BinaryTreeInvalidIndexException {
        if (index > 6) {
            throw new GatesToChannelsException();
        }
        circuit.insert(index, gate);
        buildTopDown();
    }

    /**
     * Sets the input of a specified index.
     *
     * @param value Input value.
     * @param index Index in tree.
     * @throws TemplateException If index specified does not have a parent or tries to overwrite a gate.
     * @throws BinaryTreeInvalidIndexException If index error occurs.
     */
    public void setInput(boolean value, int index) throws TemplateException, BinaryTreeInvalidIndexException {
        int parentIdx = circuit.getParentIndex(index);
        Gate parentGate = circuit.getT(parentIdx);

        //Prevent accessing null gate.
        if (parentGate == null) {
            throw new ParentGateNotSetException();
        }

        // Prevent setting already set gate
        Gate currentGate = circuit.getT(index);
        if (currentGate != null) {
            throw new GateSetException();
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
     * @throws BinaryTreeInvalidIndexException If index error occurs.
     */
    private void buildTopDown() throws BinaryTreeInvalidIndexException {
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
        // Add 2 newlines
        equations.append(System.lineSeparator()).append(System.lineSeparator());
        // Add the first line "OUT = B <Gate> C"
        equations.append("\tOUT = B ").append(circuit.getRoot()).append(" C")
                .append(System.lineSeparator()).append('\t');

        for (int i = 1; i < treeSize; i++) {
            if (!isInputOutput(i)) {
                continue;
            }
            String currentEquation = "";
            if (isOutput(i)) {
                currentEquation = getGateEquation(i);
            } else if (isInput(i)) {
                currentEquation = getInputEquation(i);
            }
            // Add subsequent lines' equations
            equations.append(currentEquation).append(System.lineSeparator()).append('\t');
        }
        currentConfig = currentConfig.stripTrailing() + equations;
    }

    /**
     * Returns the String representation of a gate equation.
     *
     * @param index Index of gate chosen.
     * @return String equation of gate.
     * @throws BinaryTreeInvalidIndexException If index error occurs.
     */
    private String getGateEquation(int index) throws BinaryTreeInvalidIndexException {
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
     * @throws BinaryTreeInvalidIndexException If index error occurs.
     */
    private String getInputEquation(int index) throws BinaryTreeInvalidIndexException {
        int parentIndex = circuit.getParentIndex(index);

        Gate gate = circuit.getT(parentIndex);

        char letter = (char) (index + ASCII_A);
        String equation = letter + " = ";

        // Odd index - first input, even index, 2nd input
        if (index % 2 == 1) {
            String input = gate.getInput() ? "1" : "0";
            equation += gate.isSetInput() ? input : "?";
        } else {
            String input = gate.getSecondInput() ? "1" : "0";
            equation += gate.isSetSecondInput() ? input : "?";
        }

        return equation;
    }

    /**
     * Calculates and returns the total output of the circuit.
     *
     * @return int type value output, can be 0 or 1.
     * @throws DukeException If input values are not set.
     */
    public boolean calculateOutput() throws DukeException {
        return calculateOutput(0);
    }

    /**
     * Recursive function which calculates the output value of the circuit at position passed.
     *
     * @param idx int type index of node.
     * @return int type value output, can be 0 or 1.
     * @throws InputsNotSetException If input values are not set for the gates.
     * @throws BinaryTreeInvalidIndexException If index error occurs
     * @throws InputsNotSetException If the gates/their inputs are not set.
     */
    private boolean calculateOutput(int idx) throws TemplateException, BinaryTreeInvalidIndexException,
            InputsNotSetException {
        if (circuit.isNullAtIndex(idx)) {
            throw new InputNotSetException();
        }

        boolean isNullAtRight = circuit.isNullAtIndex(circuit.getRightIndex(idx));
        boolean isNullAtLeft = circuit.isNullAtIndex(circuit.getLeftIndex(idx));
        Gate gate = circuit.getT(idx);

        if (!isNullAtLeft) {
            gate.setInput(calculateOutput(circuit.getLeftIndex(idx)));
        }
        if (!isNullAtRight) {
            gate.setSecondInput(calculateOutput(circuit.getRightIndex(idx)));
        }

        return gate.getOutput();
    }

    /**
     * Returns the binary tree circuit.
     *
     * @return circuit
     */
    public BinaryTree<Gate> getCircuit() {
        return circuit;
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
