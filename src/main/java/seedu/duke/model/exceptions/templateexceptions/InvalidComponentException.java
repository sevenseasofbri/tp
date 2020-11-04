package seedu.duke.model.exceptions.templateexceptions;

public class InvalidComponentException extends TemplateException {
    public InvalidComponentException(String s) {
        super("You've tried to set a " + s + " in a circuit template that doesn't support " + s + ".\nIf you want to "
                + "use " + s + " in your circuit, then consider trying out " + (s.equals("l") ? "lc or rl" :
                s.equals("c") ? "lc or rc" : "r or rl or rc" + " templates instead."));
    }
}
