package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.parser.Parser;
import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class Duke {
    /** Instances of class objects for UI. **/
    private final Ui ui;
    private Template template;

    private Duke() {
        ui = new Ui();
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String line = ui.readLine();
                Command c = Parser.parse(line);
                c.execute(ui);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke().run();
    }
}
