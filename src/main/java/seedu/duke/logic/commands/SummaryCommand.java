package seedu.duke.logic.commands;

public class SummaryCommand extends Command {
    public static final String COMMAND_WORD = "summary";
    private static final String COMMAND_SUMMARY = "Here's a summary of available commands: \n"
            + "+-----------+----------------------------+---------------------+\n"
            + "|  Command  |         Circuit            |      Boolean        |\n"
            + "+-----------+----------------------------+---------------------+\n"
            + "| Tutorial  | tutorial circuit           | tutorial boolean    |\n"
            + "| Template  | template TEMPLATE          | template TEMPLATE   |\n"
            + "| Summary   | summary                    | summary             |\n"
            + "| Set       | set COMPONENT VALUE        | set INPUT BOOLVALUE |\n"
            + "| Add       | add CONFIG COMPONENT VALUE | add INPUT GATE      |\n"
            + "| Calculate | calc EFF_VALUE             | calc                |\n"
            + "| Exit      | exit                       | exit                |\n"
            + "+-----------+----------------------------+---------------------+\n";
    private static final String PARAMETER_SUMMARY = "Here's a summary of the command parameters: \n"
            + "+-----------+----------------------------------+-------------------------------+\n"
            + "| Parameter |       Circuit Params             | Boolean Params                |\n"
            + "+-----------+----------------------------------+-------------------------------+\n"
            + "| TEMPLATE  | rc, rl, r, cl                    | or, and, nor, nand, xor, xnor |\n"
            + "| COMPONENT | r, c, l, v                       | N.A.                          |\n"
            + "| CONFIG    | parallel, series                 | N.A                           |\n"
            + "| EFF_VALUE | reff, ceff, leff, current, power | N.A                           |\n"
            + "| VALUE     | any number of double datatype    | N.A                           |\n"
            + "| INPUT     | N.A                              | A, B, C, D, E, F, G           |\n"
            + "| GATE      | N.A                              | or, and, nor, nand, xor, xnor |\n"
            + "| BOOLVALUE | N.A                              | 0, 1                          |\n"
            + "+-----------+----------------------------------+-------------------------------+\n";

    public SummaryCommand() {
        super();
    }

    @Override
    public void execute() {
    }

    /**
     * String representation of the Command.
     *
     * @return String representation.
     */
    @Override
    public String toString() {
        return COMMAND_SUMMARY + "\n" + PARAMETER_SUMMARY;
    }
}
