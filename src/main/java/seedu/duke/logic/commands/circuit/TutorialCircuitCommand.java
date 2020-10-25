package seedu.duke.logic.commands.circuit;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.TutorialCommand;
import seedu.duke.logic.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.logging.Level;

public class TutorialCircuitCommand extends CircuitCommand implements TutorialCommand {
    private static final String COMMAND_SUMMARY = "Here's a summary of available commands: \n"
            + "+-----------+----------------------------+--------------------+\n"
            + "|  Action   |           Format           |      Examples      |\n"
            + "+-----------+----------------------------+--------------------+\n"
            + "| Tutorial  | tutorial MODE              | tutorial boolean   |\n"
            + "| Template  | template TEMPLATE          | template rc        |\n"
            + "| Set       | set COMPONENT VALUE        | set r 500          |\n"
            + "| Add       | add CONFIG COMPONENT VALUE | add parallel c 500 |\n"
            + "| Calculate | calc EFF_VALUE             | calc ceff          |\n"
            + "+-----------+----------------------------+--------------------+\n";
    private static final Parser PARSER = new Parser();
    private static final String[] orderOfInstructions = {"template", "set v", "set", "set", "add", "calc"};
    private int numOfCommandsDone = 0;
    private final Ui ui;

    public TutorialCircuitCommand() {
        super();
        ui = new Ui(); // Create its own Ui instance, can be a Ui subclass later on
    }

    /**
     * Begins execution of the interactive tutorial.
     */
    @Override
    public void execute() {
        ui.printWelcomeTutorial();
        String command;
        boolean isNotDone = true;

        while (isNotDone) {
            assert numOfCommandsDone < Ui.INSTRUCTIONS.length;
            ui.printInstruction(numOfCommandsDone);
            command = ui.readLine();
            try {
                isNotDone = continueTutorial(command, ui);
            } catch (DukeException e) {
                LOGGER.log(Level.FINE, "Bad Command DukeException thrown.", e);
                ui.showError(e.getMessage());
            }
        }
        LOGGER.info("Exiting help mode");
    }

    /**
     * Continues or terminates tutorial based on user input.
     *
     * @param command String type command input by the user.
     * @param ui Ui type to perform User Interface interactions.
     * @return boolean type true to continue tutorial, false otherwise.
     * @throws DukeException If the command is invalid.
     */
    @Override
    public boolean continueTutorial(String command, Ui ui) throws DukeException {
        if (command.equals("exit")) {
            return false;
        }
        if (numOfCommandsDone >= 8 || !command.matches(orderOfInstructions[numOfCommandsDone] + "(.*)")) {
            throw new DukeException("Please revise! Or you'll struggle with the module!\n" + "You got this! ᕦ(ò_óˇ)ᕤ\n"
                    + "To exit Tutorial Mode, simply type 'exit' and press Enter.");
        }

        if (numOfCommandsDone >= 6 || !command.matches(orderOfInstructions[numOfCommandsDone] + "(.*)")) {
            throw new DukeException("Bad Command! Please follow the instructions carefully.\n"
                    + "To exit Tutorial Mode, simply type 'exit' and press Enter.");
        }
        
        CircuitCommand c = (CircuitCommand) PARSER.parse(command);
        c.execute();
        ui.printMessage(c.toString());
        numOfCommandsDone++;
        return true;
    }

    /**
     * String representation of the Command.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return "You have exited Tutorial Mode!\n" + COMMAND_SUMMARY + ":) Have fun using CLIrcuit Assistant!";
    }
}
