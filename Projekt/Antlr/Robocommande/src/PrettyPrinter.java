import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Kasper Dissing Bargsteen on 21/03/2017.
 */
public class PrettyPrinter extends RobocommandeBaseVisitor<String> {
    int indentationLevel = 0;

    private String indent(){
        return new String(new char[indentationLevel]).replace("\0", "    ");
    }

    @Override
    public String visitProg(RobocommandeParser.ProgContext ctx) {
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
    public String visitSetup(RobocommandeParser.SetupContext ctx) {
        return "SETUP\n" + visit(ctx.setupBlock());
    }

    @Override
    public String visitRun(RobocommandeParser.RunContext ctx) {
        return "RUN\n" + visit(ctx.block());
    }

    @Override
    public String visitFunctions(RobocommandeParser.FunctionsContext ctx) {
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
    public String visitDefineFunction(RobocommandeParser.DefineFunctionContext ctx) {
        return "DEFINE " + visit(ctx.id()) + "(" + visit(ctx.formalParams()) + ")\n" + visit(ctx.block());
    }

    @Override
    public String visitBehaviorFunction(RobocommandeParser.BehaviorFunctionContext ctx) {
        return "BEHAVIOR " + visit(ctx.id(0)) + "(" + visit(ctx.id(1)) + ")\n" + visit(ctx.block());
    }

    @Override
    public String visitFormalParams(RobocommandeParser.FormalParamsContext ctx) {
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
    public String visitActualParams(RobocommandeParser.ActualParamsContext ctx) {
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
    public String visitStrategy(RobocommandeParser.StrategyContext ctx) {
        return "STRATEGY " + visit(ctx.id()) + "\n" + visit(ctx.strategyDefinition());
    }

    @Override
    public String visitDefaultStrategy(RobocommandeParser.DefaultStrategyContext ctx) {
        return "DEFAULT\n" + visit(ctx.strategyDefinition());
    }

    @Override
    public String visitStrategyDefinition(RobocommandeParser.StrategyDefinitionContext ctx) {
        indentationLevel++;
        String AST = "";

        AST += ctx.run() != null ? indent() + visit(ctx.run()) : "";

        AST += ctx.functions() != null ? visit(ctx.functions()) : "";

        indentationLevel--;
        return AST;
    }

    @Override
    public String visitSetupBlock(RobocommandeParser.SetupBlockContext ctx) {
        indentationLevel++;
        String AST = "";

        for(RobocommandeParser.SetupStmtContext setupStmt : ctx.setupStmt()){
            AST += visit(setupStmt);
        }
        indentationLevel--;
        return AST;
    }

    @Override
    public String visitBlock(RobocommandeParser.BlockContext ctx) {
        indentationLevel++;
        String AST = "";

        for(RobocommandeParser.StmtContext stmt : ctx.stmt()){
            AST += visit(stmt);
        }
        indentationLevel--;
        return AST;
    }

    @Override
    public String visitSetupStmt(RobocommandeParser.SetupStmtContext ctx) {
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
    public String visitStmt(RobocommandeParser.StmtContext ctx) {
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
    public String visitStructDeclaration(RobocommandeParser.StructDeclarationContext ctx) {
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
    public String visitDeclaration(RobocommandeParser.DeclarationContext ctx) {
        String AST = "DECLARATION " + visit(ctx.id());
        if(ctx.expr() != null){
            AST += " := " + visit(ctx.expr());
        }
        return AST;
    }

    @Override
    public String visitNewDeclaration(RobocommandeParser.NewDeclarationContext ctx) {
        String AST = "NEW DECLARATION " + visit(ctx.id());
        if(ctx.expr() != null){
            AST += " := " + visit(ctx.expr());
        }
        return AST;
    }

    @Override
    public String visitNewEvent(RobocommandeParser.NewEventContext ctx) {
        return "NEW EVENT " + visit(ctx.id()) + "\n" + visit(ctx.block());
    }

    @Override
    public String visitFieldAssignment(RobocommandeParser.FieldAssignmentContext ctx) {
        return "FIELDASSIGN " + visit(ctx.fieldId()) + " := " + visit(ctx.expr());
    }

    @Override
    public String visitAssignment(RobocommandeParser.AssignmentContext ctx) {
        return "ASSIGN " + visit(ctx.id()) + " := " + visit(ctx.expr());
    }

    @Override
    public String visitIfStatement(RobocommandeParser.IfStatementContext ctx) {
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
    public String visitFunctionCall(RobocommandeParser.FunctionCallContext ctx) {
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
    public String visitStructInitialization(RobocommandeParser.StructInitializationContext ctx) {
        String AST = visit(ctx.id()) + "(";
        indentationLevel++;
        for(RobocommandeParser.AssignmentContext assignment : ctx.assignment()){
            AST += "\n" + indent() + visit(assignment);
        }
        indentationLevel--;
        AST += "\n" + indent() + ")";
        return AST;
    }

    @Override
    public String visitLoop(RobocommandeParser.LoopContext ctx) {
        String AST = "LOOP ";
        AST += ctx.expr() != null ? "WHILE " + visit(ctx.expr()) : "";
        AST += "\n" + visit(ctx.block());
        return AST;
    }

    @Override
    public String visitReturnStatement(RobocommandeParser.ReturnStatementContext ctx) {
        return "RETURN " + visit(ctx.expr());
    }






    @Override
    public String visitLiteral(RobocommandeParser.LiteralContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitFieldIdentifier(RobocommandeParser.FieldIdentifierContext ctx) {
        return visit(ctx.fieldId());
    }

    @Override
    public String visitFCall(RobocommandeParser.FCallContext ctx) {
        return visit(ctx.functionCall());
    }

    @Override
    public String visitStructInit(RobocommandeParser.StructInitContext ctx) {
        return visit(ctx.structInitialization());
    }

    @Override
    public String visitGroupedExpression(RobocommandeParser.GroupedExpressionContext ctx) {
        return "( " + visit(ctx.expr()) + " )";
    }

    @Override
    public String visitNegateBool(RobocommandeParser.NegateBoolContext ctx) {
        return "NOT " + visit(ctx.expr());
    }

    @Override
    public String visitNegateExpression(RobocommandeParser.NegateExpressionContext ctx) {
        return "- " + visit(ctx.expr());
    }

    @Override
    public String visitPower(RobocommandeParser.PowerContext ctx) {
       return visit(ctx.expr(0)) + " ^ " + visit(ctx.expr(1));
    }


    @Override
    public String visitMultDivMod(RobocommandeParser.MultDivModContext ctx) {
        return visit(ctx.expr(0))
                + getOperatorSymbol(ctx.children, "*", "/", "%")
                + visit(ctx.expr(1));
    }



    @Override
    public String visitPlusOrMinus(RobocommandeParser.PlusOrMinusContext ctx) {
        return visit(ctx.expr(0))
                + getOperatorSymbol(ctx.children, "+", "-")
                + visit(ctx.expr(1));
    }


    @Override
    public String visitComparison(RobocommandeParser.ComparisonContext ctx) {
        return visit(ctx.expr(0))
                + getOperatorSymbol(ctx.children, "<=", ">=", "<", ">")
                + visit(ctx.expr(1));
    }

    @Override
    public String visitEquality(RobocommandeParser.EqualityContext ctx) {
        return visit(ctx.expr(0))
                + getOperatorSymbol(ctx.children, "=", "!=")
                + visit(ctx.expr(1));
    }

    @Override
    public String visitAnd(RobocommandeParser.AndContext ctx) {
       return visit(ctx.expr(0)) + " AND " + visit(ctx.expr(1));
    }
    @Override
    public String visitOr(RobocommandeParser.OrContext ctx) {
        return visit(ctx.expr(0)) + " OR " + visit(ctx.expr(1));
    }

    @Override
    public String visitFieldId(RobocommandeParser.FieldIdContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitId(RobocommandeParser.IdContext ctx) {
        return ctx.ID().getText();
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
