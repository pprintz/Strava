import java.util.List;

/**
 * Created by pprintz & kukucumber on 3/24/17.
 */



abstract class ASTNode {
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ProgNode extends ASTNode {

    public SetupNode setupNode;
    public DefaultStrategyNode defaultStrategyNode;
    public List<StrategyNode> strategyNodes;
    public List<DefineFunctionNode> defineFunctionNodes;

    public ProgNode(SetupNode setupNode, DefaultStrategyNode defaultStrategyNode,
        List<StrategyNode> strategyNodes, List<DefineFunctionNode> defineFunctionNodes) {
        this.setupNode = setupNode;
        this.defaultStrategyNode = defaultStrategyNode;
        this.strategyNodes = strategyNodes;
        this.defineFunctionNodes = defineFunctionNodes;
    }
}

class SetupNode extends ASTNode {
    public SetupBlockNode setupBlockNode;

    public SetupNode(SetupBlockNode setupBlockNode) {
        this.setupBlockNode = setupBlockNode;
    }
}

class FunctionsNode extends ASTNode {
    public List<DefineFunctionNode> defineFunctions;
    public List<BehaviorFunctionNode> behaviorFunctions;

    public FunctionsNode(List<DefineFunctionNode> defineFunctions, List<BehaviorFunctionNode> behaviorFunctions) {
        this.defineFunctions = defineFunctions;
        this.behaviorFunctions = behaviorFunctions;
    }
}

class StrategyNode extends ASTNode {
    public IdNode idNode;
    public StrategyDefinitionNode strategyDefinition;

    public StrategyNode(IdNode idNode, StrategyDefinitionNode strategyDefinition) {
        this.idNode = idNode;
        this.strategyDefinition = strategyDefinition;
    }
}

class DefaultStrategyNode extends ASTNode {
    public StrategyDefinitionNode strategyDefinition;

    public DefaultStrategyNode(StrategyDefinitionNode strategyDefinition) {
        this.strategyDefinition = strategyDefinition;
    }
}

class StrategyDefinitionNode extends ASTNode {
    public RunNode runNode;
    public FunctionsNode functionsNode;

    public StrategyDefinitionNode(RunNode runNode, FunctionsNode functionsNode) {
        this.runNode = runNode;
        this.functionsNode = functionsNode;
    }
}

class RunNode extends ASTNode {
    public BlockNode blockNode;

    public RunNode(BlockNode blockNode) {
        this.blockNode = blockNode;
    }
}

class SetupBlockNode extends ASTNode {
    public List<StmtNode> setupStmts;


    public SetupBlockNode(List<StmtNode> setupStmts) {
        this.setupStmts = setupStmts;
    }
}

class BlockNode extends ASTNode {
    public List<StmtNode> functionStmtNodes;

    public BlockNode(List<StmtNode> functionStmtNodes) {
        this.functionStmtNodes = functionStmtNodes;
    }
}


abstract class GeneralStmtNode extends ASTNode {
    public void accept(Visitor v) {
        v.visit(this);
    }
}

abstract class SetupStmtNode extends GeneralStmtNode {
    public void accept(Visitor v) {
        v.visit(this);
    }
}

abstract class FunctionStmtNode extends ASTNode {
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class DefineFunctionNode extends ASTNode {
    public IdNode idNode;
    public FormalParamsNode formalParamsNode;
    public BlockNode blockNode;

    public DefineFunctionNode(IdNode idNode, FormalParamsNode formalParamsNode, BlockNode blockNode) {
        this.idNode = idNode;
        this.formalParamsNode = formalParamsNode;
        this.blockNode = blockNode;
    }
}

class BehaviorFunctionNode extends ASTNode {
    public IdNode idNode;
    public IdNode eventName;
    public BlockNode blockNode;

    public BehaviorFunctionNode(IdNode idNode, IdNode eventName, BlockNode blockNode) {
        this.idNode = idNode;
        this.eventName = eventName;
        this.blockNode = blockNode;
    }
}

abstract class StmtNode extends ASTNode {
}

class StructDeclarationNode extends StmtNode {
    public IdNode idName;
    public List<IdNode> idNodes;
    public List<AssignmentNode> assignments;

    public StructDeclarationNode(IdNode idName, List<IdNode> idNodes, List<AssignmentNode> assignments) {
        this.idName = idName;
        this.idNodes = idNodes;
        this.assignments = assignments;
    }
}

class DeclarationNode extends StmtNode {
    public IdNode id;
    public ExprNode exprNode;

    public DeclarationNode(IdNode id, ExprNode exprNode) {
        this.id = id;
        this.exprNode = exprNode;
    }
}

class NewDeclarationNode extends FunctionStmtNode {
    public IdNode idNode;
    public ExprNode exprNode;

    public NewDeclarationNode(IdNode idNode, ExprNode exprNode) {
        this.idNode = idNode;
        this.exprNode = exprNode;
    }
}

class NewEventNode extends SetupStmtNode {
    public IdNode idNode;
    public BlockNode blockNode;

