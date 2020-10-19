package seedu.duke.commands;

import seedu.duke.template.Template;

import java.util.logging.Logger;

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
