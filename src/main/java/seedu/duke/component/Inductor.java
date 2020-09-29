package seedu.duke.component;

public class Inductor extends Component{
    protected final String UNIT = "µH";

    public Inductor(double value){
        super(value);
    }

    @Override
    public String toString(){
        return (value)+UNIT;
    }
}
