// Generated from /Users/Casper/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/parse.g4 by ANTLR 4.6
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
		Keyword=1, Define=2, Behavior=3, While=4, Noiseword=5, Newline=6, Whitespace=7, 
		SetupIdentifier=8, RunIdentifier=9, Identifier=10, Reserved=11, Double=12, 
		Int=13, String=14, If=15, Else=16, Loop=17, Var=18, Comma=19, Colon=20, 
		Semicolon=21, Quote=22, LParenthesis=23, RParenthesis=24, Comment=25, 
		Plus=26, Minus=27, Multiply=28, Divide=29, Modulo=30, Assign=31, Equal=32, 
		LessEqual=33, GreaterEqual=34, NotEqual=35, And=36, Or=37, Not=38, Letter=39, 
		Digit=40, Number=41, Return=42;
	public static final int
		RULE_prog = 0, RULE_setup = 1, RULE_block = 2, RULE_statements = 3, RULE_statement = 4, 
		RULE_assignment = 5, RULE_declaration = 6, RULE_functionCall = 7, RULE_params = 8, 
		RULE_controlStructure = 9, RULE_ifStatement = 10, RULE_expression = 11, 
		RULE_factor = 12, RULE_binaryOperation = 13, RULE_returnStatement = 14, 
		RULE_run = 15, RULE_functions = 16, RULE_defineFunction = 17, RULE_behaviorFunction = 18, 
		RULE_setupHeader = 19, RULE_runHeader = 20, RULE_test = 21;
	public static final String[] ruleNames = {
		"prog", "setup", "block", "statements", "statement", "assignment", "declaration", 
		"functionCall", "params", "controlStructure", "ifStatement", "expression", 
		"factor", "binaryOperation", "returnStatement", "run", "functions", "defineFunction", 
		"behaviorFunction", "setupHeader", "runHeader", "test"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'define'", "'behavior'", "'while'", null, null, null, "'onSetup'", 
		"'onRun'", null, null, null, null, null, "'if'", "'else'", "'loop'", "'var'", 
		"','", "':'", "';'", "'\"'", "'('", "')'", null, "'+'", "'-'", "'*'", 
		"'/'", "'%'", "':='", "'='", "'<='", "'>='", "'!='", "'and'", "'or'", 
		"'not'", null, null, null, "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Keyword", "Define", "Behavior", "While", "Noiseword", "Newline", 
		"Whitespace", "SetupIdentifier", "RunIdentifier", "Identifier", "Reserved", 
		"Double", "Int", "String", "If", "Else", "Loop", "Var", "Comma", "Colon", 
		"Semicolon", "Quote", "LParenthesis", "RParenthesis", "Comment", "Plus", 
		"Minus", "Multiply", "Divide", "Modulo", "Assign", "Equal", "LessEqual", 
		"GreaterEqual", "NotEqual", "And", "Or", "Not", "Letter", "Digit", "Number", 
		"Return"
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
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(44);
				setup();
				}
				break;
			}
			setState(47);
			run();
			setState(48);
			functions();
			setState(49);
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
		enterRule(_localctx, 2, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			setupHeader();
			setState(52);
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
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(Colon);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << If) | (1L << Loop) | (1L << Var) | (1L << Return))) != 0)) {
				{
				setState(55);
				statements();
				}
			}

			setState(58);
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
		enterRule(_localctx, 6, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			statement();
			{
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				match(Newline);
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Newline );
			setState(66);
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
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				controlStructure();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
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
		enterRule(_localctx, 10, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(Identifier);
			setState(76);
			match(Assign);
			setState(77);
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
		enterRule(_localctx, 12, RULE_declaration);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(Var);
				setState(80);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				match(Var);
				setState(82);
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
		enterRule(_localctx, 14, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(Identifier);
			setState(86);
			match(LParenthesis);
			setState(87);
			params();
			setState(88);
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
		enterRule(_localctx, 16, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << LParenthesis) | (1L << Not))) != 0)) {
				{
				setState(90);
				expression();
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(91);
					match(Comma);
					setState(92);
					expression();
					}
					}
					setState(97);
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
		enterRule(_localctx, 18, RULE_controlStructure);
		try {
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(Loop);
				setState(101);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(Loop);
				setState(103);
				match(While);
				setState(104);
				expression();
				setState(105);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
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
		enterRule(_localctx, 20, RULE_ifStatement);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(If);
				setState(111);
				expression();
				setState(112);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(If);
				setState(115);
				expression();
				setState(116);
				block();
				setState(117);
				match(Else);
				setState(118);
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
		enterRule(_localctx, 22, RULE_expression);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				factor();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				factor();
				setState(124);
				binaryOperation();
				setState(125);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(Not);
				setState(128);
				expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
				match(LParenthesis);
				setState(130);
				match(Minus);
				setState(131);
				expression();
				setState(132);
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
		enterRule(_localctx, 24, RULE_factor);
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
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
		enterRule(_localctx, 26, RULE_binaryOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
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
		enterRule(_localctx, 28, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(Return);
			setState(143);
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
		enterRule(_localctx, 30, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			runHeader();
			setState(146);
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
		enterRule(_localctx, 32, RULE_functions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Define || _la==Behavior) {
				{
				setState(150);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Define:
					{
					setState(148);
					defineFunction();
					}
					break;
				case Behavior:
					{
					setState(149);
					behaviorFunction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(154);
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
		enterRule(_localctx, 34, RULE_defineFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(Define);
			setState(156);
			match(Identifier);
			setState(157);
			match(LParenthesis);
			setState(158);
			params();
			setState(159);
			match(RParenthesis);
			setState(160);
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
		enterRule(_localctx, 36, RULE_behaviorFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(Behavior);
			setState(163);
			match(Identifier);
			setState(164);
			match(LParenthesis);
			setState(166); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(165);
				match(Identifier);
				}
				}
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			setState(170);
			match(RParenthesis);
			setState(171);
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
		enterRule(_localctx, 38, RULE_setupHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(Behavior);
			setState(174);
			match(SetupIdentifier);
			setState(175);
			match(LParenthesis);
			setState(176);
			match(RParenthesis);
			setState(177);
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
		enterRule(_localctx, 40, RULE_runHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(Behavior);
			setState(180);
			match(RunIdentifier);
			setState(181);
			match(LParenthesis);
			setState(182);
			match(RParenthesis);
			setState(183);
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

	public static class TestContext extends ParserRuleContext {
		public TerminalNode LParenthesis() { return getToken(parseParser.LParenthesis, 0); }
		public TerminalNode Define() { return getToken(parseParser.Define, 0); }
		public TerminalNode RParenthesis() { return getToken(parseParser.RParenthesis, 0); }
		public TestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_test; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).enterTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof parseListener ) ((parseListener)listener).exitTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof parseVisitor ) return ((parseVisitor<? extends T>)visitor).visitTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TestContext test() throws RecognitionException {
		TestContext _localctx = new TestContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_test);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(LParenthesis);
			setState(186);
			match(Define);
			setState(187);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3,\u00c0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\5\2\60\n\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\5\4;\n\4\3\4\3\4\3\5\3\5\6\5A\n\5\r\5"+
		"\16\5B\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\5\bV\n\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n`\n\n\f\n\16\nc\13"+
		"\n\5\ne\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13o\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f{\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u0089\n\r\3\16\3\16\5\16\u008d\n\16\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\7\22\u0099\n\22\f\22\16\22\u009c"+
		"\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\6\24\u00a9"+
		"\n\24\r\24\16\24\u00aa\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\2\2\30\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\3\4\2\34 \"\'\u00bd\2/\3\2\2\2"+
		"\4\65\3\2\2\2\68\3\2\2\2\b>\3\2\2\2\nK\3\2\2\2\fM\3\2\2\2\16U\3\2\2\2"+
		"\20W\3\2\2\2\22d\3\2\2\2\24n\3\2\2\2\26z\3\2\2\2\30\u0088\3\2\2\2\32\u008c"+
		"\3\2\2\2\34\u008e\3\2\2\2\36\u0090\3\2\2\2 \u0093\3\2\2\2\"\u009a\3\2"+
		"\2\2$\u009d\3\2\2\2&\u00a4\3\2\2\2(\u00af\3\2\2\2*\u00b5\3\2\2\2,\u00bb"+
		"\3\2\2\2.\60\5\4\3\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\62\5 \21\2"+
		"\62\63\5\"\22\2\63\64\7\2\2\3\64\3\3\2\2\2\65\66\5(\25\2\66\67\5\6\4\2"+
		"\67\5\3\2\2\28:\7\26\2\29;\5\b\5\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\27"+
		"\2\2=\7\3\2\2\2>@\5\n\6\2?A\7\b\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3"+
		"\2\2\2CD\3\2\2\2DE\5\b\5\2E\t\3\2\2\2FL\5\f\7\2GL\5\16\b\2HL\5\20\t\2"+
		"IL\5\24\13\2JL\5\36\20\2KF\3\2\2\2KG\3\2\2\2KH\3\2\2\2KI\3\2\2\2KJ\3\2"+
		"\2\2L\13\3\2\2\2MN\7\f\2\2NO\7!\2\2OP\5\30\r\2P\r\3\2\2\2QR\7\24\2\2R"+
		"V\7\f\2\2ST\7\24\2\2TV\5\f\7\2UQ\3\2\2\2US\3\2\2\2V\17\3\2\2\2WX\7\f\2"+
		"\2XY\7\31\2\2YZ\5\22\n\2Z[\7\32\2\2[\21\3\2\2\2\\a\5\30\r\2]^\7\25\2\2"+
		"^`\5\30\r\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2be\3\2\2\2ca\3\2\2"+
		"\2d\\\3\2\2\2de\3\2\2\2e\23\3\2\2\2fg\7\23\2\2go\5\6\4\2hi\7\23\2\2ij"+
		"\7\6\2\2jk\5\30\r\2kl\5\6\4\2lo\3\2\2\2mo\5\26\f\2nf\3\2\2\2nh\3\2\2\2"+
		"nm\3\2\2\2o\25\3\2\2\2pq\7\21\2\2qr\5\30\r\2rs\5\6\4\2s{\3\2\2\2tu\7\21"+
		"\2\2uv\5\30\r\2vw\5\6\4\2wx\7\22\2\2xy\5\6\4\2y{\3\2\2\2zp\3\2\2\2zt\3"+
		"\2\2\2{\27\3\2\2\2|\u0089\5\32\16\2}~\5\32\16\2~\177\5\34\17\2\177\u0080"+
		"\5\30\r\2\u0080\u0089\3\2\2\2\u0081\u0082\7(\2\2\u0082\u0089\5\30\r\2"+
		"\u0083\u0084\7\31\2\2\u0084\u0085\7\35\2\2\u0085\u0086\5\30\r\2\u0086"+
		"\u0087\7\32\2\2\u0087\u0089\3\2\2\2\u0088|\3\2\2\2\u0088}\3\2\2\2\u0088"+
		"\u0081\3\2\2\2\u0088\u0083\3\2\2\2\u0089\31\3\2\2\2\u008a\u008d\7\f\2"+
		"\2\u008b\u008d\5\20\t\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2\2\2\u008d"+
		"\33\3\2\2\2\u008e\u008f\t\2\2\2\u008f\35\3\2\2\2\u0090\u0091\7,\2\2\u0091"+
		"\u0092\5\30\r\2\u0092\37\3\2\2\2\u0093\u0094\5*\26\2\u0094\u0095\5\6\4"+
		"\2\u0095!\3\2\2\2\u0096\u0099\5$\23\2\u0097\u0099\5&\24\2\u0098\u0096"+
		"\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b#\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\7\4\2\2"+
		"\u009e\u009f\7\f\2\2\u009f\u00a0\7\31\2\2\u00a0\u00a1\5\22\n\2\u00a1\u00a2"+
		"\7\32\2\2\u00a2\u00a3\5\6\4\2\u00a3%\3\2\2\2\u00a4\u00a5\7\5\2\2\u00a5"+
		"\u00a6\7\f\2\2\u00a6\u00a8\7\31\2\2\u00a7\u00a9\7\f\2\2\u00a8\u00a7\3"+
		"\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab"+
		"\u00ac\3\2\2\2\u00ac\u00ad\7\32\2\2\u00ad\u00ae\5\6\4\2\u00ae\'\3\2\2"+
		"\2\u00af\u00b0\7\5\2\2\u00b0\u00b1\7\n\2\2\u00b1\u00b2\7\31\2\2\u00b2"+
		"\u00b3\7\32\2\2\u00b3\u00b4\5\6\4\2\u00b4)\3\2\2\2\u00b5\u00b6\7\5\2\2"+
		"\u00b6\u00b7\7\13\2\2\u00b7\u00b8\7\31\2\2\u00b8\u00b9\7\32\2\2\u00b9"+
		"\u00ba\5\6\4\2\u00ba+\3\2\2\2\u00bb\u00bc\7\31\2\2\u00bc\u00bd\7\4\2\2"+
		"\u00bd\u00be\7\32\2\2\u00be-\3\2\2\2\20/:BKUadnz\u0088\u008c\u0098\u009a"+
		"\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}