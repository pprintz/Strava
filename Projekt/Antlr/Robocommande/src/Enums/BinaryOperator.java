package Enums;

public enum BinaryOperator{
    PLUS,
    MINUS,
    MULTIPLY,
    DIVISION,
    MODULO,
    LESSTHANEQUAL,
    GREATERTHANEQUAL,
    POWER,
    AND,
    OR,
    LESSTHAN,
    GREATERTHAN,
    EQUAL,
    NOTEQUAL;

    @Override
    public String toString() {
        String stringRep = "";
        switch(this) {
            case OR:
                stringRep = "or";
                break;
            case AND:
                stringRep = "and";
                break;
            case PLUS:
                stringRep = "+";
                break;
            case EQUAL:
                stringRep = "=";
                break;
            case MINUS:
                stringRep = "-";
                break;
            case POWER:
                stringRep = "^";
                break;
            case MODULO:
                stringRep = "%";
                break;
            case DIVISION:
                stringRep = "/";
                break;
            case GREATERTHANEQUAL:
                stringRep = ">=";
                break;
            case LESSTHAN:
                stringRep = "<";
                break;
            case MULTIPLY:
                stringRep = "*";
                break;
            case NOTEQUAL:
                stringRep = "!=";
                break;
            case GREATERTHAN:
                stringRep = ">";
                break;
            case LESSTHANEQUAL:
                stringRep = "<=";
                break;
        }
        return stringRep;
    }
}
