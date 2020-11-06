package seedu.duke.model.component;

import org.junit.jupiter.api.Test;
import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VoltageSourceTest {

    @Test
    void setValue_positiveVoltage_updatesVoltage() throws ZeroComponentException {
        VoltageSource v = new VoltageSource(100);
        v.setValue(200);
        assertEquals(200, v.getValue());
    }

    @Test
    void setValue_negativeVoltage_expectException() {
        VoltageSource v = new VoltageSource(100);
        assertThrows(ZeroComponentException.class, () -> v.setValue(-200));
    }

    @Test
    void setValue_zeroVoltage_expectException() {
        VoltageSource v = new VoltageSource(100);
        assertThrows(ZeroComponentException.class, () -> v.setValue(0));
    }

}
