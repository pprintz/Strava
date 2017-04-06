import gen.SimpleParserBaseVisitor;
import gen.SimpleParserParser;

/**
 * Created by pprintz on 3/10/17.
 */
public class PrettyPrinter extends SimpleParserBaseVisitor<Void> {
    @Override
    public Void visitActualParams(SimpleParserParser.ActualParamsContext ctx) {
        return super.visitActualParams(ctx);
    }

    @Override
    public Void visitAssignment(SimpleParserParser.AssignmentContext ctx) {
        return super.visitAssignment(ctx);
    }

    @Override
    public Void visitBehaviorFunction(SimpleParserParser.BehaviorFunctionContext ctx) {
        return super.visitBehaviorFunction(ctx);
    }

    @Override
    public Void visitBlock(SimpleParserParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public Void visitDeclaration(SimpleParserParser.DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }

    @Override
    public Void visitDefineFunction(SimpleParserParser.DefineFunctionContext ctx) {
        return super.visitDefineFunction(ctx);
    }

    @Override
    public Void visitExpr(SimpleParserParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public Void visitFieldId(SimpleParserParser.FieldIdContext ctx) {
        return super.visitFieldId(ctx);
    }

    @Override
    public Void visitFormalParams(SimpleParserParser.FormalParamsContext ctx) {
        return super.visitFormalParams(ctx);
    }

    @Override
    public Void visitFunctionCall(SimpleParserParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public Void visitFunctions(SimpleParserParser.FunctionsContext ctx) {
        return super.visitFunctions(ctx);
    }

    @Override
    public Void visitIfStatement(SimpleParserParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    @Override
    public Void visitLoop(SimpleParserParser.LoopContext ctx) {
        return super.visitLoop(ctx);
    }

    @Override
    public Void visitNewDeclaration(SimpleParserParser.NewDeclarationContext ctx) {
        return super.visitNewDeclaration(ctx);
    }

    @Override
    public Void visitProg(SimpleParserParser.ProgContext ctx) {
        System.out.println("p");
        return super.visitProg(ctx);
    }

    @Override
    public Void visitReturnStatement(SimpleParserParser.ReturnStatementContext ctx) {
        return super.visitReturnStatement(ctx);
    }

    @Override
    public Void visitRun(SimpleParserParser.RunContext ctx) {
        System.out.println(ctx.block().toString());
        return super.visitRun(ctx);
    }

    @Override
    public Void visitSetup(SimpleParserParser.SetupContext ctx) {
        return super.visitSetup(ctx);
    }

    @Override
    public Void visitStmt(SimpleParserParser.StmtContext ctx) {
        return super.visitStmt(ctx);
    }
}
