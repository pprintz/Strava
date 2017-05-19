package CompilerWarning;

/**
 * Created by pprintz on 5/19/17.
 */
public class UnusedFunctionWarning extends CompilerError.Error {
    private String referenceName;
    public UnusedFunctionWarning(int columnNumber, int lineNumber, String referenceName) {
        super(columnNumber, lineNumber);
        this.referenceName = referenceName;
    }

    @Override
    public String toString() {
        return lineNumber + ": unused function \'" + referenceName + "\'";
    }
}
