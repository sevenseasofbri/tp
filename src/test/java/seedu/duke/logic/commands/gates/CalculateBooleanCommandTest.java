package seedu.duke.logic.commands.gates;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.gates.AndGate;
import seedu.duke.model.gates.OrGate;
import seedu.duke.model.gates.XorGate;
import seedu.duke.model.template.BooleanTemplate;
import seedu.duke.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

 public class CalculateBooleanCommandTest {
    private static final Ui ui = new Ui();

    @Test
    void execute_emptyTree_throwsException() {
        BooleanTemplate b = null;
        try  {
            b = new BooleanTemplate(new OrGate());
        } catch (DukeException e) {
            ui.showError("Error occurred while rendering object.");
        }
        CalculateBooleanCommand c = new CalculateBooleanCommand(b);
        assertThrows(DukeException.class, () -> c.execute());
    }

    @Test
     void execute_notEmpty_doesNotThrowException() {
        BooleanTemplate b = null;
        try  {
            b = new BooleanTemplate(new OrGate());
            b.addGate(new AndGate(), 1);
            b.setInput(1, 2);
            b.addGate(new XorGate(), 4);
            b.setInput(1, 3);
            b.setInput(0, 9);
            b.setInput(1, 10);
        } catch (DukeException e) {
            ui.showError("Error occurred while rendering object.");
        }
        CalculateBooleanCommand c = new CalculateBooleanCommand(b);
        assertDoesNotThrow(() -> c.execute());
    }

    @Test
     void execute_notEmptyWithInputNotSet_throwsException() {
        BooleanTemplate b = null;
        try  {
            b = new BooleanTemplate(new OrGate());
            b.addGate(new AndGate(), 1);
            b.addGate(new XorGate(), 4);
            b.setInput(1, 3);
            b.setInput(0, 9);
            b.setInput(1, 10);
        } catch (DukeException e) {
            ui.showError("Error occurred while rendering object.");
        }
        CalculateBooleanCommand c = new CalculateBooleanCommand(b);
        assertThrows(DukeException.class, () -> c.execute());
    }

}
