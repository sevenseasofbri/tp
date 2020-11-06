package seedu.duke.logic.commands.binary;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.logic.commands.gates.AddBooleanCommand;
import seedu.duke.logic.commands.gates.CalculateBooleanCommand;
import seedu.duke.model.gates.Gate;
import seedu.duke.model.gates.NandGate;
import seedu.duke.model.gates.XnorGate;
import seedu.duke.model.gates.XorGate;
import seedu.duke.model.template.BooleanTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddBooleanCommandTest {
    private static Gate nandGate = new NandGate();
    private static Gate xnorGate = new XnorGate();
    private static int Output;

    @Test
    void execute_addGate_addsGateToCircuit() throws DukeException {
        BooleanTemplate booleanNandTemplate = new BooleanTemplate(nandGate);
        AddBooleanCommand c = new AddBooleanCommand(booleanNandTemplate, xnorGate, 2);
        c.execute();
        assertEquals(xnorGate, booleanNandTemplate.getCircuit().getT(2));
    }

    @Test
    void execute_addGateToWrongIndex_expectException() throws DukeException {
        BooleanTemplate booleanNandTemplate = new BooleanTemplate(nandGate);
        AddBooleanCommand c = new AddBooleanCommand(booleanNandTemplate, xnorGate, 5);
        assertThrows(DukeException.class, c::execute);
    }






}
