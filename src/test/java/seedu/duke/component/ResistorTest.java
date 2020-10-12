package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResistorTest {

    @Test
    void getValue_doubleResistance_returnsResistance() {
        Resistor r = new Resistor(100);
        assertEquals(100, r.getValue());
    }

    @Test
    void setValueTest_positiveResistance_updatesResistance() {
        Resistor r = new Resistor(100);
        r.setValue(200);
        assertEquals(200, r.getValue());
    }

    @Test
    void setValueTest_negativeResistance_sameResistance() {
        Resistor r = new Resistor(100);
        r.setValue(-200);
        assertEquals(100, r.getValue());
    }

    @Test
    void setValueTest_zeroResistance_sameResistance() {
        Resistor r = new Resistor(100);
        r.setValue(0);
        assertEquals(100, r.getValue());
    }

    @Test
    void toString_doubleResistance_returnsResistanceWithUnit() {
        Resistor r = new Resistor(100);
        assertEquals("100.0 Ω", r.toString());
    }

}
