package CompilerError;

import java.lang.*;

/**
 * Created by pprintz on 5/11/17.
 */
public class ParameterMismatchError extends Error {
    private String expectedSignature;
    private String actualSignature;

    public ParameterMismatchError(int columnNumber, int lineNumber, String expectedSignature, String actualSignature) {
        super(columnNumber, lineNumber);
        this.expectedSignature = expectedSignature;
        this.actualSignature = actualSignature;
    }

    @Override
    public String toString() {
        return lineNumber + ": " + "expected parameters of type: " + expectedSignature + ", got " + actualSignature;
    }
}
