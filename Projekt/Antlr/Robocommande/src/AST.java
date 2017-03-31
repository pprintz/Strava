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
    public TypeIdNode typeIdNode;
    public StrategyDefinitionNode strategyDefinition;

    public StrategyNode(TypeIdNode typeIdNode, StrategyDefinitionNode strategyDefinition) {
        this.typeIdNode = typeIdNode;
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
    public TypeIdNode typeIdNode;
    public FormalParamsNode formalParamsNode;
    public BlockNode blockNode;

    public DefineFunctionNode(TypeIdNode typeIdNode, FormalParamsNode formalParamsNode, BlockNode blockNode) {
        this.typeIdNode = typeIdNode;
        this.formalParamsNode = formalParamsNode;
        this.blockNode = blockNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class BehaviorFunctionNode extends ASTNode {
    public TypeIdNode typeIdNode;
    public TypeIdNode eventName;
    public BlockNode blockNode;

    public BehaviorFunctionNode(TypeIdNode typeIdNode, TypeIdNode eventName, BlockNode blockNode) {
        this.typeIdNode = typeIdNode;
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
    public TypeIdNode structIdNode;
    public List<TypeIdNode> typeIdNodes;
    public List<AssignmentNode> assignments;

    public StructDefinitionNode(TypeIdNode structIdNode, List<TypeIdNode> typeIdNodes, List<AssignmentNode> assignments) {
        this.structIdNode = structIdNode;
        this.typeIdNodes = typeIdNodes;
        this.assignments = assignments;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class DeclarationNode extends StmtNode {
    public TypeIdNode typeIdNode;
    public ExprNode exprNode;

    public DeclarationNode(TypeIdNode typeIdNode, ExprNode exprNode) {
        this.typeIdNode = typeIdNode;
        this.exprNode = exprNode;
    }
    @Override
    public void accept(Visitor v) { v.visit(this); }
}

class NewEventNode extends StmtNode {
    public TypeIdNode typeIdNode;
    public BlockNode blockNode;

    public NewEventNode(TypeIdNode typeIdNode, BlockNode blockNode) {
        this.typeIdNode = typeIdNode;
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
    public TypeIdNode typeIdNode;
    public ExprNode exprNode;

    public AssignmentNode(TypeIdNode typeIdNode, ExprNode exprNode) {
        this.typeIdNode = typeIdNode;
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
    public TypeIdNode typeIdNode;
    public ActualParamsNode actualParams;

    public FunctionCallNode(FieldIdNode fieldIdNode, TypeIdNode typeIdNode, ActualParamsNode actualParams) {
        this.fieldIdNode = fieldIdNode;
        this.typeIdNode = typeIdNode;
        this.actualParams = actualParams;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class StructInitializationNode extends ExprNode {
    public TypeIdNode typeIdNode;
    public List<AssignmentNode> assignments;

    public StructInitializationNode(TypeIdNode typeIdNode, List<AssignmentNode> assignments) {
        this.typeIdNode = typeIdNode;
        this.assignments = assignments;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ExprFunctionCallNode extends ExprNode {
    public FieldIdNode fieldIdNode;
    public TypeIdNode typeIdNode;
    public ActualParamsNode actualParams;

    public ExprFunctionCallNode(FieldIdNode fieldIdNode, TypeIdNode typeIdNode, ActualParamsNode actualParams) {
        this.fieldIdNode = fieldIdNode;
        this.typeIdNode = typeIdNode;
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
    public List<TypeIdNode> typeIdNodes;
    public FormalParamsNode(List<TypeIdNode> typeIdNodes) {
        this.typeIdNodes = typeIdNodes;
    }

    @Override
    public void accept(Visitor v) {

    }
}

class ActualParamsNode extends ASTNode {
    public List<ExprNode> exprs;

    public ActualParamsNode(List<ExprNode> exprs) {
        this.exprs = exprs;
    }

    @Override
    public void accept(Visitor v) {
    }
}

abstract class ExprNode extends ASTNode {
    @Override
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
    public List<TypeIdNode> typeIdNodes;

    public FieldIdNode(List<TypeIdNode> typeIdNodes) {
        this.typeIdNodes = typeIdNodes;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }


}

class TypeIdNode extends ASTNode {
    public String id;
    public String type;
    public TypeIdNode(String id, String type) {
        this.id = id;
        this.type = type;
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
        if (!(obj instanceof TypeIdNode))
            return false;
        if (obj == this)
            return true;

        TypeIdNode other = (TypeIdNode) obj;
        return other.id.equals(this.id) && other.type.equals(this.type);
    }
}

