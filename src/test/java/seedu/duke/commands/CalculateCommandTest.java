package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.template.LcTemplate;
import seedu.duke.template.LrTemplate;
import seedu.duke.template.RTemplate;
import seedu.duke.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateCommandTest {
    private static final Ui UI = new Ui();
    private static final RTemplate RTEMPLATE = new RTemplate(100, 100);
    private static final LrTemplate LR_TEMPLATE = new LrTemplate(0, 0, 10);
    private static final LcTemplate LC_TEMPLATE = new LcTemplate(1600, 299, 220);
    private static final String POWER = "power";
    private static final String INDUCTANCE = "leff";
    private static final String CAPACITANCE = "ceff";
    private static final String CURRENT = "current";

    @Test
    void execute_calcPower_calculatesPower() throws DukeException {
        CalculateCommand c = new CalculateCommand(RTEMPLATE, POWER);
        c.execute(UI);
        assertEquals(100, c.template.getPower());
    }

    @Test
    void execute_calcCeff_calculatesEffectiveCapacitance() throws DukeException {
        CalculateCommand c = new CalculateCommand(LC_TEMPLATE, CAPACITANCE);
        LcTemplate lc = (LcTemplate) c.template;
        c.execute(UI);
        assertEquals(1600, lc.getCapacitor().getValue());
    }

    @Test
    void execute_calcCurrentWithZeroValueComponents_expectException() {
        CalculateCommand c = new CalculateCommand(LR_TEMPLATE, CURRENT);
        assertThrows(DukeException.class, () -> c.execute(UI));
    }

    @Test
    void execute_invalidComponentForTemplate_expectException() {
        CalculateCommand c = new CalculateCommand(RTEMPLATE, INDUCTANCE);
        assertThrows(DukeException.class, () -> c.execute(UI));
    }
}
