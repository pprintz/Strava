/**
 * Created by Casper on 27/03/2017.
 */
public class PrettyPrintVisitor extends Visitor {
    int indentationLevel = 0;

    private String indent(){
        return new String(new char[indentationLevel]).replace("\0", "    ");
    }

    @Override
    public void visit(ActualParamsNode node) {
        int len = node.exprs.size();
        for(int i = 0; i < len; i++ ){
            if(i == len-1) visit(node.exprs.get(i));
            else {
                visit(node.exprs.get(i));
                System.out.print(", ");
            }
        }

    }

    @Override
    public void visit(TypeNode node) {
    }

    @Override
    public void visit(ASTNode node) {
        super.visit(node);
    }

    @Override
    public void visit(FunctionStmtNode node) {
        super.visit(node);
    }

    @Override
    public void visit(GeneralStmtNode node) {
        System.out.print(indent());
        super.visit(node);
        System.out.println();
    }

    @Override
    public void visit(AssignmentNode node) {
        System.out.print(indent() + "ASSIGN ");
        node.idNode.accept(this);
        System.out.print(" := ");
        node.exprNode.accept(this);
        System.out.println();
    }

    @Override
    public void visit(BehaviorFunctionNode node) {
        System.out.print(indent() + "BEHAVIOR ");
        visit(node.idNode);
        System.out.println("(" + node.eventType.type + " " + node.idNode.id + ")");
        indentationLevel++;
        visit(node.blockNode);
        indentationLevel--;
    }

    @Override
    public void visit(BlockNode node) {
        indentationLevel++;
        super.visit(node);
        System.out.println();
        indentationLevel--;
    }

    @Override
    public void visit(DeclarationNode node) {
        System.out.print(indent() + "DECLARE ");
        System.out.print(node.typeNode.type + " ");
        visit(node.idNode);
        if(node.exprNode != null) {
            System.out.print(" := ");
            visit(node.exprNode);
        }
        System.out.println();
    }

    @Override
    public void visit(DefaultStrategyNode node) {
        System.out.println(indent() + "DEFAULT STRATEGY ");
        indentationLevel++;
        super.visit(node);
        indentationLevel--;
    }

    @Override
    public void visit(DefineFunctionNode node) {
        System.out.print(indent() + "DEFINE ");
        visit(node.idNode);
        System.out.print("(");
        visit(node.formalParamsNode);
        System.out.print(")");
        System.out.println(" RETURNS " + node.typeNode.type);

        if(node.blockNode != null) {
            indentationLevel++;
            visit(node.blockNode);
            indentationLevel--;
        }
    }



    @Override
    public void visit(ElseIfStatementNode node) {
        System.out.print(indent() + "ELSE IF ");
        visit(node.predicate);
        System.out.println();
        visit(node.blockNode);
    }


    @Override
    public void visit(FieldAssignmentNode node) {
        System.out.print(indent() + "ASSIGN ");
        visit(node.fieldIdNode);
        System.out.print(" := ");
        visit(node.exprNode);
        System.out.println();
    }

    @Override
    public void visit(FieldIdNode node)
    {
        int len = node.idNodes.size();
        for(int i = 0; i < len; i++){
           visit(node.idNodes.get(i));
           if(i < len-1) System.out.print(".");
        }
    }

    @Override
    public void visit(FormalParamsNode node) {
        int len = node.idNodes.size();
        for(int i = 0; i < len; i++ ){
            System.out.print(node.typeNodes.get(i).type + " ");
            visit(node.idNodes.get(i));
            if(i < len-1)
                System.out.print(", ");
        }
    }

    @Override
    public void visit(FunctionCallNode node) {
        System.out.print(indent() + "CALL ");
        if(node.idNode != null) visit(node.idNode);
        else visit(node.fieldIdNode);
        System.out.print("(");
        if(node.actualParams != null) visit(node.actualParams);
        System.out.print(")\n");

    }

    @Override
    public void visit(FunctionsNode node) {
        super.visit(node);
    }

    @Override
    public void visit(IdNode node) {
        System.out.print(node.id);
    }

    @Override
    public void visit(IfStatementNode node) {
        System.out.print(indent() + "IF ");
        visit(node.predicate);
        System.out.println();
        visit(node.ifBlockNode);
        for(ElseIfStatementNode elif : node.elseIfNodes){
            visit(elif);
        }
        if(node.elseBlockNode != null){
            System.out.print(indent() + "ELSE ");
            System.out.println();
            visit(node.elseBlockNode);
        }
    }

