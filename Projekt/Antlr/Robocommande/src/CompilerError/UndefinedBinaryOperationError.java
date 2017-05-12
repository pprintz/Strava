package CompilerError;

import Enums.BinaryOperator;

import java.lang.*;

/**
 * Created by pprintz on 5/10/17.
 */
public class UndefinedBinaryOperationError extends Error {
    private String leftOperandType;
    private String rightOperandType;
    private BinaryOperator binaryOperator;
    private String[] expectedTypes;

    public UndefinedBinaryOperationError(int columnNumber, int lineNumber, String leftOperandType,
                                         String rightOperandType, BinaryOperator binaryOperator, String... expectedTypes) {
        super(columnNumber, lineNumber);
        this.leftOperandType = leftOperandType;
        this.rightOperandType = rightOperandType;
        this.binaryOperator = binaryOperator;
        this.expectedTypes = expectedTypes;
    }
    @Override
    public String toString() {
        String s = lineNumber + ": Invalid operation -> " + leftOperandType + " " + binaryOperator + " " +  rightOperandType + " " +
                "(operator \'" + binaryOperator + "\' is defined for: ";
        for(int i = 0; i < expectedTypes.length; i++){
            s += expectedTypes[i];
            if( i < expectedTypes.length-1){
               s += ", ";
            }
        }
        s += ")";
        return s;
    }
}
