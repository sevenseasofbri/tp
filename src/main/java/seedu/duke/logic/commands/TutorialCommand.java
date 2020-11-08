package seedu.duke.logic.commands;

import seedu.duke.DukeException;
import seedu.duke.ui.Ui;

/**
 *  The TutorialCommand class is used to enter the specified
 *  interactive tutorial modes of either circuit or boolean.
 */
public interface TutorialCommand {
    String COMMAND_WORD = "tutorial";
    boolean continueTutorial(String command, Ui ui) throws DukeException;
}
