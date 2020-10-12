package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapacitorTest {

    @Test
    void setValue_positiveCapacitance_returnsCapacitance() {
        Capacitor c = new Capacitor(100);
        c.setValue(200);
        assertEquals(200, c.getValue());
    }

    @Test
    void setValue_negativeCapacitance_sameCapacitance() {
        Capacitor c = new Capacitor(100);
        c.setValue(-200);
        assertEquals(100, c.getValue());
    }

    @Test
    void setValue_zeroCapacitance_sameCapacitance() {
        Capacitor c = new Capacitor(100);
        c.setValue(0);
        assertEquals(100, c.getValue());
    }

}
