package seedu.duke.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.logic.parser.exceptions.InvalidGateException;
import seedu.duke.logic.parser.exceptions.InvalidInputException;
import seedu.duke.logic.parser.exceptions.NoTemplateException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BooleanParserTest {

    @Test
    void parseTemplate_setWithoutTemplate_NoTemplateException() {
        Parser p = new Parser();
        String line = "set B 1";
        assertThrows(NoTemplateException.class, () -> p.parse(line));
    }

    @Test
    void parseSet_setInvalidInput_InvalidInputException() throws DukeException {
        Parser p = new Parser();
        p.parse("template and");
        String line = "set B 0.5";
        assertThrows(InvalidInputException.class, () -> p.parse(line));
    }

    @Test
    void parseAdd_invalidGate_InvalidGateException() throws DukeException {
        Parser p = new Parser();
        p.parse("template and");
        String line = "add B yolo";
        assertThrows(InvalidGateException.class, () -> p.parse(line));
    }

    @Test
    void prepareBooleanTemplate_normalInput_noException() {
        BooleanParser p = new BooleanParser();
        assertDoesNotThrow(() -> p.prepareBooleanTemplate(new String[]{"template", "xnor"}));
    }

    @Test
    void prepareBooleanTemplate_invalidInput_InvalidGateException() {
        BooleanParser p = new BooleanParser();
        assertThrows(InvalidGateException.class, () -> p.prepareBooleanTemplate(new String[]{"template", "yeah"}));
    }
}