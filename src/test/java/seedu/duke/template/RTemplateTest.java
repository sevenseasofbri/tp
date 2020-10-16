package seedu.duke.template;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RTemplateTest {
    public static final double DELTA = 1e-15;

    @Test
    void calcImpedance_zeroCapacitance_expectException() {
        RcTemplate t = new RcTemplate();
        assertThrows(AssertionError.class, t::calcImpedance);
    }

    @Test
    void calcImpedance_rValueEqualsOne_returnsImpedance() throws DukeException {
        RTemplate t = new RTemplate(5,1);
        assertEquals(5, t.calcImpedance(), DELTA);
    }

    @Test
    void setCapacitor_rValueEqualsFive_returnsResistor() {
        RTemplate t = new RTemplate(1, 1);
        t.setResistor(5);
        assertEquals(5, t.getResistor().getValue(), DELTA);
    }

    @Test
    void setComponent_rValueEqualsFive_getResistorValue() {
        RTemplate t = new RTemplate();
        t.setComponent("r", 5);
        assertEquals(5, t.getResistor().getValue(), DELTA);
    }

    @Test
    void getCurrent_rValueEqualsOne_returnsCurrent() throws DukeException {
        RcTemplate t = new RcTemplate(1,1,1);
        double current = 1 / t.calcImpedance();
        assertEquals(current, t.getCurrent());
    }

    @Test
    void getPower_rValueEqualsOne_returnsPower() throws DukeException {
        RcTemplate t = new RcTemplate(1,1,1);
        double power = 1 * 1 / t.calcImpedance();
        assertEquals(power, t.getPower());
    }
}