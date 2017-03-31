/**
 * Created by Casper on 27/03/2017.
 */
public abstract class Visitor {


    public void visit(ActualParamsNode node){
        for(ExprNode expr : node.exprs){
            visit(expr);
        }
    }

    public void visit(ASTNode node){
        node.accept(this);
    }

    public void visit(FunctionStmtNode node){
        node.accept(this);
    }

    public void visit(AndNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(GeneralStmtNode node){
        node.accept(this);
    }

    public void visit(AssignmentNode node){
        node.typeIdNode.accept(this);
        node.exprNode.accept(this);
    }

    public void visit(BehaviorFunctionNode node){
        node.typeIdNode.accept(this);
        node.eventName.accept(this);
        node.blockNode.accept(this);
    }

    public void visit(BlockNode node){
        for(StmtNode stmtNode : node.functionStmtNodes){
            stmtNode.accept(this);
        }
    }

    public void visit(ComparisonNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(DeclarationNode node){
        node.id.accept(this);
        if(node.exprNode != null)
            node.exprNode.accept(this);
    }

    public void visit(DefaultStrategyNode node){
        node.strategyDefinition.accept(this);
    }

    public void visit(DefineFunctionNode node){
        node.typeIdNode.accept(this);
        node.formalParamsNode.accept(this);
        node.blockNode.accept(this);
    }

    public void visit(DivNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(ElseIfStatementNode node){
        node.predicate.accept(this);
        node.blockNode.accept(this);
    }

    public void visit(EqualityNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(FieldAssignmentNode node){
        node.fieldIdNode.accept(this);
        node.exprNode.accept(this);
    }

    public void visit(FieldIdNode node){
        for(TypeIdNode idnode : node.ids){
            idnode.accept(this);
        }
    }

    public void visit(FormalParamsNode node){
        for(TypeIdNode pnode : node.ids){
            pnode.accept(this);
        }
    }

    public void visit(FunctionCallNode node){
        if(node.fieldIdNode != null)
        node.fieldIdNode.accept(this);
        node.typeIdNode.accept(this);
        if(node.actualParams != null)
        node.actualParams.accept(this);
    }

    public void visit(FunctionsNode node){
        for(DefineFunctionNode defnode : node.defineFunctions){
            defnode.accept(this);
        }

        for(BehaviorFunctionNode behnode : node.behaviorFunctions){
            behnode.accept(this);
        }
    }

    public void visit(GeqThanNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(GreaterThanNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(GroupedExpressionNode node){
        node.exprNode.accept(this);
    }

    public void visit(TypeIdNode node){

    }

    public void visit(IfStatementNode node){
        node.predicate.accept(this);
        node.ifBlockNode.accept(this);
        for(ElseIfStatementNode elifNode : node.elseIfNodes){
            elifNode.accept(this);
        }
        node.elseBlockNode.accept(this);
    }
    public void visit(ExprFunctionCallNode node){
        if(node.fieldIdNode != null)
            node.fieldIdNode.accept(this);
        node.typeIdNode.accept(this);
        if(node.actualParams != null)
            node.actualParams.accept(this);
    }

    public void visit(InEqualityNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(LeqThanNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(LessThanNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(LiteralNode node){

    }

    public void visit(LoopNode node){
        node.exprNode.accept(this);
        node.block.accept(this);
    }

    public void visit(MinusNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(ModNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(MultNode node){
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(NegateBoolNode node){
        node.exprNode.accept(this);
    }

    public void visit(NegateExpressionNode node){
        node.exprNode.accept(this);
    }

    public void visit(NewDeclarationNode node){
        node.idNode.accept(this);
        node.exprNode.accept(this);
    }

    public void visit(NewEventNode node){
        node.typeIdNode.accept(this);
        node.blockNode.accept(this);
    }

    public void visit(OrNode node) {
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(PlusNode node) {
        node.leftExprNode.accept(this);
        node.rightExprNode.accept(this);
    }

    public void visit(PowerNode node) {
        node.baseNode.accept(this);
        node.exponentNode.accept(this);
    }

    public void visit(ProgNode node) {
        node.setupNode.accept(this);
        node.defaultStrategyNode.accept(this);
        for(StrategyNode strategyNode : node.strategyNodes) {
            strategyNode.accept(this);
        }

        for(DefineFunctionNode defineFunctionsNode : node.defineFunctionNodes) {
            defineFunctionsNode.accept(this);
        }
    }

    public void visit(ReturnStatementNode node) {
        node.exprNode.accept(this);
    }

    public void visit(RunNode node) {
        node.blockNode.accept(this);
    }

    public void visit(SetupBlockNode node) {
        for (StmtNode setupStmt : node.setupStmts) {
            setupStmt.accept(this);
        }
    }

    public void visit(SetupNode node) {
        node.setupBlockNode.accept(this);
    }

    public void visit(SetupStmtNode node) {
        // SetupStmtNode is abstract
    }
    public void visit(StmtNode node){
        node.accept(this);
    }

    public void visit(StrategyDefinitionNode node) {
        if(node.runNode != null)
            node.runNode.accept(this);
        if(node.functionsNode != null)
            node.functionsNode.accept(this);
    }

    public void visit(StrategyNode node) {
        node.typeIdNode.accept(this);
        node.strategyDefinition.accept(this);
    }

    public void visit(StructDefinitionNode node) {
        node.idName.accept(this);
        for(TypeIdNode typeIdNode : node.typeIdNodes) {
            typeIdNode.accept(this);
        }
        for(AssignmentNode assignmentNode : node.assignments) {
            assignmentNode.accept(this);
        }
    }

    public void visit(StructInitializationNode node) {
        node.name.accept(this);
        for(AssignmentNode assignmentNode : node.assignments) {
            assignmentNode.accept(this);
        }
    }
}
















