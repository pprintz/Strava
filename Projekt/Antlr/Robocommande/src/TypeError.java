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
        return lineNumber + ": " + " the actual type " + actualType + " doesn't match whit the expected type " + expectedType;
    }
}
