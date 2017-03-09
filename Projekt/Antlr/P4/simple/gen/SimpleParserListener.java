// Generated from /Users/Kasper/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/simple/SimpleParser.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParserParser}.
 */
public interface SimpleParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpleParserParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpleParserParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleParserParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleParserParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SimpleParserParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SimpleParserParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(SimpleParserParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(SimpleParserParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void enterDefineFunction(SimpleParserParser.DefineFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void exitDefineFunction(SimpleParserParser.DefineFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorFunction(SimpleParserParser.BehaviorFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorFunction(SimpleParserParser.BehaviorFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void enterActualParams(SimpleParserParser.ActualParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void exitActualParams(SimpleParserParser.ActualParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void enterFormalParams(SimpleParserParser.FormalParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void exitFormalParams(SimpleParserParser.FormalParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SimpleParserParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SimpleParserParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SimpleParserParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SimpleParserParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SimpleParserParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SimpleParserParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SimpleParserParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SimpleParserParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SimpleParserParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SimpleParserParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#newDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNewDeclaration(SimpleParserParser.NewDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#newDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNewDeclaration(SimpleParserParser.NewDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(SimpleParserParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(SimpleParserParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SimpleParserParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SimpleParserParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(SimpleParserParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(SimpleParserParser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#setup}.
	 * @param ctx the parse tree
	 */
	void enterSetup(SimpleParserParser.SetupContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#setup}.
	 * @param ctx the parse tree
	 */
	void exitSetup(SimpleParserParser.SetupContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParserParser#fieldId}.
	 * @param ctx the parse tree
	 */
	void enterFieldId(SimpleParserParser.FieldIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParserParser#fieldId}.
	 * @param ctx the parse tree
	 */
	void exitFieldId(SimpleParserParser.FieldIdContext ctx);
}