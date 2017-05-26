package CompilerError;

/**
 * Created by pprintz on 5/26/17.
 */
public class ReturnInBehaviorSetupError extends Error{
    public ReturnInBehaviorSetupError(int columnNumber, int lineNumber) {
        super(columnNumber, lineNumber);
    }

    @Override
    public String toString() {
        return lineNumber + ": can not return behavior";
    }
}
