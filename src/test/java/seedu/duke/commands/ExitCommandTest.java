package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.ui.Ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ExitCommandTest {

    @Test
    void execute_run_setsExit() {
        Ui ui = new Ui();
        ExitCommand c = new ExitCommand();
        assertTrue(c.isExit());
    }
}