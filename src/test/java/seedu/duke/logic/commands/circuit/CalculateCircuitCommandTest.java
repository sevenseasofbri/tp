package seedu.duke.logic.commands.circuit;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.template.LcTemplate;
import seedu.duke.model.template.LrTemplate;
import seedu.duke.model.template.RTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateCircuitCommandTest {
    private static final RTemplate RTEMPLATE = new RTemplate(100, 100);
    private static final LrTemplate LR_TEMPLATE = new LrTemplate(0, 0, 10);
    private static final LcTemplate LC_TEMPLATE = new LcTemplate(1600, 299, 220);
    private static final String POWER = "power";
    private static final String INDUCTANCE = "leff";
    private static final String CAPACITANCE = "ceff";
    private static final String CURRENT = "current";

    @Test
    void execute_calcPower_calculatesPower() throws DukeException {
        CalculateCircuitCommand c = new CalculateCircuitCommand(RTEMPLATE, POWER);
        c.execute();
        assertEquals(100, c.template.getPower());
    }

    @Test
    void execute_calcCeff_calculatesEffectiveCapacitance() {
        CalculateCircuitCommand c = new CalculateCircuitCommand(LC_TEMPLATE, CAPACITANCE);
        assertDoesNotThrow(c::execute);
    }

    @Test
    void execute_calcCurrentWithZeroValueComponents_expectException() {
        CalculateCircuitCommand c = new CalculateCircuitCommand(LR_TEMPLATE, CURRENT);
        assertThrows(AssertionError.class, c::execute);
    }

    @Test
    void execute_invalidComponentForTemplate_expectException() {
        CalculateCircuitCommand c = new CalculateCircuitCommand(RTEMPLATE, INDUCTANCE);
        assertThrows(DukeException.class, c::execute);
    }
}