    @Override
    public void visit(ExprFunctionCallNode node) {
        System.out.print("CALL ");
        if(node.idNode != null)
            visit(node.idNode);
        else  if (node.fieldIdNode != null) visit(node.fieldIdNode);
        System.out.print("(");
        if(node.actualParams != null)
        visit(node.actualParams);
        System.out.print(")");
    }

    @Override
    public void visit(BinaryExprNode node) {
        switch (node.binaryOperator) {
            case PLUS:
                binaryStatements(node, "+");
                break;
            case MINUS:
                binaryStatements(node, "-");
                break;
            case MULTIPLY:
                binaryStatements(node, "*");
                break;
            case DIVISION:
                binaryStatements(node, "/");
                break;
            case MODULO:
                binaryStatements(node, "%");
                break;
            case LESSTHANEQUAL:
                binaryStatements(node, "<=");
                break;
            case GREATERTHANEQUAL:
                binaryStatements(node, ">=");
                break;
            case POWER:
                binaryStatements(node, "^");
                break;
            case AND:
                binaryStatements(node, "and");
                break;
            case OR:
                binaryStatements(node, "or");
                break;
            case LESSTHAN:
                binaryStatements(node, "<");
                break;
            case GREATERTHAN:
                binaryStatements(node, ">");
                break;
            case EQUAL:
                binaryStatements(node, "=");
                break;
            case NOTEQUAL:
                binaryStatements(node, "!=");
                break;
        }
    }

    private void binaryStatements(BinaryExprNode node, String symbol) {
        if (node.leftNode != null) visit(node.leftNode);
        System.out.print(" " + symbol + " ");
        if (node.rigthNode != null) visit(node.rigthNode);
    }

    @Override
    public void visit(UnaryExprNode node) {
        super.visit(node);
    }

    @Override
    public void visit(NewEventNode node) {
        super.visit(node);
    }

    @Override
    public void visit(LiteralNode node) {
        System.out.print(node.literalText);
    }

    @Override
    public void visit(LoopNode node) {
        System.out.print(indent() + "LOOP ");
        if(node.exprNode != null) System.out.print("WHILE ");
        visit(node.exprNode);
        System.out.println();
        visit(node.block);
    }

    @Override
    public void visit(ProgNode node) {
        super.visit(node);
    }

    @Override
    public void visit(ReturnStatementNode node) {
        System.out.print(indent() + "RETURN ");
        super.visit(node);
        System.out.println();
    }

    @Override
    public void visit(RunNode node) {
        System.out.println(indent() + "ON RUN ");
        visit(node.blockNode);
    }

    @Override
    public void visit(SetupBlockNode node) {
        indentationLevel++;
        super.visit(node);
        System.out.println();
        indentationLevel--;
    }


    @Override
    public void visit(SetupNode node) {
        System.out.print("SETUP: \n");
        super.visit(node);
    }

    @Override
    public void visit(SetupStmtNode node) {
        System.out.print(indent());
        super.visit(node);
    }

    public void visit(StmtNode node) {
        System.out.print(indent());
        super.visit(node);
    }

    @Override
    public void visit(StrategyDefinitionNode node) {
        super.visit(node);
    }

    @Override
    public void visit(StrategyNode node) {
        System.out.print(indent() + "STRATEGY ");
        visit(node.idNode);
        System.out.println();
        indentationLevel++;
        visit(node.strategyDefinition);
        indentationLevel--;
    }

    @Override
    public void visit(StructDefinitionNode node) {
        System.out.print(indent() + "STRUCT ");
        indentationLevel++;
        System.out.println("{ ");
        for(DeclarationNode declNode : node.declarationNodes){
            System.out.print(indent() + declNode.typeNode.type + " " + declNode.idNode.id);
            if(declNode.exprNode != null) {
                System.out.print(" := ");
                visit(declNode.exprNode);
            }
            System.out.println();
        }
        indentationLevel--;
        System.out.println(indent() + "}");
    }

    @Override
    public void visit(StructInitializationNode node) {
        visit(node.idNode);
        System.out.println("(");
        indentationLevel++;
        int len = node.assignments.size();
        for(int i = 0; i < len; i++){
            visit(node.assignments.get(i));
        }
        indentationLevel--;
        System.out.print(indent() + ")");
    }
}
