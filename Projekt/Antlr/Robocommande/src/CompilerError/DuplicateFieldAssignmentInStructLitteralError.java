package CompilerError;

/**
 * Created by pprintz on 5/12/17.
 */
public class DuplicateFieldAssignmentInStructLitteralError extends Error {
    String referenceName;
    public DuplicateFieldAssignmentInStructLitteralError(int columnNumber, int lineNumber, String referenceName) {
        super(columnNumber, lineNumber);
        this.referenceName = referenceName;
    }

    @Override
    public String toString() {
        return lineNumber + ": duplicate field assignment in struct litteral: " + referenceName;
    }
}
