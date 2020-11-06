package seedu.duke.model.component;

import org.junit.jupiter.api.Test;
import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InductorTest {

    @Test
    void setValue_positiveInductance_updatesInductance() throws ZeroComponentException {
        Inductor l = new Inductor(100);
        l.setValue(200);
        assertEquals(200, l.getValue());
    }

    @Test
    void setValue_negativeInductance_expectException() {
        Inductor l = new Inductor(100);
        assertThrows(ZeroComponentException.class, () -> l.setValue(-200));
    }

    @Test
    void setValue_zeroInductance_expectException() {
        Inductor l = new Inductor(100);
        assertThrows(ZeroComponentException.class, () -> l.setValue(0));
    }
}
