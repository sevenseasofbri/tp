package seedu.duke.template;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.component.Capacitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LcTemplateTest {
    public static final double DELTA = 1e-15;

    @Test
    void calcImpedance_zeroCapacitance_expectException() {
        LcTemplate t = new LcTemplate();
        assertThrows(DukeException.class, t::calcImpedance);
    }

    @Test
    void calcImpedance_lCValueEqualsOne_returnsImpedance() throws DukeException {
        LcTemplate t = new LcTemplate(1,1,1);
        double inductance = 1 * Math.pow(10, -6);
        double capacitance = 1 * Math.pow(10, -6);
        double impedance = t.ANGULAR_FREQUENCY * Math.abs(inductance - (1 / capacitance));
        assertEquals(impedance, t.calcImpedance(), DELTA);
    }

    @Test
    void getInductor_lCValueEqualsOne_returnsInductor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        t.setInductor(5);
        assertEquals(5, t.getInductor().getValue(), DELTA);
    }

    @Test
    void setComponent_lCValueEqualsOne_setInductorValue() {
        LcTemplate t = new LcTemplate();
        t.setComponent("l", 5);
        assertEquals(5, t.getInductor().getValue(), DELTA);
    }

    @Test
    void getCapacitor_lCValueEqualsOne_returnsCapacitor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        t.setCapacitor(5);
        assertEquals(5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setCapacitor_lCValueEqualsOne_setsCapacitor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        assertEquals(1, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setComponent_cValueEqualsFive_setCapacitorValue() {
        LcTemplate t = new LcTemplate();
        t.setComponent("c", 5);
        assertEquals(5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void getComponent_cValueEqualsFive_getCapacitorValue() throws DukeException {
        LcTemplate t = new LcTemplate();
        t.setComponent("c", 5);
        assertEquals(5, t.getComponent("c").getValue(), DELTA);
    }

    @Test
    void getComponent_cValueEqualsFive_getInductorValue() throws DukeException {
        LcTemplate t = new LcTemplate();
        t.setComponent("l", 5);
        assertEquals(5, t.getComponent("l").getValue(), DELTA);
    }

    @Test
    void getComponent_noValue_expectException() {
        LcTemplate t = new LcTemplate();
        assertThrows(DukeException.class, () -> t.getComponent(""));
    }

    @Test
    void getCurrent_lCValueEqualsOne_returnsCurrent() throws DukeException {
        LcTemplate t = new LcTemplate(1,1,1);
        double current = 1 / t.calcImpedance();
        assertEquals(current, t.getCurrent());
    }

    @Test
    void getPower_lCValueEqualsOne_returnsPower() throws DukeException {
        LcTemplate t = new LcTemplate(1,1,1);
        double power = 1 * 1 / t.calcImpedance();
        assertEquals(power, t.getPower());
    }

    /**
     * Edge cases for the tests.
     */

    @Test
    void getInductor_lValueNegative_returnsInductor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        t.setInductor(-2);
        assertEquals(-2, t.getInductor().getValue(), DELTA);
    }

    @Test
    void setComponent_lValueNegative_setInductorValue() {
        LcTemplate t = new LcTemplate();
        t.setComponent("l", -3);
        assertEquals(-3, t.getInductor().getValue(), DELTA);
    }

    @Test
    void getCapacitor_cValueNegative_returnsCapacitor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        t.setCapacitor(-5);
        assertEquals(-5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setCapacitor_cValueEqualsOne_setsCapacitor() {
        LcTemplate t = new LcTemplate(-1, 1, 1);
        assertEquals(-1, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setComponent_cValueNegative_setCapacitorValue() {
        LcTemplate t = new LcTemplate();
        t.setComponent("c", -5);
        assertEquals(-5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void getComponent_cValueNegative_getCapacitorValue() throws DukeException {
        LcTemplate t = new LcTemplate();
        t.setComponent("c", -5);
        assertEquals(-5, t.getComponent("c").getValue(), DELTA);
    }

    @Test
    void getComponent_lValueNegative_getInductorValue() throws DukeException {
        LcTemplate t = new LcTemplate();
        t.setComponent("l", -5);
        assertEquals(-5, t.getComponent("l").getValue(), DELTA);
    }

    @Test
    void getCurrent_lCValuesNegative_returnsCurrent() throws DukeException {
        LcTemplate t = new LcTemplate(-1,-1,1);
        double current = 1 / t.calcImpedance();
        assertEquals(current, t.getCurrent());
    }

    @Test
    void getPower_lCValuesNegative_returnsPower() throws DukeException {
        LcTemplate t = new LcTemplate(-1,-1,1);
        double power = 1 * 1 / t.calcImpedance();
        assertEquals(power, t.getPower());
    }



}