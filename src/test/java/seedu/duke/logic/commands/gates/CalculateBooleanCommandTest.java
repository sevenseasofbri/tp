package seedu.duke.logic.commands.gates;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.gates.AndGate;
import seedu.duke.model.gates.OrGate;
import seedu.duke.model.gates.XorGate;
import seedu.duke.model.template.BooleanTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateBooleanCommandTest {

    @Test
    void execute_emptyTree_throwsException() throws DukeException {
        BooleanTemplate b = new BooleanTemplate(new OrGate());
        CalculateBooleanCommand c = new CalculateBooleanCommand(b);
        assertThrows(DukeException.class, c::execute);
    }

    @Test
     void execute_notEmpty_doesNotThrowException() throws DukeException {
        BooleanTemplate b = new BooleanTemplate(new OrGate());
        b.addGate(new AndGate(), 1);
        b.setInput(true, 2);
        b.addGate(new XorGate(), 4);
        b.setInput(true, 3);
        b.setInput(false, 9);
        b.setInput(true, 10);
        CalculateBooleanCommand c = new CalculateBooleanCommand(b);
        assertDoesNotThrow(c::execute);
    }

    @Test
     void execute_notEmptyWithInputNotSet_throwsException() throws DukeException {
        BooleanTemplate b = new BooleanTemplate(new OrGate());
        b.addGate(new AndGate(), 1);
        b.addGate(new XorGate(), 4);
        b.setInput(true, 3);
        b.setInput(false, 9);
        b.setInput(true, 10);
        CalculateBooleanCommand c = new CalculateBooleanCommand(b);
        assertThrows(DukeException.class, c::execute);
    }

}
