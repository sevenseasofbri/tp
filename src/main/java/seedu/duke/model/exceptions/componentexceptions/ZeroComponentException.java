package seedu.duke.model.exceptions.componentexceptions;

public class ZeroComponentException extends ComponentException {
    public ZeroComponentException() {
        super("You tried to enter a value <=0! Please use +ve real numbers for component values.");
    }
}
