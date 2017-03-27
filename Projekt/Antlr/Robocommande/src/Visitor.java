import com.sun.org.apache.xpath.internal.ExpressionNode;
import jdk.nashorn.internal.ir.IfNode;
import sun.tools.jstat.Literal;

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
    }

    public void visit(GeneralStmtNode node){
        node.accept(this);
    }

    public void visit(AssignmentNode node){
        visit(node.idNode);
        visit(node.exprNode);
    }

    public void visit(BehaviorFunctionNode node){
        visit(node.idNode);
        visit(node.eventName);
        visit(node.blockNode);
    }

    public void visit(BlockNode node){
        for(FunctionStmtNode nodes : node.functionStmtNodes){
            visit(nodes);
        }
    }

    public void visit(ComparisonNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(DeclarationNode node){
        visit(node.id);
        visit(node.exprNode);
    }

    public void visit(DefaultStrategyNode node){
        visit(node.strategyDefinition);
    }

    public void visit(DefineFunctionNode node){
        visit(node.idNode);
        visit(node.formalParamsNode);
        visit(node.blockNode);
    }

    public void visit(DivNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(ElseIfStatementNode node){
        visit(node.predicate);
        visit(node.blockNode);
    }

    public void visit(EqualityNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(FieldAssignmentNode node){
        visit(node.fieldIdNode);
        visit(node.exprNode);
    }

    public void visit(FieldIdNode node){
        for(IdNode idnode : node.ids){
            visit(idnode);
        }
    }

    public void visit(FormalParamsNode node){
        for(IdNode pnode : node.ids){
            visit(pnode);
        }
    }

    public void visit(FunctionCallNode node){
        visit(node.fieldIdNode);
        visit(node.idNode);
        visit(node.actualParams);
    }

    public void visit(FunctionsNode node){
        for(DefineFunctionNode defnode : node.defineFunctions){
            visit(defnode);
        }

        for(BehaviorFunctionNode behnode : node.behaviorFunctions){
            visit(behnode);
        }
    }

    public void visit(GeqThanNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(GreaterThanNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(GroupedExpressionNode node){

    }

    public void visit(IdNode node){

    }

    public void visit(IfStatementNode node){
        visit(node.predicate);
        visit(node.ifBlockNode);
        for(ElseIfStatementNode elifNode : node.elseIfNodes){
            visit(elifNode);
        }
        visit(node.elseBlockNode);
    }

    public void visit(InEqualityNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(LeqThanNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(LessThanNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(LiteralNode node){

    }

    public void visit(LoopNode node){
        visit(node.exprNode);
        visit(node.block);
    }

    public void visit(MinusNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(ModNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(MultNode node){
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(NegateBoolNode node){
        visit(node.exprNode);
    }

    public void visit(NegateExpressionNode node){
        visit(node.exprNode);
    }

    public void visit(NewDeclarationNode node){
        visit(node.idNode);
        visit(node.exprNode);
    }

    public void visit(NewEventNode node){
        visit(node.idNode);
        visit(node.blockNode);
    }

    public void visit(OrNode node) {
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(PlusNode node) {
        visit(node.leftExprNode);
        visit(node.rightExprNode);
    }

    public void visit(PowerNode node) {
        visit(node.baseNode);
        visit(node.exponentNode);
    }

    public void visit(ProgNode node) {
        visit(node.setupNode);
        visit(node.defaultStrategyNode);
        for(StrategyNode strategyNode : node.strategyNodes) {
            visit(strategyNode);
        }

        for(DefineFunctionNode defineFunctionsNode : node.defineFunctionNodes) {
            visit(defineFunctionsNode);
        }
    }

    public void visit(ReturnStatementNode node) {
        visit(node.exprNode);
    }

    public void visit(RunNode node) {
        visit(node.blockNode);
    }

    public void visit(SetupBlockNode node) {
        for (SetupStmtNode setupStmt : node.setupStmts) {
            visit(setupStmt);
        }
    }

    public void visit(SetupNode node) {
        visit(node.setupBlockNode);
    }

    public void visit(SetupStmtNode node) {
        // SetupStmtNode is abstract
    }

    public void visit(StrategyDefinitionNode node) {
        visit(node.runNode);
        visit(node.functionsNode);
    }

    public void visit(StrategyNode node) {
        visit(node.idNode);
        visit(node.strategyDefinition);
    }

    public void visit(StructDeclarationNode node) {
        visit(node.idName);
        for(IdNode idNode : node.idNodes) {
            visit(idNode);
        }
        for(AssignmentNode assignmentNode : node.assignments) {
            visit(assignmentNode);
        }
    }

    public void visit(StructInitializationNode node) {
        visit(node.name);
        for(AssignmentNode assignmentNode : node.assignments) {
            visit(assignmentNode);
        }
    }

}
















