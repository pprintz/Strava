/**
 * Created by Kasper Dissing Bargsteen on 21/03/2017.
 */
public class PrettyPrinter extends RobocommandeBaseVisitor<String> {


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
            AST += visit(behaFunc);
        }
        for(RobocommandeParser.DefineFunctionContext defFunc : ctx.defineFunction()){
            AST += visit(defFunc);
        }
        return AST;
    }

    @Override
    public String visitStrategy(RobocommandeParser.StrategyContext ctx) {
        return "STRATEGY\n" + visit(ctx.strategyDefinition());
    }

    @Override
    public String visitDefaultStrategy(RobocommandeParser.DefaultStrategyContext ctx) {
        return "DEFAULT\n" + visit(ctx.strategyDefinition());
    }

    @Override
    public String visitStrategyDefinition(RobocommandeParser.StrategyDefinitionContext ctx) {
        return "";
    }

    @Override
    public String visitSetupBlock(RobocommandeParser.SetupBlockContext ctx) {
        String AST = "";

        for(RobocommandeParser.SetupStmtContext setupStmt : ctx.setupStmt()){
            AST += visit(setupStmt);
        }

        return AST;
    }

    @Override
    public String visitBlock(RobocommandeParser.BlockContext ctx) {
        String AST = "";

        for(RobocommandeParser.StmtContext stmt : ctx.stmt()){
            AST += visit(stmt);
        }

        return AST;
    }

    @Override
    public String visitSetupStmt(RobocommandeParser.SetupStmtContext ctx) {
        return "\n>> " + visit(ctx.getChild(1)) + "<<\n";
    }

    @Override
    public String visitStmt(RobocommandeParser.StmtContext ctx) {
        return super.visitStmt(ctx);
    }

    @Override
    public String visitDefineFunction(RobocommandeParser.DefineFunctionContext ctx) {
        return super.visitDefineFunction(ctx);
    }

    @Override
    public String visitBehaviorFunction(RobocommandeParser.BehaviorFunctionContext ctx) {
        return super.visitBehaviorFunction(ctx);
    }

    @Override
    public String visitStructDeclaration(RobocommandeParser.StructDeclarationContext ctx) {
        return super.visitStructDeclaration(ctx);
    }

    @Override
    public String visitDeclaration(RobocommandeParser.DeclarationContext ctx) {
        return "DECLARATION :: " + ctx.ID().getText() + " := " + visit(ctx.expr());
    }

    @Override
    public String visitNewDeclaration(RobocommandeParser.NewDeclarationContext ctx) {
        return super.visitNewDeclaration(ctx);
    }

    @Override
    public String visitNewEvent(RobocommandeParser.NewEventContext ctx) {
        return super.visitNewEvent(ctx);
    }

    @Override
    public String visitFieldAssignment(RobocommandeParser.FieldAssignmentContext ctx) {
        return super.visitFieldAssignment(ctx);
    }

    @Override
    public String visitAssignment(RobocommandeParser.AssignmentContext ctx) {
        return "ASSIGN " + ctx.ID().getText() + " := " + visit(ctx.expr());
    }

    @Override
    public String visitChangeStrategy(RobocommandeParser.ChangeStrategyContext ctx) {
        return super.visitChangeStrategy(ctx);
    }

    @Override
    public String visitIfStatement(RobocommandeParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    @Override
    public String visitFunctionCall(RobocommandeParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public String visitStructInitialization(RobocommandeParser.StructInitializationContext ctx) {
        return super.visitStructInitialization(ctx);
    }

    @Override
    public String visitLoop(RobocommandeParser.LoopContext ctx) {
        return super.visitLoop(ctx);
    }

    @Override
    public String visitReturnStatement(RobocommandeParser.ReturnStatementContext ctx) {
        return super.visitReturnStatement(ctx);
    }

    @Override
    public String visitFormalParams(RobocommandeParser.FormalParamsContext ctx) {
        return super.visitFormalParams(ctx);
    }

    @Override
    public String visitActualParams(RobocommandeParser.ActualParamsContext ctx) {
        return super.visitActualParams(ctx);
    }

    @Override
    public String visitComparison(RobocommandeParser.ComparisonContext ctx) {
        return super.visitComparison(ctx);
    }

    @Override
    public String visitOr(RobocommandeParser.OrContext ctx) {
        return super.visitOr(ctx);
    }

    @Override
    public String visitMultDivMod(RobocommandeParser.MultDivModContext ctx) {
        return super.visitMultDivMod(ctx);
    }

    @Override
    public String visitPlusOrMinus(RobocommandeParser.PlusOrMinusContext ctx) {
        return super.visitPlusOrMinus(ctx);
    }

    @Override
    public String visitNegateBool(RobocommandeParser.NegateBoolContext ctx) {
        return super.visitNegateBool(ctx);
    }

    @Override
    public String visitLiteral(RobocommandeParser.LiteralContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitGroupedExpression(RobocommandeParser.GroupedExpressionContext ctx) {
        return super.visitGroupedExpression(ctx);
    }

    @Override
    public String visitFieldIdentifier(RobocommandeParser.FieldIdentifierContext ctx) {
        return super.visitFieldIdentifier(ctx);
    }

    @Override
    public String visitAnd(RobocommandeParser.AndContext ctx) {
        return super.visitAnd(ctx);
    }

    @Override
    public String visitFCall(RobocommandeParser.FCallContext ctx) {
        return super.visitFCall(ctx);
    }

    @Override
    public String visitPower(RobocommandeParser.PowerContext ctx) {
        return super.visitPower(ctx);
    }

    @Override
    public String visitStructInitializator(RobocommandeParser.StructInitializatorContext ctx) {
        return super.visitStructInitializator(ctx);
    }

    @Override
    public String visitNegateNum(RobocommandeParser.NegateNumContext ctx) {
        return super.visitNegateNum(ctx);
    }

    @Override
    public String visitEquality(RobocommandeParser.EqualityContext ctx) {
        return super.visitEquality(ctx);
    }

    @Override
    public String visitFieldId(RobocommandeParser.FieldIdContext ctx) {
        return super.visitFieldId(ctx);
    }
}
