package seedu.duke.model.template;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.gates.AndGate;
import seedu.duke.model.gates.OrGate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BooleanTemplateTest {
    @Test
    void addGate_orGate_doesNotThrow() throws DukeException {
        BooleanTemplate template = new BooleanTemplate(new AndGate());
        assertDoesNotThrow(() -> template.addGate(new OrGate(), 1));
    }

    @Test
    void setInput() {
    }
}