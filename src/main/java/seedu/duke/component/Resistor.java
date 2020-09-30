package seedu.duke.component;

public class Resistor extends Component {
    private static final String SI_UNIT = "µH";

    public Resistor(double value){
        super(value);
    }
    //Returns String with value and SI unit of Resistor
    @Override
    public String toString(){
        return (value) + SI_UNIT;
    }
}
