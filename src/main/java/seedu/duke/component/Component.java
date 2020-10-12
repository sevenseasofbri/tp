package seedu.duke.component;

import seedu.duke.DukeException;

public abstract class Component {
    protected double value;
    protected String siUnit;


    public Component(double value) {
        this.value = value;
    }

    /**
     * Returns the value of the Component.
     *
     * @return Value of Component.
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the Component.
     *
     * @param value Value of Component.
     */
    public void setValue(double value) {
        if(value > 0){
            this.value = value;
        }
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
