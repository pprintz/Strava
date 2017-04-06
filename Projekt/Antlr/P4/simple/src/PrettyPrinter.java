/**
 * Created by Kasper Dissing Bargsteen on 17/03/2017.
 */

public class PrettyPrinter extends SimpleBaseVisitor<String> {

    @Override
    public String visitProg(SimpleParser.ProgContext ctx) {
        return super.visitProg(ctx);
    }

    @Override
    public String visitSetup(SimpleParser.SetupContext ctx) {
        return super.visitSetup(ctx);
    }

    @Override
    public String visitRun(SimpleParser.RunContext ctx) {
        return super.visitRun(ctx);
    }

    @Override
    public String visitFunctions(SimpleParser.FunctionsContext ctx) {
        return super.visitFunctions(ctx);
    }

    @Override
    public String visitBlock(SimpleParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public String visitStmt(SimpleParser.StmtContext ctx) {
        return super.visitStmt(ctx);
    }

    @Override
    public String visitDefineFunction(SimpleParser.DefineFunctionContext ctx) {
        return super.visitDefineFunction(ctx);
    }

    @Override
    public String visitBehaviorFunction(SimpleParser.BehaviorFunctionContext ctx) {
        return super.visitBehaviorFunction(ctx);
    }

    @Override
    public String visitStructDeclaration(SimpleParser.StructDeclarationContext ctx) {
        return super.visitStructDeclaration(ctx);
    }

    @Override
    public String visitDeclaration(SimpleParser.DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }

    @Override
    public String visitNewDeclaration(SimpleParser.NewDeclarationContext ctx) {
        return super.visitNewDeclaration(ctx);
    }

    @Override
    public String visitFieldAssignment(SimpleParser.FieldAssignmentContext ctx) {
        return super.visitFieldAssignment(ctx);
    }

    @Override
    public String visitAssignment(SimpleParser.AssignmentContext ctx) {
        return super.visitAssignment(ctx);
    }

    @Override
    public String visitIfStatement(SimpleParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    @Override
    public String visitFunctionCall(SimpleParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public String visitStructInitialization(SimpleParser.StructInitializationContext ctx) {
        return super.visitStructInitialization(ctx);
    }

    @Override
    public String visitLoop(SimpleParser.LoopContext ctx) {
        return super.visitLoop(ctx);
    }

    @Override
    public String visitReturnStatement(SimpleParser.ReturnStatementContext ctx) {
        return super.visitReturnStatement(ctx);
    }

    @Override
    public String visitFormalParams(SimpleParser.FormalParamsContext ctx) {
        return super.visitFormalParams(ctx);
    }

    @Override
    public String visitActualParams(SimpleParser.ActualParamsContext ctx) {
        return super.visitActualParams(ctx);
    }

    @Override
    public String visitComparison(SimpleParser.ComparisonContext ctx) {
        return super.visitComparison(ctx);
    }

    @Override
    public String visitOr(SimpleParser.OrContext ctx) {
        return super.visitOr(ctx);
    }

    @Override
    public String visitMultDivMod(SimpleParser.MultDivModContext ctx) {
        return super.visitMultDivMod(ctx);
    }

    @Override
    public String visitPlusOrMinus(SimpleParser.PlusOrMinusContext ctx) {
        return super.visitPlusOrMinus(ctx);
    }

    @Override
    public String visitNegateBool(SimpleParser.NegateBoolContext ctx) {
        return super.visitNegateBool(ctx);
    }

    @Override
    public String visitList(SimpleParser.ListContext ctx) {
        return super.visitList(ctx);
    }

    @Override
    public String visitGroupedExpression(SimpleParser.GroupedExpressionContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public String visitLiteral(SimpleParser.LiteralContext ctx) {
        return ctx.getText();
    }

    @Override
    public String visitFieldIdentifier(SimpleParser.FieldIdentifierContext ctx) {
        return visit(ctx.fieldId());
    }

    @Override
    public String visitAnd(SimpleParser.AndContext ctx) {
        return super.visitAnd(ctx);
    }

    @Override
    public String visitFCall(SimpleParser.FCallContext ctx) {
        return super.visitFCall(ctx);
    }

    @Override
    public String visitPower(SimpleParser.PowerContext ctx) {
        return super.visitPower(ctx);
    }

    @Override
    public String visitStructInitializator(SimpleParser.StructInitializatorContext ctx) {
        return super.visitStructInitializator(ctx);
    }

    @Override
    public String visitNegateNum(SimpleParser.NegateNumContext ctx) {
        return super.visitNegateNum(ctx);
    }

    @Override
    public String visitEquality(SimpleParser.EqualityContext ctx) {
        return super.visitEquality(ctx);
    }

    @Override
    public String visitFieldId(SimpleParser.FieldIdContext ctx) {
        return super.visitFieldId(ctx);
    }
}
