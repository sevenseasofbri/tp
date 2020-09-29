package seedu.duke.component;

public class Inductor extends Component {
    private static final String SI_UNIT = "µH";

    public Inductor(double value) {
        super(value);
    }

    /**
     * Returns String constituting value and unit of Inductor object.
     *
     * @return String representation of Inductor object.
     */
    @Override
    public String toString() {
        return (value) + SI_UNIT;
    }
}
