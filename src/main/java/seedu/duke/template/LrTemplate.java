package seedu.duke.template;

import seedu.duke.component.Inductor;
import seedu.duke.component.Resistor;
import seedu.duke.component.VoltageSource;

import java.util.ArrayList;

public class LrTemplate extends Template {
    private Resistor initialResistor;
    private Inductor initialInductor;
    private ArrayList<Resistor> resistors;
    private ArrayList<Inductor> inductors;
    private static final String RL_TEMPLATE = "\t+---R-----L---+\n"
                                            + "\t|             |\n"
                                            + "\t|             |\n"
                                            + "\t+----+V_ac+---+\n";

    public LrTemplate(double resistance, double inductance, double powerSupply) {
        super(powerSupply);
        initialInductor = new Inductor(inductance);
        inductors.add(initialInductor);
        initialResistor = new Resistor(resistance);
        resistors.add(initialResistor);
    }

    @Override
    public String toString() {
        return RL_TEMPLATE + "Total Resistance: " + initialResistor + System.lineSeparator()
                + "Total Inductance: " + initialInductor + System.lineSeparator();
    }

}
