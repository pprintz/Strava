public class MissingReturnError extends Error{

    private String functionName;

    public MissingReturnError(int columnNumber, int lineNumber, String functionName) {
        super(columnNumber, lineNumber);
        this.functionName = functionName;
    }

    @Override
    public String toString() {
        return lineNumber + "/" + columnNumber + ": " + "Missing return in " + functionName;
    }
}
