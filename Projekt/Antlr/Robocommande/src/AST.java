import java.util.List;

/**
 * Created by pprintz & kukucumber on 3/24/17.
 */

abstract class ASTNode {
    public abstract void accept(Visitor v) ;
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

    @Override
    public void accept(Visitor v) {
       v.visit(this);
    }
}

class SetupNode extends ASTNode {
    public SetupBlockNode setupBlockNode;

    public SetupNode(SetupBlockNode setupBlockNode) {
        this.setupBlockNode = setupBlockNode;
    }
    @Override
    public void accept(Visitor v) {
       v.visit(this);
    }
}

class FunctionsNode extends ASTNode {
    public List<DefineFunctionNode> defineFunctions;
    public List<BehaviorFunctionNode> behaviorFunctions;

    public FunctionsNode(List<DefineFunctionNode> defineFunctions, List<BehaviorFunctionNode> behaviorFunctions) {
        this.defineFunctions = defineFunctions;
        this.behaviorFunctions = behaviorFunctions;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class StrategyNode extends ASTNode {
    public IdNode idNode;
    public StrategyDefinitionNode strategyDefinition;

    public StrategyNode(IdNode idNode, StrategyDefinitionNode strategyDefinition) {
        this.idNode = idNode;
        this.strategyDefinition = strategyDefinition;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class DefaultStrategyNode extends ASTNode {
    public StrategyDefinitionNode strategyDefinition;

    public DefaultStrategyNode(StrategyDefinitionNode strategyDefinition) {
        this.strategyDefinition = strategyDefinition;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class StrategyDefinitionNode extends ASTNode {
    public RunNode runNode;
    public FunctionsNode functionsNode;

    public StrategyDefinitionNode(RunNode runNode, FunctionsNode functionsNode) {
        this.runNode = runNode;
        this.functionsNode = functionsNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class RunNode extends ASTNode {
    public BlockNode blockNode;

    public RunNode(BlockNode blockNode) {
        this.blockNode = blockNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class SetupBlockNode extends ASTNode {
    public List<StmtNode> setupStmts;


    public SetupBlockNode(List<StmtNode> setupStmts) {
        this.setupStmts = setupStmts;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class BlockNode extends ASTNode {
    public List<StmtNode> functionStmtNodes;

    public BlockNode(List<StmtNode> functionStmtNodes) {
        this.functionStmtNodes = functionStmtNodes;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
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
    @Override
    public void accept(Visitor v) {
        v.visit(this);
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
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

abstract class StmtNode extends ASTNode {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class StructDefinitionNode extends StmtNode {
    public IdNode idName;
    public List<IdNode> idNodes;
    public List<AssignmentNode> assignments;

    public StructDefinitionNode(IdNode idName, List<IdNode> idNodes, List<AssignmentNode> assignments) {
        this.idName = idName;
        this.idNodes = idNodes;
        this.assignments = assignments;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class DeclarationNode extends StmtNode {
    public IdNode id;
    public ExprNode exprNode;
    public Type type;

    public DeclarationNode(IdNode id, ExprNode exprNode, Type type) {
        this.id = id;
        this.exprNode = exprNode;
        this.type = type;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

enum Type { num, text, bool, struct}

class StructDeclarationNode extends DeclarationNode{
    public String structName;

    public StructDeclarationNode(IdNode id, ExprNode exprNode, Type type, String structName) {
        super(id, exprNode, type);
        this.structName = structName;
    }
}

class NewEventNode extends StmtNode {
    public IdNode idNode;
    public BlockNode blockNode;

    public NewEventNode(IdNode idNode, BlockNode blockNode) {
        this.idNode = idNode;
        this.blockNode = blockNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class FieldAssignmentNode extends StmtNode {
    public FieldIdNode fieldIdNode;
    public ExprNode exprNode;

    public FieldAssignmentNode(FieldIdNode fieldIdNode, ExprNode exprNode) {
        this.fieldIdNode = fieldIdNode;
        this.exprNode = exprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}


class AssignmentNode extends StmtNode {
    public IdNode idNode;
    public ExprNode exprNode;

    public AssignmentNode(IdNode idNode, ExprNode exprNode) {
        this.idNode = idNode;
        this.exprNode = exprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
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
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ElseIfStatementNode extends ASTNode {
    public ExprNode predicate;
    public BlockNode blockNode;

    public ElseIfStatementNode(ExprNode predicate, BlockNode blockNode) {
        this.predicate = predicate;
        this.blockNode = blockNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
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
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class StructInitializationNode extends ExprNode {
    public IdNode name;
    public List<AssignmentNode> assignments;

    public StructInitializationNode(IdNode name, List<AssignmentNode> assignments) {
        this.name = name;
        this.assignments = assignments;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
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
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class LoopNode extends StmtNode {
    public ExprNode exprNode;
    public BlockNode block;

    public LoopNode(ExprNode exprNode, BlockNode block) {
        this.exprNode = exprNode;
        this.block = block;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}


class FormalParamsNode extends ASTNode {
    public List<IdNode> ids;

    public FormalParamsNode(List<IdNode> ids) {
        this.ids = ids;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ActualParamsNode extends ASTNode {
    public List<ExprNode> exprs;

    public ActualParamsNode(List<ExprNode> exprs) {
        this.exprs = exprs;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
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
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ReturnStatementNode extends StmtNode {
    public ExprNode exprNode;

    public ReturnStatementNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class GroupedExpressionNode extends ExprNode {
    public ExprNode exprNode;

    public GroupedExpressionNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class NegateBoolNode extends ExprNode {
    public ExprNode exprNode;

    public NegateBoolNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class NegateExpressionNode extends ExprNode {
    public ExprNode exprNode;
    public NegateExpressionNode(ExprNode exprNode) {
        this.exprNode = exprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class PowerNode extends ExprNode {
    public ExprNode baseNode;
    public ExprNode exponentNode;

    public PowerNode(ExprNode baseNode, ExprNode exponentNode) {
        this.baseNode = baseNode;
        this.exponentNode = exponentNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class MultNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public MultNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class DivNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public DivNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ModNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public ModNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class PlusNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public PlusNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class MinusNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public MinusNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ComparisonNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public ComparisonNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class EqualityNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public EqualityNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class InEqualityNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public InEqualityNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class LessThanNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public LessThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
class LeqThanNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public LeqThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
class GeqThanNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public GeqThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
class GreaterThanNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public GreaterThanNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class AndNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public AndNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class OrNode extends ExprNode {
    public ExprNode leftExprNode;
    public ExprNode rightExprNode;

    public OrNode(ExprNode leftExprNode, ExprNode rightExprNode) {
        this.leftExprNode = leftExprNode;
        this.rightExprNode = rightExprNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class FieldIdNode extends ASTNode {
    public List<IdNode> ids;

    public FieldIdNode(List<IdNode> ids) {
        this.ids = ids;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }


}

class IdNode extends ASTNode {
    public String id;

    public IdNode(String id) {
        this.id = id;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IdNode))
            return false;
        if (obj == this)
            return true;

        IdNode other = (IdNode) obj;
        return other.id.equals(this.id);
    }
}

