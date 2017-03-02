// Generated from /Users/Casper/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/parse.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link parseParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface parseVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link parseParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(parseParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(parseParser.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(parseParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(parseParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(parseParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(parseParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(parseParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(parseParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(parseParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#controlStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStructure(parseParser.ControlStructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(parseParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(parseParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(parseParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#binaryOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperation(parseParser.BinaryOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(parseParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#run}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun(parseParser.RunContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(parseParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#defineFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineFunction(parseParser.DefineFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#behaviorFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorFunction(parseParser.BehaviorFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#setupHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetupHeader(parseParser.SetupHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#runHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRunHeader(parseParser.RunHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link parseParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(parseParser.TestContext ctx);
}