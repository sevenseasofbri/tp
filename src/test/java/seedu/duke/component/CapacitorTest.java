package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapacitorTest {

    @Test
    void getValueTest() {
        Capacitor c = new Capacitor(100);
        assertEquals(100, c.getValue());
    }

    @Test
    void setValueTest() {
        Capacitor c = new Capacitor(100);
        c.setValue(200);
        assertEquals(200, c.getValue());
    }

    @Test
    void toStringTest() {
        Capacitor c = new Capacitor(100);
        assertEquals("100.0 µF", c.toString());
    }


}
