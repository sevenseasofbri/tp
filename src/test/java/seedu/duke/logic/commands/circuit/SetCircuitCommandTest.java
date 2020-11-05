package seedu.duke.logic.commands.circuit;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;
import seedu.duke.model.template.RcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SetCircuitCommandTest {

    @Test
    void execute_voltageSource_setComponent() throws DukeException {
        RcTemplate t = new RcTemplate(100, 100, 100);
        SetCircuitCommand c = new SetCircuitCommand(t, "v", 200);
        c.execute();
        assertEquals(c.component, "v");
        assertEquals(c.componentObject.getValue(), 200);
    }

    @Test
    void execute_BadCommand_expectException() {
        RcTemplate t = new RcTemplate(100, 100, 100);
        SetCircuitCommand c = new SetCircuitCommand(t, "v", -100);
        assertThrows(ZeroComponentException.class, c::execute);
    }


}