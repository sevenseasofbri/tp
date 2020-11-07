package seedu.duke.logic.parser;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.Command;
import seedu.duke.logic.commands.ExitCommand;
import seedu.duke.logic.commands.SummaryCommand;
import seedu.duke.logic.commands.TutorialCommand;
import seedu.duke.logic.commands.circuit.TemplateCircuitCommand;
import seedu.duke.logic.commands.circuit.TutorialCircuitCommand;
import seedu.duke.logic.commands.gates.TutorialBooleanCommand;
import seedu.duke.logic.parser.exceptions.InvalidArgumentException;
import seedu.duke.logic.parser.exceptions.InvalidCommandException;
import seedu.duke.logic.parser.exceptions.InvalidTemplateException;
import seedu.duke.logic.parser.exceptions.NotEnoughArgumentsException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  The Parser class handles text parsing for CLIrcuit Assistant.
 */
public class Parser {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private boolean isCircuit = true;
    private final CircuitParser circuitParser = new CircuitParser();
    private final BooleanParser booleanParser = new BooleanParser();

    /**
     * Returns a Command object based on the input line.
     *
     * @param line Line of user input.
     * @return Command object.
     * @throws DukeException If given line is blank.
     */
    public Command parse(String line) throws DukeException {
        // Prevent blank tasks
        if (line.isBlank()) {
            LOGGER.log(Level.WARNING, "Blank line entered.");
            throw new InvalidCommandException();
        }
        // split by whitespace
        String[] args = line.split("\\s+");
        String command = args[0].toLowerCase();

        switch (command) {
        case SummaryCommand.COMMAND_WORD:
            return new SummaryCommand();
        case TutorialCommand.COMMAND_WORD:
            return prepareTutorial(args);
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        case TemplateCircuitCommand.COMMAND_WORD:
            return prepareTemplate(args);
        default:
            break;
        }

        if (isCircuit) {
            return circuitParser.parse(args, command);
        } else {
            return booleanParser.parse(args, command);
        }
    }

    private Command prepareTemplate(String[] args) throws DukeException {
        if (args.length < 2) {
            throw new NotEnoughArgumentsException(2);
        }

        String firstArg = args[1].toLowerCase();
        boolean isCircuitTemplate = firstArg.equals("r") || firstArg.equals("rc")
                || firstArg.equals("rl") || firstArg.equals("lc");
        boolean isBooleanTemplate = firstArg.equals("and") || firstArg.equals("or") || firstArg.equals("xor")
                || firstArg.equals("nand") || firstArg.equals("nor") || firstArg.equals("xnor");

        if (isCircuitTemplate) {
            isCircuit = true;
            return circuitParser.prepareCircuitTemplate(args);
        } else if (isBooleanTemplate) {
            isCircuit = false;
            return booleanParser.prepareBooleanTemplate(args);
        }

        throw new InvalidArgumentException();
    }

    private Command prepareTutorial(String[] args) throws DukeException {
        if (args.length < 2) {
            throw new NotEnoughArgumentsException(2);
        }
        String command = args[1].toLowerCase();
        switch (command) {
        case "circuit":
            return new TutorialCircuitCommand();
        case "boolean":
            return new TutorialBooleanCommand();
        default:
            throw new InvalidTemplateException();
        }
    }
}