    public NewEventNode(IdNode idNode, BlockNode blockNode) {
        this.idNode = idNode;
        this.blockNode = blockNode;
    }
}

class FieldAssignmentNode extends StmtNode {
    public FieldIdNode fieldIdNode;
    public ExprNode exprNode;

    public FieldAssignmentNode(FieldIdNode fieldIdNode, ExprNode exprNode) {
        this.fieldIdNode = fieldIdNode;
        this.exprNode = exprNode;
    }
}


class AssignmentNode extends StmtNode {
    public IdNode idNode;
    public ExprNode exprNode;

    public AssignmentNode(IdNode idNode, ExprNode exprNode) {
        this.idNode = idNode;
        this.exprNode = exprNode;
    }
}


class IfStatementNode extends StmtNode {
    public ExprNode predicate;
    public BlockNode ifBlockNode;
    public List<ElseIfStatementNode> elseIfNodes;
    public BlockNode elseBlockNode;

    public IfStatementNode(ExprNode predicate, BlockNode ifBlockNode,
                           List<ElseIfStatementNode> elseIfNodes, BlockNode elseBlockNode) {
        this.predicate = predicate;
        this.ifBlockNode = ifBlockNode;
        this.elseIfNodes = elseIfNodes;
        this.elseBlockNode = elseBlockNode;
    }
}

class ElseIfStatementNode extends ASTNode {
    public ExprNode predicate;
    public BlockNode blockNode;

    public ElseIfStatementNode(ExprNode predicate, BlockNode blockNode) {
        this.predicate = predicate;
        this.blockNode = blockNode;
    }
}


class FunctionCallNode extends StmtNode {
    public FieldIdNode fieldIdNode;
    public IdNode idNode;
    public ActualParamsNode actualParams;

    public FunctionCallNode(FieldIdNode fieldIdNode, IdNode idNode, ActualParamsNode actualParams) {
        this.fieldIdNode = fieldIdNode;
        this.idNode = idNode;
        this.actualParams = actualParams;
    }
}

class StructInitializationNode extends ASTNode {
    public IdNode name;
    public List<AssignmentNode> assignments;
}

class ExprFunctionCallNode extends ExprNode {
    public FieldIdNode fieldIdNode;
    public IdNode idNode;
    public ActualParamsNode actualParams;

    public ExprFunctionCallNode(FieldIdNode fieldIdNode, IdNode idNode, ActualParamsNode actualParams) {
        this.fieldIdNode = fieldIdNode;
        this.idNode = idNode;
        this.actualParams = actualParams;
    }
}

class LoopNode extends StmtNode {
    public ExprNode exprNode;
    public BlockNode block;

    public LoopNode(ExprNode exprNode, BlockNode block) {
        this.exprNode = exprNode;
        this.block = block;
    }
}


class FormalParamsNode extends ASTNode {
    public List<IdNode> ids;

    public FormalParamsNode(List<IdNode> ids) {
        this.ids = ids;
    }
}

class ActualParamsNode extends ASTNode {
    public List<ExprNode> exprs;

    public ActualParamsNode(List<ExprNode> exprs) {
        this.exprs = exprs;
    }
}

abstract class ExprNode extends ASTNode {
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class LiteralNode extends ExprNode {
    public String literalText;

    public LiteralNode(String literalText) {
        this.literalText = literalText;
    }
}

class ReturnStatementNode extends StmtNode {
    public ExprNode exprNode;

    public ReturnStatementNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
}

class GroupedExpressionNode extends ExprNode {
    public ExprNode exprNode;

    public GroupedExpressionNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
}

class NegateBoolNode extends ExprNode {
    public ExprNode exprNode;

    public NegateBoolNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
}

class NegateExpressionNode extends ExprNode {
    public ExprNode exprNode;
    public NegateExpressionNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
}

class PowerNode extends ExprNode {
    public ExprNode baseNode;
    public ExprNode exponentNode;

    public PowerNode(ExprNode baseNode, ExprNode exponentNode) {
        this.baseNode = baseNode;
        this.exponentNode = exponentNode;
    }
}

class MultNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public MultNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class DivNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public DivNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class ModNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public ModNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class PlusNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public PlusNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class MinusNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public MinusNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class ComparisonNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public ComparisonNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class EqualityNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public EqualityNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class InEqualityNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public InEqualityNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class LessThanNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public LessThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}
class LeqThanNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public LeqThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}
class GeqThanNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public GeqThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}
class GreaterThanNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public GreaterThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class AndNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public AndNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class OrNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public OrNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
}

class FieldIdNode extends ASTNode {
    public List<IdNode> ids;

    public FieldIdNode(List<IdNode> ids) {
        this.ids = ids;
    }
}

class IdNode extends ASTNode {
    public String id;

    public IdNode(String id) {
        this.id = id;
    }
}

