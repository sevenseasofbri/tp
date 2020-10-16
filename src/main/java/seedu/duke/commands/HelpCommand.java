package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.Scanner;

public class HelpCommand extends Command {
    private static final Parser PARSER = new Parser();
    private int numOfCommandsDone = 0;
    private static final String[] orderOfInstructions = {"template", "set v", "set", "set", "add", "calc"};

    public HelpCommand() {
        super();
    }

    /**
     * Begins execution of the interactive tutorial.
     *
     * @param ui Ui object.
     */
    @Override
    public void execute(Ui ui) {
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
        ui.printExitHelp();
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
        c.execute(ui);
        numOfCommandsDone++;
        return true;
    }
}
