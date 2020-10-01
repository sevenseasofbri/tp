package seedu.duke.component;

public class Resistor extends Component {
    private static final String SI_UNIT = "μH";

    public Resistor(double value){
        super(value);
    }
    /**
     * Returns the value and unit of Capacitor object.
     *
     * @return String of Capacitor value
     */
    @Override
    public String toString(){
        return (value) + SI_UNIT;
    }
}
