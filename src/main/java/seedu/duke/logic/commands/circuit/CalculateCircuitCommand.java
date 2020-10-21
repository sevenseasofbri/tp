package seedu.duke.logic.commands.circuit;

import seedu.duke.DukeException;
import seedu.duke.model.template.CircuitTemplate;

public class CalculateCircuitCommand extends CircuitCommand {
    private final String calculationType;
    private String value;

    public CalculateCircuitCommand(CircuitTemplate template, String calculationType) {
        super(template);
        this.calculationType = calculationType;
    }

    /**
     * Executes calculate command.
     *
     * @throws DukeException If execution error occurs.
     */
    @Override
    public void execute() throws DukeException {
        value = getValue();
    }

    private String getValue() throws DukeException {
        switch (calculationType) {
        case "power":
            return template.getPower() + "W";
        case "current":
            return template.getCurrent() + "A";
        case "reff":
            return template.getComponent("r").toString();
        case "ceff":
            return template.getComponent("c").toString();
        case "leff":
            return template.getComponent("l").toString();
        default:
            throw new DukeException("No such value");
        }
    }

    /**
     * String representation of the Command.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        switch (calculationType) {
        case "power":
            return "The power dissipated in the circuit is " + value;
        case "current":
            return "The total rms current flowing through the circuit is " + value;
        case "reff":
            return "The effective resistance calculated is " + value;
        case "ceff":
            return "The effective capacitance calculated is " + value;
        case "leff":
            return "The effective inductance calculated is " + value;
        default:
            return "Unknown calculation type!";
        }
    }
}
