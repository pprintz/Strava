// Generated from /Users/Kasper/P4-AAU-Kursusopgaver/Projekt/Antlr/Robocommande/Robocommande.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RobocommandeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RobocommandeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(RobocommandeParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#setup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetup(RobocommandeParser.SetupContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#run}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun(RobocommandeParser.RunContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(RobocommandeParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#defineFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineFunction(RobocommandeParser.DefineFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#behaviorFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBehaviorFunction(RobocommandeParser.BehaviorFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#formalParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParams(RobocommandeParser.FormalParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#actualParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParams(RobocommandeParser.ActualParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#strategy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategy(RobocommandeParser.StrategyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#defaultStrategy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultStrategy(RobocommandeParser.DefaultStrategyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#strategyDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrategyDefinition(RobocommandeParser.StrategyDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#setupBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetupBlock(RobocommandeParser.SetupBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(RobocommandeParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#setupStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetupStmt(RobocommandeParser.SetupStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(RobocommandeParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#generalStmtPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneralStmtPart(RobocommandeParser.GeneralStmtPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#structDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDefinition(RobocommandeParser.StructDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(RobocommandeParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numType}
	 * labeled alternative in {@link RobocommandeParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumType(RobocommandeParser.NumTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textType}
	 * labeled alternative in {@link RobocommandeParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextType(RobocommandeParser.TextTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link RobocommandeParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(RobocommandeParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structType}
	 * labeled alternative in {@link RobocommandeParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructType(RobocommandeParser.StructTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#newDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDeclaration(RobocommandeParser.NewDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#newEvent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewEvent(RobocommandeParser.NewEventContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#fieldAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldAssignment(RobocommandeParser.FieldAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(RobocommandeParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(RobocommandeParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(RobocommandeParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#structInitialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructInitialization(RobocommandeParser.StructInitializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(RobocommandeParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(RobocommandeParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(RobocommandeParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(RobocommandeParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivMod}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivMod(RobocommandeParser.MultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusOrMinus}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusOrMinus(RobocommandeParser.PlusOrMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negateBool}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegateBool(RobocommandeParser.NegateBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literal}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(RobocommandeParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupedExpression}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupedExpression(RobocommandeParser.GroupedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code structInit}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructInit(RobocommandeParser.StructInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fieldIdentifier}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldIdentifier(RobocommandeParser.FieldIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(RobocommandeParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fCall}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFCall(RobocommandeParser.FCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code power}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(RobocommandeParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negateExpression}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegateExpression(RobocommandeParser.NegateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equality}
	 * labeled alternative in {@link RobocommandeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(RobocommandeParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#fieldId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldId(RobocommandeParser.FieldIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link RobocommandeParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(RobocommandeParser.IdContext ctx);
}