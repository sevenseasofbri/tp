package seedu.duke.logic.commands.exceptions;

/**
 * The ComponentNotSetException class inherits from CommandException
 * and is thrown if the component has yet to be set.
 */
public class ComponentNotSetException extends CommandException {
    public ComponentNotSetException() {
        super("Component not yet set! Use the 'set' command to set the value of components.");
    }
}
