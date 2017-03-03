// Generated from SimpleLexer.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleLexerParser}.
 */
public interface SimpleLexerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleLexerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpleLexerParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLexerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpleLexerParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLexerParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleLexerParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLexerParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleLexerParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleLexerParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SimpleLexerParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleLexerParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SimpleLexerParser.StmtContext ctx);
}