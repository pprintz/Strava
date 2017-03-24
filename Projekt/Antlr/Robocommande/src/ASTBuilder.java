import jdk.nashorn.internal.ir.Block;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kasper Dissing Bargsteen on 21/03/2017.
 */
public class ASTBuilder extends RobocommandeBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProg(RobocommandeParser.ProgContext ctx) {
        String AST = "";
        AST += visit(ctx.setup());
        AST += visit(ctx.defaultStrategy());

        for(RobocommandeParser.StrategyContext strategy : ctx.strategy()){
            AST += visit(strategy);
        }

        for(RobocommandeParser.DefineFunctionContext defFunc : ctx.defineFunction()){
            AST += visit(defFunc);
        }
        return AST;
    }

    @Override
    public ASTNode visitSetup(RobocommandeParser.SetupContext ctx) {
        return "SETUP\n" + visit(ctx.setupBlock());
    }

    @Override
    public ASTNode visitRun(RobocommandeParser.RunContext ctx) {
        return "RUN\n" + visit(ctx.block());
    }

    @Override
    public ASTNode visitFunctions(RobocommandeParser.FunctionsContext ctx) {
        String AST = "";
        for(RobocommandeParser.BehaviorFunctionContext behaFunc : ctx.behaviorFunction()){
            AST += indent() + visit(behaFunc);
        }
        for(RobocommandeParser.DefineFunctionContext defFunc : ctx.defineFunction()){
            AST += indent() + visit(defFunc);
        }
        return AST;
    }

    @Override
    public ASTNode visitDefineFunction(RobocommandeParser.DefineFunctionContext ctx) {
        return "DEFINE " + visit(ctx.id()) + "(" + visit(ctx.formalParams()) + ")\n" + visit(ctx.block());
    }

    @Override
    public ASTNode visitBehaviorFunction(RobocommandeParser.BehaviorFunctionContext ctx) {
        return "BEHAVIOR " + visit(ctx.id(0)) + "(" + visit(ctx.id(1)) + ")\n" + visit(ctx.block());
    }

    @Override
    public ASTNode visitFormalParams(RobocommandeParser.FormalParamsContext ctx) {
        String AST = "";
        int size = ctx.id().size() - 1;
        for(int i = 0; i <= size; i++){
            if(i == size){
                AST += visit(ctx.id(i));
            }
            else{
                AST += visit(ctx.id(i)) + ", ";
            }
        }

        return AST;
    }

    @Override
    public ASTNode visitActualParams(RobocommandeParser.ActualParamsContext ctx) {
        String AST = "";
        int size = ctx.expr().size() - 1;
        for(int i = 0; i <= size; i++){
            if(i == size){
                AST += visit(ctx.expr(i));
            }
            else{
                AST += visit(ctx.expr(i)) + ", ";
            }
        }
        return AST;
    }

    @Override
    public ASTNode visitStrategy(RobocommandeParser.StrategyContext ctx) {
        return "STRATEGY " + visit(ctx.id()) + "\n" + visit(ctx.strategyDefinition());
    }

    @Override
    public ASTNode visitDefaultStrategy(RobocommandeParser.DefaultStrategyContext ctx) {
        return "DEFAULT\n" + visit(ctx.strategyDefinition());
    }

    @Override
    public ASTNode visitStrategyDefinition(RobocommandeParser.StrategyDefinitionContext ctx) {
        indentationLevel++;
        String AST = "";

        AST += ctx.run() != null ? indent() + visit(ctx.run()) : "";

        AST += ctx.functions() != null ? visit(ctx.functions()) : "";

        indentationLevel--;
        return AST;
    }

    @Override
    public ASTNode visitSetupBlock(RobocommandeParser.SetupBlockContext ctx) {
        indentationLevel++;
        String AST = "";

        for(RobocommandeParser.SetupStmtContext setupStmt : ctx.setupStmt()){
            AST += visit(setupStmt);
        }
        indentationLevel--;
        return AST;
    }

    @Override
    public ASTNode visitBlock(RobocommandeParser.BlockContext ctx) {

        List<FunctionStmtNode> functionStmtNodes = new ArrayList<>();
        for(RobocommandeParser.StmtContext stmt : ctx.stmt()){
            functionStmtNodes.add((FunctionStmtNode)visit(stmt));
        }
        return new BlockNode(functionStmtNodes);
    }

    @Override
    public ASTNode visitSetupStmt(RobocommandeParser.SetupStmtContext ctx) {
        if(ctx.declaration() != null){ return visit(ctx.declaration()); }
        else if(ctx.structDeclaration() != null){ return visit(ctx.structDeclaration()); }
        else if(ctx.assignment() != null){ return visit(ctx.assignment()); }
        else if(ctx.fieldAssignment() != null){ return visit(ctx.fieldAssignment()); }
        else if(ctx.ifStatement() != null){ return visit(ctx.ifStatement()); }
        else if(ctx.functionCall() != null){ return visit(ctx.functionCall()); }
        else if(ctx.loop() != null){ return visit(ctx.loop()); }
        else if(ctx.newEvent() != null){ return visit(ctx.newEvent()); }

        return  null;
    }

    @Override
    public ASTNode visitStmt(RobocommandeParser.StmtContext ctx) {
        if(ctx.declaration() != null){ return visit(ctx.declaration()); }
        else if(ctx.structDeclaration() != null){ return visit(ctx.structDeclaration()); }
        else if(ctx.assignment() != null){ return visit(ctx.assignment()); }
        else if(ctx.fieldAssignment() != null){ return visit(ctx.fieldAssignment()); }
        else if(ctx.ifStatement() != null){ return visit(ctx.ifStatement()); }
        else if(ctx.functionCall() != null){ return visit(ctx.functionCall()); }
        else if(ctx.loop() != null){ return visit(ctx.loop()); }
        else if(ctx.newDeclaration() != null){ return visit(ctx.newDeclaration()); }
        else if(ctx.returnStatement() != null){ return visit(ctx.returnStatement()); }

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
        return new DeclarationNode((IdNode)visit(ctx.id()), (ExprNode)visit(ctx.expr()));
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
                ifBlockNode = (BlockNode)visit(ctx.expr(i));
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
        IdNode idNode = (IdNode)visit(ctx.id()); // what if null?
        FieldIdNode fieldIdNode = (FieldIdNode)visit(ctx.fieldId()); // what if null?
        ActualParamsNode actualParamsNode = (ActualParamsNode)visit(ctx.actualParams());

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
        return visit(ctx.functionCall());
    }

    @Override
    public ASTNode visitStructInit(RobocommandeParser.StructInitContext ctx) {
        return visit(ctx.structInitialization());
    }

    @Override
    public ASTNode visitGroupedExpression(RobocommandeParser.GroupedExpressionContext ctx) {
        return new GroupedExpression((ExprNode)visit(ctx.expr()));
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
                res = " " + current + " ";
            }
        }
        return res;
    }
}
