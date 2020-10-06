package seedu.duke.template;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RcTemplateTest {

    @Test
    void calcImpedance_zeroCapacitance_expectException() {
        RcTemplate t = new RcTemplate();
        assertThrows(DukeException.class, t::calcImpedance);
    }
}