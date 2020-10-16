package seedu.duke.commands;

import seedu.duke.ui.Ui;

public class SummaryCommand extends Command {
    public SummaryCommand() {
        super();
    }

    /**
     * Prints a summary of the commands.
     *
     * @param ui Ui object.
     */
    @Override
    public void execute(Ui ui) {
        ui.printCommandSummary();
    }
}
