package seedu.duke.model.component;

import seedu.duke.model.exceptions.componentexceptions.ZeroComponentException;

/**
 * The LoadComponent class inherits from the Component class
 * and is used to create LoadComponent objects.
 */
public abstract class LoadComponent extends Component {
    protected boolean isDirectSeries;

    public LoadComponent(double value) {
        super(value);
    }

    private double addDirect(double otherValue) throws ZeroComponentException {
        if (otherValue <= 0) {
            throw new ZeroComponentException();
        }
        return value + otherValue;
    }

    private double addReciprocal(double otherValue) throws ZeroComponentException {
        if (otherValue <= 0) {
            throw new ZeroComponentException();
        }
        if (value != 0) {
            return 1 / ((1 / value) + (1 / otherValue));
        } else {
            return otherValue;
        }
    }

    /**
     * Returns the effective Component value when added in series.
     *
     * @param otherValue Component value.
     * @return Effective value.
     * @throws ZeroComponentException If value or otherValue is <=0.
     */
    public double addSeries(double otherValue) throws ZeroComponentException {
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
     * @throws ZeroComponentException If value or otherValue is non-positive.
     */
    public double addParallel(double otherValue) throws ZeroComponentException {
        if (!isDirectSeries) {
            return addDirect(otherValue);
        } else {
            return addReciprocal(otherValue);
        }
    }
}
