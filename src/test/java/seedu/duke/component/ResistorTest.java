package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResistorTest {

    @Test
    void setValueTest_positiveResistance_updatesResistance() {
        Resistor r = new Resistor(100);
        r.setValue(200);
        assertEquals(200, r.getValue());
    }

    @Test
    void setValueTest_negativeResistance_expectException() {
        Resistor r = new Resistor(100);
        assertThrows(ArithmeticException.class, () -> r.setValue(-200));
    }

    @Test
    void setValueTest_zeroResistance_expectException() {
        Resistor r = new Resistor(100);
        assertThrows(ArithmeticException.class, () -> r.setValue(0));
    }

}
