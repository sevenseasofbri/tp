package seedu.duke.model.gates;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.exceptions.gatesexceptions.GateException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GateTest {

    @Test
    void getOutput_nandGateOneZero_One() throws GateException {
        NandGate gate = new NandGate();
        assertFalse(gate.isSetInput());
        assertFalse(gate.isSetSecondInput());
        gate.setInput(true);
        gate.setSecondInput(false);
        assertTrue(gate.getOutput());
    }

    @Test
    void getOutput_norGateOneZero_One() throws GateException {
        NorGate gate = new NorGate();
        assertFalse(gate.isSetInput());
        assertFalse(gate.isSetSecondInput());
        gate.setInput(true);
        gate.setSecondInput(false);
        assertFalse(gate.getOutput());
    }

    @Test
    void getOutput_xnorGateOneZero_One() throws GateException {
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