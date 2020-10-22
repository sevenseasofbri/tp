package seedu.duke.logic.commands.gates;

import seedu.duke.DukeException;
import seedu.duke.model.template.BooleanTemplate;

public class SetBooleanCommand extends BooleanCommand {
    public static final String COMMAND_WORD = "set";
    private final int value;
    private final int index;

    public SetBooleanCommand(BooleanTemplate booleanTemplate, int value, int index) {
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
}
