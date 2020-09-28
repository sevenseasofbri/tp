package seedu.duke.parser;

import seedu.duke.DukeException;
import seedu.duke.commands.Command;
import seedu.duke.ui.Ui;

public class Parser {
    private static final Ui ui = new Ui();

    /**
     * Returns a Command object based on the input line.
     *
     * @param line Line of user input.
     * @return Command object.
     * @throws DukeException If given line is blank.
     */
    public static Command parse(String line) throws DukeException {
        // Prevent blank tasks
        if (line.isBlank()) {
            throw new DukeException("Invalid command!");
        }
        // split by whitespace
        String[] args = line.split("\\s+");

        switch (args[0].toLowerCase()) {
        case "help":
            return new Command();
        case "template":
            return prepareTemplate(args);
        case "set":
            return prepareAdd(args);
        case "add":
            return prepareSet(args);
        case "calc":
            return prepareCalc(args);
        default:
            throw new DukeException("Invalid Command!");
        }
    }

    private static boolean hasMinArguments(String[] args, int n) {
        return args.length < n;
    }

    private static boolean isComponent(String arg) {
        return arg.equals("r") || arg.equals("c") || arg.equals("l");
    }

    //@@author hughjazzman-reused
    //Reused from https://stackoverflow.com/a/1102916 with minor modifications
    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
    //@@author

    private static Command prepareTemplate(String[] args) throws DukeException {
        if (hasMinArguments(args, 2)) {
            throw new DukeException("Not enough arguments!");
        }

        boolean isTemplate = args[1].equals("r") || args[1].equals("rc") ||
                args[1].equals("rl") || args[1].equals("lc");

        if (!isTemplate) {
            throw new DukeException("Invalid argument");
        }

        return new Command();
    }

    private static Command prepareSet(String[] args) throws DukeException {
        if (hasMinArguments(args, 3)) {
            throw new DukeException("Not enough arguments!");
        }
        if (!(isComponent(args[1]) && isNumeric(args[2]))) {
            throw new DukeException("Invalid argument");
        }

        return new Command();
    }

    private static Command prepareAdd(String[] args) throws DukeException {
        if (hasMinArguments(args, 4)) {
            throw new DukeException("Not enough arguments!");
        }

        boolean isConfig = args[1].equals("parallel") || args[1].equals("series");
        boolean isValid = isConfig && isComponent(args[2]) && isNumeric(args[3]);

        if (!isValid) {
            throw new DukeException("Invalid argument");
        }
        return new Command();
    }

    private static Command prepareCalc(String[] args) throws DukeException {
        if (hasMinArguments(args, 2)) {
            throw new DukeException("Not enough arguments!");
        }

        boolean isCalc = args[1].equals("reff") || args[1].equals("ceff") ||
                args[1].equals("leff") || args[1].equals("current") || args[1].equals("power");

        if (!isCalc) {
            throw new DukeException("Invalid argument");
        }
        return new Command();
    }
}
