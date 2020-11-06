package seedu.duke.model.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CapacitorTest {

    @Test
    void setValue_positiveCapacitance_returnsCapacitance() throws DukeException {
        Capacitor c = new Capacitor(100);
        c.setValue(200);
        assertEquals(200, c.getValue());
    }

    @Test
    void setValue_negativeCapacitance_expectException() {
        Capacitor c = new Capacitor(100);
        assertThrows(ZeroComponentException.class, () -> c.setValue(-200));
    }

    @Test
    void setValue_zeroCapacitance_expectException() {
        Capacitor c = new Capacitor(100);
        assertThrows(ZeroComponentException.class, () -> c.setValue(0));
    }

}
