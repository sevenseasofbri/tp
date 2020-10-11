package seedu.duke.template;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.*;

class RTemplateTest {
    public static final double DELTA = 1e-15;

    @Test
    void calcImpedance_zeroCapacitance_expectException() {
        RcTemplate t = new RcTemplate();
        assertThrows(DukeException.class, t::calcImpedance);
    }

    @Test
    void calcImpedance_returnsDouble() throws DukeException {
        RTemplate t = new RTemplate(5,1);
        assertEquals(5, t.calcImpedance(), DELTA);
    }

    @Test
    void getCapacitor_returnsResistor() {
        RTemplate t = new RTemplate(1, 1);
        t.setResistor(5);
        assertEquals(5, t.getResistor().getValue(), DELTA);
    }

    @Test
    void setComponent_getResistorValue() {
        RTemplate t = new RTemplate();
        t.setComponent("r", 5);
        assertEquals(5, t.getResistor().getValue(), DELTA);
    }

    @Test
    void toString_returnsString() {
        RTemplate t = new RTemplate(5,5);
        String templateString = t.R_TEMPLATE + "Total Resistance: " + t.resistor + System.lineSeparator();
        assertEquals(templateString, t.toString());
    }

    @Test
    void getComponent_getResistorValue() throws DukeException {
        RTemplate t = new RTemplate();
        t.setComponent("r", 5);
        assertEquals(5, t.getResistor().getValue(), DELTA);
    }

    @Test
    void getComponent_expectException() {
        RTemplate t = new RTemplate();
        assertThrows(DukeException.class, () -> t.getComponent(""));
    }

    @Test
    void getCurrent_returnsDouble() throws DukeException {
        RcTemplate t = new RcTemplate(1,1,1);
        double current = 1 / t.calcImpedance();
        assertEquals(current, t.getCurrent());
    }

    @Test
    void getPower_returnsDouble() throws DukeException {
        RcTemplate t = new RcTemplate(1,1,1);
        double power = 1 * 1 / t.calcImpedance();
        assertEquals(power, t.getPower());
    }

}