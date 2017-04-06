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
    public void visit(AndNode node) {
        visit(node.leftExprNode);
        System.out.print(" and ");
        visit(node.rightExprNode);
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
    public void visit(ComparisonNode node) {
        super.visit(node);
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

        indentationLevel++;
        visit(node.blockNode);
        indentationLevel--;
    }

    @Override
    public void visit(DivNode node) {
        visit(node.leftExprNode);
        System.out.print(" / ");
        visit(node.rightExprNode);
    }

    @Override
    public void visit(ElseIfStatementNode node) {
        System.out.print(indent() + "ELSE IF ");
        visit(node.predicate);
        System.out.println();
        visit(node.blockNode);
    }

    @Override
    public void visit(EqualityNode node) {
        visit(node.leftExprNode);
        System.out.print(" = ");
        visit(node.rightExprNode);
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
        System.out.println(node.defineFunctionNode.idNode.id);

    }

    @Override
    public void visit(FunctionsNode node) {
        super.visit(node);
    }

    @Override
    public void visit(GeqThanNode node) {
        visit(node.leftExprNode);
        System.out.print(" >= ");
        visit(node.rightExprNode);
    }

    @Override
    public void visit(GreaterThanNode node) {
        visit(node.leftExprNode);
        System.out.print(" > ");
        visit(node.rightExprNode);
    }

    @Override
    public void visit(GroupedExpressionNode node) {
        System.out.print("(");
        visit(node.exprNode);
        System.out.print(")");
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
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        if(node.idNode != null)
            visit(node.idNode);
        else  if (node.fieldIdNode != null) visit(node.fieldIdNode);
        System.out.print("(");
        if(node.actualParams != null)
        visit(node.actualParams);
        System.out.print(")");
    }

    @Override
    public void visit(InEqualityNode node) {
        visit(node.leftExprNode);
        System.out.print(" != ");
        visit(node.rightExprNode);
    }

    @Override
    public void visit(LeqThanNode node) {
        visit(node.leftExprNode);
        System.out.print(" <= ");
        visit(node.rightExprNode);
    }

    @Override
    public void visit(LessThanNode node) {
        visit(node.leftExprNode);
        System.out.print(" < ");
        visit(node.rightExprNode);
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
    public void visit(MinusNode node) {
        visit(node.leftExprNode);
        System.out.print(" - ");
        visit(node.rightExprNode);
    }

    @Override
    public void visit(ModNode node) {
        visit(node.leftExprNode);
        System.out.print(" % ");
        visit(node.rightExprNode);
    }

    @Override
    public void visit(MultNode node) {
        visit(node.leftExprNode);
        System.out.print(" * ");
        visit(node.rightExprNode);
    }

    @Override
    public void visit(NegateBoolNode node) {
        System.out.print("not ");
        super.visit(node);
    }

    @Override
    public void visit(NegateExpressionNode node) {
        System.out.print("-");
        super.visit(node);
    }

    @Override
    public void visit(NewEventNode node) {
        System.out.print(indent() + "NEW EVENT ");
        System.out.print(node.idNode.id + "\n");
        visit(node.blockNode);
    }

    @Override
    public void visit(OrNode node) {
        visit(node.leftExprNode);
        System.out.print(" or ");
        visit(node.rightExprNode);
    }

    @Override
    public void visit(PlusNode node) {
        node.leftExprNode.accept(this);
        System.out.print(" + ");
        node.rightExprNode.accept(this);
    }

    @Override
    public void visit(PowerNode node) {
        visit(node.baseNode);
        System.out.print("^(");
        visit(node.exponentNode);
        System.out.print(")");
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
