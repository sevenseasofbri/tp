package seedu.duke.logic.commands;

import seedu.duke.model.template.Template;

public class TemplateCommand extends Command {

    public TemplateCommand(Template template) {
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
