package seedu.duke.logic.commands.gates;

import seedu.duke.logic.commands.Command;
import seedu.duke.model.template.BooleanTemplate;

public abstract class BooleanCommand extends Command {
    protected final BooleanTemplate template;

    protected BooleanCommand(BooleanTemplate template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return template.toString();
    }
}
