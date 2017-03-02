// Generated from /Users/Casper/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/parse.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link parse}.
 */
public interface parseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link parse#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(parse.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(parse.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#setup}.
	 * @param ctx the parse tree
	 */
	void enterSetup(parse.SetupContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#setup}.
	 * @param ctx the parse tree
	 */
	void exitSetup(parse.SetupContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(parse.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(parse.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(parse.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(parse.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(parse.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(parse.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(parse.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(parse.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(parse.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(parse.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(parse.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(parse.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(parse.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(parse.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#controlStructure}.
	 * @param ctx the parse tree
	 */
	void enterControlStructure(parse.ControlStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#controlStructure}.
	 * @param ctx the parse tree
	 */
	void exitControlStructure(parse.ControlStructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(parse.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(parse.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(parse.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(parse.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(parse.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(parse.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(parse.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(parse.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(parse.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(parse.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(parse.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(parse.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(parse.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(parse.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#defineFunction}.
	 * @param ctx the parse tree
	 */
	void enterDefineFunction(parse.DefineFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#defineFunction}.
	 * @param ctx the parse tree
	 */
	void exitDefineFunction(parse.DefineFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorFunction(parse.BehaviorFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorFunction(parse.BehaviorFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#setupHeader}.
	 * @param ctx the parse tree
	 */
	void enterSetupHeader(parse.SetupHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#setupHeader}.
	 * @param ctx the parse tree
	 */
	void exitSetupHeader(parse.SetupHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link parse#runHeader}.
	 * @param ctx the parse tree
	 */
	void enterRunHeader(parse.RunHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link parse#runHeader}.
	 * @param ctx the parse tree
	 */
	void exitRunHeader(parse.RunHeaderContext ctx);
}