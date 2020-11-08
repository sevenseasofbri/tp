package seedu.duke.logic.commands.gates;

import seedu.duke.DukeException;
import seedu.duke.model.template.BooleanTemplate;

/**
 * The CalculateBooleanCommand class inherits from the BooleanCommand class,
 * and is used to calculate the effective output of the configured logic gates stored in the BinaryTree.
 */
public class CalculateBooleanCommand extends BooleanCommand {
    public static final String COMMAND_WORD = "calc";
    private boolean output;

    public CalculateBooleanCommand(BooleanTemplate template) {
        super(template);
    }

    @Override
    public void execute() throws DukeException {
        output = template.calculateOutput();
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "\tThe output of the above configuration is " + (output ? "1" : "0") + ".";
    }
}
