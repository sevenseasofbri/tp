package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoadComponentTest {

    @Test
    void addSeries_zeroCapacitance_expectException() {
        Capacitor c = new Capacitor(100);
        assertThrows(DukeException.class, () -> c.addSeries(0));
    }

    @Test
    void addSeries_negativeCapacitance_expectException() {
        Capacitor c = new Capacitor(100);
        assertThrows(DukeException.class, () -> c.addSeries(-200));
    }

    @Test
    void addSeries_positiveNonZeroCapacitance_updatesCapacitance() throws DukeException {
        Capacitor c = new Capacitor(100);
        assertEquals(50.0, c.addSeries(100));
    }

    @Test
    void addParallel_zeroResistance_expectException() {
        Resistor r = new Resistor(100);
        assertThrows(DukeException.class, () -> r.addParallel(0));
    }

    @Test
    void addParallel_zeroInductance_expectException() {
        Inductor l = new Inductor(0);
        assertThrows(DukeException.class, () -> l.addParallel(0));
    }
}