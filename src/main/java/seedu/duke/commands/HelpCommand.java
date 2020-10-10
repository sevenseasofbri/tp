package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;

import java.util.Scanner;

public class HelpCommand extends Command {
    private static final Scanner SC = new Scanner(System.in);
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
        String response;
        String command;
        boolean isNotDone = true;

        while (isNotDone) {
            System.out.println(ui.INSTRUCTIONS[numOfCommandsDone]);
            response = SC.nextLine();
            command = response.trim().toLowerCase();
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
        } else if (numOfCommandsDone < 6 && command.matches(orderOfInstructions[numOfCommandsDone] + "(.*)")) {
            Command c = PARSER.parse(command);
            c.execute(ui);
            numOfCommandsDone++;
        } else {
            System.out.println("Bad Command! Please follow the instructions carefully. "
                    + "If you want to exit this mode, type 'exit' and press enter.\n");
        }
        return true;
    }
}
