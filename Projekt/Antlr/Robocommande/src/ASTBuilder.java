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
        indentationLevel++;
        String AST = "";

        for(RobocommandeParser.StmtContext stmt : ctx.stmt()){
            AST += visit(stmt);
        }
        indentationLevel--;
        return AST;
    }

    @Override
    public ASTNode visitSetupStmt(RobocommandeParser.SetupStmtContext ctx) {
        String AST = indent();
        if(ctx.declaration() != null){ AST += visit(ctx.declaration()); }
        else if(ctx.structDeclaration() != null){ AST += visit(ctx.structDeclaration()); }
        else if(ctx.assignment() != null){ AST += visit(ctx.assignment()); }
        else if(ctx.fieldAssignment() != null){ AST += visit(ctx.fieldAssignment()); }
        else if(ctx.ifStatement() != null){ AST += visit(ctx.ifStatement()); }
        else if(ctx.functionCall() != null){ AST += visit(ctx.functionCall()); }
        else if(ctx.loop() != null){ AST += visit(ctx.loop()); }
        else if(ctx.newEvent() != null){ AST += visit(ctx.newEvent()); }

        return  AST + "\n";
    }

    @Override
    public ASTNode visitStmt(RobocommandeParser.StmtContext ctx) {
        String AST = indent();
        if(ctx.declaration() != null){ AST += visit(ctx.declaration()); }
        else if(ctx.structDeclaration() != null){ AST += visit(ctx.structDeclaration()); }
        else if(ctx.assignment() != null){ AST += visit(ctx.assignment()); }
        else if(ctx.fieldAssignment() != null){ AST += visit(ctx.fieldAssignment()); }
        else if(ctx.ifStatement() != null){ AST += visit(ctx.ifStatement()); }
        else if(ctx.functionCall() != null){ AST += visit(ctx.functionCall()); }
        else if(ctx.loop() != null){ AST += visit(ctx.loop()); }
        else if(ctx.newDeclaration() != null){ AST += visit(ctx.newDeclaration()); }
        else if(ctx.returnStatement() != null){ AST += visit(ctx.returnStatement()); }

        return  AST + "\n";
    }


    @Override
    public ASTNode visitStructDeclaration(RobocommandeParser.StructDeclarationContext ctx) {
        String AST = "STRUCT " + visit(ctx.id(0)) + " {\n";
        indentationLevel++;
        int childrenCount = ctx.children.size();
        for(int i = 1 ; i < childrenCount ; i++){
            ParseTree field = ctx.children.get(i);
            if(field instanceof RobocommandeParser.AssignmentContext){
                AST += indent() + visit(field) + "\n";
            } else if(field instanceof RobocommandeParser.IdContext){
                AST += indent() + visit(field) + "\n";
            }
        }

        indentationLevel--;

        AST += indent() + "}";

        return AST;
    }

    @Override
    public ASTNode visitDeclaration(RobocommandeParser.DeclarationContext ctx) {
        String AST = "DECLARATION " + visit(ctx.id());
        if(ctx.expr() != null){
            AST += " := " + visit(ctx.expr());
        }
        return AST;
    }

    @Override
    public ASTNode visitNewDeclaration(RobocommandeParser.NewDeclarationContext ctx) {
        String AST = "NEW DECLARATION " + visit(ctx.id());
        if(ctx.expr() != null){
            AST += " := " + visit(ctx.expr());
        }
        return AST;
    }

    @Override
    public ASTNode visitNewEvent(RobocommandeParser.NewEventContext ctx) {
        return "NEW EVENT " + visit(ctx.id()) + "\n" + visit(ctx.block());
    }

    @Override
    public ASTNode visitFieldAssignment(RobocommandeParser.FieldAssignmentContext ctx) {
        return "FIELDASSIGN " + visit(ctx.fieldId()) + " := " + visit(ctx.expr());
    }

    @Override
    public ASTNode visitAssignment(RobocommandeParser.AssignmentContext ctx) {
        return "ASSIGN " + visit(ctx.id()) + " := " + visit(ctx.expr());
    }

    @Override
    public ASTNode visitIfStatement(RobocommandeParser.IfStatementContext ctx) {
        String AST = "";

        int blockCount = ctx.block().size() - 1;

        for(int i = 0; i <= blockCount ; i++){
            if(i == 0){
                AST += "IF " + visit(ctx.expr(i)) + "\n" + visit(ctx.block(i));
            } else if(i != 0 && i == blockCount){
                AST += indent() + "ELSE \n" + visit(ctx.block(i));
            }
            else{
                AST += indent() + "ELSE IF " + visit(ctx.expr(i)) + "\n" + visit(ctx.block(i));
            }
        }

        return AST;
    }

    @Override
    public ASTNode visitFunctionCall(RobocommandeParser.FunctionCallContext ctx) {
        String AST = "CALL ";
        AST += visit(ctx.id()) != null ? visit(ctx.id()) : visit(ctx.fieldId());
        AST += "(";
        if(ctx.actualParams() != null){
            AST += visit(ctx.actualParams());
        }
        AST += ")";
        return AST;
    }

    @Override
    public ASTNode visitStructInitialization(RobocommandeParser.StructInitializationContext ctx) {
        IdNode name = (IdNode)visit(ctx.id());





        String AST = visit(ctx.id()) + "(";
        indentationLevel++;
        for(RobocommandeParser.AssignmentContext assignment : ctx.assignment()){
            AST += "\n" + indent() + visit(assignment);
        }
        indentationLevel--;
        AST += "\n" + indent() + ")";
        return AST;

        goto


    }

    @Override
    public ASTNode visitLoop(RobocommandeParser.LoopContext ctx) {
        String AST = "LOOP ";
        AST += ctx.expr() != null ? "WHILE " + visit(ctx.expr()) : "";
        AST += "\n" + visit(ctx.block());
        return AST;
    }

    @Override
    public ASTNode visitReturnStatement(RobocommandeParser.ReturnStatementContext ctx) {
        return "RETURN " + visit(ctx.expr());
    }






    @Override
    public ASTNode visitLiteral(RobocommandeParser.LiteralContext ctx) {
        return ctx.getText();
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
        idsToBeConverted.forEach(node -> idNodes.add(new IdNode(node));
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
