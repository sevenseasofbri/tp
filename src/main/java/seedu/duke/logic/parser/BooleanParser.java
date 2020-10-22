package seedu.duke.logic.parser;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.gates.AddBooleanCommand;
import seedu.duke.logic.commands.gates.BooleanCommand;
import seedu.duke.logic.commands.gates.SetBooleanCommand;
import seedu.duke.logic.commands.gates.TemplateBooleanCommand;
import seedu.duke.model.gates.AndGate;
import seedu.duke.model.gates.NandGate;
import seedu.duke.model.gates.NorGate;
import seedu.duke.model.gates.OrGate;
import seedu.duke.model.gates.TwoInputGate;
import seedu.duke.model.gates.XnorGate;
import seedu.duke.model.gates.XorGate;
import seedu.duke.model.template.BooleanTemplate;

public class BooleanParser {
    private static BooleanTemplate booleanTemplate;

    /**
     * Returns a Command object based on the input line.
     *
     * @param args Array of arguments.
     * @param command Command as String.
     * @return Command object.
     * @throws DukeException If given line is blank.
     */
    public BooleanCommand parse(String[] args, String command) throws DukeException {
        switch (command) {
        case "help":
        case "set":
            return prepareBooleanSet(args);
        case "add":
            return prepareBooleanAdd(args);
        case "calc":
        default:
            throw new DukeException("Invalid Command!");
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
        return new TemplateBooleanCommand();
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


    private SetBooleanCommand prepareBooleanSet(String[] args) throws DukeException {
        if (hasMinArguments(args, 3)) {
            throw new DukeException("Not enough arguments!");
        }
        if (!isValidInput(args[2])) {
            throw new DukeException("Invalid input");
        }
        if (hasNoTemplate()) {
            throw new DukeException("No template set yet!");
        }

        int index = getIndex(args[1]);

        int input = Integer.parseInt(args[2]) == 0 ? 0 : 1;

        return new SetBooleanCommand(booleanTemplate, input, index);
    }

    private int getIndex(String arg) throws DukeException {
        int index = arg.charAt(0) - 'A';
        if (index < 0 || index >= 16) {
            throw new DukeException("Invalid position");
        }
        return index;
    }

    private AddBooleanCommand prepareBooleanAdd(String[] args) throws DukeException {
        if (hasMinArguments(args, 3)) {
            throw new DukeException("Not enough arguments!");
        }
        if (hasNoTemplate()) {
            throw new DukeException("No template set yet!");
        }

        int index = getIndex(args[1]);

        TwoInputGate gate = getGate(args[2]);
        return new AddBooleanCommand(booleanTemplate, gate, index);
    }

    private TwoInputGate getGate(String arg) throws DukeException {
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
            throw new DukeException("Invalid Gate!");
        }
    }

    private BooleanTemplate getBooleanTemplate(String arg) throws DukeException {
        TwoInputGate gate = getGate(arg);
        return new BooleanTemplate(gate);
    }
}
