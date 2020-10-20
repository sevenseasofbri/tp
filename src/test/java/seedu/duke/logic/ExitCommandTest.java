package seedu.duke.logic;

import org.junit.jupiter.api.Test;
import seedu.duke.logic.commands.ExitCommand;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ExitCommandTest {

    @Test
    void execute_run_setsExit() {
        ExitCommand c = new ExitCommand();
        c.execute();
        assertTrue(c.isExit());
    }
}