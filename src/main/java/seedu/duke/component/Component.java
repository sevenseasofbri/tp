package seedu.duke.component;

public abstract class Component {
    protected double value;
    protected String siUnit;

    public Component(double value) {
        this.value = value;
    }

    /**
     * Returns the value and unit of Component object.
     *
     * @return String representation of Component value
     */
    @Override
    public String toString() {
        return (value) + " " + siUnit;
    }
}
