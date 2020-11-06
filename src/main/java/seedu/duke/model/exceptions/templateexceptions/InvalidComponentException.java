package seedu.duke.model.exceptions.templateexceptions;

public class InvalidComponentException extends TemplateException {
    public InvalidComponentException(String s) {
        super("You've tried to use a " + s + " in a circuit template that doesn't support " + s + ".\n\tIf you want to "
                + "use " + s + " in your circuit, then consider trying out " + (s.equals("l") ? "template lc or "
                + "template rl" : s.equals("c") ? "template lc or template rc" :
            "template or template rl or template rc") + "\n\tinstead.");
    }
}
