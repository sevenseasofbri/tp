package seedu.duke.model.exceptions.templateexceptions;

public class GatesToChannelsException extends TemplateException {
    public GatesToChannelsException() {
        super("Cannot add gates to channels H, I, J, K, L, M, N, O! Try setting them instead.");
    }
}
