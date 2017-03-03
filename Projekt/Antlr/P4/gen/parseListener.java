// Generated from /Users/Kasper/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/parse.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link parseParser}.
 */
public interface parseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link parseParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(parseParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(parseParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(parseParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(parseParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#setup}.
	 * @param ctx the parse tree
	 */
	void enterSetup(parseParser.SetupContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#setup}.
	 * @param ctx the parse tree
	 */
	void exitSetup(parseParser.SetupContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(parseParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(parseParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(parseParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(parseParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(parseParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(parseParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(parseParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(parseParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(parseParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(parseParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(parseParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(parseParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(parseParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(parseParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#controlStructure}.
	 * @param ctx the parse tree
	 */
	void enterControlStructure(parseParser.ControlStructureContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#controlStructure}.
	 * @param ctx the parse tree
	 */
	void exitControlStructure(parseParser.ControlStructureContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(parseParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(parseParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(parseParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(parseParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(parseParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(parseParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperation(parseParser.BinaryOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#binaryOperation}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperation(parseParser.BinaryOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(parseParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(parseParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(parseParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(parseParser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(parseParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(parseParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void enterDefineFunction(parseParser.DefineFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void exitDefineFunction(parseParser.DefineFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorFunction(parseParser.BehaviorFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorFunction(parseParser.BehaviorFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#setupHeader}.
	 * @param ctx the parse tree
	 */
	void enterSetupHeader(parseParser.SetupHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#setupHeader}.
	 * @param ctx the parse tree
	 */
	void exitSetupHeader(parseParser.SetupHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link parseParser#runHeader}.
	 * @param ctx the parse tree
	 */
	void enterRunHeader(parseParser.RunHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link parseParser#runHeader}.
	 * @param ctx the parse tree
	 */
	void exitRunHeader(parseParser.RunHeaderContext ctx);
}