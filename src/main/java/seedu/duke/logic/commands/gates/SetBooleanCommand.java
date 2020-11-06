package seedu.duke.logic.commands.gates;

import seedu.duke.DukeException;
import seedu.duke.model.template.BooleanTemplate;

public class SetBooleanCommand extends BooleanCommand {
    public static final String COMMAND_WORD = "set";
    private final boolean value;
    private final int index;

    public SetBooleanCommand(BooleanTemplate booleanTemplate, boolean value, int index) {
        super(booleanTemplate);
        this.value = value;
        this.index = index;
    }

    /**
     * Executes the setting of value in BooleanTemplate.
     *
     * @throws DukeException If setInput throws DukeException.
     */
    @Override
    public void execute() throws DukeException {
        template.setInput(value, index);
    }

    /**
     * Returns String representation of SetBooleanCommand.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return "Successfully set " + (char)(index + 'A') + " to " + (value ? "1" : "0") + System.lineSeparator()
                + '\t' + super.toString();
    }
}
