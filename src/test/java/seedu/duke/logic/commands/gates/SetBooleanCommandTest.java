package seedu.duke.logic.commands.gates;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.gates.Gate;
import seedu.duke.model.gates.NandGate;
import seedu.duke.model.gates.NorGate;
import seedu.duke.model.gates.XnorGate;
import seedu.duke.model.template.BooleanTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SetBooleanCommandTest {

    @Test
    void execute_setValidZero_noException() throws DukeException {
        Gate gate = new NorGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, false, 1);
        assertDoesNotThrow(cmd::execute);
        assertFalse(gate.getInput());
        assertFalse(gate.isSetSecondInput());
    }

    @Test
    void execute_setValidOne_noException() throws DukeException {
        Gate gate = new NandGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, true, 2);
        assertDoesNotThrow(cmd::execute);
        assertTrue(gate.getSecondInput());
        assertFalse(gate.isSetInput());
    }

    @Test
    void execute_setZeroIndex_expectException() throws DukeException {
        Gate gate = new NandGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, true, 0);
        assertThrows(DukeException.class, cmd::execute);
    }

    @Test
    void execute_setNegativeIndex_expectException() throws DukeException {
        Gate gate = new NandGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, true, -5);
        assertThrows(DukeException.class, cmd::execute);
    }

    @Test
    void execute_setNonExistentIndex_expectException() throws DukeException {
        Gate gate = new XnorGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, true, 7);
        assertThrows(DukeException.class, cmd::execute);
    }

    @Test
    void execute_setNullIndex_expectException() throws DukeException {
        Gate gate = new XnorGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, true, 4);
        assertThrows(DukeException.class, cmd::execute);
    }

    @Test
    void execute_setLowestLeaf_expectException() throws DukeException {
        Gate gate = new XnorGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        template.addGate(new NandGate(), 2);
        Gate norGate = new NorGate();
        template.addGate(norGate, 6);
        SetBooleanCommand cmd = new SetBooleanCommand(template, true, 14);
        assertDoesNotThrow(cmd::execute);
        assertTrue(norGate.getSecondInput());
    }
}