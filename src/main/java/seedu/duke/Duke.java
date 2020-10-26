package seedu.duke;

import seedu.duke.logic.commands.Command;
import seedu.duke.logic.parser.Parser;
import seedu.duke.ui.Ui;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Duke {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    /** Instances of class objects for UI. **/
    private final Ui ui;
    private final Parser parser;

    private Duke() {
        ui = new Ui();
        parser = new Parser();
    }

    public void run() {
        setUpLogger();
        LOGGER.info("Execution is beginning.");
        ui.promptForIntro();
        boolean isExit = false;
        while (!isExit) {
            try {
                String line = ui.readLine();
                Command c = parser.parse(line);
                c.execute();
                isExit = c.isExit();
                ui.printMessage(c.toString());
            } catch (DukeException e) {
                LOGGER.log(Level.WARNING, "Bad command", e);
                ui.showError(e.getMessage());
            }
        }
        LOGGER.info("Execution has ended");
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke().run();
    }

    private void setUpLogger() {
        LogManager.getLogManager().reset();
        LOGGER.setLevel(Level.ALL);

        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        LOGGER.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("appLog.log");
            fh.setLevel(Level.FINE);
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "File logger not working", e);
        }
    }
}
