package seedu.duke.logic.commands.circuit;

import seedu.duke.model.template.CircuitTemplate;

/**
 *  The TemplateCircuitCommand class inherits from the CircuitCommand class
 *  and is used to choose a circuit template.
 */
public class TemplateCircuitCommand extends CircuitCommand {
    public static final String COMMAND_WORD = "template";

    public TemplateCircuitCommand(CircuitTemplate template) {
        super(template);
    }

    @Override
    public void execute() {
        LOGGER.info("Template was chosen");
    }

    @Override
    public String toString() {
        return template.toString();
    }
}
