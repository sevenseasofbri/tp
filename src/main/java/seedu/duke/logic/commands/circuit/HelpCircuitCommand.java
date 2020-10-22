package seedu.duke.logic.commands.circuit;

import seedu.duke.DukeException;
import seedu.duke.logic.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.logging.Level;

public class HelpCircuitCommand extends CircuitCommand {
    private static final Parser PARSER = new Parser();
    private static final String[] orderOfInstructions = {"template", "set v", "set", "set", "add", "calc"};
    private int numOfCommandsDone = 0;
    private final Ui ui;

    public HelpCircuitCommand() {
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

    private boolean continueTutorial(String command, Ui ui) throws DukeException {
        if (command.equals("exit")) {
            return false;
        }
        
        if (numOfCommandsDone >= 6 || !command.matches(orderOfInstructions[numOfCommandsDone] + "(.*)")) {
            throw new DukeException("Bad Command! Please follow the instructions carefully."
                    + "If you want to exit this mode, type 'exit' and press enter.");
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
        return ":) Have fun using CLIrcuit Assistant!";
    }
}