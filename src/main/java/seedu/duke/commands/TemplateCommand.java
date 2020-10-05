package seedu.duke.commands;

import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class TemplateCommand extends Command {
    private final Template template;

    public TemplateCommand(Template template) {
        this.template = template;
    }

    /**
     * Executes appropriate methods based on the given command.
     *
     * @param ui Ui object.
     * @param oldTemplate Template object.
     * @return Template object.
     */
    @Override
    public Template execute(Ui ui, Template oldTemplate) {
        ui.printMessage(this.template.toString());
        return this.template;
    }
}
