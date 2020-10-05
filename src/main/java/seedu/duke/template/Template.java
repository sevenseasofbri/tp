package seedu.duke.template;

import seedu.duke.component.VoltageSource;

public class Template {
    protected VoltageSource initialPowerSupply;

    public Template(double powerSupply) {
        initialPowerSupply = new VoltageSource(powerSupply);
    }

    /**
     * Returns the initialPowerSupply as specified at the instantiation of Template.
     *
     * @return initialPowerSupply, an instance of VoltageSource.
     */
    public VoltageSource getInitialPowerSupply() {
        return initialPowerSupply;
    }
}
