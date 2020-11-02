package seedu.duke.model.gates;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GateTest {

    @Test
    void getOutput_nandGateOneZero_One() throws DukeException {
        NandGate gate = new NandGate();
        assertFalse(gate.isSetInput());
        assertFalse(gate.isSetSecondInput());
        gate.setInput(true);
        gate.setSecondInput(false);
        assertTrue(gate.getOutput());
    }

    @Test
    void getOutput_norGateOneZero_One() throws DukeException {
        NorGate gate = new NorGate();
        assertFalse(gate.isSetInput());
        assertFalse(gate.isSetSecondInput());
        gate.setInput(true);
        gate.setSecondInput(false);
        assertFalse(gate.getOutput());
    }

    @Test
    void getOutput_xnorGateOneZero_One() throws DukeException {
        XnorGate gate = new XnorGate();
        assertFalse(gate.isSetInput());
        assertFalse(gate.isSetSecondInput());
        gate.setInput(true);
        gate.setSecondInput(false);
        assertFalse(gate.getOutput());
        gate.setInput(false);
        assertTrue(gate.getOutput());
    }
}