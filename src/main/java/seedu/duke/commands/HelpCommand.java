package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

public class HelpCommand extends Command {
    private static final Parser PARSER = new Parser();
    private static final String[] orderOfInstructions = {"template", "set v", "set", "set", "add", "calc"};
    private int numOfCommandsDone = 0;
    private final Ui ui;

    public HelpCommand() {
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
            ui.printInstruction(numOfCommandsDone);
            command = ui.readLine();
            try {
                isNotDone = continueTutorial(command, ui);
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    private boolean continueTutorial(String command, Ui ui) throws DukeException {
        if (command.equals("exit")) {
            return false;
        }
        
        if (numOfCommandsDone >= 6 || !command.matches(orderOfInstructions[numOfCommandsDone] + "(.*)")) {
            throw new DukeException("Bad Command! Please follow the instructions carefully."
                    + "If you want to exit this mode, type 'exit' and press enter.");
        }
        
        Command c = PARSER.parse(command);
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
