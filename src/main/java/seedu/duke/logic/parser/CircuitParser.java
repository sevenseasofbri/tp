package seedu.duke.logic.parser;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.circuit.AddCircuitCommand;
import seedu.duke.logic.commands.circuit.CalculateCircuitCommand;
import seedu.duke.logic.commands.circuit.CircuitCommand;
import seedu.duke.logic.commands.circuit.SetCircuitCommand;
import seedu.duke.logic.commands.circuit.TemplateCircuitCommand;
import seedu.duke.logic.parser.exceptions.InvalidArgumentException;
import seedu.duke.logic.parser.exceptions.InvalidCommandException;
import seedu.duke.logic.parser.exceptions.InvalidNumberException;
import seedu.duke.logic.parser.exceptions.InvalidTemplateException;
import seedu.duke.logic.parser.exceptions.NoTemplateException;
import seedu.duke.logic.parser.exceptions.NotEnoughArgumentsException;
import seedu.duke.model.template.CircuitTemplate;
import seedu.duke.model.template.LcTemplate;
import seedu.duke.model.template.LrTemplate;
import seedu.duke.model.template.RTemplate;
import seedu.duke.model.template.RcTemplate;

public class CircuitParser implements LogicParser {
    private CircuitTemplate circuitTemplate = null;

    /**
     * Returns a CircuitCommand object based on the input line.
     *
     * @param args Array of arguments.
     * @param command Command as String.
     * @return CircuitCommand object.
     * @throws DukeException If given line is blank.
     */
    public CircuitCommand parse(String[] args, String command) throws DukeException {
        switch (command) {
        case SetCircuitCommand.COMMAND_WORD:
            return prepareCircuitSet(args);
        case AddCircuitCommand.COMMAND_WORD:
            return prepareCircuitAdd(args);
        case CalculateCircuitCommand.COMMAND_WORD:
            return prepareCircuitCalc(args);
        default:
            throw new InvalidCommandException();
        }
    }

    /**
     * Prepares arguments for template command with BooleanTemplate.
     *
     * @param args Template chosen.
     * @return TemplateBooleanCommand object.
     * @throws DukeException If parsing error occurs.
     */
    public TemplateCircuitCommand prepareCircuitTemplate(String[] args) throws DukeException {
        circuitTemplate = getCircuitTemplate(args[1]);
        return new TemplateCircuitCommand(circuitTemplate);
    }


    private boolean isComponent(String arg) {
        return arg.equals("r") || arg.equals("c") || arg.equals("l") || arg.equals("v");
    }

    //@@author hughjazzman-reused
    //Reused from https://stackoverflow.com/a/1102916 with minor modifications
    private boolean isNotNumeric(String str) {
        try {
            return !(Double.parseDouble(str) > 0);
        } catch (NumberFormatException e) {
            return true;
        }
    }
    //@@author

    private boolean hasNoTemplate() {
        return circuitTemplate == null;
    }



    private CircuitTemplate getCircuitTemplate(String arg) throws DukeException {
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
            throw new InvalidTemplateException();
        }
    }

    private CircuitCommand prepareCircuitSet(String[] args) throws DukeException {
        if (hasMinArguments(args, 3)) {
            throw new NotEnoughArgumentsException(3);
        }
        if (hasNoTemplate()) {
            throw new NoTemplateException();
        }
        if (!isComponent(args[1])) {
            throw new InvalidArgumentException();
        }
        if (isNotNumeric(args[2])) {
            throw new InvalidNumberException();
        }

        double value = Double.parseDouble(args[2]);
        assert value > 0;
        return new SetCircuitCommand(circuitTemplate, args[1], value);
    }

    private boolean hasMinArguments(String[] args, int i) {
        return args.length < i;
    }

    private CircuitCommand prepareCircuitAdd(String[] args) throws DukeException {
        if (hasMinArguments(args, 4)) {
            throw new NotEnoughArgumentsException(4);
        }
        if (hasNoTemplate()) {
            throw new NoTemplateException();
        }

        boolean isConfig = args[1].equals("parallel") || args[1].equals("series");
        boolean isValid = isConfig && isComponent(args[2]);

        if (!isValid) {
            throw new InvalidArgumentException();
        }
        if (isNotNumeric(args[3])) {
            throw new InvalidNumberException();
        }

        double value = Double.parseDouble(args[3]);
        assert value > 0;
        return new AddCircuitCommand(circuitTemplate, args[1], args[2], value);
    }

    private CircuitCommand prepareCircuitCalc(String[] args) throws DukeException {
        if (hasMinArguments(args, 2)) {
            throw new NotEnoughArgumentsException(2);
        }
        if (hasNoTemplate()) {
            throw new NoTemplateException();
        }

        boolean isCalc = args[1].equals("reff") || args[1].equals("ceff") || args[1].equals("leff")
                || args[1].equals("current") || args[1].equals("power");

        if (!isCalc) {
            throw new InvalidArgumentException();
        }
        return new CalculateCircuitCommand(circuitTemplate, args[1]);
    }
}
