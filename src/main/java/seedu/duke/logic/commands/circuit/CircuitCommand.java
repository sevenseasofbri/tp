package seedu.duke.logic.commands.circuit;

import seedu.duke.logic.commands.Command;
import seedu.duke.model.template.CircuitTemplate;

/**
 * The CircuitCommand class inherits from the Command class and is used to create CircuitCommand objects.
 */
public abstract class CircuitCommand extends Command {
    protected CircuitTemplate template;

    protected CircuitCommand(CircuitTemplate template) {
        this.template = template;
    }

}
