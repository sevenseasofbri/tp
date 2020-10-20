package seedu.duke.logic.parser;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.Command;
import seedu.duke.logic.commands.ExitCommand;
import seedu.duke.logic.commands.SummaryCommand;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static boolean isCircuit = true;
    private static final CircuitParser circuitParser = new CircuitParser();
    private static final BooleanParser booleanParser = new BooleanParser();

    public Command parse(String line) throws DukeException {
        // Prevent blank tasks
        if (line.isBlank()) {
            LOGGER.log(Level.WARNING, "Blank line entered.");
            throw new DukeException("Invalid command!");
        }
        // split by whitespace
        String[] args = line.split("\\s+");
        String command = args[0].toLowerCase();

        switch (command) {
        case "summary":
            return new SummaryCommand();
        case "bye":
            return new ExitCommand();
        case "template":
            return prepareTemplate(args);
        }

        if (isCircuit) {
            return circuitParser.parse(args, command);
        } else {
            return booleanParser.parse(args, command);
        }
    }

    private Command prepareTemplate(String[] args) throws DukeException {
        if (args.length < 2) {
            throw new DukeException("Not enough arguments!");
        }

        boolean isCircuitTemplate = args[1].equals("r") || args[1].equals("rc")
                || args[1].equals("rl") || args[1].equals("lc");
        boolean isBooleanTemplate = args[1].equals("and") || args[1].equals("or") || args[1].equals("xor")
                || args[1].equals("nand") || args[1].equals("nor") || args[1].equals("xnor");

        if (isCircuitTemplate) {
            isCircuit = true;
            return circuitParser.prepareCircuitTemplate(args);
        } else if (isBooleanTemplate) {
            isCircuit = false;
            return booleanParser.prepareBooleanTemplate(args);
        }

        throw new DukeException("Invalid argument");

    }




}
