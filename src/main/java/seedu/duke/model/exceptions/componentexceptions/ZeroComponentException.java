package seedu.duke.model.exceptions.componentexceptions;

/**
 * The ZeroComponentException class inherits from the ComponentException class and
 * is thrown when the value entered is zero or negative.
 */
public class ZeroComponentException extends ComponentException {
    public ZeroComponentException() {
        super("You tried to enter a value <=0! Please use +ve real numbers for component values.");
    }
}
