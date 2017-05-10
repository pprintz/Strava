/**
 * Created by pprintz on 5/10/17.
 */
public class UndefinedUnaryOperationError extends Error{
    private String operand;
    private UnaryOperator unaryOperator;
    private String validType;

    public UndefinedUnaryOperationError(int columnNumber, int lineNumber, String operand, UnaryOperator unaryOperator, String validType ) {
        super(columnNumber, lineNumber);
        this.operand = operand;
        this.unaryOperator = unaryOperator;
        this.validType = validType;
    }
    @Override
    public String toString() {
        String s = lineNumber + ": Invalid operation -> " + unaryOperator + " " + operand +  " " +
                "(operator \'" + unaryOperator + "\' is defined for: " + validType + ")";
        return s;
    }
}
