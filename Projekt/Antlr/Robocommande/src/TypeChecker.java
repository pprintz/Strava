/**
 * Created by Teitur on 10-04-2017.
 */
public class TypeChecker extends Visitor {

    public Boolean programHasTypeErrors = false;

    private void TypeErrorOccured(Type actualType, Type expectedType){
        programHasTypeErrors = true;

        System.out.println("Type error occured. The type was: " + actualType +
                ", but the expected type was: " + expectedType);
    }

    private void TypeErrorOccured(Type typeOne, Type typeTwo, Type expectedType){
        programHasTypeErrors = true;

        System.out.println("Type error occured. The type were: " + typeOne + " and " +
                typeTwo + ", but the expected type was: " + expectedType);
    }

    public void visit(UnaryExprNode unaryExprNode){
        switch (unaryExprNode.unaryOperator) {
            case PARANTHESIS:
                // empty since PARANTHESIS has nothing to do with types
                break;
            case NEGATEBOOL:
                if(checkExpectedType(unaryExprNode, Type.BOOL)){
                    unaryExprNode.Type = Type.BOOL;
                }
                break;
            case NEGATE:
                if(checkExpectedType(unaryExprNode, Type.NUM)){
                    unaryExprNode.Type = Type.NUM;
                }
                break;
            default:
                System.out.println("Type checking unaryExpression went horribly wrong.");
        }
    }

    public void visit(BinaryExprNode binaryExprNode){
        switch (binaryExprNode.binaryOperator) {
            case PLUS:
            case MINUS:
            case MULTIPLY:
            case DIVISION:
            case MODULO:
            case POWER:
                if(checkExpectedType(binaryExprNode, Type.NUM)){
                    binaryExprNode.Type = Type.NUM;
                }
                break;

            case GREATERTHAN:
            case LESSTHANEQUAL:
            case GREATERTHANEQUAL:
            case LESSTHAN:
                if(checkExpectedType(binaryExprNode, Type.NUM)){
                    binaryExprNode.Type = Type.BOOL;
                }
                break;
            case AND:
            case OR:
                if(checkExpectedType(binaryExprNode, Type.BOOL)){
                    binaryExprNode.Type = Type.BOOL;
                }
                break;
            case EQUAL:
            case NOTEQUAL:
                if(checkExpectedType(binaryExprNode, Type.BOOL)
                        || checkExpectedType(binaryExprNode, Type.BOOL)) {
                    binaryExprNode.Type = Type.BOOL;
                }
                break;
            default:
                System.out.println("Type checking binaryExpression went horribly wrong.");
        }
    }

    private boolean checkExpectedType(BinaryExprNode binaryExprNode, Type expectedType) {
        if(expectedType == Type.TEXT || expectedType == Type.STRUCT){
            System.out.println("Don't call checkExpectedType with expectedType TEXT or STRUCT");
            return false;
        }
        Boolean typesAreCompatible = false;

        // TODO do smarter
        String typeString = expectedType == Type.BOOL ? "bool" : "num";

        if(binaryExprNode.leftNode.Type == expectedType && binaryExprNode.rightNode.Type == expectedType){
            typesAreCompatible = true;
        }
        else if(binaryExprNode.leftNode instanceof IdNode){
            IdNode idNode = (IdNode) binaryExprNode.leftNode;
            if(binaryExprNode.rightNode.Type == expectedType && idNode.declarationNode.typeNode.type.equals(typeString)) {
                typesAreCompatible = true;
            }
        }
        else if(binaryExprNode.rightNode instanceof IdNode){
            IdNode idNode = (IdNode) binaryExprNode.leftNode;
            if(binaryExprNode.leftNode.Type == expectedType && idNode.declarationNode.typeNode.type.equals(typeString)) {
                typesAreCompatible = true;
            }
        }
        if(typesAreCompatible == false){
            TypeErrorOccured(binaryExprNode.leftNode.Type, binaryExprNode.rightNode.Type, expectedType);
        }
        return typesAreCompatible;
    }

    private boolean checkExpectedType(UnaryExprNode unaryExprNode, Type expectedType) {
        if(expectedType == Type.TEXT || expectedType == Type.STRUCT){
            System.out.println("Don't call checkExpectedType with expectedType TEXT or STRUCT");
            return false;
        }
        Boolean typesAreCompatible = false;
        String typeString = null;

        // TODO this if else needs to be handled smarter
        if(expectedType == Type.BOOL){
            typeString = "bool";
        }
        else if(expectedType == Type.NUM){
            typeString = "num";
        }

        if(unaryExprNode.exprNode.Type == expectedType && unaryExprNode.exprNode.Type == expectedType){
            typesAreCompatible = true;
        }
        else if(unaryExprNode.exprNode instanceof IdNode){
            IdNode idNode = (IdNode) unaryExprNode.exprNode;
            if(unaryExprNode.exprNode.Type == expectedType && idNode.declarationNode.typeNode.type.equals(typeString)) {
                typesAreCompatible = true;
            }
        }
        else if(unaryExprNode.exprNode instanceof IdNode){
            IdNode idNode = (IdNode) unaryExprNode.exprNode;
            if(unaryExprNode.exprNode.Type == expectedType && idNode.declarationNode.typeNode.type.equals(typeString)) {
                typesAreCompatible = true;
            }
        }

        if(typesAreCompatible == false){
            TypeErrorOccured(unaryExprNode.exprNode.Type, unaryExprNode.exprNode.Type, expectedType);
        }

        return typesAreCompatible;
    }

}
