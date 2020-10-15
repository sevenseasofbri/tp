package seedu.duke.commands;

import seedu.duke.template.Template;

public class TemplateCommand extends Command {

    public TemplateCommand(Template template) {
        super(template);
    }

    @Override
    public void execute() {
    }

    @Override
    public String toString() {
        return template.toString();
    }
}
