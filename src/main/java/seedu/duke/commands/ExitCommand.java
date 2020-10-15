package seedu.duke.commands;

import java.util.logging.Logger;

public class ExitCommand extends Command {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    /**
     * Executes the exit command.
     */
    @Override
    public void execute() {
        isExit = true;
        LOGGER.info("Changed flag to exit program.");
    }

    /**
     * String representation of the Command.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return " Bye. See you next time!";
    }
}
