package seedu.duke.commands;

public class ExitCommand extends Command {
    /**
     * Executes the exit command.
     */
    @Override
    public void execute() {
        isExit = true;
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
