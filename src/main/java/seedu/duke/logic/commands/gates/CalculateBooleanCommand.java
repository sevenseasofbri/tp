package seedu.duke.logic.commands.gates;

import seedu.duke.DukeException;
import seedu.duke.model.template.BooleanTemplate;
import seedu.duke.ui.Ui;

public class CalculateBooleanCommand extends BooleanCommand {
    public static final String COMMAND_WORD = "calc";
    public static final Ui ui = new Ui();

    public CalculateBooleanCommand(BooleanTemplate template) {
        super(template);
    }

    @Override
    public void execute() throws DukeException {
        ui.printMessage("The output of the above configuration is " + template.calculateOutput(0) + ".");
    }
}
