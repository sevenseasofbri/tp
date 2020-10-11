package seedu.duke;

import seedu.duke.commands.Command;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

public class Duke {
    /** Instances of class objects for UI. **/
    private final Ui ui;
    private final Parser parser;


    private Duke() {
        ui = new Ui();
        parser = new Parser();
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String line = ui.readLine();
                Command c = parser.parse(line);
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
