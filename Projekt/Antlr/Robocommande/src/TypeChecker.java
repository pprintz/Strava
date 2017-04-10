/**
 * Created by Teitur on 10-04-2017.
 */
public class TypeChecker extends Visitor {

    public void visit(AssignmentNode node){
     //   node.exprNode.Type
    }

    private void Err(){
        System.out.println("ERROR TYPE.");
    }

    public void visit(BinaryExprNode node){
        switch (node.binaryOperator) {
            case PLUS:
            case MINUS:
            case MULTIPLY:
            case DIVISION:
            case MODULO:
            case POWER:
                if(checkExpectedType(node, Type.NUM)){
                    node.Type = Type.NUM;
                }
                break;

            case GREATERTHAN:
            case LESSTHANEQUAL:
            case GREATERTHANEQUAL:
            case LESSTHAN:
                if(checkExpectedType(node, Type.NUM)){
                    node.Type = Type.BOOL;
                }
                break;
            case AND:
            case OR:
                if(checkExpectedType(node, Type.BOOL)){
                    node.Type = Type.BOOL;
                }
                break;
            case EQUAL:
            case NOTEQUAL:
                if(checkExpectedType(node, Type.BOOL)
                        || checkExpectedType(node, Type.BOOL)) {
                    node.Type = Type.BOOL;
                }
                break;
        }
    }

    private boolean checkExpectedType(BinaryExprNode node, Type expectedType) {
        if(expectedType == Type.TEXT || expectedType == Type.STRUCT){
            System.exit(0);
        }
        Boolean typesAreCompatible = false;
        String typeString = expectedType == Type.BOOL ? "bool" : "num";

        if(node.leftNode.Type == expectedType && node.rightNode.Type == expectedType){
            typesAreCompatible = true;
        }
        else if(node.leftNode instanceof IdNode){
            IdNode idNode = (IdNode) node.leftNode;
            if(node.rightNode.Type == expectedType && idNode.declarationNode.typeNode.type.equals(typeString)) {
                typesAreCompatible = true;
            }
        }
        else if(node.rightNode instanceof IdNode){
            IdNode idNode = (IdNode) node.leftNode;
            if(node.leftNode.Type == expectedType && idNode.declarationNode.typeNode.type.equals(typeString)) {
                typesAreCompatible = true;
            }
        }

        return typesAreCompatible;
    }

//    private boolean checkExpectedType(UnaryExprNode node, Type expectedType) {
//        if(expectedType == Type.TEXT || expectedType == Type.STRUCT){
//            System.exit(0);
//        }
//        Boolean typesAreCompatible = false;
//        String typeString = expectedType == Type.BOOL ? "bool" : "num";
//
//        if(node.leftNode.Type == expectedType && node.rightNode.Type == expectedType){
//            typesAreCompatible = true;
//        }
//        else if(node.leftNode instanceof IdNode){
//            IdNode idNode = (IdNode) node.leftNode;
//            if(node.rightNode.Type == expectedType && idNode.declarationNode.typeNode.type.equals(typeString)) {
//                typesAreCompatible = true;
//            }
//        }
//        else if(node.rightNode instanceof IdNode){
//            IdNode idNode = (IdNode) node.leftNode;
//            if(node.leftNode.Type == expectedType && idNode.declarationNode.typeNode.type.equals(typeString)) {
//                typesAreCompatible = true;
//            }
//        }
//
//        return typesAreCompatible;
//    }

}
