package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CapacitorTest {

    Capacitor c = new Capacitor(100);

    @Test
    void getValueTest(){
        assertEquals(100, c.getValue());
    }

    @Test
    void setValueTest(){
        c.setValue(200);
        assertEquals(200, c.getValue());
    }

    @Test
    void toStringTest(){
        assertEquals("100.0 µF", c.toString());
    }


}
