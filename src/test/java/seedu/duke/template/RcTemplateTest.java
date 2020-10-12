package seedu.duke.template;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.component.Capacitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RcTemplateTest {
    public static final double DELTA = 1e-15;

    @Test
    void calcImpedance_zeroCapacitance_expectException() {
        RcTemplate t = new RcTemplate();
        assertThrows(DukeException.class, t::calcImpedance);
    }

    @Test
    void calcImpedance_rCValuesEqualsOne_returnsImpedance() throws DukeException {
        RcTemplate t = new RcTemplate(1,1,1);
        double impedance = Math.sqrt(Math.pow(1, 2)
                + (1 / Math.pow((t.ANGULAR_FREQUENCY * 1 * Math.pow(10, -6)), 2)));
        assertEquals(impedance, t.calcImpedance(), DELTA);
    }

    @Test
    void getCapacitor_rCValuesEqualsOne_returnsCapacitorObject() {
        RcTemplate t = new RcTemplate(1, 1, 1);
        t.setCapacitor(5);
        assertEquals(5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setCapacitor_rCValuesEqualsOne_setsCapacitorObject() {
        RcTemplate t = new RcTemplate(1, 1, 1);
        assertEquals(1, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setComponent_rCValuesEqualsOne_setCapacitorValue() {
        RcTemplate t = new RcTemplate();
        t.setComponent("c", 5);
        assertEquals(5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void getCurrent_rCValuesEqualsOne_returnsCurrent() throws DukeException {
        RcTemplate t = new RcTemplate(1,1,1);
        double current = 1 / t.calcImpedance();
        assertEquals(current, t.getCurrent());
    }

    @Test
    void getPower_rCValuesEqualsOne_returnsPower() throws DukeException {
        RcTemplate t = new RcTemplate(1,1,1);
        double power = 1 * 1 / t.calcImpedance();
        assertEquals(power, t.getPower());
    }

    /**
     * Edge cases for the tests.
     */

    @Test
    void calcImpedance_rCValuesNegative_returnsImpedance() throws DukeException {
        RcTemplate t = new RcTemplate(-1,-1,1);
        double impedance = Math.sqrt(Math.pow(1, 2)
                + (1 / Math.pow((t.ANGULAR_FREQUENCY * 1 * Math.pow(10, -6)), 2)));
        assertEquals(impedance, t.calcImpedance(), DELTA);
    }

    @Test
    void getCapacitor_cValuesNegative_returnsCapacitorObject() {
        RcTemplate t = new RcTemplate(1, 1, 1);
        t.setCapacitor(-5);
        assertEquals(-5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setCapacitor_rCValuesNegative_setsCapacitorObject() {
        RcTemplate t = new RcTemplate(-1, -1, 1);
        assertEquals(-1, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setComponent_cValuesNegative_setCapacitorValue() {
        RcTemplate t = new RcTemplate();
        t.setComponent("c", -5);
        assertEquals(-5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void getCurrent_rCValuesNegative_returnsCurrent() throws DukeException {
        RcTemplate t = new RcTemplate(-1,-1,1);
        double current = 1 / t.calcImpedance();
        assertEquals(current, t.getCurrent());
    }

    @Test
    void getPower_rCValuesNegative_returnsPower() throws DukeException {
        RcTemplate t = new RcTemplate(-1,-1,1);
        double power = 1 * 1 / t.calcImpedance();
        assertEquals(power, t.getPower());
    }



}