package seedu.duke.logic.parser;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.gates.AddBooleanCommand;
import seedu.duke.logic.commands.gates.BooleanCommand;
import seedu.duke.logic.commands.gates.CalculateBooleanCommand;
import seedu.duke.logic.commands.gates.SetBooleanCommand;
import seedu.duke.logic.commands.gates.TemplateBooleanCommand;
import seedu.duke.logic.parser.exceptions.InvalidCommandException;
import seedu.duke.logic.parser.exceptions.InvalidGateException;
import seedu.duke.logic.parser.exceptions.InvalidInputException;
import seedu.duke.logic.parser.exceptions.InvalidPositionException;
import seedu.duke.logic.parser.exceptions.NoTemplateException;
import seedu.duke.logic.parser.exceptions.NotEnoughArgumentsException;
import seedu.duke.logic.parser.exceptions.ParserException;
import seedu.duke.model.gates.AndGate;
import seedu.duke.model.gates.Gate;
import seedu.duke.model.gates.NandGate;
import seedu.duke.model.gates.NorGate;
import seedu.duke.model.gates.OrGate;
import seedu.duke.model.gates.XnorGate;
import seedu.duke.model.gates.XorGate;
import seedu.duke.model.template.BooleanTemplate;

public class BooleanParser implements LogicParser {
    private BooleanTemplate booleanTemplate;

    /**
     * Returns a BooleanCommand object based on the input line.
     *
     * @param args Array of arguments.
     * @param command Command as String.
     * @return BooleanCommand object.
     * @throws DukeException If given line is blank.
     */
    public BooleanCommand parse(String[] args, String command) throws DukeException {
        switch (command) {
        case SetBooleanCommand.COMMAND_WORD:
            return prepareBooleanSet(args);
        case AddBooleanCommand.COMMAND_WORD:
            return prepareBooleanAdd(args);
        case CalculateBooleanCommand.COMMAND_WORD:
            return prepareBooleanCalculate();
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
    public TemplateBooleanCommand prepareBooleanTemplate(String[] args) throws DukeException {
        booleanTemplate = getBooleanTemplate(args[1]);
        return new TemplateBooleanCommand(booleanTemplate);
    }

    private boolean hasNoTemplate() {
        return booleanTemplate == null;
    }

    private boolean isValidInput(String arg) {
        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean hasMinArguments(String[] args, int i) {
        return args.length < i;
    }

    /**
     * Returns the SetBooleanCommand after parsing the input arguments.
     *
     * @param args User Input arguments.
     * @return SetBooleanCommand object to be executed.
     * @throws ParserException If input parsed incorrectly, or no template set yet.
     */
    private SetBooleanCommand prepareBooleanSet(String[] args) throws ParserException {
        if (hasMinArguments(args, 3)) {
            throw new NotEnoughArgumentsException(3);
        }
        if (!isValidInput(args[2])) {
            throw new InvalidInputException();
        }
        if (hasNoTemplate()) {
            throw new NoTemplateException();
        }

        int index = getIndex(args[1]);

        boolean input = Integer.parseInt(args[2]) != 0;

        return new SetBooleanCommand(booleanTemplate, input, index);
    }

    /**
     * Extracts index number the command passed.
     *
     * @param arg String type command input.
     * @return int type index.
     * @throws InvalidPositionException If the index passed is invalid.
     */
    private int getIndex(String arg) throws InvalidPositionException {
        String capsArg = arg.toUpperCase();
        int index = capsArg.charAt(0) - 'A';
        if (index < 0 || index >= 16 || arg.length() > 1) {
            throw new InvalidPositionException();
        }
        return index;
    }

    /**
     * Returns an instance of AddBooleanCommand after parsing the user input.
     *
     * @param args String type user input.
     * @return AddBooleanCommand instance to be executed.
     * @throws ParserException If input parsed is incorrect or no template is set yet.
     */
    private AddBooleanCommand prepareBooleanAdd(String[] args) throws ParserException {
        if (hasMinArguments(args, 3)) {
            throw new NotEnoughArgumentsException(3);
        }
        if (hasNoTemplate()) {
            throw new NoTemplateException();
        }

        int index = getIndex(args[1]);

        Gate gate = getGate(args[2]);
        return new AddBooleanCommand(booleanTemplate, gate, index);
    }

    /**
     * Returns new instance of CalculateBooleanCommand after parsing user input.
     *
     * @return CalculateBooleanCommand instance to be executed.
     * @throws NoTemplateException If the template hasn't been set yet.
     */
    private CalculateBooleanCommand prepareBooleanCalculate() throws NoTemplateException {
        if (hasNoTemplate()) {
            throw new NoTemplateException();
        }
        return new CalculateBooleanCommand(booleanTemplate);
    }

    /**
     * Parses user command to determine and return the gate instance specified.
     *
     * @param arg String type user input.
     * @return Gate type object.
     * @throws InvalidGateException If gate specified is invalid.
     */
    private Gate getGate(String arg) throws InvalidGateException {
        switch (arg.toLowerCase()) {
        case "and":
            return new AndGate();
        case "or":
            return new OrGate();
        case "xor":
            return new XorGate();
        case "nand":
            return new NandGate();
        case "nor":
            return new NorGate();
        case "xnor":
            return new XnorGate();
        default:
            throw new InvalidGateException();
        }
    }

    /**
     * Returns new instance of BooleanTemplate class.
     *
     * @param arg String type user input.
     * @return BooleanTemplate type instance.
     * @throws DukeException If the gate processed is invalid or BooleanTemplate cannot be created.
     */
    private BooleanTemplate getBooleanTemplate(String arg) throws DukeException {
        Gate gate = getGate(arg);
        return new BooleanTemplate(gate);
    }
}
