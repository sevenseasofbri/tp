package seedu.duke.model.exceptions.templateexceptions;

/**
 * The GateToChannelsException class inherits from the TemplateException class and
 * is thrown when the user attempts to add logic gates to channels.
 */
public class GatesToChannelsException extends TemplateException {
    public GatesToChannelsException() {
        super("Cannot add gates to channels H, I, J, K, L, M, N, O! Try setting them instead.");
    }
}
