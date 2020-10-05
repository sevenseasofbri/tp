package seedu.duke.component;

public abstract class LoadComponent extends Component {
    protected boolean isDirectSeries;

    public LoadComponent(double value) {
        super(value);
    }

    private double addDirect(double otherValue) {
        return value + otherValue;
    }

    private double addReciprocal(double otherValue) {
        return 1 / ((1 / value) + (1 / otherValue));
    }

    /**
     * Returns the effective Component value when added in series.
     *
     * @param otherValue Component value.
     * @return Effective value.
     */
    public double addSeries(double otherValue) {
        if (isDirectSeries) {
            return addDirect(otherValue);
        } else {
            return addReciprocal(otherValue);
        }
    }

    /**
     * Returns the effective Component value when added in parallel.
     *
     * @param otherValue Component value.
     * @return Effective value.
     */
    public double addParallel(double otherValue) {
        if (!isDirectSeries) {
            return addDirect(otherValue);
        } else {
            return addReciprocal(otherValue);
        }
    }
}
