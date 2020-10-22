package seedu.duke.logic.commands.circuit;

import seedu.duke.model.template.CircuitTemplate;

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
