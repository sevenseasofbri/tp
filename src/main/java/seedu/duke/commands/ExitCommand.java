package seedu.duke.commands;

import seedu.duke.ui.Ui;

public class ExitCommand extends Command {
    public ExitCommand() {
        isExit = true;
    }

    /**
     * Executes the exit command message.
     *
     * @param ui Ui object.
     */
    @Override
    public void execute(Ui ui) {
        ui.printFarewell();
    }
}
