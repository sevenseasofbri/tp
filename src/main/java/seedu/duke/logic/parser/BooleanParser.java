package seedu.duke.logic.parser;

import seedu.duke.DukeException;
import seedu.duke.logic.commands.gates.BooleanCommand;
import seedu.duke.logic.commands.gates.TemplateBooleanCommand;
import seedu.duke.model.gates.AndGate;
import seedu.duke.model.gates.NandGate;
import seedu.duke.model.gates.NorGate;
import seedu.duke.model.gates.OrGate;
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
        case "add":
        case "calc":
        default:
            throw new DukeException("Invalid Command!");
        }
    }

    public BooleanCommand prepareBooleanTemplate(String[] args) throws DukeException {
        booleanTemplate = getBooleanTemplate(args[1]);
        return new TemplateBooleanCommand();
    }

    private BooleanTemplate getBooleanTemplate(String arg) throws DukeException {
        switch (arg.toLowerCase()) {
        case "and":
            return new BooleanTemplate(new AndGate());
        case "or":
            return new BooleanTemplate(new OrGate());
        case "xor":
            return new BooleanTemplate(new XorGate());
        case "nand":
            return new BooleanTemplate(new NandGate());
        case "nor":
            return new BooleanTemplate(new NorGate());
        case "xnor":
            return new BooleanTemplate(new XnorGate());
        default:
            throw new DukeException("Invalid Template!");
        }
    }
}
