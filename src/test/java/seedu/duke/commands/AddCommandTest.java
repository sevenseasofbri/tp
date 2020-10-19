package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.template.RcTemplate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCommandTest {
    private static final RcTemplate TEMPLATE = new RcTemplate(500, 500, 5);
    private static final String CONFIG = "series";
    private static final String COMPONENT = "r";
    private static final double VALUE = 500;

    @Test
    void execute_addResistor_setsResistor() throws DukeException {
        AddCommand c = new AddCommand(TEMPLATE, CONFIG, COMPONENT, VALUE);
        c.execute();
        assertEquals(1000, c.template.getComponent("r").getValue());
    }

    @Test
    void execute_wrongComponent_expectException() {
        AddCommand c = new AddCommand(TEMPLATE, CONFIG, "l", VALUE);
        assertThrows(DukeException.class, c::execute);
    }
}