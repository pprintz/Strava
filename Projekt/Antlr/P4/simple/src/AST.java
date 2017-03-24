/**
 * Created by pprintz on 3/24/17.
 */

abstract class Visitor{
    public void visit(ASTNode a){}

}
abstract class ASTNode{
    public virtual accept(Visitor v){
        v.visit(this);
    }
}
class ProgNode extends ASTNode
{
    private SetupNode setupNode;
    private DefaultStrategyNode defaultStrategyNode;
    private List<StrategyNode> strategyNodes;
    private List<DefineFunctionNode> defineFunctionNodes;
}
class SetupNode extends ASTNode
{
    SetupBlockNode
}

class FunctionsNode extends ASTNode
{
    private List<DefineFunctionNode> defineFunctions
    private List<behaviorFunction> behaviorFunctions
}
class StrategyNode extends ASTNode
{
    private IdNode idNode
    private StrategyDefinition strategyDefinition
}
class DefaultStrategyNode extends ASTNode
{
    private StrategyDefinition strategyDefinition
}
class StrategyDefinitionNode extends ASTNode
{
    private RunNode runNode
    private FunctionsNode functionsNode
}
class SetupBlockNode extends ASTNode
{
    private SetupStmt setupStmt
}
class BlockNode extends ASTNode
{
    private List<StmtNode> stmtNode
}
class SetupStmtNode extends ASTNode
{
    private DeclarationNode declarationNode
    private StructDeclarationNode structDeclarationNode
    private AssignmentNode assignmentNode
    private FieldAssignmentNode fieldAssignmentNode
    private IfStatementNode ifStatementNode
    private FunctionCallNode functionCallNode
    private LoopNode loopNode
    private NewEventNode newEventNode
}
class StmtNode extends ASTNode
{
    private DeclarationNode declarationNode
    private StructDeclarationNode structDeclarationNode
    private AssignmentNode assignmentNode
    private FieldAssignmentNode fieldAssignmentNode
    private IfStatementNode ifStatementNode
    private FunctionCallNode functionCallNode
    private LoopNode loopNode
    private NewDeclarationNode newDeclarationNode
    private ReturnStatementNode returnStatementNode
}
class DefineFunctionNode extends ASTNode
{
    private IdNode idNode
    private formalParamsNode
    private BlockNode blockNode
}
class BehaviorFunctionNode extends ASTNode
{
    private idNode idNode
    private idNode eventName
    private blockNode blockNode
}
class StructDeclarationNode extends ASTNode
{
    private String idName
    private List<>idList(Fields)
    assignmentList
}
class DeclarationNode extends ASTNode
{
    private IdNode id
    private ExprNode exprNode
}
class NewDeclarationNode extends ASTNode
{
    private IDNode idNode
    private ExprNode exprNode
}
class NewEventNode extends ASTNode
{
    private IdNode idNode
    private BlockNode blockNode
}
class FieldAssignmentNode extends ASTNode
{
    private FieldIdNode fieldIdNode
    private ExprNode exprNode
}
class AssignmentNode extends ASTNode
{
    private IdNode idNode
    private ExprNode exprNode
}
class IfStatementNode extends ASTNode
{
    private ExprNode predicate
    private BlockNode ifBlockNode
    private List<ElseIfStatementNode> elseIfNodes
    private BlockNode elseBlockNode
}

class ElseIfStatementNode extends ASTNode
{
    private ExprNode predicate
    private BlockNode blockNode
}

class FunctionCallNode extends ASTNode
{
    private FieldIdNode fieldIdNode
    private IdNode idNode
    private ActualParams actualParams
}
class StructInitializationNode extends ASTNode
{
    private IdNode id
    private AssignmentNode assignment
}
class LoopNode extends ASTNode
{
    private ExprNode exprNode
    private BlockNode block
}
class ReturnStatementNode extends ASTNode
{
    private ExprNode exprNode
}
class FormalParamsNode extends ASTNode
{
    private List<IdNode> idList
}
class ActualParamsNode extends ASTNode
{
    private List<ExprNode> exprList
}
abstract class ExprNode extends ASTNode {}

class FCallNode extends ExprNode {}

class LiteralNode extends ExprNode
{
    private String literalText
}
class GroupedExpression extends ExprNode
{
    private ExprNode exprNode
}
class NegateBoolNode extends ExprNode
{
    private ExprNode exprNode
}

class NegateExpressionNode extends ExprNode {}

class PowerNode extends ExprNode
{
    private ExpreNode baseNode
    private ExprNode exponentNode
}
class MultiNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}
class DivNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}
class ModNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}
class PlusNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}
class MinusNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}

class ComparisonNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}
class EqualityNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}
class LessThanNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}

class AndNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}
class OrNode extends ExprNode
{
    private LeftExprNode leftExprNode
    private RightExprNode rightExprNode
}

class FieldIdNode
{
    private List<IdNode> idList
}
class IdNode
{
    private String Id
}

