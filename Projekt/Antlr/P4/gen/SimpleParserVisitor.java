// Generated from /home/pprintz/stuff/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/simple/SimpleParser.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SimpleParserParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleParserParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(SimpleParserParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(SimpleParserParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#defineFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineFunction(SimpleParserParser.DefineFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#behaviorFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorFunction(SimpleParserParser.BehaviorFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#actualParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParams(SimpleParserParser.ActualParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParams(SimpleParserParser.FormalParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SimpleParserParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleParserParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SimpleParserParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SimpleParserParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SimpleParserParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#newDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDeclaration(SimpleParserParser.NewDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(SimpleParserParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SimpleParserParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#run}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun(SimpleParserParser.RunContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(SimpleParserParser.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParserParser#fieldId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldId(SimpleParserParser.FieldIdContext ctx);
}