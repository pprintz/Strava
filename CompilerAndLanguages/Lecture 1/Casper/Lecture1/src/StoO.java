import java.util.ArrayList;
import java.util.List;

/**
 * Created by Casper on 01/02/2017.
 */
public class StoO {
    public List<Obj> _objects;

    public StoO(String string){
        _objects = new ArrayList<Obj>();

        String[] parts = string.split("\\s+");

        for (String s : parts) {
            _objects.add(new Obj(s));
        }
    }

    public void printAllObjects() {
        for (Obj object: _objects) {
            System.out.println(object.text);
        }
    }
}

class Obj {
    public String text;

    public Obj(String string){
        text = string;
    }
}
