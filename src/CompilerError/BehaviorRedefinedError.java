package CompilerError;

/**
 * Created by pprintz on 5/24/17.
 */
public class BehaviorRedefinedError extends Error {
    private String behaviorName;
    private int number;
    public BehaviorRedefinedError(int columnNumber, int lineNumber, String behaviorName, int number) {
        super(columnNumber, lineNumber);
        this.behaviorName = behaviorName;
        this.number = number;
    }

    @Override
    public String toString() {
        return lineNumber + ": behavior " + behaviorName + " already declared at line " + number;
    }
}
