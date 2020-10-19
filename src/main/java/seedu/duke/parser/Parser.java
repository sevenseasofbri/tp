package seedu.duke.parser;

import seedu.duke.DukeException;
import seedu.duke.commands.AddCommand;
import seedu.duke.commands.CalculateCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.HelpCommand;
import seedu.duke.commands.SetCommand;
import seedu.duke.commands.SummaryCommand;
import seedu.duke.commands.TemplateCommand;
import seedu.duke.template.LcTemplate;
import seedu.duke.template.LrTemplate;
import seedu.duke.template.RTemplate;
import seedu.duke.template.RcTemplate;
import seedu.duke.template.Template;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static Template template = null;

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
            throw new DukeException("Invalid command!");
        }
        // split by whitespace
        String[] args = line.split("\\s+");
        String command = args[0].toLowerCase();

        switch (command) {
        case "help":
            return new HelpCommand();
        case "summary":
            return new SummaryCommand();
        case "template":
            return prepareTemplate(args);
        case "set":
            return prepareSet(args);
        case "add":
            return prepareAdd(args);
        case "calc":
            return prepareCalc(args);
        case "bye":
            return new ExitCommand();
        default:
            throw new DukeException("Invalid Command!");
        }
    }

    private boolean hasMinArguments(String[] args, int n) {
        return args.length < n;
    }

    private boolean isComponent(String arg) {
        return arg.equals("r") || arg.equals("c") || arg.equals("l") || arg.equals("v");
    }

    //@@author hughjazzman-reused
    //Reused from https://stackoverflow.com/a/1102916 with minor modifications
    private boolean isNumeric(String str) {
        try {
            return Double.parseDouble(str) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //@@author

    private boolean hasNoTemplate() {
        return template == null;
    }

    private Command prepareTemplate(String[] args) throws DukeException {
        if (hasMinArguments(args, 2)) {
            throw new DukeException("Not enough arguments!");
        }

        boolean isTemplate = args[1].equals("r") || args[1].equals("rc")
                || args[1].equals("rl") || args[1].equals("lc");

        if (!isTemplate) {
            throw new DukeException("Invalid argument");
        }

        template = getTemplate(args[1]);
        return new TemplateCommand(template);
    }

    private Template getTemplate(String arg) throws DukeException {
        switch (arg) {
        case "rl":
            return new LrTemplate();
        case "rc":
            return new RcTemplate();
        case "r":
            return new RTemplate();
        case "lc":
            return new LcTemplate();
        default:
            throw new DukeException("Invalid Template!");
        }
    }

    private Command prepareSet(String[] args) throws DukeException {
        if (hasMinArguments(args, 3)) {
            throw new DukeException("Not enough arguments!");
        }
        if (hasNoTemplate()) {
            throw new DukeException("No template set yet!");
        }
        if (!(isComponent(args[1]) && isNumeric(args[2]))) {
            throw new DukeException("Invalid argument");
        }

        double value = Double.parseDouble(args[2]);
        assert value > 0;
        return new SetCommand(template, args[1], value);
    }

    private Command prepareAdd(String[] args) throws DukeException {
        if (hasMinArguments(args, 4)) {
            throw new DukeException("Not enough arguments!");
        }
        if (hasNoTemplate()) {
            throw new DukeException("No template set yet!");
        }

        boolean isConfig = args[1].equals("parallel") || args[1].equals("series");
        boolean isValid = isConfig && isComponent(args[2]) && isNumeric(args[3]);

        if (!isValid) {
            throw new DukeException("Invalid argument");
        }

        double value = Double.parseDouble(args[3]);
        assert value > 0;
        return new AddCommand(template, args[1], args[2], value);
    }

    private Command prepareCalc(String[] args) throws DukeException {
        if (hasMinArguments(args, 2)) {
            throw new DukeException("Not enough arguments!");
        }
        if (hasNoTemplate()) {
            throw new DukeException("No template set yet!");
        }

        boolean isCalc = args[1].equals("reff") || args[1].equals("ceff") || args[1].equals("leff")
                || args[1].equals("current") || args[1].equals("power");

        if (!isCalc) {
            throw new DukeException("Invalid argument");
        }
        return new CalculateCommand(template, args[1]);
    }
}
