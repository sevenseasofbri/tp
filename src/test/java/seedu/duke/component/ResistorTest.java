package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResistorTest {

    Resistor r = new Resistor(100);

    @Test
    void getValueTest(){
        assertEquals(100, r.getValue());
    }

    @Test
    void setValueTest(){
        r.setValue(200);
        assertEquals(200, r.getValue());
    }

    @Test
    void toStringTest(){
        assertEquals("100.0 Ω", r.toString());
    }


}
