package seedu.duke.model.component;

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
    void addParallel_zeroCapacitance_expectException() {
        Capacitor c = new Capacitor(100);
        assertThrows(DukeException.class, () -> c.addParallel(0));
    }

    @Test
    void addParallel_negativeCapacitance_expectException() {
        Capacitor c = new Capacitor(100);
        assertThrows(DukeException.class, () -> c.addParallel(-200));
    }

    @Test
    void addParallel_positiveNonZeroCapacitance_updatesCapacitance() throws DukeException {
        Capacitor c = new Capacitor(100);
        assertEquals(200, c.addParallel(100));
    }


    @Test
    void addParallel_zeroResistance_expectException() {
        Resistor r = new Resistor(100);
        assertThrows(DukeException.class, () -> r.addParallel(0));
    }

    @Test
    void addParallel_negativeResistance_expectException() {
        Resistor r = new Resistor(100);
        assertThrows(DukeException.class, () -> r.addParallel(-200));
    }

    @Test
    void addParallel_positiveResistance_updatesResistance() throws DukeException {
        Resistor r = new Resistor(100);
        assertEquals(50.0, r.addParallel(100));
    }

    @Test
    void addSeries_zeroResistance_expectException() {
        Resistor r = new Resistor(100);
        assertThrows(DukeException.class, () -> r.addSeries(0));
    }

    @Test
    void addSeries_negativeResistance_expectException() {
        Resistor r = new Resistor(100);
        assertThrows(DukeException.class, () -> r.addSeries(-200));
    }

    @Test
    void addSeries_positiveResistance_updatesResistance() throws DukeException {
        Resistor r = new Resistor(100);
        assertEquals(200.0, r.addSeries(100));
    }

    @Test
    void addParallel_zeroInductance_expectException() {
        Inductor l = new Inductor(100);
        assertThrows(DukeException.class, () -> l.addParallel(0));
    }

    @Test
    void addParallel_negativeInductance_expectException() {
        Inductor l = new Inductor(100);
        assertThrows(DukeException.class, () -> l.addParallel(-200));
    }

    @Test
    void addParallel_positiveInductance_updatesInductance() throws DukeException {
        Inductor l = new Inductor(100);
        assertEquals(50.0, l.addParallel(100));
    }

    @Test
    void addSeries_zeroInductance_expectException() {
        Inductor l = new Inductor(100);
        assertThrows(DukeException.class, () -> l.addSeries(0));
    }

    @Test
    void addSeries_negativeInductance_expectException() {
        Inductor l = new Inductor(100);
        assertThrows(DukeException.class, () -> l.addSeries(-200));
    }

    @Test
    void addSeries_positiveInductance_updatesInductance() throws DukeException {
        Inductor l = new Inductor(100);
        assertEquals(200.0, l.addSeries(100));
    }
}