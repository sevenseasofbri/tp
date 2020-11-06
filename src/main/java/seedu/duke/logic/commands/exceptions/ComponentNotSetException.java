package seedu.duke.logic.commands.exceptions;

public class ComponentNotSetException extends CommandException {
    public ComponentNotSetException() {
        super("Component not yet set! Use the 'set' command to set the value of components.");
    }
}
