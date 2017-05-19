package CompilerWarning;

/**
 * Created by pprintz on 5/19/17.
 */
public class UnreachableCodeWarning extends CompilerError.Error {
    private int unreachableCodeEnd;
    public UnreachableCodeWarning(int columnNumber, int lineNumber, int unreachableCodeEnd) {
        super(columnNumber, lineNumber);
        this.unreachableCodeEnd = unreachableCodeEnd;
    }

    @Override
    public String toString() {
        return lineNumber + "-" + unreachableCodeEnd + ": " + "Unreachable code";
    }
}
