package seedu.duke.logic.commands;

import seedu.duke.DukeException;
import seedu.duke.ui.Ui;

public interface TutorialCommand {
    String COMMAND_WORD = "tutorial";
    boolean continueTutorial(String command, Ui ui) throws DukeException;
}
