package CompilerWarning;

/**
 * Created by pprintz on 5/19/17.
 */
public class UnusedVariableWarning extends CompilerError.Error {
    String referenceName;
    public UnusedVariableWarning(int columnNumber, int lineNumber, String referenceName) {
        super(columnNumber, lineNumber);
        this.referenceName = referenceName;
    }

    @Override
    public String toString() {
        return lineNumber + ": unused variable \'" + referenceName + "\'";
    }
}
