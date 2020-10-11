package seedu.duke.template;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.*;

class LrTemplateTest {
    public static final double DELTA = -5*10^-5;
    @Test
    void calcImpedance_zeroInductance_expectException() {
        LrTemplate t = new LrTemplate();
        assertThrows(DukeException.class, t::calcImpedance);
    }

    @Test
    void calcImpedance_returnsDouble() throws DukeException {
        LrTemplate t = new LrTemplate(1,1,1);
        double impedance = Math.sqrt(Math.pow(1, 2)
                + (1 / Math.pow((t.ANGULAR_FREQUENCY * 1), 2)));
        assertEquals(impedance, t.calcImpedance(), DELTA);
    }

    @Test
    void getInductor_returnsInductor() {
        LrTemplate t = new LrTemplate(1, 1, 1);
        t.setInductor(5);
        assertEquals(5, t.getInductor().getValue(), DELTA);
    }

    @Test
    void setInductor_setsInductor() {
        LrTemplate t = new LrTemplate(1, 1, 1);
        assertEquals(1, t.getInductor().getValue(), DELTA);
    }

    @Test
    void setComponent_setCapacitorValue() {
        LrTemplate t = new LrTemplate();
        t.setComponent("l", 5);
        assertEquals(5, t.getInductor().getValue(), DELTA);
    }

    @Test
    void toString_returnsString() {
        LrTemplate t = new LrTemplate(5,5,5);
        String templateString = t.RL_TEMPLATE + "Total Resistance: " + t.resistor + System.lineSeparator()
                + "Total Inductance: " + t.inductor + System.lineSeparator();
        assertEquals(templateString, t.toString());
    }

    @Test
    void getComponent_getCapacitorValue() throws DukeException {
        LrTemplate t = new LrTemplate();
        t.setComponent("l", 5);
        assertEquals(5, t.getInductor().getValue(), DELTA);
    }

    @Test
    void getCurrent_returnsDouble() throws DukeException {
        LrTemplate t = new LrTemplate(1,1,1);
        double current = 1 / t.calcImpedance();
        assertEquals(current, t.getCurrent());
    }

    @Test
    void getPower_returnsDouble() throws DukeException {
        LrTemplate t = new LrTemplate(1,1,1);
        double power = 1 * 1 / t.calcImpedance();
        assertEquals(power, t.getPower());
    }
}