package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InductorTest {

    @Test
    void setValue_positiveInductance_updatesInductance() {
        Inductor l = new Inductor(100);
        l.setValue(200);
        assertEquals(200, l.getValue());
    }

    @Test
    void setValue_negativeInductance_sameInductance() {
        Inductor l = new Inductor(100);
        l.setValue(-200);
        assertEquals(100, l.getValue());
    }

    @Test
    void setValue_zeroInductance_updatesInductance() {
        Inductor l = new Inductor(100);
        l.setValue(0);
        assertEquals(100, l.getValue());
    }
}
