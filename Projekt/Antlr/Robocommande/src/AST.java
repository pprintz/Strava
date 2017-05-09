import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

/**
 * Created by pprintz & kukucumber on 3/24/17.
 */

abstract class ASTNode {
    public ASTNode() {

    }
    public abstract void accept(Visitor v) ;
    public int lineNumber;
    public int columnNumber;

    @Override
    public String toString() {
        return "(Line/column : " + lineNumber + "/" + columnNumber + ")";
    }

    public ASTNode(ParserRuleContext ctx) {
        lineNumber = ctx.start.getLine();
        columnNumber = ctx.start.getCharPositionInLine();
    }
}

class ProgNode extends ASTNode {

    public SetupNode setupNode;
    public DefaultStrategyNode defaultStrategyNode;
    public List<StrategyNode> strategyNodes;
    public List<DefineFunctionNode> defineFunctionNodes;

    public ProgNode(SetupNode setupNode, DefaultStrategyNode defaultStrategyNode,
        List<StrategyNode> strategyNodes, List<DefineFunctionNode> defineFunctionNodes) {
        super();
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

    public SetupNode(SetupBlockNode setupBlockNode, RobocommandeParser.SetupContext ctx) {
        super(ctx);
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

    public StrategyNode(IdNode idNode,
                        StrategyDefinitionNode strategyDefinition, RobocommandeParser.StrategyContext ctx) {
        super(ctx);
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

    public DefaultStrategyNode(StrategyDefinitionNode strategyDefinition, RobocommandeParser.DefaultStrategyContext ctx) {
        super(ctx);
        this.strategyDefinition = strategyDefinition;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public String toString() {
    	return "default";
	}
}

class StrategyDefinitionNode extends ASTNode {
    public RunNode runNode;
    public FunctionsNode functionsNode;

    public StrategyDefinitionNode(RunNode runNode, FunctionsNode functionsNode, RobocommandeParser.StrategyDefinitionContext ctx) {
        super(ctx);
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

    public RunNode(BlockNode blockNode, RobocommandeParser.RunContext ctx) {
        super(ctx);
        this.blockNode = blockNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class SetupBlockNode extends ASTNode {
    public List<StmtNode> setupStmts;


    public SetupBlockNode(List<StmtNode> setupStmts, RobocommandeParser.SetupBlockContext ctx) {
        super(ctx);
        this.setupStmts = setupStmts;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class BlockNode extends ASTNode {
    public List<StmtNode> functionStmtNodes;

    public BlockNode(List<StmtNode> functionStmtNodes, RobocommandeParser.BlockContext ctx) {
        super(ctx);
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
    public TypeNode typeNode;
    public IdNode idNode;
    public FormalParamsNode formalParamsNode;
    public BlockNode blockNode;

    public DefineFunctionNode(TypeNode typeNode, IdNode idNode, FormalParamsNode formalParamsNode,
                              BlockNode blockNode, RobocommandeParser.DefineFunctionContext ctx) {
        super(ctx);
        this.typeNode = typeNode;
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
    public TypeNode eventType;
    public BlockNode blockNode;

    public BehaviorFunctionNode(IdNode idNode, TypeNode eventType, BlockNode blockNode,
                                RobocommandeParser.BehaviorFunctionContext ctx) {
        super(ctx);
        this.idNode = idNode;
        this.eventType = eventType;
        this.blockNode = blockNode;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

abstract class StmtNode extends ASTNode {
    public abstract void accept(Visitor v);

    public StmtNode(){

    }

    public StmtNode(ParserRuleContext ctx){
        super(ctx);
    }
}

class StructDefinitionNode extends StmtNode {
    public TypeNode typeNode;
    public List<DeclarationNode> declarationNodes;

    public StructDefinitionNode(TypeNode typeNode, List<DeclarationNode> declarationNodes,
                                RobocommandeParser.StructDefinitionContext ctx) {
        super(ctx);
        this.typeNode = typeNode;
        this.declarationNodes = declarationNodes;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class DeclarationNode extends StmtNode {
    public TypeNode typeNode;

    public DeclarationNode() {
    }

    public IdNode idNode;
    public boolean IsGlobal;
    public ExprNode exprNode;
    public StructDefinitionNode structDefinitionNode;
    public Type Type;

    public DeclarationNode(TypeNode typeNode, IdNode idNode, RobocommandeParser.StructDefinitionContext ctx) {
        super(ctx);
        this.typeNode = typeNode;
        this.idNode = idNode;
        this.exprNode = null;



    }
    public DeclarationNode(TypeNode typeNode, IdNode idNode, ExprNode exprNode, RobocommandeParser.DeclarationContext ctx) {
        super(ctx);
        this.typeNode = typeNode;
        this.idNode = idNode;
        this.exprNode = exprNode;
    }

    @Override
    public void accept(Visitor v) { v.visit(this); }
}

class NewEventNode extends StmtNode {
    public IdNode idNode;
    public BlockNode blockNode;

    public NewEventNode(IdNode idNode, BlockNode blockNode, RobocommandeParser.NewEventContext ctx) {
        super(ctx);
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

    public FieldAssignmentNode(FieldIdNode fieldIdNode, ExprNode exprNode, RobocommandeParser.FieldAssignmentContext ctx) {
        super(ctx);
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
    public DefineFunctionNode defineFunctionNode;

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
    public TypeNode typeNode;
    public List<AssignmentNode> assignments;
    public StructDefinitionNode structDefinitionNode;

    public StructInitializationNode(TypeNode typeNode, List<AssignmentNode> assignments) {
        this.typeNode = typeNode;
        this.assignments = assignments;
        this.Type = typeNode.Type;
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
    public DefineFunctionNode defineFunctionNode;

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
    public ExprNode predicate;
    public BlockNode block;

    public LoopNode(ExprNode predicate, BlockNode block) {
        this.predicate = predicate;
        this.block = block;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}


class FormalParamsNode extends ASTNode {
    public List<TypeNode> typeNodes;
    public List<IdNode> idNodes;

    public FormalParamsNode(List<TypeNode> typeNodes, List<IdNode> idNodes) {
        this.typeNodes = typeNodes;
        this.idNodes = idNodes;
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
    public ExprNode(){

    }

    public ExprNode(ParserRuleContext ctx){
        super(ctx);
    }
    @Override
    public abstract void accept(Visitor v);
    public Type Type;
}

class LiteralNode extends ExprNode {
    public String literalText;
    public LiteralNode(String literalText, Type type) {
        this.literalText = literalText;
        this.Type = type;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class ReturnStatementNode extends StmtNode {
    public ExprNode exprNode;

    public ReturnStatementNode(ExprNode exprNode, RobocommandeParser.ReturnStatementContext ctx) {
        super(ctx);
        this.exprNode = exprNode;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class FieldIdNode extends ASTNode {
    public List<IdNode> idNodes;
    public StructDefinitionNode structDefinitionNode;

    public FieldIdNode(List<IdNode> idNodes, RobocommandeParser.FieldIdContext ctx) {
        super(ctx);
        this.idNodes = idNodes;
    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }


}

class FieldValueNode extends ExprNode {
    public List<IdNode> idNodes;
    public StructDefinitionNode structDefinitionNode;

    public FieldValueNode(List<IdNode> idNodes, RobocommandeParser.FieldValueContext ctx) {
        super(ctx);
        this.idNodes = idNodes;
    }

    @Override
    public void accept(Visitor v) { v.visit(this); }
}

class TypeNode extends ASTNode{
    public String type;
    public Type Type;

    public TypeNode(String type) {
        this.type = type;
        switch(this.type){
            case "num":
                this.Type = Type.NUM;
                break;
            case "text":
                this.Type = Type.TEXT;
                break;
            case "bool":
                this.Type = Type.BOOL;
                break;
            default:
                this.Type = Type.STRUCT;
                break;
        }

    }
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

class IdNode extends ExprNode {
    public String id;

    public IdNode(String id) {
        this.id = id;
    }

    public DeclarationNode declarationNode;
    public boolean isDeclaration = false;


    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public int hashCode() {
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
    class UnaryExprNode extends ExprNode{

        public UnaryExprNode(ExprNode exprNode, UnaryOperator unaryOperator, RobocommandeParser.UnaryExprContext ctx) {
            super(ctx);
            this.exprNode = exprNode;
            this.unaryOperator = unaryOperator;
        }
        public UnaryExprNode(ExprNode exprNode) {
            this.exprNode = exprNode;
        }

        public UnaryOperator unaryOperator;
        public ExprNode exprNode;

        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }

    }

    class BinaryExprNode extends ExprNode {

        @Override
        public void accept(Visitor v) {
            v.visit(this);
        }

        public ExprNode leftNode;
        public ExprNode rightNode;

        public BinaryOperator binaryOperator;
        public BinaryExprNode(ExprNode leftNode, ExprNode rigthNode, BinaryOperator binaryOperator, RobocommandeParser.BinaryExprContext ctx) {
            super(ctx);
            this.leftNode = leftNode;
            this.rightNode = rigthNode;
            this.binaryOperator = binaryOperator;
        }

        public BinaryExprNode(ExprNode leftNode, ExprNode rigthNode, RobocommandeParser.BinaryExprContext ctx) {
            super(ctx);
            this.leftNode = leftNode;
            this.rightNode = rigthNode;
            this.binaryOperator = binaryOperator;
        }
    }
    enum BinaryOperator{
        PLUS,
        MINUS,
        MULTIPLY,
        DIVISION,
        MODULO,
        LESSTHANEQUAL,
        GREATERTHANEQUAL,
        POWER,
        AND,
        OR,
        LESSTHAN,
        GREATERTHAN,
        EQUAL,
        NOTEQUAL
    }
    enum UnaryOperator{
        PARANTHESIS,
        NEGATEBOOL,
        NEGATE
    }

    enum Type{
        NUM,
        TEXT,
        BOOL,
        STRUCT,
        ERROR
    }

