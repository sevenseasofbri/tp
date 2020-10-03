package seedu.duke.template;

import seedu.duke.component.Inductor;
import seedu.duke.component.Resistor;
import seedu.duke.component.VoltageSource;

public class LrTemplate extends Template {
    private Resistor resistor;
    private Inductor inductor;
    private static final String RL_TEMPLATE = "\t+---R-----L---+\n"
                                            + "\t|             |\n"
                                            + "\t|             |\n"
                                            + "\t+----+V_ac+---+\n";

    public LrTemplate(double resistance, double inductance, double powerSupply) {
        super(powerSupply);
        inductor = new Inductor(inductance);
        resistor = new Resistor(resistance);
    }

    @Override
    public String toString() {
        return RL_TEMPLATE + "Total Resistance: " + resistor + System.lineSeparator()
                + "Total Inductance: " + inductor + System.lineSeparator();
    }

}
