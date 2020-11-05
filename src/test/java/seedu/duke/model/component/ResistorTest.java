package seedu.duke.model.component;

import org.junit.jupiter.api.Test;
import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResistorTest {

    @Test
    void setValueTest_positiveResistance_updatesResistance() throws ZeroComponentException {
        Resistor r = new Resistor(100);
        r.setValue(200);
        assertEquals(200, r.getValue());
    }

    @Test
    void setValueTest_negativeResistance_expectException() {
        Resistor r = new Resistor(100);
        assertThrows(ZeroComponentException.class, () -> r.setValue(-200));
    }

    @Test
    void setValueTest_zeroResistance_expectException() {
        Resistor r = new Resistor(100);
        assertThrows(ZeroComponentException.class, () -> r.setValue(0));
    }

}
