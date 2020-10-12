package seedu.duke.ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UiTest {

    @Test
    void printInstruction_PassInvalidInstructionNumber_ThrowsException() {
        Ui ui = new Ui();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> ui.printInstruction(8));
    }
}
