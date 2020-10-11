package seedu.duke.commands;

import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class TemplateCommand extends Command {

    public TemplateCommand(Template template) {
        super(template);
    }

    /**
    * Executes appropriate methods based on the given command.
    *
    * @param ui Ui object.
    */
    @Override
    public void execute(Ui ui) {
        ui.printMessage(template.toString());
    }
}
