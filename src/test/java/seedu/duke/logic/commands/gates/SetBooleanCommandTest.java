package seedu.duke.logic.commands.gates;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.gates.Gate;
import seedu.duke.model.gates.NandGate;
import seedu.duke.model.gates.NorGate;
import seedu.duke.model.gates.XnorGate;
import seedu.duke.model.template.BooleanTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SetBooleanCommandTest {

    @Test
    void execute_setValidZero_noException() throws DukeException {
        Gate gate = new NorGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, 0, 1);
        assertDoesNotThrow(cmd::execute);
        assertEquals(0, gate.getInput());
        assertEquals(-1, gate.getSecondInput());
    }

    @Test
    void execute_setValidOne_noException() throws DukeException {
        Gate gate = new NandGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, 1, 2);
        assertDoesNotThrow(cmd::execute);
        assertEquals(1, gate.getSecondInput());
        assertEquals(-1, gate.getInput());
    }

    @Test
    void execute_setZeroIndex_expectException() throws DukeException {
        Gate gate = new NandGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, 1, 0);
        assertThrows(DukeException.class, cmd::execute);
    }

    @Test
    void execute_setNegativeIndex_expectException() throws DukeException {
        Gate gate = new NandGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, 1, -5);
        assertThrows(DukeException.class, cmd::execute);
    }

    @Test
    void execute_setNonExistentIndex_expectException() throws DukeException {
        Gate gate = new XnorGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, 1, 7);
        assertThrows(DukeException.class, cmd::execute);
    }

    @Test
    void execute_setNullIndex_expectException() throws DukeException {
        Gate gate = new XnorGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        SetBooleanCommand cmd = new SetBooleanCommand(template, 1, 4);
        assertThrows(DukeException.class, cmd::execute);
    }

    @Test
    void execute_setLowestLeaf_expectException() throws DukeException {
        Gate gate = new XnorGate();
        BooleanTemplate template = new BooleanTemplate(gate);
        template.addGate(new NandGate(), 2);
        Gate norGate = new NorGate();
        template.addGate(norGate, 6);
        SetBooleanCommand cmd = new SetBooleanCommand(template, 1, 14);
        assertDoesNotThrow(cmd::execute);
        assertEquals(1, norGate.getSecondInput());
    }
}