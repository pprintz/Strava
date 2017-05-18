package CompilerError;

/**
 * Created by pprintz on 5/18/17.
 */
public class OverrideDefaultFunctionError extends Error {
    private String referenceName;
    private int conflictLine;
    public OverrideDefaultFunctionError(int columnNumber, int lineNumber, String referenceName, int conflictLine) {
        super(columnNumber, lineNumber);
        this.referenceName = referenceName;
        this.conflictLine= conflictLine;
    }

    @Override
    public String toString() {
        return lineNumber + ": function " + referenceName + " already defined in default at line " + conflictLine;
    }
}
