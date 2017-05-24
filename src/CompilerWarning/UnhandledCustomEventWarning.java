package CompilerWarning;

/**
 * Created by pprintz on 5/24/17.
 */
public class UnhandledCustomEventWarning extends CompilerError.Error {

    private String eventName;
    public UnhandledCustomEventWarning(int columnNumber, int lineNumber, String eventName) {
        super(columnNumber, lineNumber);
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return lineNumber + ": " + eventName + " is never handled by a behavior";
    }
}
