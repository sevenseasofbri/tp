package seedu.duke.model.template;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;
import seedu.duke.model.exceptions.templateexceptions.TemplateComponentsNotSetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LcTemplateTest {
    //@@author PraveenElango
    public static final double DELTA = 1e-15;

    @Test
    void calcImpedance_zeroCapacitance_expectException() {
        LcTemplate t = new LcTemplate();
        assertThrows(TemplateComponentsNotSetException.class, t::calcImpedance);
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
    void getInductor_lCValueEqualsOne_returnsInductor() throws ZeroComponentException {
        LcTemplate t = new LcTemplate(1, 1, 1);
        t.setInductor(5);
        assertEquals(5, t.getInductor().getValue(), DELTA);
    }

    @Test
    void setComponent_lCValueEqualsOne_setInductorValue() throws ZeroComponentException {
        LcTemplate t = new LcTemplate();
        t.setComponent("l", 5);
        assertEquals(5, t.getInductor().getValue(), DELTA);
    }

    @Test
    void setCapacitor_lCValueEqualsOne_setsCapacitor() {
        LcTemplate t = new LcTemplate(1, 1, 1);
        assertEquals(1, t.getCapacitor().getValue(), DELTA);
    }

    @Test
    void setComponent_cValueEqualsFive_setCapacitorValue() throws ZeroComponentException {
        LcTemplate t = new LcTemplate();
        t.setComponent("c", 5);
        assertEquals(5, t.getCapacitor().getValue(), DELTA);
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
    //@@author




}