package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoltageSourceTest {

    @Test
    void getValueTest() {
        VoltageSource v = new VoltageSource(100);
        assertEquals(100, v.getValue());
    }

    @Test
    void setValueTest() {
        VoltageSource v = new VoltageSource(100);
        v.setValue(200);
        assertEquals(200, v.getValue());
    }

    @Test
    void toStringTest() {
        VoltageSource v = new VoltageSource(100);
        assertEquals("100.0 V", v.toString());
    }

}
