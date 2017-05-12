/**
 * Created by pprintz on 5/12/17.
 */
public class RedeclarationError extends Error{
    private String referenceName;
    public RedeclarationError(int columnNumber, int lineNumber, String referenceName) {
        super(columnNumber, lineNumber);
    }

    @Override
    public String toString() {
        return lineNumber + ": " + referenceName + " redeclared in this scope";
    }
}
