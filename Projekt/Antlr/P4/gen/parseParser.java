// Generated from /Users/Kasper/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/parse.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class parseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Keyword=1, Define=2, Behavior=3, While=4, Return=5, Noiseword=6, Newline=7, 
		Whitespace=8, SetupIdentifier=9, RunIdentifier=10, Reserved=11, Double=12, 
		Int=13, String=14, If=15, Else=16, Loop=17, Var=18, Comma=19, Colon=20, 
		Semicolon=21, Quote=22, LParenthesis=23, RParenthesis=24, Comment=25, 
		Plus=26, Minus=27, Multiply=28, Divide=29, Modulo=30, Assign=31, Equal=32, 
		LessEqual=33, GreaterEqual=34, NotEqual=35, And=36, Or=37, Not=38, Letter=39, 
		Digit=40, Number=41, Identifier=42;
	public static final int
		RULE_file = 0, RULE_prog = 1, RULE_setup = 2, RULE_block = 3, RULE_statements = 4, 
		RULE_statement = 5, RULE_assignment = 6, RULE_declaration = 7, RULE_functionCall = 8, 
		RULE_params = 9, RULE_controlStructure = 10, RULE_ifStatement = 11, RULE_expression = 12, 
		RULE_factor = 13, RULE_binaryOperation = 14, RULE_returnStatement = 15, 
		RULE_run = 16, RULE_functions = 17, RULE_defineFunction = 18, RULE_behaviorFunction = 19, 
		RULE_setupHeader = 20, RULE_runHeader = 21;
	public static final String[] ruleNames = {
		"file", "prog", "setup", "block", "statements", "statement", "assignment", 
		"declaration", "functionCall", "params", "controlStructure", "ifStatement", 
		"expression", "factor", "binaryOperation", "returnStatement", "run", "functions", 
		"defineFunction", "behaviorFunction", "setupHeader", "runHeader"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'define'", "'behavior'", "'while'", "'return'", null, null, 
		null, "'onSetup'", "'onRun'", null, null, null, null, "'if'", "'else'", 
		"'loop'", "'var'", "','", "':'", "';'", "'\"'", "'('", "')'", null, "'+'", 
		"'-'", "'*'", "'/'", "'%'", "':='", "'='", "'<='", "'>='", "'!='", "'and'", 
		"'or'", "'not'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Keyword", "Define", "Behavior", "While", "Return", "Noiseword", 
		"Newline", "Whitespace", "SetupIdentifier", "RunIdentifier", "Reserved", 
		"Double", "Int", "String", "If", "Else", "Loop", "Var", "Comma", "Colon", 
		"Semicolon", "Quote", "LParenthesis", "RParenthesis", "Comment", "Plus", 
		"Minus", "Multiply", "Divide", "Modulo", "Assign", "Equal", "LessEqual", 
		"GreaterEqual", "NotEqual", "And", "Or", "Not", "Letter", "Digit", "Number", 
		"Identifier"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "parse.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public parseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			prog();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgContext extends ParserRuleContext {
		public RunContext run() {
			return getRuleContext(RunContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(parseParser.EOF, 0); }
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(46);
				setup();
				}
				break;
			}
			setState(49);
			run();
			setState(50);
			functions();
			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetupContext extends ParserRuleContext {
		public SetupHeaderContext setupHeader() {
			return getRuleContext(SetupHeaderContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterSetup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitSetup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitSetup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			setupHeader();
			setState(54);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(parseParser.Colon, 0); }
		public TerminalNode Semicolon() { return getToken(parseParser.Semicolon, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(Colon);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << If) | (1L << Loop) | (1L << Var) | (1L << Identifier))) != 0)) {
				{
				setState(57);
				statements();
				}
			}

			setState(60);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public List<TerminalNode> Newline() { return getTokens(parseParser.Newline); }
		public TerminalNode Newline(int i) {
			return getToken(parseParser.Newline, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			statement();
			{
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(63);
				match(Newline);
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Newline );
			setState(68);
			statements();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ControlStructureContext controlStructure() {
			return getRuleContext(ControlStructureContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				controlStructure();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				returnStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(parseParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(parseParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(Identifier);
			setState(78);
			match(Assign);
			setState(79);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode Var() { return getToken(parseParser.Var, 0); }
		public TerminalNode Identifier() { return getToken(parseParser.Identifier, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_declaration);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(Var);
				setState(82);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(Var);
				setState(84);
				assignment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(parseParser.Identifier, 0); }
		public TerminalNode LParenthesis() { return getToken(parseParser.LParenthesis, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RParenthesis() { return getToken(parseParser.RParenthesis, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(Identifier);
			setState(88);
			match(LParenthesis);
			setState(89);
			params();
			setState(90);
			match(RParenthesis);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(parseParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(parseParser.Comma, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParenthesis) | (1L << Not) | (1L << Identifier))) != 0)) {
				{
				setState(92);
				expression();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(93);
					match(Comma);
					setState(94);
					expression();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ControlStructureContext extends ParserRuleContext {
		public TerminalNode Loop() { return getToken(parseParser.Loop, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode While() { return getToken(parseParser.While, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ControlStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterControlStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitControlStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitControlStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlStructureContext controlStructure() throws RecognitionException {
		ControlStructureContext _localctx = new ControlStructureContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_controlStructure);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(Loop);
				setState(103);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(Loop);
				setState(105);
				match(While);
				setState(106);
				expression();
				setState(107);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				ifStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(parseParser.If, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Else() { return getToken(parseParser.Else, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStatement);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(If);
				setState(113);
				expression();
				setState(114);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(If);
				setState(117);
				expression();
				setState(118);
				block();
				setState(119);
				match(Else);
				setState(120);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public BinaryOperationContext binaryOperation() {
			return getRuleContext(BinaryOperationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Not() { return getToken(parseParser.Not, 0); }
		public TerminalNode LParenthesis() { return getToken(parseParser.LParenthesis, 0); }
		public TerminalNode Minus() { return getToken(parseParser.Minus, 0); }
		public TerminalNode RParenthesis() { return getToken(parseParser.RParenthesis, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				factor();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				factor();
				setState(126);
				binaryOperation();
				setState(127);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(Not);
				setState(130);
				expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				match(LParenthesis);
				setState(132);
				match(Minus);
				setState(133);
				expression();
				setState(134);
				match(RParenthesis);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(parseParser.Identifier, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_factor);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				functionCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryOperationContext extends ParserRuleContext {
		public TerminalNode Multiply() { return getToken(parseParser.Multiply, 0); }
		public TerminalNode Plus() { return getToken(parseParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(parseParser.Minus, 0); }
		public TerminalNode Divide() { return getToken(parseParser.Divide, 0); }
		public TerminalNode Modulo() { return getToken(parseParser.Modulo, 0); }
		public TerminalNode Equal() { return getToken(parseParser.Equal, 0); }
		public TerminalNode LessEqual() { return getToken(parseParser.LessEqual, 0); }
		public TerminalNode GreaterEqual() { return getToken(parseParser.GreaterEqual, 0); }
		public TerminalNode NotEqual() { return getToken(parseParser.NotEqual, 0); }
		public TerminalNode And() { return getToken(parseParser.And, 0); }
		public TerminalNode Or() { return getToken(parseParser.Or, 0); }
		public BinaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterBinaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitBinaryOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitBinaryOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryOperationContext binaryOperation() throws RecognitionException {
		BinaryOperationContext _localctx = new BinaryOperationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_binaryOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Multiply) | (1L << Divide) | (1L << Modulo) | (1L << Equal) | (1L << LessEqual) | (1L << GreaterEqual) | (1L << NotEqual) | (1L << And) | (1L << Or))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(parseParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(Return);
			setState(145);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RunContext extends ParserRuleContext {
		public RunHeaderContext runHeader() {
			return getRuleContext(RunHeaderContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitRun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitRun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			runHeader();
			setState(148);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionsContext extends ParserRuleContext {
		public List<DefineFunctionContext> defineFunction() {
			return getRuleContexts(DefineFunctionContext.class);
		}
		public DefineFunctionContext defineFunction(int i) {
			return getRuleContext(DefineFunctionContext.class,i);
		}
		public List<BehaviorFunctionContext> behaviorFunction() {
			return getRuleContexts(BehaviorFunctionContext.class);
		}
		public BehaviorFunctionContext behaviorFunction(int i) {
			return getRuleContext(BehaviorFunctionContext.class,i);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Define || _la==Behavior) {
				{
				setState(152);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Define:
					{
					setState(150);
					defineFunction();
					}
					break;
				case Behavior:
					{
					setState(151);
					behaviorFunction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineFunctionContext extends ParserRuleContext {
		public TerminalNode Define() { return getToken(parseParser.Define, 0); }
		public TerminalNode Identifier() { return getToken(parseParser.Identifier, 0); }
		public TerminalNode LParenthesis() { return getToken(parseParser.LParenthesis, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RParenthesis() { return getToken(parseParser.RParenthesis, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public DefineFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterDefineFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitDefineFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitDefineFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineFunctionContext defineFunction() throws RecognitionException {
		DefineFunctionContext _localctx = new DefineFunctionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_defineFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(Define);
			setState(158);
			match(Identifier);
			setState(159);
			match(LParenthesis);
			setState(160);
			params();
			setState(161);
			match(RParenthesis);
			setState(162);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BehaviorFunctionContext extends ParserRuleContext {
		public TerminalNode Behavior() { return getToken(parseParser.Behavior, 0); }
		public List<TerminalNode> Identifier() { return getTokens(parseParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(parseParser.Identifier, i);
		}
		public TerminalNode LParenthesis() { return getToken(parseParser.LParenthesis, 0); }
		public TerminalNode RParenthesis() { return getToken(parseParser.RParenthesis, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BehaviorFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behaviorFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterBehaviorFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitBehaviorFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitBehaviorFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorFunctionContext behaviorFunction() throws RecognitionException {
		BehaviorFunctionContext _localctx = new BehaviorFunctionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_behaviorFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(Behavior);
			setState(165);
			match(Identifier);
			setState(166);
			match(LParenthesis);
			setState(168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167);
				match(Identifier);
				}
				}
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			setState(172);
			match(RParenthesis);
			setState(173);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetupHeaderContext extends ParserRuleContext {
		public TerminalNode Behavior() { return getToken(parseParser.Behavior, 0); }
		public TerminalNode SetupIdentifier() { return getToken(parseParser.SetupIdentifier, 0); }
		public TerminalNode LParenthesis() { return getToken(parseParser.LParenthesis, 0); }
		public TerminalNode RParenthesis() { return getToken(parseParser.RParenthesis, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SetupHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setupHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterSetupHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitSetupHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitSetupHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupHeaderContext setupHeader() throws RecognitionException {
		SetupHeaderContext _localctx = new SetupHeaderContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_setupHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(Behavior);
			setState(176);
			match(SetupIdentifier);
			setState(177);
			match(LParenthesis);
			setState(178);
			match(RParenthesis);
			setState(179);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RunHeaderContext extends ParserRuleContext {
		public TerminalNode Behavior() { return getToken(parseParser.Behavior, 0); }
		public TerminalNode RunIdentifier() { return getToken(parseParser.RunIdentifier, 0); }
		public TerminalNode LParenthesis() { return getToken(parseParser.LParenthesis, 0); }
		public TerminalNode RParenthesis() { return getToken(parseParser.RParenthesis, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RunHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_runHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterRunHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitRunHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitRunHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RunHeaderContext runHeader() throws RecognitionException {
		RunHeaderContext _localctx = new RunHeaderContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_runHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(Behavior);
			setState(182);
			match(RunIdentifier);
			setState(183);
			match(LParenthesis);
			setState(184);
			match(RParenthesis);
			setState(185);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u00be\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\5\3\62"+
		"\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\5\5=\n\5\3\5\3\5\3\6\3\6\6\6"+
		"C\n\6\r\6\16\6D\3\6\3\6\3\7\3\7\3\7\3\7\3\7\5\7N\n\7\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\5\tX\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13b\n\13"+
		"\f\13\16\13e\13\13\5\13g\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fq\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r}\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u008b\n\16\3\17\3\17\5\17"+
		"\u008f\n\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\7\23\u009b"+
		"\n\23\f\23\16\23\u009e\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\6\25\u00ab\n\25\r\25\16\25\u00ac\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\2\2\30\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\3\4\2\34 \"\'\u00bb\2.\3\2\2"+
		"\2\4\61\3\2\2\2\6\67\3\2\2\2\b:\3\2\2\2\n@\3\2\2\2\fM\3\2\2\2\16O\3\2"+
		"\2\2\20W\3\2\2\2\22Y\3\2\2\2\24f\3\2\2\2\26p\3\2\2\2\30|\3\2\2\2\32\u008a"+
		"\3\2\2\2\34\u008e\3\2\2\2\36\u0090\3\2\2\2 \u0092\3\2\2\2\"\u0095\3\2"+
		"\2\2$\u009c\3\2\2\2&\u009f\3\2\2\2(\u00a6\3\2\2\2*\u00b1\3\2\2\2,\u00b7"+
		"\3\2\2\2./\5\4\3\2/\3\3\2\2\2\60\62\5\6\4\2\61\60\3\2\2\2\61\62\3\2\2"+
		"\2\62\63\3\2\2\2\63\64\5\"\22\2\64\65\5$\23\2\65\66\7\2\2\3\66\5\3\2\2"+
		"\2\678\5*\26\289\5\b\5\29\7\3\2\2\2:<\7\26\2\2;=\5\n\6\2<;\3\2\2\2<=\3"+
		"\2\2\2=>\3\2\2\2>?\7\27\2\2?\t\3\2\2\2@B\5\f\7\2AC\7\t\2\2BA\3\2\2\2C"+
		"D\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\5\n\6\2G\13\3\2\2\2HN\5\16\b"+
		"\2IN\5\20\t\2JN\5\22\n\2KN\5\26\f\2LN\5 \21\2MH\3\2\2\2MI\3\2\2\2MJ\3"+
		"\2\2\2MK\3\2\2\2ML\3\2\2\2N\r\3\2\2\2OP\7,\2\2PQ\7!\2\2QR\5\32\16\2R\17"+
		"\3\2\2\2ST\7\24\2\2TX\7,\2\2UV\7\24\2\2VX\5\16\b\2WS\3\2\2\2WU\3\2\2\2"+
		"X\21\3\2\2\2YZ\7,\2\2Z[\7\31\2\2[\\\5\24\13\2\\]\7\32\2\2]\23\3\2\2\2"+
		"^c\5\32\16\2_`\7\25\2\2`b\5\32\16\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3"+
		"\2\2\2dg\3\2\2\2ec\3\2\2\2f^\3\2\2\2fg\3\2\2\2g\25\3\2\2\2hi\7\23\2\2"+
		"iq\5\b\5\2jk\7\23\2\2kl\7\6\2\2lm\5\32\16\2mn\5\b\5\2nq\3\2\2\2oq\5\30"+
		"\r\2ph\3\2\2\2pj\3\2\2\2po\3\2\2\2q\27\3\2\2\2rs\7\21\2\2st\5\32\16\2"+
		"tu\5\b\5\2u}\3\2\2\2vw\7\21\2\2wx\5\32\16\2xy\5\b\5\2yz\7\22\2\2z{\5\b"+
		"\5\2{}\3\2\2\2|r\3\2\2\2|v\3\2\2\2}\31\3\2\2\2~\u008b\5\34\17\2\177\u0080"+
		"\5\34\17\2\u0080\u0081\5\36\20\2\u0081\u0082\5\32\16\2\u0082\u008b\3\2"+
		"\2\2\u0083\u0084\7(\2\2\u0084\u008b\5\32\16\2\u0085\u0086\7\31\2\2\u0086"+
		"\u0087\7\35\2\2\u0087\u0088\5\32\16\2\u0088\u0089\7\32\2\2\u0089\u008b"+
		"\3\2\2\2\u008a~\3\2\2\2\u008a\177\3\2\2\2\u008a\u0083\3\2\2\2\u008a\u0085"+
		"\3\2\2\2\u008b\33\3\2\2\2\u008c\u008f\7,\2\2\u008d\u008f\5\22\n\2\u008e"+
		"\u008c\3\2\2\2\u008e\u008d\3\2\2\2\u008f\35\3\2\2\2\u0090\u0091\t\2\2"+
		"\2\u0091\37\3\2\2\2\u0092\u0093\7\7\2\2\u0093\u0094\5\32\16\2\u0094!\3"+
		"\2\2\2\u0095\u0096\5,\27\2\u0096\u0097\5\b\5\2\u0097#\3\2\2\2\u0098\u009b"+
		"\5&\24\2\u0099\u009b\5(\25\2\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d%\3\2\2\2"+
		"\u009e\u009c\3\2\2\2\u009f\u00a0\7\4\2\2\u00a0\u00a1\7,\2\2\u00a1\u00a2"+
		"\7\31\2\2\u00a2\u00a3\5\24\13\2\u00a3\u00a4\7\32\2\2\u00a4\u00a5\5\b\5"+
		"\2\u00a5\'\3\2\2\2\u00a6\u00a7\7\5\2\2\u00a7\u00a8\7,\2\2\u00a8\u00aa"+
		"\7\31\2\2\u00a9\u00ab\7,\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\32"+
		"\2\2\u00af\u00b0\5\b\5\2\u00b0)\3\2\2\2\u00b1\u00b2\7\5\2\2\u00b2\u00b3"+
		"\7\13\2\2\u00b3\u00b4\7\31\2\2\u00b4\u00b5\7\32\2\2\u00b5\u00b6\5\b\5"+
		"\2\u00b6+\3\2\2\2\u00b7\u00b8\7\5\2\2\u00b8\u00b9\7\f\2\2\u00b9\u00ba"+
		"\7\31\2\2\u00ba\u00bb\7\32\2\2\u00bb\u00bc\5\b\5\2\u00bc-\3\2\2\2\20\61"+
		"<DMWcfp|\u008a\u008e\u009a\u009c\u00ac";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}