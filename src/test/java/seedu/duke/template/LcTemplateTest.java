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
    void calcImpedance_returnsDouble() throws DukeException {
        LcTemplate t = new LcTemplate(1,1,1);
        double inductance = 1 * Math.pow(10, -6);
        double capacitance = 1 * Math.pow(10, -6);
        double impedance = t.ANGULAR_FREQUENCY * Math.abs(inductance - (1 / capacitance));
        assertEquals(impedance, t.calcImpedance(), DELTA);
    }

    @Test
    void getInductor_returnsInductor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        t.setInductor(5);
        assertEquals(5, t.getInductor().getValue(), DELTA);
    }

    @Test
    void setInductor_setsInductor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        assertEquals(1, t.getInductor().getValue(), DELTA);
    }

    @Test
    void setComponent_setInductorValue() {
        LcTemplate t = new LcTemplate();
        t.setComponent("l", 5);
        assertEquals(5, t.getInductor().getValue(), DELTA);
    }

    @Test
    void getCapacitor_returnsCapacitor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        t.setCapacitor(5);
        assertEquals(5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setCapacitor_setsCapacitor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        assertEquals(1, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setComponent_setCapacitorValue() {
        LcTemplate t = new LcTemplate();
        t.setComponent("c", 5);
        assertEquals(5, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void toString_returnsString() {
        LcTemplate t = new LcTemplate(5,5,5);
        String templateString = t.LC_TEMPLATE + "Total Capacitance: " + t.capacitor + System.lineSeparator()
                + "Total Inductance: " + t.inductor + System.lineSeparator();
        assertEquals(templateString, t.toString());
    }

    @Test
    void getComponent_getCapacitorValue() throws DukeException {
        LcTemplate t = new LcTemplate();
        t.setComponent("c", 5);
        assertEquals(5, t.getComponent("c").getValue(), DELTA);
    }

    @Test
    void getComponent_getInductorValue() throws DukeException {
        LcTemplate t = new LcTemplate();
        t.setComponent("l", 5);
        assertEquals(5, t.getComponent("l").getValue(), DELTA);
    }

    @Test
    void getComponent_expectException() {
        LcTemplate t = new LcTemplate();
        assertThrows(DukeException.class, () -> t.getComponent(""));
    }

    @Test
    void getCurrent_returnsDouble() throws DukeException {
        LcTemplate t = new LcTemplate(1,1,1);
        double current = 1 / t.calcImpedance();
        assertEquals(current, t.getCurrent());
    }

    @Test
    void getPower_returnsDouble() throws DukeException {
        LcTemplate t = new LcTemplate(1,1,1);
        double power = 1 * 1 / t.calcImpedance();
        assertEquals(power, t.getPower());
    }

}