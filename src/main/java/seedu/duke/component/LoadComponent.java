package seedu.duke.component;

import seedu.duke.Duke;
import seedu.duke.DukeException;

public abstract class LoadComponent extends Component {
    protected boolean isDirectSeries;

    public LoadComponent(double value) {
        super(value);
    }

    private double addDirect(double otherValue) throws DukeException {
        if (value <= 0 || otherValue <= 0) {
            throw new DukeException("Invalid value (<=0)");
        }
        return value + otherValue;
    }

    private double addReciprocal(double otherValue) throws DukeException {
        if (value <= 0 || otherValue <= 0) {
            throw new DukeException("Invalid value (<=0)");
        }
        return 1 / ((1 / value) + (1 / otherValue));
    }

    /**
     * Returns the effective Component value when added in series.
     *
     * @param otherValue Component value.
     * @return Effective value.
     * @throws DukeException If value or otherValue is non-positive.
     */
    public double addSeries(double otherValue) throws DukeException {
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
     * @throws DukeException If value or otherValue is non-positive.
     */
    public double addParallel(double otherValue) throws DukeException {
        if (!isDirectSeries) {
            return addDirect(otherValue);
        } else {
            return addReciprocal(otherValue);
        }
    }
}
