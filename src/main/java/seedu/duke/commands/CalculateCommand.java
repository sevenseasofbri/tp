package seedu.duke.commands;

import seedu.duke.DukeException;
import seedu.duke.template.LcTemplate;
import seedu.duke.template.LrTemplate;
import seedu.duke.template.RTemplate;
import seedu.duke.template.RcTemplate;
import seedu.duke.template.Template;
import seedu.duke.ui.Ui;

public class CalculateCommand extends Command {
    private String calculationType;

    public CalculateCommand(Template template,String calculationType) {
        super(template);
        this.calculationType = calculationType;
    }

    /**
     * Executes calculate command.
     *
     * @param ui Ui object.
     * @throws DukeException If execution error occurs.
     */
    @Override
    public void execute(Ui ui) throws DukeException {
        switch (calculationType) {
        case "power":
            ui.printCalculatedPower(template.getPower());
            break;
        case "current":
            ui.printCalculatedCurrent(template.getCurrent());
            break;
        case "reff":
            calculateReff(ui);
            break;
        case "ceff":
            calculateCeff(ui);
            break;
        default:
            calculateLeff(ui);
            break;
        }
    }

    /**
     * Calculates and prints the effective resistance of the circuit.
     *
     * @param ui Ui object.
     * @throws DukeException If the chosen template does not contain resistors.
     */
    private void calculateReff(Ui ui) throws DukeException {
        if (template instanceof RTemplate) {
            ui.printCalculatedResistance(((RTemplate)template).getResistor());
        } else {
            throw new DukeException("Chosen template does not contain resistors! :( ");
        }
    }

    /**
     * Calculates and prints the effective capacitance of the circuit.
     *
     * @param ui Ui object.
     * @throws DukeException If the chosen template does not contain capacitors.
     */
    private void calculateCeff(Ui ui) throws DukeException {
        if (template instanceof LcTemplate) {
            ui.printCalculatedCapacitance(((LcTemplate) template).getCapacitor());
        } else if (template instanceof RcTemplate) {
            ui.printCalculatedCapacitance(((RcTemplate) template).getCapacitor());
        } else {
            throw new DukeException("Chosen template does not contain capacitors! :( ");
        }
    }

    /**
     * Calculates and prints the effective inductance of the circuit.
     *
     * @param ui Ui object.
     * @throws DukeException If the chosen template does not contain inductors.
     */
    private void calculateLeff(Ui ui) throws DukeException {
        if (template instanceof LcTemplate) {
            ui.printCalculatedInductance(((LcTemplate) template).getInductor());
        } else if (template instanceof LrTemplate) {
            ui.printCalculatedInductance(((LrTemplate) template).getInductor());
        } else {
            throw new DukeException("Chosen template does not contain inductors! :( ");
        }
    }
}
