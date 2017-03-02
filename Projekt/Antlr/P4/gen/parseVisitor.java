// Generated from /Users/Casper/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/parse.g4 by ANTLR 4.6
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
	 * Visit a parse tree produced by {@link parse#controlStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStructure(parse.ControlStructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(parse.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(parse.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(parse.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#binaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperation(parse.BinaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(parse.ReturnStatementContext ctx);
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
	 * Visit a parse tree produced by {@link parse#defineFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineFunction(parse.DefineFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#behaviorFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorFunction(parse.BehaviorFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#setupHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetupHeader(parse.SetupHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link parse#runHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRunHeader(parse.RunHeaderContext ctx);
}