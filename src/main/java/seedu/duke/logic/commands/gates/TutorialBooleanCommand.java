package seedu.duke.logic.commands.gates;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.TutorialCommand;
import seedu.duke.logic.parser.Parser;
import seedu.duke.ui.Ui;

public class TutorialBooleanCommand extends BooleanCommand implements TutorialCommand {
    private static final Parser PARSER = new Parser();
    private final Ui ui;

    public TutorialBooleanCommand() {
        super();
        ui = new Ui();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean continueTutorial(String command, Ui ui) throws DukeException {
        return false;
    }
}
