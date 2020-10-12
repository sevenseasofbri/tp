package seedu.duke.component;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoltageSourceTest {

    @Test
    void setValue_positiveVoltage_updatesVoltage() {
        VoltageSource v = new VoltageSource(100);
        v.setValue(200);
        assertEquals(200, v.getValue());
    }

    @Test
    void setValue_negativeVoltage_sameVoltage() {
        VoltageSource v = new VoltageSource(100);
        v.setValue(200);
        assertEquals(200, v.getValue());
    }

    @Test
    void setValue_zeroVoltage_sameVoltage() {
        VoltageSource v = new VoltageSource(100);
        v.setValue(200);
        assertEquals(200, v.getValue());
    }

}
