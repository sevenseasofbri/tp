package seedu.duke.logic.parser;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.Command;

public interface LogicParser {
    Command parse(String[] args, String command) throws DukeException;
}
