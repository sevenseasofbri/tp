package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InductorTest {

    @Test
    void getValueTest() {
        Inductor l = new Inductor(100);
        assertEquals(100, l.getValue());
    }

    @Test
    void setValueTest() {
        Inductor l = new Inductor(100);
        l.setValue(200);
        assertEquals(200, l.getValue());
    }

    @Test
    void toStringTest() {
        Inductor l = new Inductor(100);
        assertEquals("100.0 µH", l.toString());
    }

}
