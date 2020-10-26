package seedu.duke.logic.commands.gates;

import seedu.duke.DukeException;
import seedu.duke.model.template.BooleanTemplate;

public class CalculateBooleanCommand extends BooleanCommand {
    public static final String COMMAND_WORD = "calc";
    private int output;

    public CalculateBooleanCommand(BooleanTemplate template) {
        super(template);
    }

    @Override
    public void execute() throws DukeException {
        output = template.calculateOutput();
    }

    @Override
    public String toString() {
        return "The output of the current configuration is " + output + ".\n" + super.toString();
    }
}
