package CompilerError;

/**
 * Created by pprintz on 5/18/17.
 */
public class ShadowingError extends Error{
    private String referenceName;
    private int conflictLine;
    public ShadowingError(int columnNumber, int lineNumber, String referenceName, int conflictLine) {
        super(columnNumber, lineNumber);
        this.referenceName = referenceName;
        this.conflictLine = conflictLine;
    }

    @Override
    public String toString() {
        return lineNumber + ": " + referenceName + " already defined in outer scope (at line " + conflictLine + ")";
    }
}
