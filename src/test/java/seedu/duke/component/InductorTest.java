package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InductorTest {

    Inductor l = new Inductor(100);

    @Test
    void getValueTest(){
        assertEquals(100, l.getValue());
    }

    @Test
    void setValueTest(){
        l.setValue(200);
        assertEquals(200, l.getValue());
    }

    @Test
    void toStringTest(){
        assertEquals("100.0 µH", l.toString());
    }


}
