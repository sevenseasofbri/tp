package seedu.duke.logic.commands;

public class ExitCommand extends Command {
    public static final String COMMAND_WORD = "bye";

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
