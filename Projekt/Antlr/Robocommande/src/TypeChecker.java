/**
 * Created by Teitur on 10-04-2017.
 */
public class TypeChecker extends Visitor {


    private void Err(){
        System.out.println("ERROR TYPE.");
    }

    private void SUCCESS( String msg) {System.out.println(msg);}

    public void visit(IdNode node){
        switch(node.declarationNode.typeNode.type){
            case "num":
                node.Type = Type.NUM;
                break;
            case "text":
                node.Type = Type.TEXT;
                break;
            case "bool":
                node.Type = Type.BOOL;
                break;
            default:
                node.Type = Type.STRUCT;
        }
    }

    public void visit(UnaryExprNode node){
        switch (node.unaryOperator) {
            case PARANTHESIS:
                visit(node.exprNode);
                break;
            case NEGATEBOOL:
                if(checkExpectedTypeUnary(node, Type.BOOL)){
                    node.Type = Type.BOOL;
                }
                break;
            case NEGATE:
                if(checkExpectedTypeUnary(node, Type.NUM)){
                    node.Type = Type.NUM;
                }
                break;
        }
    }


    public void visit(BinaryExprNode node){
        visit(node.leftNode);
        visit(node.rightNode);
        switch (node.binaryOperator) {
            case PLUS:
            case MINUS:
            case MULTIPLY:
            case DIVISION:
            case MODULO:
            case POWER:
                if(checkExpectedTypeBinary(node, Type.NUM)){
                    node.Type = Type.NUM;
                    SUCCESS("IS NOW TYPE NUM!");
                }
                break;

            case GREATERTHAN:
            case LESSTHANEQUAL:
            case GREATERTHANEQUAL:
            case LESSTHAN:
                if(checkExpectedTypeBinary(node, Type.NUM)){
                    node.Type = Type.BOOL;
                    SUCCESS("IS NOW TYPE BOOL!");
                }
                break;
            case AND:
            case OR:
                if(checkExpectedTypeBinary(node, Type.BOOL)){
                    node.Type = Type.BOOL;
                }
                break;
            case EQUAL:
            case NOTEQUAL:
                if(checkExpectedTypeBinary(node, Type.BOOL)
                        || checkExpectedTypeBinary(node, Type.BOOL)) {
                    node.Type = Type.BOOL;
                }
                break;
        }
    }

    private boolean checkExpectedTypeBinary(BinaryExprNode node, Type expectedType) {
        if(expectedType == Type.TEXT || expectedType == Type.STRUCT){
            System.exit(0);
        }
        Boolean typesAreCompatible = false;

        if(node.leftNode.Type == expectedType && node.rightNode.Type == expectedType){
            typesAreCompatible = true;
        }
        return typesAreCompatible;
    }

    private boolean checkExpectedTypeUnary(UnaryExprNode node, Type expectedType) {
        if(expectedType == Type.TEXT || expectedType == Type.STRUCT){
            System.exit(0);
        }
        Boolean typesAreCompatible = false;
        String typeString = expectedType == Type.BOOL ? "bool" : "num";

        if(node.exprNode.Type == expectedType){
            typesAreCompatible = true;
        }
        return typesAreCompatible;
    }

}
