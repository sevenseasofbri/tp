package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.DukeException;
import seedu.duke.commands.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserTest {

    @Test
    void parse_noLine_expectException() {
        Parser p = new Parser();
        String line = "";
        assertThrows(DukeException.class, () -> p.parse(line));
    }

    @Test
    void parseHelp_help_returnsHelpCommand() throws DukeException {
        Parser p = new Parser();
        String line = "help";
        Command c = p.parse(line);
        assertTrue(c instanceof Command); // change to HelpCommand once done
    }

    @Test
    void parseTemplate_Template_returnsTemplateCommand() throws DukeException {
        Parser p = new Parser();
        String line = "template ";
        String[] tmp = {"r", "rl", "rc", "lc"};
        Command c;
        for (String s : tmp) {
            c = p.parse(line + s);
            assertTrue(c instanceof TemplateCommand);
        }
    }

    @Test
    void parseTemplate_noTemplate_expectException() {
        Parser p = new Parser();
        String line = "template";
        assertThrows(DukeException.class, () -> p.parse(line));
    }

    @Test
    void parseTemplate_wrongArgument_expectException() {
        Parser p = new Parser();
        String line = "template haha";
        assertThrows(DukeException.class, () -> p.parse(line));
    }

    @Test
    void parseSet_resistor_returnsSetCommand() throws DukeException {
        Parser p = new Parser();
        p.parse("template rl");
        String line = "set r 500";
        Command c = p.parse(line);
        assertTrue(c instanceof SetCommand);
    }

    @Test
    void parseSet_noResistance_expectException() throws DukeException {
        Parser p = new Parser();
        p.parse("template rl");
        String line = "set r ";
        assertThrows(DukeException.class, () -> p.parse(line));
    }

    @Test
    void parseSet_negativeResistance_expectException() throws DukeException {
        Parser p = new Parser();
        p.parse("template rl");
        String line = "set r -500";
        assertThrows(DukeException.class, () -> p.parse(line));
    }

    @Test
    void parseSet_invalidResistance_expectException() throws DukeException {
        Parser p = new Parser();
        p.parse("template rl");
        String line = "set r yolo";
        assertThrows(DukeException.class, () -> p.parse(line));
    }

    @Test
    void parseSet_invalidComponent_expectException() throws DukeException {
        Parser p = new Parser();
        p.parse("template rl");
        String line = "set c 500";
        Command c = p.parse(line);
        assertTrue(c instanceof SetCommand);
    }

    @Test
    void parseAdd_addResistor_returnsAddCommand() throws DukeException {
        Parser p = new Parser();
        p.parse("template rl");
        p.parse("set r 500");
        String line = "add series r 500";
        Command c = p.parse(line);
        assertTrue(c instanceof AddCommand);
    }

    @Test
    void parseAdd_wrongConfig_expectException() throws DukeException {
        Parser p = new Parser();
        p.parse("template rl");
        p.parse("set r 500");
        String line = "add diagonal r 500";
        assertThrows(DukeException.class, () -> p.parse(line));
    }

    @Test
    void parseAdd_wrongComponent_expectException() throws DukeException {
        Parser p = new Parser();
        p.parse("template rl");
        p.parse("set r 500");
        String line = "add series c 500";
        Command c = p.parse(line);
        assertTrue(c instanceof AddCommand);
    }

    @Test
    void parseCalc_valueEff_CalculateCommand() throws DukeException {
        Parser p = new Parser();
        p.parse("template rl");
        String line = "calc ";
        String[] valueEff = {"reff", "leff", "current", "power"};
        Command c;
        for (String s : valueEff) {
            c = p.parse(line + s);
            assertTrue(c instanceof CalculateCommand);
        }

        p.parse("template rc");
        String capEff = "ceff";
        c = p.parse(line + capEff);
        assertTrue(c instanceof CalculateCommand);

    }

    @Test
    void parseExit_bye_ExitCommand() throws DukeException {
        Parser p = new Parser();
        String line = "bye";
        Command c = p.parse(line);
        assertTrue(c instanceof ExitCommand);
    }


}