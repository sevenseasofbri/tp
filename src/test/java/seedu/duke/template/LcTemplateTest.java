package seedu.duke.template;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LcTemplateTest {

    @Test
    void calcImpedance_zeroCapacitance_expectException() {
        LcTemplate t = new LcTemplate();
        assertThrows(DukeException.class, t::calcImpedance);
    }
}