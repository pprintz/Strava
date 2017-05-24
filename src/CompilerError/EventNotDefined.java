package CompilerError;

/**
 * Created by pprintz on 5/24/17.
 */
public class EventNotDefined extends Error{
    private String eventName;
    public EventNotDefined(int columnNumber, int lineNumber, String eventName) {
        super(columnNumber, lineNumber);
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return lineNumber + ": there is no event called " + eventName;
    }
}
