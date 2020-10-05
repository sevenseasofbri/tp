package seedu.duke.template;

import seedu.duke.component.Inductor;
import seedu.duke.component.Resistor;

public class LrTemplate extends Template {
    private static final String RL_TEMPLATE = "\t+---R-----L---+\n"
                                            + "\t|             |\n"
                                            + "\t|             |\n"
                                            + "\t+----+V_ac+---+\n";
    private Resistor resistor;
    private Inductor inductor;

    public LrTemplate(double resistance, double inductance, double powerSupply) {
        super(powerSupply);
        inductor = new Inductor(inductance);
        resistor = new Resistor(resistance);
    }

    public LrTemplate() {
        this(0,0,0);
    }

    /**
     * Returns inductor object, an attribute of the instance of LrTemplate.
     *
     * @return inductor, an instance of the Inductor class.
     */
    public Inductor getInductor() {
        return inductor;
    }

    /**
     * Returns resistor object, an attribute of the instance of LrTemplate.
     *
     * @return resistor, an instance of the Resistor class.
     */
    public Resistor getResistor() {
        return resistor;
    }

    /**
     * Returns String consisting of total inductance and resistance values of the LrTemplate object.
     *
     * @return String representation of LrTemplate object.
     */
    @Override
    public String toString() {
        return RL_TEMPLATE + "Total Resistance: " + resistor + System.lineSeparator()
                + "Total Inductance: " + inductor + System.lineSeparator();
    }

}
