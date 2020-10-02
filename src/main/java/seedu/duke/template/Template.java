package seedu.duke.template;

import seedu.duke.component.VoltageSource;

public class Template {
    protected VoltageSource initialPowerSupply;

    public Template(double powerSupply) {
        initialPowerSupply = new VoltageSource(powerSupply);
    }
}
