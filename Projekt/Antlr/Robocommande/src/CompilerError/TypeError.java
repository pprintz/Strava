package CompilerError;

import java.lang.*;

/**
 * Created by Teitur on 10-05-2017.
 */
public class TypeError extends Error {

    private String actualType;
    private String expectedType;

    public TypeError(int columnNumber, int lineNumber, String actualType, String expectedType ) {
        super(columnNumber, lineNumber);
        this.actualType = actualType;
        this.expectedType = expectedType;
    }
    @Override
    public String toString() {
        return lineNumber + ": " + "expected type " + expectedType + ", got " + actualType;
    }
}
