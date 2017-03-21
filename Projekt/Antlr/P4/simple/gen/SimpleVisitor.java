// Generated from /home/pprintz/stuff/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/simple/Simple.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SimpleParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(SimpleParser.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#run}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun(SimpleParser.RunContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(SimpleParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#strategy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategy(SimpleParser.StrategyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#defaultStrategy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultStrategy(SimpleParser.DefaultStrategyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#strategyDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategyDefinition(SimpleParser.StrategyDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(SimpleParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#defineFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineFunction(SimpleParser.DefineFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#behaviorFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorFunction(SimpleParser.BehaviorFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(SimpleParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(SimpleParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#newDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDeclaration(SimpleParser.NewDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#newEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewEvent(SimpleParser.NewEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#fieldAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAssignment(SimpleParser.FieldAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SimpleParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#changeStrategy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChangeStrategy(SimpleParser.ChangeStrategyContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(SimpleParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SimpleParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#structInitialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructInitialization(SimpleParser.StructInitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(SimpleParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(SimpleParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParams(SimpleParser.FormalParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#actualParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParams(SimpleParser.ActualParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(SimpleParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(SimpleParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivMod}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivMod(SimpleParser.MultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusOrMinus}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusOrMinus(SimpleParser.PlusOrMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negateBool}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegateBool(SimpleParser.NegateBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code list}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(SimpleParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(SimpleParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupedExpression}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupedExpression(SimpleParser.GroupedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldIdentifier}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldIdentifier(SimpleParser.FieldIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(SimpleParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fCall}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFCall(SimpleParser.FCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code power}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(SimpleParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structInitializator}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructInitializator(SimpleParser.StructInitializatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negateNum}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegateNum(SimpleParser.NegateNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equality}
	 * labeled alternative in {@link SimpleParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(SimpleParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleParser#fieldId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldId(SimpleParser.FieldIdContext ctx);
}