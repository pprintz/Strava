import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kasper Dissing Bargsteen on 21/03/2017.
 */
public class ASTBuilder extends RobocommandeBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProg(RobocommandeParser.ProgContext ctx) {
        SetupNode setupNode = (SetupNode)visit(ctx.setup());
        DefaultStrategyNode defaultStrategyNode = (DefaultStrategyNode)visit(ctx.defaultStrategy());
        List<StrategyNode> strategyNodes = new LinkedList<>();
        List<DefineFunctionNode> defineFunctionNodes = new LinkedList<>();
        for(RobocommandeParser.StrategyContext strategy : ctx.strategy()){
            strategyNodes.add((StrategyNode)visit(strategy));
        }
        for(RobocommandeParser.DefineFunctionContext defFunc : ctx.defineFunction()){
            defineFunctionNodes.add((DefineFunctionNode)visit(defFunc));
        }
        return new ProgNode(setupNode, defaultStrategyNode, strategyNodes, defineFunctionNodes);
    }

    @Override
    public ASTNode visitSetup(RobocommandeParser.SetupContext ctx) {
        return new SetupNode((SetupBlockNode)visit(ctx.setupBlock()));
    }

    @Override
    public ASTNode visitRun(RobocommandeParser.RunContext ctx) {
        return new RunNode((BlockNode)visit(ctx.block()));

    }

    @Override
    public ASTNode visitFunctions(RobocommandeParser.FunctionsContext ctx) {
        List<BehaviorFunctionNode> behaviorFunctions = new LinkedList<>();
        List<DefineFunctionNode> defineFunctions = new LinkedList<>();

        for(RobocommandeParser.BehaviorFunctionContext behaFunc : ctx.behaviorFunction()) {
            behaviorFunctions.add((BehaviorFunctionNode) visit(behaFunc));
        }

        for(RobocommandeParser.DefineFunctionContext defFunc : ctx.defineFunction()) {
            defineFunctions.add((DefineFunctionNode) visit(defFunc));
        }

        return new FunctionsNode(defineFunctions, behaviorFunctions);
    }

    @Override
    public ASTNode visitDefineFunction(RobocommandeParser.DefineFunctionContext ctx) {
        IdNode idNode = (IdNode) visit((ctx.id()));
        FormalParamsNode formalParamsNode = (FormalParamsNode) visit((ctx.formalParams()));
        BlockNode blockNode = (BlockNode) visit((ctx.block()));

        return new DefineFunctionNode(idNode, formalParamsNode, blockNode);
    }

    @Override
    public ASTNode visitBehaviorFunction(RobocommandeParser.BehaviorFunctionContext ctx) {
        IdNode idNode = (IdNode) visit((ctx.id(0)));
        IdNode eventNode = (IdNode) visit((ctx.id(1)));
        BlockNode blockNode = (BlockNode) visit((ctx.block()));

        return new BehaviorFunctionNode(idNode, eventNode, blockNode);
    }

    @Override
    public ASTNode visitFormalParams(RobocommandeParser.FormalParamsContext ctx) {
        List<IdNode> idNodes = new LinkedList<>();
        ctx.id().forEach(idNode -> idNodes.add((IdNode)visit(idNode)));
        return new FormalParamsNode(idNodes);
    }

    @Override
    public ASTNode visitActualParams(RobocommandeParser.ActualParamsContext ctx) {
        List<ExprNode> exprNodes = new LinkedList<>();
        ctx.expr().forEach(exprNode -> exprNodes.add((ExprNode)visit(exprNode)));
        return new ActualParamsNode(exprNodes);
    }

    @Override
    public ASTNode visitStrategy(RobocommandeParser.StrategyContext ctx) {
        return new StrategyNode((IdNode) visit(ctx.id()),
                (StrategyDefinitionNode) visit(ctx.strategyDefinition()));
    }

    @Override
    public ASTNode visitDefaultStrategy(RobocommandeParser.DefaultStrategyContext ctx) {
        return new DefaultStrategyNode((StrategyDefinitionNode) visit(ctx.strategyDefinition()));
    }

    @Override
    public ASTNode visitStrategyDefinition(RobocommandeParser.StrategyDefinitionContext ctx) {
        RunNode runNode = null;
        if(ctx.run() != null)
            runNode = (RunNode) visit(ctx.run());

        FunctionsNode functionsNode = null;
        if(ctx.functions() != null)
            functionsNode = (FunctionsNode) visit(ctx.functions());

        return new StrategyDefinitionNode(runNode, functionsNode);
    }

    @Override
    public ASTNode visitSetupBlock(RobocommandeParser.SetupBlockContext ctx) {
        List<StmtNode> setupStmts = new LinkedList<>();
        ctx.setupStmt().forEach(stmt -> setupStmts.add((StmtNode)visit(stmt)));
        return new SetupBlockNode(setupStmts);
    }

    @Override
    public ASTNode visitBlock(RobocommandeParser.BlockContext ctx) {

        List<StmtNode> stmtNodes = new ArrayList<>();
        for(RobocommandeParser.StmtContext stmt : ctx.stmt()){
            stmtNodes.add((StmtNode)visit(stmt));
        }
        return new BlockNode(stmtNodes);
    }


    @Override
    public ASTNode visitSetupStmt(RobocommandeParser.SetupStmtContext ctx) {
        if(ctx.generalStmtPart() != null){ return visit(ctx.generalStmtPart()); }
        else if(ctx.newEvent() != null){ return visit(ctx.newEvent()); }
        return  null;
    }

    @Override
    public ASTNode visitStmt(RobocommandeParser.StmtContext ctx) {
        if(ctx.generalStmtPart() != null){ return visit(ctx.generalStmtPart()); }
        else if(ctx.newDeclaration() != null){ return visit(ctx.newDeclaration()); }
        else if(ctx.returnStatement() != null){ return visit(ctx.returnStatement()); }

        return null;
    }

    @Override
    public  ASTNode visitGeneralStmtPart(RobocommandeParser.GeneralStmtPartContext ctx){
        if(ctx.declaration() != null){ return visit(ctx.declaration()); }
        else if(ctx.structDeclaration() != null){ return visit(ctx.structDeclaration()); }
        else if(ctx.assignment() != null){ return visit(ctx.assignment()); }
        else if(ctx.fieldAssignment() != null){ return visit(ctx.fieldAssignment()); }
        else if(ctx.ifStatement() != null){ return visit(ctx.ifStatement()); }
        else if(ctx.functionCall() != null){ return visit(ctx.functionCall()); }
        else if(ctx.loop() != null){ return visit(ctx.loop()); }

        return null;

    }

    @Override
    public ASTNode visitStructDeclaration(RobocommandeParser.StructDeclarationContext ctx) {
        IdNode name = (IdNode)visit(ctx.id(0));
        List<IdNode> idNodes = new ArrayList<>();
        List<AssignmentNode> assignments = new ArrayList<>();

        int childrenCount = ctx.children.size();
        for(int i = 1 ; i < childrenCount ; i++){
            ParseTree field = ctx.children.get(i);
            if(field instanceof RobocommandeParser.AssignmentContext){
                assignments.add((AssignmentNode)visit(field));
            } else if(field instanceof RobocommandeParser.IdContext){
                idNodes.add((IdNode)visit(field));
            }
        }
        return new StructDeclarationNode(name, idNodes, assignments);
    }

    @Override
    public ASTNode visitDeclaration(RobocommandeParser.DeclarationContext ctx) {
        ExprNode exprNode = ctx.expr() != null ? (ExprNode)visit(ctx.expr()) : null;
        return new DeclarationNode((IdNode)visit(ctx.id()), exprNode);
    }

    @Override
    public ASTNode visitNewDeclaration(RobocommandeParser.NewDeclarationContext ctx) {
        return new NewDeclarationNode((IdNode)visit(ctx.id()), (ExprNode)visit(ctx.expr()));
    }

    @Override
    public ASTNode visitNewEvent(RobocommandeParser.NewEventContext ctx) {
        return new NewEventNode((IdNode)visit(ctx.id()), (BlockNode)visit(ctx.block()));
    }

    @Override
    public ASTNode visitFieldAssignment(RobocommandeParser.FieldAssignmentContext ctx) {
        FieldIdNode fieldIdNode = (FieldIdNode)visit(ctx.fieldId());
        ExprNode exprNode = (ExprNode)visit(ctx.expr());

        return new FieldAssignmentNode(fieldIdNode, exprNode);
    }

    @Override
    public ASTNode visitAssignment(RobocommandeParser.AssignmentContext ctx) {
        IdNode idNode = (IdNode)visit(ctx.id());
        ExprNode exprNode = (ExprNode)visit(ctx.expr());

        return new AssignmentNode(idNode, exprNode);
    }

    @Override
    public ASTNode visitIfStatement(RobocommandeParser.IfStatementContext ctx) {
        ExprNode predicate = null;
        BlockNode ifBlockNode = null;
        List<ElseIfStatementNode> elseIfNodes = new ArrayList<>();
        BlockNode elseBlockNode = null;

        int blockCount = ctx.block().size() - 1;

        for(int i = 0; i <= blockCount ; i++){
            if(i == 0){
                predicate = (ExprNode)visit(ctx.expr(i));
                ifBlockNode = (BlockNode)visit(ctx.block(i));
            } else if(i != 0 && i == blockCount){
                elseBlockNode = (BlockNode)visit(ctx.block(i));
            }
            else{
                elseIfNodes.add(new ElseIfStatementNode((ExprNode)visit(ctx.expr(i)),
                        (BlockNode)visit(ctx.block(i))));
            }
        }
        return new IfStatementNode(predicate, ifBlockNode, elseIfNodes, elseBlockNode);
    }

    @Override
    public ASTNode visitFunctionCall(RobocommandeParser.FunctionCallContext ctx) {
        IdNode idNode = ctx.id() != null ? (IdNode)visit(ctx.id()) : null;
        FieldIdNode fieldIdNode = ctx.fieldId() != null ? (FieldIdNode)visit(ctx.fieldId()) : null;

        ActualParamsNode actualParamsNode = ctx.actualParams() != null ? (ActualParamsNode)visit(ctx.actualParams()) : null;

        return new FunctionCallNode(fieldIdNode, idNode, actualParamsNode);
    }

    @Override
    public ASTNode visitStructInitialization(RobocommandeParser.StructInitializationContext ctx) {
        IdNode name = (IdNode)visit(ctx.id());
        List<AssignmentNode> assignments = new ArrayList<>();

        for(RobocommandeParser.AssignmentContext assignment : ctx.assignment()){
            assignments.add((AssignmentNode)visit(assignment));
        }
        return new StructInitializationNode(name, assignments);
    }

    @Override
    public ASTNode visitLoop(RobocommandeParser.LoopContext ctx) {
        ExprNode exprNode = (ExprNode)visit(ctx.expr());
        BlockNode blockNode = (BlockNode)visit(ctx.block());
        return new LoopNode(exprNode, blockNode);
    }

    @Override
    public ASTNode visitReturnStatement(RobocommandeParser.ReturnStatementContext ctx) {
        return new ReturnStatementNode((ExprNode)visit(ctx.expr()));
    }

    @Override
    public ASTNode visitLiteral(RobocommandeParser.LiteralContext ctx) {
        return new LiteralNode(ctx.getText());
    }

    @Override
    public ASTNode visitFieldIdentifier(RobocommandeParser.FieldIdentifierContext ctx) {
        return visit(ctx.fieldId());
    }

    @Override
    public ASTNode visitFCall(RobocommandeParser.FCallContext ctx) {
        IdNode idNode = ctx.functionCall().id() != null ? (IdNode)visit(ctx.functionCall().id()) : null;
        FieldIdNode fieldIdNode = ctx.functionCall().fieldId() != null ? (FieldIdNode)visit(ctx.functionCall().fieldId()) : null;

        ActualParamsNode actualParamsNode = ctx.functionCall().actualParams() != null ? (ActualParamsNode)visit(ctx.functionCall().actualParams()) : null;

        return new ExprFunctionCallNode(fieldIdNode, idNode, actualParamsNode);
    }

    @Override
    public ASTNode visitStructInit(RobocommandeParser.StructInitContext ctx) {
        return visit(ctx.structInitialization());
    }

    @Override
    public ASTNode visitGroupedExpression(RobocommandeParser.GroupedExpressionContext ctx) {
        return new GroupedExpressionNode((ExprNode)visit(ctx.expr()));
    }

    @Override
    public ASTNode visitNegateBool(RobocommandeParser.NegateBoolContext ctx) {
        return new NegateBoolNode((ExprNode)visit(ctx.expr()));
    }

    @Override
    public ASTNode visitNegateExpression(RobocommandeParser.NegateExpressionContext ctx) {
        return new NegateExpressionNode((ExprNode)visit(ctx.expr()));
    }

    @Override
    public ASTNode visitPower(RobocommandeParser.PowerContext ctx) {
        ExprNode base = (ExprNode)visit(ctx.expr(0));
        ExprNode exponent = (ExprNode)visit(ctx.expr(1));
        return new PowerNode(base, exponent);
    }


    @Override
    public ASTNode visitMultDivMod(RobocommandeParser.MultDivModContext ctx) {
        ExprNode left = (ExprNode)visit(ctx.expr(0));
        ExprNode right = (ExprNode)visit(ctx.expr(1));

        switch (getOperatorSymbol(ctx.children, "*", "/", "%")){
            case "*":
                return new MultNode(left, right);
            case "/":
                return new DivNode(left, right);
            case "%":
                return new ModNode(left, right);
            default:
                return null;
        }
    }



    @Override
    public ASTNode visitPlusOrMinus(RobocommandeParser.PlusOrMinusContext ctx) {
        ExprNode left = (ExprNode)visit(ctx.expr(0));
        ExprNode right = (ExprNode)visit(ctx.expr(1));

        switch (getOperatorSymbol(ctx.children, "+", "-")){
            case "+":
                return new PlusNode(left, right);
            case "-":
                return new MinusNode(left, right);
            default:
                return null;
        }
    }


    @Override
    public ASTNode visitComparison(RobocommandeParser.ComparisonContext ctx) {

        ExprNode left = (ExprNode)visit(ctx.expr(0));
        ExprNode right = (ExprNode)visit(ctx.expr(1));

        switch (getOperatorSymbol(ctx.children, "<=", ">=", "<", ">")){
            case "<=":
                return new LeqThanNode(left, right);
            case ">=":
                return new GeqThanNode(left, right);
            case "<":
                return new LessThanNode(left, right);
            case ">":
                return new GreaterThanNode(left, right);
            default:
                return null;
        }
    }

    @Override
    public ASTNode visitEquality(RobocommandeParser.EqualityContext ctx) {
        ExprNode left = (ExprNode)visit(ctx.expr(0));
        ExprNode right = (ExprNode)visit(ctx.expr(1));

        switch (getOperatorSymbol(ctx.children, "=", "!=")){
            case "=":
                return new EqualityNode(left, right);
            case "!=":
                return new InEqualityNode(left, right);
            default:
                return null;
        }
    }

    @Override
    public ASTNode visitAnd(RobocommandeParser.AndContext ctx) {
        ExprNode left = (ExprNode)visit(ctx.expr(0));
        ExprNode right = (ExprNode)visit(ctx.expr(1));
        return new AndNode(left, right);
    }
    @Override
    public ASTNode visitOr(RobocommandeParser.OrContext ctx) {
        ExprNode left = (ExprNode)visit(ctx.expr(0));
        ExprNode right = (ExprNode)visit(ctx.expr(1));
        return new OrNode(left, right);
    }

    @Override
    public ASTNode visitFieldId(RobocommandeParser.FieldIdContext ctx) {
        List<String> idsToBeConverted = Arrays.asList(ctx.getText().split("."));
        List<IdNode> idNodes = new ArrayList<IdNode>();
        idsToBeConverted.forEach(node -> idNodes.add(new IdNode(node)));
        return new FieldIdNode(idNodes);
    }

    @Override
    public ASTNode visitId(RobocommandeParser.IdContext ctx) {
        return new IdNode(ctx.ID().getText());
    }

    private String getOperatorSymbol(List<ParseTree> children, String... symbols){
        String res = "";
        for(ParseTree child : children){
            String current = child.getText();
            if(Arrays.asList(symbols).contains(current)){
                res = current;
            }
        }
        return res;
    }
}
