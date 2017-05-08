/**
 * Created by Teitur on 10-04-2017.
 */
public class TypeChecker extends Visitor {

    public Boolean programHasTypeErrors = false;

    private void TypeErrorOccured(ASTNode node){
        programHasTypeErrors = true;
        System.out.format("[%d:%d] Type error of unknown kind.\n", node.lineNumber, node.columnNumber);
    }

    private void TypeErrorOccured(ASTNode node, Type actualType, Type expectedType){
        programHasTypeErrors = true;

        System.out.format("[%d:%d] Type error: expected %s, got %s\n", node.lineNumber, node.columnNumber, expectedType, actualType);
    }

    private void TypeErrorOccured(ASTNode node, String actualTypeString, String expectedTypeString){
        programHasTypeErrors = true;
        System.out.format("[%d:%d] Type error: expected %s, got %s\n", node.lineNumber, node.columnNumber, expectedTypeString, actualTypeString);
    }

    private void TypeErrorOccured(ASTNode node, Type typeOne, Type typeTwo, Type expectedType){
        programHasTypeErrors = true;

        System.out.format("[%d:%d] Type error: expected two %s, got %s and %s\n", node.lineNumber, node.columnNumber, expectedType, typeOne, typeTwo);
    }

    private void TypeErrorOccured(ASTNode node, Type typeOne, Type typeTwo, Type expectedType, Type expectedTypeAlternative){
        programHasTypeErrors = true;

        System.out.format("[%d:%d] Type error: expected two of %s OR %s, got %s and %s\n", node.lineNumber, node.columnNumber, expectedType, expectedTypeAlternative, typeOne, typeTwo);
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
                else{
                    unaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(unaryExprNode, unaryExprNode.exprNode.Type, Type.BOOL);
                }
                break;
            case NEGATE:
                if(checkExpectedType(unaryExprNode, Type.NUM)){
                    unaryExprNode.Type = Type.NUM;
                }
                else {
                    unaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(unaryExprNode, unaryExprNode.exprNode.Type, Type.NUM);
                }
                break;
            default:
                unaryExprNode.Type = Type.ERROR;
                TypeErrorOccured(unaryExprNode);
        }
    }

    public void visit(BinaryExprNode binaryExprNode){
        visit((binaryExprNode.leftNode));
        visit((binaryExprNode.rightNode));

        switch (binaryExprNode.binaryOperator) {
            case PLUS:
                if(checkExpectedType(binaryExprNode, Type.TEXT)){
                    binaryExprNode.Type = Type.TEXT;
                    break;
                }
            case MINUS:
            case MULTIPLY:
            case DIVISION:
            case MODULO:
            case POWER:
                if(checkExpectedType(binaryExprNode, Type.NUM)){
                    binaryExprNode.Type = Type.NUM;
                }
                else {
                    binaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(binaryExprNode, binaryExprNode.leftNode.Type, binaryExprNode.rightNode.Type, Type.NUM, Type.TEXT);
                }
                break;

            case GREATERTHAN:
            case LESSTHANEQUAL:
            case GREATERTHANEQUAL:
            case LESSTHAN:
                if(checkExpectedType(binaryExprNode, Type.NUM)){
                    binaryExprNode.Type = Type.BOOL;
                }
                else{
                    binaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(binaryExprNode, binaryExprNode.leftNode.Type, binaryExprNode.rightNode.Type, Type.NUM, Type.TEXT);
                }
                break;
            case AND:
            case OR:
                if(checkExpectedType(binaryExprNode, Type.BOOL)){
                    binaryExprNode.Type = Type.BOOL;
                }
                else{
                    binaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(binaryExprNode, binaryExprNode.leftNode.Type, binaryExprNode.rightNode.Type, Type.BOOL);
                }
                break;
            case EQUAL:
            case NOTEQUAL:
                if(checkExpectedType(binaryExprNode, Type.BOOL)
                        || checkExpectedType(binaryExprNode, Type.NUM)) {
                    binaryExprNode.Type = Type.BOOL;
                }else{
                    binaryExprNode.Type = Type.ERROR;
                    TypeErrorOccured(binaryExprNode, binaryExprNode.leftNode.Type, binaryExprNode.rightNode.Type, Type.NUM, Type.BOOL);
                }
                break;
            default:
                binaryExprNode.Type = Type.ERROR;
                TypeErrorOccured(binaryExprNode);
        }
    }



    public void visit(ExprFunctionCallNode node){
        node.Type = node.defineFunctionNode.typeNode.Type;
        CompareActualToFormalParams(node, node.actualParams, node.defineFunctionNode.formalParamsNode);
    }

    public void visit(FunctionCallNode node){
        CompareActualToFormalParams(node, node.actualParams, node.defineFunctionNode.formalParamsNode);
    }

    private void CompareActualToFormalParams(ASTNode node, ActualParamsNode actualParamsNode, FormalParamsNode formalParamsNode){
        int actualParamsCount = actualParamsNode.exprs.size();

        if(actualParamsCount == formalParamsNode.typeNodes.size()){
            for(int i = 0; i < actualParamsCount; i++){
                TypeNode currentFormalTypeNode = formalParamsNode.typeNodes.get(i);
                ExprNode currentActualExprNode = actualParamsNode.exprs.get(i);
                CheckTypeAndExprMatch(node, currentFormalTypeNode, currentActualExprNode);
            }
        }else{
            System.out.println("Mismatch between number of formal and actual params");
        }
    }


    private boolean checkExpectedType(BinaryExprNode binaryExprNode, Type expectedType) {
        if(expectedType == Type.STRUCT){
            System.out.println("Don't call checkExpectedType with expectedType STRUCT");
            return false;
        }
        Boolean typesAreCompatible = false;

        if(binaryExprNode.leftNode.Type == expectedType && binaryExprNode.rightNode.Type == expectedType){
            typesAreCompatible = true;
        }
        else if(binaryExprNode.leftNode instanceof IdNode){
            IdNode idNode = (IdNode) binaryExprNode.leftNode;
            if(binaryExprNode.rightNode.Type == expectedType && idNode.declarationNode.Type == expectedType) {
                typesAreCompatible = true;
            }
        }
        else if(binaryExprNode.rightNode instanceof IdNode){
            IdNode idNode = (IdNode) binaryExprNode.rightNode;
            if(binaryExprNode.leftNode.Type == expectedType && idNode.declarationNode.Type == expectedType) {
                typesAreCompatible = true;
            }
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
        if(unaryExprNode.exprNode.Type.equals(expectedType) && unaryExprNode.exprNode.Type.equals(expectedType)){
            typesAreCompatible = true;
        }
        else if(unaryExprNode.exprNode instanceof IdNode){
            IdNode idNode = (IdNode) unaryExprNode.exprNode;
            if(unaryExprNode.exprNode.Type.equals(expectedType) && idNode.declarationNode.typeNode.type.equals(typeString)) {
                typesAreCompatible = true;
            }
        }

        return typesAreCompatible;
    }

    public void visit(LiteralNode node){
    }

    // a := 2
    // a := lol

    // struct != struct
    // struct != else
    // else != struct
    // else1 != else2



    public void visit(AssignmentNode node) {
        CheckTypeAndExprMatch(node, node.idNode.declarationNode.typeNode, node.exprNode);
    }

    private void CheckTypeAndExprMatch(ASTNode node, TypeNode typeNode, ExprNode exprNode){
        visit(exprNode);
        if(typeNode.Type == Type.STRUCT || exprNode.Type == Type.STRUCT){
            if(typeNode.Type == Type.STRUCT && exprNode.Type == Type.STRUCT){
                String rightSideTypeString;
                if(exprNode instanceof IdNode){
                    rightSideTypeString = ((IdNode) exprNode).declarationNode.typeNode.type;
                } else{
                    rightSideTypeString = ((StructInitializationNode) exprNode).typeNode.type;
                }
                if( ! typeNode.type.equals(rightSideTypeString)){
                    TypeErrorOccured(node, rightSideTypeString, typeNode.type );
                }
            } else if(typeNode.Type == Type.STRUCT){
                TypeErrorOccured(node, exprNode.Type.toString(), typeNode.type);
            } else {
                StructInitializationNode rightSide = (StructInitializationNode) exprNode;
                TypeErrorOccured(node, rightSide.typeNode.type, typeNode.Type.toString());
            }
        } else if(typeNode.Type != exprNode.Type) {
            TypeErrorOccured(node, exprNode.Type, typeNode.Type);
        }
    }

    public void visit(StructInitializationNode node){
        node.Type = Type.STRUCT;
        node.assignments.forEach((a) -> visit(a));
    }

    public void visit(FieldValueNode node){
        int lastIdIndex = node.idNodes.size() - 1;
        IdNode lastIdNode = node.idNodes.get(lastIdIndex);
        visit(lastIdNode);

        node.Type = lastIdNode.Type;
    }

    public void visit(IdNode node){
        if( ! node.isDeclaration){
            node.Type = node.declarationNode.typeNode.Type;
        }
    }


    public void visit(DeclarationNode node){
        node.Type = node.typeNode.Type;
        if(node.exprNode != null){
            visit(node.exprNode);
            if(node.Type == Type.STRUCT || node.exprNode.Type == Type.STRUCT){
                if(node.Type == Type.STRUCT && node.exprNode.Type == Type.STRUCT){
                    StructInitializationNode rightSide = (StructInitializationNode) node.exprNode;
                    if ( ! node.typeNode.type.equals(rightSide.typeNode.type)) {
                        TypeErrorOccured(node, rightSide.typeNode.type, node.typeNode.type);
                    } else{
                        node.idNode.Type = node.exprNode.Type; // Struct and Struct
                    }
                } else if(node.Type == Type.STRUCT){
                    TypeErrorOccured(node, node.exprNode.Type.toString(), node.typeNode.type);

                    node.Type = Type.ERROR;
                    node.idNode.Type = Type.ERROR;
                } else { // right side is struct
                    StructInitializationNode rightSide = (StructInitializationNode) node.exprNode;
                    TypeErrorOccured(node, rightSide.typeNode.type, node.Type.toString());

                    node.Type = Type.ERROR;
                    node.idNode.Type = Type.ERROR;
                }
            }

            else if(node.Type != node.exprNode.Type) {
                TypeErrorOccured(node, node.exprNode.Type, node.Type);
                node.Type = Type.ERROR;
                node.idNode.Type = Type.ERROR;
            }
        }
        else {
            node.idNode.Type = node.typeNode.Type;
        }
    }


    public void visit(DefineFunctionNode node){
        for(StmtNode stmtNode : node.blockNode.functionStmtNodes){
            if(stmtNode instanceof ReturnStatementNode){
                ReturnStatementNode returnStmt = (ReturnStatementNode) stmtNode;
                CheckTypeAndExprMatch(returnStmt, node.typeNode, returnStmt.exprNode);
            }
        }

    }

}
