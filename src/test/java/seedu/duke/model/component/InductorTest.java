package seedu.duke.model.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InductorTest {

    @Test
    void setValue_positiveInductance_updatesInductance() {
        Inductor l = new Inductor(100);
        l.setValue(200);
        assertEquals(200, l.getValue());
    }

    @Test
    void setValue_negativeInductance_expectException() {
        Inductor l = new Inductor(100);
        assertThrows(ArithmeticException.class, () -> l.setValue(-200));
    }

    @Test
    void setValue_zeroInductance_expectException() {
        Inductor l = new Inductor(100);
        assertThrows(ArithmeticException.class, () -> l.setValue(0));
    }
}
