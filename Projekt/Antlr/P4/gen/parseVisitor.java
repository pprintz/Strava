// Generated from /Users/Casper/Downloads/Studio_Code/P4/parse.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link parse}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface parseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link parse#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(parse.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(parse.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(parse.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(parse.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(parse.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(parse.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(parse.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(parse.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(parse.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(parse.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#controlStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStructure(parse.ControlStructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#returnExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpression(parse.ReturnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#run}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun(parse.RunContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(parse.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#setupHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetupHeader(parse.SetupHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(parse.ExpressionContext ctx);
}