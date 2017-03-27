import java.util.List;

/**
 * Created by pprintz & kukucumber on 3/24/17.
 */

abstract class Visitor {
    public void visit(ASTNode a) {
    }

}

abstract class ASTNode {
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ProgNode extends ASTNode {

    private SetupNode setupNode;
    private DefaultStrategyNode defaultStrategyNode;
    private List<StrategyNode> strategyNodes;
    private List<DefineFunctionNode> defineFunctionNodes;

    public ProgNode(SetupNode setupNode, DefaultStrategyNode defaultStrategyNode,
                    List<StrategyNode> strategyNodes, List<DefineFunctionNode> defineFunctionNodes) {
        this.setupNode = setupNode;
        this.defaultStrategyNode = defaultStrategyNode;
        this.strategyNodes = strategyNodes;
        this.defineFunctionNodes = defineFunctionNodes;
    }
}

class SetupNode extends ASTNode {
    private SetupBlockNode setupBlockNode;

    public SetupNode(SetupBlockNode setupBlockNode) {
        this.setupBlockNode = setupBlockNode;
    }
}

class FunctionsNode extends ASTNode {
    private List<DefineFunctionNode> defineFunctions;
    private List<BehaviorFunctionNode> behaviorFunctions;

    public FunctionsNode(List<DefineFunctionNode> defineFunctions, List<BehaviorFunctionNode> behaviorFunctions) {
        this.defineFunctions = defineFunctions;
        this.behaviorFunctions = behaviorFunctions;
    }
}

class StrategyNode extends ASTNode {
    private IdNode idNode;
    private StrategyDefinitionNode strategyDefinition;

    public StrategyNode(IdNode idNode, StrategyDefinitionNode strategyDefinition) {
        this.idNode = idNode;
        this.strategyDefinition = strategyDefinition;
    }
}

class DefaultStrategyNode extends ASTNode {
    private StrategyDefinitionNode strategyDefinition;

    public DefaultStrategyNode(StrategyDefinitionNode strategyDefinition) {
        this.strategyDefinition = strategyDefinition;
    }
}

class StrategyDefinitionNode extends ASTNode {
    private RunNode runNode;
    private FunctionsNode functionsNode;

    public StrategyDefinitionNode(RunNode runNode, FunctionsNode functionsNode) {
        this.runNode = runNode;
        this.functionsNode = functionsNode;
    }
}

class RunNode extends ASTNode {
    private BlockNode blockNode;

    public RunNode(BlockNode blockNode) {
        this.blockNode = blockNode;
    }
}

class SetupBlockNode extends ASTNode {
    private List<StmtNode> setupStmts;


    public SetupBlockNode(List<StmtNode> setupStmts) {
        this.setupStmts = setupStmts;
    }
}

class BlockNode extends ASTNode {
    private List<StmtNode> functionStmtNodes;

    public BlockNode(List<StmtNode> functionStmtNodes) {
        this.functionStmtNodes = functionStmtNodes;
    }
}


abstract class StmtNode extends ASTNode {
}
class StructDeclarationNode extends StmtNode {
    private IdNode idName;
    private List<IdNode> idNodes;
    private List<AssignmentNode> assignments;

    public StructDeclarationNode(IdNode idName, List<IdNode> idNodes, List<AssignmentNode> assignments) {
        this.idName = idName;
        this.idNodes = idNodes;
        this.assignments = assignments;
    }
}

class DeclarationNode extends StmtNode {
    private IdNode id;
    private ExprNode exprNode;

    public DeclarationNode(IdNode id, ExprNode exprNode) {
        this.id = id;
        this.exprNode = exprNode;
    }
}

class FieldAssignmentNode extends StmtNode {
    private FieldIdNode fieldIdNode;
    private ExprNode exprNode;

    public FieldAssignmentNode(FieldIdNode fieldIdNode, ExprNode exprNode) {
        this.fieldIdNode = fieldIdNode;
        this.exprNode = exprNode;
    }
}

class AssignmentNode extends StmtNode {
    private IdNode idNode;
    private ExprNode exprNode;

    public AssignmentNode(IdNode idNode, ExprNode exprNode) {
        this.idNode = idNode;
        this.exprNode = exprNode;
    }
}

class IfStatementNode extends StmtNode {
    private ExprNode predicate;
    private BlockNode ifBlockNode;
    private List<ElseIfStatementNode> elseIfNodes;
    private BlockNode elseBlockNode;

    public IfStatementNode(ExprNode predicate, BlockNode ifBlockNode,
                           List<ElseIfStatementNode> elseIfNodes, BlockNode elseBlockNode) {
        this.predicate = predicate;
        this.ifBlockNode = ifBlockNode;
        this.elseIfNodes = elseIfNodes;
        this.elseBlockNode = elseBlockNode;
    }
}

class FunctionCallNode extends StmtNode {
    private FieldIdNode fieldIdNode;
    private IdNode idNode;
    private ActualParamsNode actualParams;

