package seedu.duke.logic.commands.gates;

import seedu.duke.DukeException;
import seedu.duke.model.gates.Gate;
import seedu.duke.model.template.BooleanTemplate;

public class AddBooleanCommand extends BooleanCommand {
    private final Gate gate;
    private final int index;

    public AddBooleanCommand(BooleanTemplate template, Gate gate, int index) {
        super(template);
        this.gate = gate;
        this.index = index;
    }

    @Override
    public void execute() throws DukeException {
        template.addGate(gate, index);
    }
}
