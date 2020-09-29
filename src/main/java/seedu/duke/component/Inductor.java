package seedu.duke.component;

public class Inductor extends Component {
    private static final String SI_UNIT = "µH";

    public Inductor(double value) {
        super(value);
    }

    @Override
    public String toString() {
        return (value) + SI_UNIT;
    }
}
