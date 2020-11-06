package seedu.duke.logic.commands;

public class SummaryCommand extends Command {
    public static final String COMMAND_WORD = "summary";
    private static final String COMMAND_SUMMARY = "\tHere's a summary of available commands: \n"
            + "\t+-----------+----------------------------+---------------------+\n"
            + "\t|  Command  |         Circuit            |      Boolean        |\n"
            + "\t+-----------+----------------------------+---------------------+\n"
            + "\t| Tutorial  | tutorial circuit           | tutorial boolean    |\n"
            + "\t| Template  | template TEMPLATE          | template TEMPLATE   |\n"
            + "\t| Summary   | summary                    | summary             |\n"
            + "\t| Set       | set COMPONENT VALUE        | set INPUT BOOLVALUE |\n"
            + "\t| Add       | add CONFIG COMPONENT VALUE | add INPUT GATE      |\n"
            + "\t| Calculate | calc EFF_VALUE             | calc                |\n"
            + "\t| Exit      | bye                        | bye                 |\n"
            + "\t+-----------+----------------------------+---------------------+\n";
    private static final String PARAMETER_SUMMARY = "\tHere's a summary of the command parameters: \n"
            + "\t+-----------+----------------------------------+-------------------------------+\n"
            + "\t| Parameter |       Circuit Params             |        Boolean Params         |\n"
            + "\t+-----------+----------------------------------+-------------------------------+\n"
            + "\t| TEMPLATE  | rc, rl, r, cl                    | or, and, nor, nand, xor, xnor |\n"
            + "\t| COMPONENT | r, c, l, v                       | N.A.                          |\n"
            + "\t| CONFIG    | parallel, series                 | N.A                           |\n"
            + "\t| EFF_VALUE | reff, ceff, leff, current, power | N.A                           |\n"
            + "\t| VALUE     | any number of double datatype    | N.A                           |\n"
            + "\t| INPUT     | N.A                              | A, B, C, D, E, F, G           |\n"
            + "\t| GATE      | N.A                              | or, and, nor, nand, xor, xnor |\n"
            + "\t| BOOLVALUE | N.A                              | 0, 1                          |\n"
            + "\t+-----------+----------------------------------+-------------------------------+\n";

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
