package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoltageSourceTest {

    VoltageSource v = new VoltageSource(100);

    @Test
    void getValueTest(){
        assertEquals(100, v.getValue());
    }

    @Test
    void setValueTest(){
        v.setValue(200);
        assertEquals(200, v.getValue());
    }

    @Test
    void toStringTest(){
        assertEquals("100.0 V", v.toString());
    }

}
