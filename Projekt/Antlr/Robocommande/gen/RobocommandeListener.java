// Generated from C:/Users/Teitur/Desktop/P4/P4-AAU-Kursusopgaver/Projekt/Antlr/Robocommande\Robocommande.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RobocommandeParser}.
 */
public interface RobocommandeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(RobocommandeParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(RobocommandeParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#setup}.
	 * @param ctx the parse tree
	 */
	void enterSetup(RobocommandeParser.SetupContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#setup}.
	 * @param ctx the parse tree
	 */
	void exitSetup(RobocommandeParser.SetupContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(RobocommandeParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(RobocommandeParser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(RobocommandeParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(RobocommandeParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void enterDefineFunction(RobocommandeParser.DefineFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void exitDefineFunction(RobocommandeParser.DefineFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorFunction(RobocommandeParser.BehaviorFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorFunction(RobocommandeParser.BehaviorFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void enterFormalParams(RobocommandeParser.FormalParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void exitFormalParams(RobocommandeParser.FormalParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void enterActualParams(RobocommandeParser.ActualParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void exitActualParams(RobocommandeParser.ActualParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#strategy}.
	 * @param ctx the parse tree
	 */
	void enterStrategy(RobocommandeParser.StrategyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#strategy}.
	 * @param ctx the parse tree
	 */
	void exitStrategy(RobocommandeParser.StrategyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#defaultStrategy}.
	 * @param ctx the parse tree
	 */
	void enterDefaultStrategy(RobocommandeParser.DefaultStrategyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#defaultStrategy}.
	 * @param ctx the parse tree
	 */
	void exitDefaultStrategy(RobocommandeParser.DefaultStrategyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#strategyDefinition}.
	 * @param ctx the parse tree
	 */
	void enterStrategyDefinition(RobocommandeParser.StrategyDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#strategyDefinition}.
	 * @param ctx the parse tree
	 */
	void exitStrategyDefinition(RobocommandeParser.StrategyDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#setupBlock}.
	 * @param ctx the parse tree
	 */
	void enterSetupBlock(RobocommandeParser.SetupBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#setupBlock}.
	 * @param ctx the parse tree
	 */
	void exitSetupBlock(RobocommandeParser.SetupBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(RobocommandeParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(RobocommandeParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void enterSetupStmt(RobocommandeParser.SetupStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#setupStmt}.
	 * @param ctx the parse tree
	 */
	void exitSetupStmt(RobocommandeParser.SetupStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(RobocommandeParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(RobocommandeParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#generalStmtPart}.
	 * @param ctx the parse tree
	 */
	void enterGeneralStmtPart(RobocommandeParser.GeneralStmtPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#generalStmtPart}.
	 * @param ctx the parse tree
	 */
	void exitGeneralStmtPart(RobocommandeParser.GeneralStmtPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#structDefinition}.
	 * @param ctx the parse tree
	 */
	void enterStructDefinition(RobocommandeParser.StructDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#structDefinition}.
	 * @param ctx the parse tree
	 */
	void exitStructDefinition(RobocommandeParser.StructDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(RobocommandeParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(RobocommandeParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(RobocommandeParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(RobocommandeParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#newEvent}.
	 * @param ctx the parse tree
	 */
	void enterNewEvent(RobocommandeParser.NewEventContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#newEvent}.
	 * @param ctx the parse tree
	 */
	void exitNewEvent(RobocommandeParser.NewEventContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#fieldAssignment}.
	 * @param ctx the parse tree
	 */
	void enterFieldAssignment(RobocommandeParser.FieldAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#fieldAssignment}.
	 * @param ctx the parse tree
	 */
	void exitFieldAssignment(RobocommandeParser.FieldAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(RobocommandeParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(RobocommandeParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(RobocommandeParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(RobocommandeParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(RobocommandeParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(RobocommandeParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#structInitialization}.
	 * @param ctx the parse tree
	 */
	void enterStructInitialization(RobocommandeParser.StructInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#structInitialization}.
	 * @param ctx the parse tree
	 */
	void exitStructInitialization(RobocommandeParser.StructInitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(RobocommandeParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(RobocommandeParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(RobocommandeParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(RobocommandeParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structInit}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStructInit(RobocommandeParser.StructInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structInit}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStructInit(RobocommandeParser.StructInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(RobocommandeParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(RobocommandeParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldIdentifier}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFieldIdentifier(RobocommandeParser.FieldIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldIdentifier}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFieldIdentifier(RobocommandeParser.FieldIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fCall}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFCall(RobocommandeParser.FCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fCall}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFCall(RobocommandeParser.FCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(RobocommandeParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(RobocommandeParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(RobocommandeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(RobocommandeParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link RobocommandeParser#fieldId}.
	 * @param ctx the parse tree
	 */
	void enterFieldId(RobocommandeParser.FieldIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RobocommandeParser#fieldId}.
	 * @param ctx the parse tree
	 */
	void exitFieldId(RobocommandeParser.FieldIdContext ctx);
}