package seedu.duke.logic.commands.gates;

import seedu.duke.model.template.BooleanTemplate;

public class TemplateBooleanCommand extends BooleanCommand {
    public static final String COMMAND_WORD = "template";

    public TemplateBooleanCommand(BooleanTemplate template) {
        super(template);
    }

    @Override
    public void execute() {

    }
}
