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
        assertThrows(DukeException.class, t::calcImpedance);
    }

    @Test
    void calcImpedance_rValueEqualsOne_returnsImpedance() throws DukeException {
        RTemplate t = new RTemplate(5,1);
        assertEquals(5, t.calcImpedance(), DELTA);
    }

    @Test
    void getCapacitor_rValueEqualsFive_returnsResistor() {
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
    void getComponent_rValueEqualsFive_getResistorValue() throws DukeException {
        RTemplate t = new RTemplate();
        t.setComponent("r", 5);
        assertEquals(5, t.getResistor().getValue(), DELTA);
    }

    @Test
    void getComponent_rValueEqualsOne_expectException() {
        RTemplate t = new RTemplate();
        assertThrows(DukeException.class, () -> t.getComponent(""));
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

    /**
     * Edge cases for the tests.
     */

    @Test
    void calcImpedance_rValueNegative_returnsImpedance() throws DukeException {
        RTemplate t = new RTemplate(-5,1);
        assertEquals(-5, t.calcImpedance(), DELTA);
    }

    @Test
    void getCapacitor_rValueNegative_returnsResistor() {
        RTemplate t = new RTemplate(1, 1);
        t.setResistor(-5);
        assertEquals(-5, t.getResistor().getValue(), DELTA);
    }

    @Test
    void setComponent_rValueNegative_getResistorValue() {
        RTemplate t = new RTemplate();
        t.setComponent("r", -5);
        assertEquals(-5, t.getResistor().getValue(), DELTA);
    }

    @Test
    void getComponent_rValueNegative_getResistorValue() throws DukeException {
        RTemplate t = new RTemplate();
        t.setComponent("r", -5);
        assertEquals(-5, t.getResistor().getValue(), DELTA);
    }

    @Test
    void getCurrent_rValueNegative_returnsCurrent() throws DukeException {
        RcTemplate t = new RcTemplate(-1,1,1);
        double current = 1 / t.calcImpedance();
        assertEquals(current, t.getCurrent());
    }

    @Test
    void getPower_rValueNegative_returnsPower() throws DukeException {
        RcTemplate t = new RcTemplate(-1,1,1);
        double power = 1 * 1 / t.calcImpedance();
        assertEquals(power, t.getPower());
    }

}