package seedu.duke.logic.commands;

import seedu.duke.DukeException;
import seedu.duke.ui.Ui;

public interface TutorialCommand {
    public static final String COMMAND_WORD = "tutorial";
    public abstract boolean continueTutorial(String command, Ui ui) throws DukeException;
}
