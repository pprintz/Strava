/**
 * Created by Teitur on 10-04-2017.
 */
public class TypeChecker extends Visitor {

    public void visit(AssignmentNode node){
        node.exprNode.Type
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
                if(node.leftNode.Type == Type.NUM && node.rigthNode.Type == Type.NUM){
                    node.Type = Type.NUM;
                }
                else{
                    Err();
                }
                break;
            case LESSTHANEQUAL:
                break;
            case GREATERTHANEQUAL:
                break;
            case POWER:
                break;
            case AND:
                break;
            case OR:
                break;
            case LESSTHAN:
                break;
            case GREATERTHAN:
                break;
            case EQUAL:
                break;
            case NOTEQUAL:
                break;
        }
    }

}
