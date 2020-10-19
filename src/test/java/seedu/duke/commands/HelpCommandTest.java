package seedu.duke.commands;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.ui.Ui;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class HelpCommandTest {

    @Test
    void execute_BadCommand_expectException() {
        HelpCommand c = new HelpCommand();
        assertThrows(NoSuchElementException.class, c::execute);
    }
}
