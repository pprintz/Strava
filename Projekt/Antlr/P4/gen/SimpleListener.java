// Generated from C:/Users/Teitur/Desktop/P4-AAU-Kursusopgaver/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/simple\Simple.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleParser}.
 */
public interface SimpleListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpleParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpleParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#setup}.
	 * @param ctx the parse tree
	 */
	void enterSetup(SimpleParser.SetupContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#setup}.
	 * @param ctx the parse tree
	 */
	void exitSetup(SimpleParser.SetupContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(SimpleParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(SimpleParser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(SimpleParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(SimpleParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SimpleParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SimpleParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void enterDefineFunction(SimpleParser.DefineFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#defineFunction}.
	 * @param ctx the parse tree
	 */
	void exitDefineFunction(SimpleParser.DefineFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void enterBehaviorFunction(SimpleParser.BehaviorFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#behaviorFunction}.
	 * @param ctx the parse tree
	 */
	void exitBehaviorFunction(SimpleParser.BehaviorFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#strategyFunction}.
	 * @param ctx the parse tree
	 */
	void enterStrategyFunction(SimpleParser.StrategyFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#strategyFunction}.
	 * @param ctx the parse tree
	 */
	void exitStrategyFunction(SimpleParser.StrategyFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(SimpleParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(SimpleParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(SimpleParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(SimpleParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#newDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNewDeclaration(SimpleParser.NewDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#newDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNewDeclaration(SimpleParser.NewDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#newEvent}.
	 * @param ctx the parse tree
	 */
	void enterNewEvent(SimpleParser.NewEventContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#newEvent}.
	 * @param ctx the parse tree
	 */
	void exitNewEvent(SimpleParser.NewEventContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#fieldAssignment}.
	 * @param ctx the parse tree
	 */
	void enterFieldAssignment(SimpleParser.FieldAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#fieldAssignment}.
	 * @param ctx the parse tree
	 */
	void exitFieldAssignment(SimpleParser.FieldAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SimpleParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SimpleParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#changeStrategy}.
	 * @param ctx the parse tree
	 */
	void enterChangeStrategy(SimpleParser.ChangeStrategyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#changeStrategy}.
	 * @param ctx the parse tree
	 */
	void exitChangeStrategy(SimpleParser.ChangeStrategyContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(SimpleParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(SimpleParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(SimpleParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(SimpleParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#structInitialization}.
	 * @param ctx the parse tree
	 */
	void enterStructInitialization(SimpleParser.StructInitializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#structInitialization}.
	 * @param ctx the parse tree
	 */
	void exitStructInitialization(SimpleParser.StructInitializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(SimpleParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(SimpleParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(SimpleParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(SimpleParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void enterFormalParams(SimpleParser.FormalParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#formalParams}.
	 * @param ctx the parse tree
	 */
	void exitFormalParams(SimpleParser.FormalParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void enterActualParams(SimpleParser.ActualParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#actualParams}.
	 * @param ctx the parse tree
	 */
	void exitActualParams(SimpleParser.ActualParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparison(SimpleParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparison(SimpleParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code or}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOr(SimpleParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code or}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOr(SimpleParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDivMod}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultDivMod(SimpleParser.MultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDivMod}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultDivMod(SimpleParser.MultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusOrMinus}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusOrMinus(SimpleParser.PlusOrMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusOrMinus}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusOrMinus(SimpleParser.PlusOrMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negateBool}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegateBool(SimpleParser.NegateBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negateBool}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegateBool(SimpleParser.NegateBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code list}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterList(SimpleParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code list}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitList(SimpleParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literal}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(SimpleParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(SimpleParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code groupedExpression}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGroupedExpression(SimpleParser.GroupedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code groupedExpression}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGroupedExpression(SimpleParser.GroupedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fieldIdentifier}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFieldIdentifier(SimpleParser.FieldIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fieldIdentifier}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFieldIdentifier(SimpleParser.FieldIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code and}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd(SimpleParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code and}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd(SimpleParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fCall}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFCall(SimpleParser.FCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fCall}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFCall(SimpleParser.FCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code power}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPower(SimpleParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code power}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPower(SimpleParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code structInitializator}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStructInitializator(SimpleParser.StructInitializatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code structInitializator}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStructInitializator(SimpleParser.StructInitializatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negateNum}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegateNum(SimpleParser.NegateNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negateNum}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegateNum(SimpleParser.NegateNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equality}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquality(SimpleParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equality}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquality(SimpleParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleParser#fieldId}.
	 * @param ctx the parse tree
	 */
	void enterFieldId(SimpleParser.FieldIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleParser#fieldId}.
	 * @param ctx the parse tree
	 */
	void exitFieldId(SimpleParser.FieldIdContext ctx);
}