    public FunctionCallNode(FieldIdNode fieldIdNode, IdNode idNode, ActualParamsNode actualParams) {
        this.fieldIdNode = fieldIdNode;
        this.idNode = idNode;
        this.actualParams = actualParams;
    }
}

class ExprFunctionCallNode extends ExprNode {
    private FieldIdNode fieldIdNode;
    private IdNode idNode;
    private ActualParamsNode actualParams;

    public ExprFunctionCallNode(FieldIdNode fieldIdNode, IdNode idNode, ActualParamsNode actualParams) {
        this.fieldIdNode = fieldIdNode;
        this.idNode = idNode;
        this.actualParams = actualParams;
    }
}

class LoopNode extends StmtNode {
    private ExprNode exprNode;
    private BlockNode block;

    public LoopNode(ExprNode exprNode, BlockNode block) {
        this.exprNode = exprNode;
        this.block = block;
    }
}


class NewEventNode extends StmtNode {
    private IdNode idNode;
    private BlockNode blockNode;

    public NewEventNode(IdNode idNode, BlockNode blockNode) {
        this.idNode = idNode;
        this.blockNode = blockNode;
    }
}



class NewDeclarationNode extends StmtNode {
    private IdNode idNode;
    private ExprNode exprNode;

    public NewDeclarationNode(IdNode idNode, ExprNode exprNode) {
        this.idNode = idNode;
        this.exprNode = exprNode;
    }
}

class ReturnStatementNode extends StmtNode {
    private ExprNode exprNode;

    public ReturnStatementNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
}

class DefineFunctionNode extends ASTNode {
    private IdNode idNode;
    private FormalParamsNode formalParamsNode;
    private BlockNode blockNode;

    public DefineFunctionNode(IdNode idNode, FormalParamsNode formalParamsNode, BlockNode blockNode) {
        this.idNode = idNode;
        this.formalParamsNode = formalParamsNode;
        this.blockNode = blockNode;
    }
}

class BehaviorFunctionNode extends ASTNode {
    private IdNode idNode;
    private IdNode eventName;
    private BlockNode blockNode;

    public BehaviorFunctionNode(IdNode idNode, IdNode eventName, BlockNode blockNode) {
        this.idNode = idNode;
        this.eventName = eventName;
        this.blockNode = blockNode;
    }
}



class ElseIfStatementNode extends ASTNode {
    private ExprNode predicate;
    private BlockNode blockNode;

    public ElseIfStatementNode(ExprNode predicate, BlockNode blockNode) {
        this.predicate = predicate;
        this.blockNode = blockNode;
    }
}


class StructInitializationNode extends ExprNode {
    private IdNode name;
    private List<AssignmentNode> assignments;

    public StructInitializationNode(IdNode name, List<AssignmentNode> assignments) {
        this.name = name;
        this.assignments = assignments;
    }
}


class FormalParamsNode extends ASTNode {
    private List<IdNode> ids;

    public FormalParamsNode(List<IdNode> ids) {
        this.ids = ids;
    }
}

class ActualParamsNode extends ASTNode {
    private List<ExprNode> exprs;

    public ActualParamsNode(List<ExprNode> exprs) {
        this.exprs = exprs;
    }
}

abstract class ExprNode extends StmtNode {
    public ExprNode() {
    }
}

class LiteralNode extends ExprNode {
    private String literalText;

    public LiteralNode(String literalText) {
        this.literalText = literalText;
    }
}

class GroupedExpression extends ExprNode {
    private ExprNode exprNode;

    public GroupedExpression(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
}

class NegateBoolNode extends ExprNode {
    private ExprNode exprNode;

    public NegateBoolNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
}

class NegateExpressionNode extends ExprNode {
    private ExprNode exprNode;
    public NegateExpressionNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
}

class PowerNode extends ExprNode {
    private ExprNode baseNode;
    private ExprNode exponentNode;

    public PowerNode(ExprNode baseNode, ExprNode exponentNode) {
        this.baseNode = baseNode;
        this.exponentNode = exponentNode;
    }
}

class MultNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public MultNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class DivNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public DivNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class ModNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public ModNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class PlusNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public PlusNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class MinusNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public MinusNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class ComparisonNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public ComparisonNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class EqualityNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public EqualityNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class InEqualityNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public InEqualityNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class LessThanNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public LessThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}
class LeqThanNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public LeqThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}
class GeqThanNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public GeqThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}
class GreaterThanNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public GreaterThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class AndNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public AndNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class OrNode extends ExprNode {
    private ExprNode leftExprNode;
    private ExprNode rightExprNode;

    public OrNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class FieldIdNode extends ASTNode {
    private List<IdNode> ids;

    public FieldIdNode(List<IdNode> ids) {
        this.ids = ids;
    }
}

class IdNode extends ASTNode {
    private String id;

    public IdNode(String id) {
        this.id = id;
    }
}

