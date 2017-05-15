package CompilerError;

/**
 * Created by pprintz on 5/12/17.
 */
public class InvalidStructLitteralError extends Error {
    private String expectedStructLitteral;
    private String actualStructLitteral;

    public InvalidStructLitteralError(int columnNumber, int lineNumber, String expectedStructLitteral, String actualStructLitteral) {
        super(columnNumber, lineNumber);
        this.expectedStructLitteral = expectedStructLitteral;
        this.actualStructLitteral = actualStructLitteral;
    }

    @Override
    public String toString() {
        return lineNumber + ": expected struct litteral signature: " + expectedStructLitteral + ", got " + actualStructLitteral;
    }
}
