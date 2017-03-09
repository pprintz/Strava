// Generated from /Users/Kasper/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/simple/SimpleParser.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, ID=37, NUM=38, INT=39, 
		FLOAT=40, STRING=41, COMMENT=42, WS=43, NEWLINE=44, LETTER=45, ESC=46;
	public static final int
		RULE_prog = 0, RULE_block = 1, RULE_stmt = 2, RULE_functions = 3, RULE_defineFunction = 4, 
		RULE_behaviorFunction = 5, RULE_actualParams = 6, RULE_formalParams = 7, 
		RULE_functionCall = 8, RULE_expr = 9, RULE_ifStatement = 10, RULE_assignment = 11, 
		RULE_declaration = 12, RULE_newDeclaration = 13, RULE_loop = 14, RULE_returnStatement = 15, 
		RULE_run = 16, RULE_setup = 17, RULE_fieldId = 18;
	public static final String[] ruleNames = {
		"prog", "block", "stmt", "functions", "defineFunction", "behaviorFunction", 
		"actualParams", "formalParams", "functionCall", "expr", "ifStatement", 
		"assignment", "declaration", "newDeclaration", "loop", "returnStatement", 
		"run", "setup", "fieldId"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "';'", "'define'", "'('", "')'", "'behavior'", "','", "'false'", 
		"'true'", "'not'", "'-'", "'^'", "'*'", "'/'", "'%'", "'+'", "'<='", "'>='", 
		"'<'", "'>'", "'!='", "'='", "'and'", "'or'", "'if'", "'else if'", "'else'", 
		"':='", "'var'", "'new'", "'loop'", "'while'", "'return'", "'onRun'", 
		"'onSetup'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "ID", "NUM", "INT", "FLOAT", "STRING", "COMMENT", "WS", "NEWLINE", 
		"LETTER", "ESC"
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
	public String getGrammarFileName() { return "SimpleParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public RunContext run() {
			return getRuleContext(RunContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SimpleParserParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParserParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParserParser.NEWLINE, i);
		}
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(38);
				match(NEWLINE);
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(44);
				setup();
				}
				break;
			}
			setState(47);
			run();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2 || _la==T__5) {
				{
				setState(48);
				functions();
				}
			}

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

	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParserParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParserParser.NEWLINE, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__0);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(54);
				stmt();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(T__1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(61);
					match(NEWLINE);
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class StmtContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParserParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParserParser.NEWLINE, i);
		}
		public DefineFunctionContext defineFunction() {
			return getRuleContext(DefineFunctionContext.class,0);
		}
		public BehaviorFunctionContext behaviorFunction() {
			return getRuleContext(BehaviorFunctionContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public NewDeclarationContext newDeclaration() {
			return getRuleContext(NewDeclarationContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(67);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(70); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(72);
				defineFunction();
				}
				break;
			case 2:
				{
				setState(73);
				behaviorFunction();
				}
				break;
			case 3:
				{
				setState(74);
				functionCall();
				}
				break;
			case 4:
				{
				setState(75);
				assignment();
				}
				break;
			case 5:
				{
				setState(76);
				ifStatement();
				}
				break;
			case 6:
				{
				setState(77);
				declaration();
				}
				break;
			case 7:
				{
				setState(78);
				loop();
				}
				break;
			case 8:
				{
				setState(79);
				newDeclaration();
				}
				break;
			case 9:
				{
				setState(80);
				returnStatement();
				}
				break;
			}
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(83);
					match(NEWLINE);
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitFunctions(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__2:
					{
					setState(89);
					defineFunction();
					}
					break;
				case T__5:
					{
					setState(90);
					behaviorFunction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__5 );
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
		public TerminalNode ID() { return getToken(SimpleParserParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormalParamsContext formalParams() {
			return getRuleContext(FormalParamsContext.class,0);
		}
		public DefineFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defineFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterDefineFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitDefineFunction(this);
		}
	}

	public final DefineFunctionContext defineFunction() throws RecognitionException {
		DefineFunctionContext _localctx = new DefineFunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_defineFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__2);
			setState(96);
			match(ID);
			setState(97);
			match(T__3);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(98);
				formalParams();
				}
			}

			setState(101);
			match(T__4);
			setState(102);
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
		public List<TerminalNode> ID() { return getTokens(SimpleParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleParserParser.ID, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BehaviorFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behaviorFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterBehaviorFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitBehaviorFunction(this);
		}
	}

	public final BehaviorFunctionContext behaviorFunction() throws RecognitionException {
		BehaviorFunctionContext _localctx = new BehaviorFunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_behaviorFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__5);
			setState(105);
			match(ID);
			setState(106);
			match(T__3);
			setState(107);
			match(ID);
			setState(108);
			match(T__4);
			setState(109);
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

	public static class ActualParamsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ActualParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterActualParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitActualParams(this);
		}
	}

	public final ActualParamsContext actualParams() throws RecognitionException {
		ActualParamsContext _localctx = new ActualParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_actualParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			expr(0);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(112);
				match(T__6);
				setState(113);
				expr(0);
				}
				}
				setState(118);
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

	public static class FormalParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SimpleParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleParserParser.ID, i);
		}
		public FormalParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterFormalParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitFormalParams(this);
		}
	}

	public final FormalParamsContext formalParams() throws RecognitionException {
		FormalParamsContext _localctx = new FormalParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_formalParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(ID);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(120);
				match(T__6);
				setState(121);
				match(ID);
				}
				}
				setState(126);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FieldIdContext fieldId() {
			return getRuleContext(FieldIdContext.class,0);
		}
		public ActualParamsContext actualParams() {
			return getRuleContext(ActualParamsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			fieldId();
			setState(128);
			match(T__3);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << ID) | (1L << NUM) | (1L << STRING))) != 0)) {
				{
				setState(129);
				actualParams();
				}
			}

			setState(132);
			match(T__4);
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

	public static class ExprContext extends ParserRuleContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FieldIdContext fieldId() {
			return getRuleContext(FieldIdContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleParserParser.ID, 0); }
		public TerminalNode NUM() { return getToken(SimpleParserParser.NUM, 0); }
		public TerminalNode STRING() { return getToken(SimpleParserParser.STRING, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(135);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				{
				setState(136);
				functionCall();
				}
				break;
			case 3:
				{
				setState(137);
				fieldId();
				}
				break;
			case 4:
				{
				setState(138);
				match(ID);
				}
				break;
			case 5:
				{
				setState(139);
				match(NUM);
				}
				break;
			case 6:
				{
				setState(140);
				match(STRING);
				}
				break;
			case 7:
				{
				setState(141);
				match(T__3);
				setState(142);
				expr(0);
				setState(143);
				match(T__4);
				}
				break;
			case 8:
				{
				setState(145);
				match(T__9);
				setState(146);
				expr(9);
				}
				break;
			case 9:
				{
				setState(147);
				match(T__3);
				setState(148);
				match(T__10);
				setState(149);
				expr(0);
				setState(150);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(175);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(155);
						match(T__11);
						setState(156);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(158);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(159);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(161);
						_la = _input.LA(1);
						if ( !(_la==T__10 || _la==T__15) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(162);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(163);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(164);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(165);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(166);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(167);
						_la = _input.LA(1);
						if ( !(_la==T__20 || _la==T__21) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(168);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(170);
						match(T__22);
						setState(171);
						expr(3);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(173);
						match(T__23);
						setState(174);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(T__24);
			setState(181);
			expr(0);
			setState(182);
			block();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__25) {
				{
				{
				setState(183);
				match(T__25);
				setState(184);
				expr(0);
				setState(185);
				block();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__26) {
				{
				setState(192);
				match(T__26);
				setState(193);
				block();
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

	public static class AssignmentContext extends ParserRuleContext {
		public FieldIdContext fieldId() {
			return getRuleContext(FieldIdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			fieldId();
			setState(197);
			match(T__27);
			setState(198);
			expr(0);
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleParserParser.ID, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__28);
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(201);
				assignment();
				}
				break;
			case 2:
				{
				setState(202);
				match(ID);
				}
				break;
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

	public static class NewDeclarationContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleParserParser.ID, 0); }
		public NewDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterNewDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitNewDeclaration(this);
		}
	}

	public final NewDeclarationContext newDeclaration() throws RecognitionException {
		NewDeclarationContext _localctx = new NewDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_newDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__29);
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(206);
				assignment();
				}
				break;
			case 2:
				{
				setState(207);
				match(ID);
				}
				break;
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

	public static class LoopContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitLoop(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__30);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(211);
				match(T__31);
				setState(212);
				expr(0);
				}
			}

			setState(215);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__32);
			setState(218);
			expr(0);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitRun(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__5);
			setState(221);
			match(T__33);
			setState(222);
			match(T__3);
			setState(223);
			match(T__4);
			setState(224);
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

	public static class SetupContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterSetup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitSetup(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(T__5);
			setState(227);
			match(T__34);
			setState(228);
			match(T__3);
			setState(229);
			match(T__4);
			setState(230);
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

	public static class FieldIdContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SimpleParserParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleParserParser.ID, i);
		}
		public FieldIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).enterFieldId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleParserListener ) ((SimpleParserListener)listener).exitFieldId(this);
		}
	}

	public final FieldIdContext fieldId() throws RecognitionException {
		FieldIdContext _localctx = new FieldIdContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fieldId);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(ID);
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(233);
					match(T__35);
					setState(234);
					match(ID);
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\60\u00f3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\5\2\60\n\2\3\2\3"+
		"\2\5\2\64\n\2\3\2\3\2\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\7\3A\n\3"+
		"\f\3\16\3D\13\3\3\4\6\4G\n\4\r\4\16\4H\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4T\n\4\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\5\3\5\6\5^\n\5\r\5\16\5_\3"+
		"\6\3\6\3\6\3\6\5\6f\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\7\bu\n\b\f\b\16\bx\13\b\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13"+
		"\t\3\n\3\n\3\n\5\n\u0085\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u009b\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00b2\n\13\f\13\16\13\u00b5\13"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00be\n\f\f\f\16\f\u00c1\13\f\3\f"+
		"\3\f\5\f\u00c5\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\5\16\u00ce\n\16\3\17"+
		"\3\17\3\17\5\17\u00d3\n\17\3\20\3\20\3\20\5\20\u00d8\n\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\7\24\u00ee\n\24\f\24\16\24\u00f1\13\24\3\24\2\3\24"+
		"\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\7\3\2\n\13\3\2\17\21"+
		"\4\2\r\r\22\22\3\2\23\26\3\2\27\30\u010a\2+\3\2\2\2\4\67\3\2\2\2\6F\3"+
		"\2\2\2\b]\3\2\2\2\na\3\2\2\2\fj\3\2\2\2\16q\3\2\2\2\20y\3\2\2\2\22\u0081"+
		"\3\2\2\2\24\u009a\3\2\2\2\26\u00b6\3\2\2\2\30\u00c6\3\2\2\2\32\u00ca\3"+
		"\2\2\2\34\u00cf\3\2\2\2\36\u00d4\3\2\2\2 \u00db\3\2\2\2\"\u00de\3\2\2"+
		"\2$\u00e4\3\2\2\2&\u00ea\3\2\2\2(*\7.\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2"+
		"\2+,\3\2\2\2,/\3\2\2\2-+\3\2\2\2.\60\5$\23\2/.\3\2\2\2/\60\3\2\2\2\60"+
		"\61\3\2\2\2\61\63\5\"\22\2\62\64\5\b\5\2\63\62\3\2\2\2\63\64\3\2\2\2\64"+
		"\65\3\2\2\2\65\66\7\2\2\3\66\3\3\2\2\2\67;\7\3\2\28:\5\6\4\298\3\2\2\2"+
		":=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>B\7\4\2\2?A\7.\2\2"+
		"@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2C\5\3\2\2\2DB\3\2\2\2EG\7.\2\2"+
		"FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IS\3\2\2\2JT\5\n\6\2KT\5\f\7\2"+
		"LT\5\22\n\2MT\5\30\r\2NT\5\26\f\2OT\5\32\16\2PT\5\36\20\2QT\5\34\17\2"+
		"RT\5 \21\2SJ\3\2\2\2SK\3\2\2\2SL\3\2\2\2SM\3\2\2\2SN\3\2\2\2SO\3\2\2\2"+
		"SP\3\2\2\2SQ\3\2\2\2SR\3\2\2\2ST\3\2\2\2TX\3\2\2\2UW\7.\2\2VU\3\2\2\2"+
		"WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\7\3\2\2\2ZX\3\2\2\2[^\5\n\6\2\\^\5\f\7"+
		"\2][\3\2\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\t\3\2\2\2ab\7\5"+
		"\2\2bc\7\'\2\2ce\7\6\2\2df\5\20\t\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7"+
		"\7\2\2hi\5\4\3\2i\13\3\2\2\2jk\7\b\2\2kl\7\'\2\2lm\7\6\2\2mn\7\'\2\2n"+
		"o\7\7\2\2op\5\4\3\2p\r\3\2\2\2qv\5\24\13\2rs\7\t\2\2su\5\24\13\2tr\3\2"+
		"\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\17\3\2\2\2xv\3\2\2\2y~\7\'\2\2z{\7"+
		"\t\2\2{}\7\'\2\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\21"+
		"\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\5&\24\2\u0082\u0084\7\6\2\2\u0083"+
		"\u0085\5\16\b\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3"+
		"\2\2\2\u0086\u0087\7\7\2\2\u0087\23\3\2\2\2\u0088\u0089\b\13\1\2\u0089"+
		"\u009b\t\2\2\2\u008a\u009b\5\22\n\2\u008b\u009b\5&\24\2\u008c\u009b\7"+
		"\'\2\2\u008d\u009b\7(\2\2\u008e\u009b\7+\2\2\u008f\u0090\7\6\2\2\u0090"+
		"\u0091\5\24\13\2\u0091\u0092\7\7\2\2\u0092\u009b\3\2\2\2\u0093\u0094\7"+
		"\f\2\2\u0094\u009b\5\24\13\13\u0095\u0096\7\6\2\2\u0096\u0097\7\r\2\2"+
		"\u0097\u0098\5\24\13\2\u0098\u0099\7\7\2\2\u0099\u009b\3\2\2\2\u009a\u0088"+
		"\3\2\2\2\u009a\u008a\3\2\2\2\u009a\u008b\3\2\2\2\u009a\u008c\3\2\2\2\u009a"+
		"\u008d\3\2\2\2\u009a\u008e\3\2\2\2\u009a\u008f\3\2\2\2\u009a\u0093\3\2"+
		"\2\2\u009a\u0095\3\2\2\2\u009b\u00b3\3\2\2\2\u009c\u009d\f\t\2\2\u009d"+
		"\u009e\7\16\2\2\u009e\u00b2\5\24\13\t\u009f\u00a0\f\b\2\2\u00a0\u00a1"+
		"\t\3\2\2\u00a1\u00b2\5\24\13\t\u00a2\u00a3\f\7\2\2\u00a3\u00a4\t\4\2\2"+
		"\u00a4\u00b2\5\24\13\b\u00a5\u00a6\f\6\2\2\u00a6\u00a7\t\5\2\2\u00a7\u00b2"+
		"\5\24\13\7\u00a8\u00a9\f\5\2\2\u00a9\u00aa\t\6\2\2\u00aa\u00b2\5\24\13"+
		"\6\u00ab\u00ac\f\4\2\2\u00ac\u00ad\7\31\2\2\u00ad\u00b2\5\24\13\5\u00ae"+
		"\u00af\f\3\2\2\u00af\u00b0\7\32\2\2\u00b0\u00b2\5\24\13\4\u00b1\u009c"+
		"\3\2\2\2\u00b1\u009f\3\2\2\2\u00b1\u00a2\3\2\2\2\u00b1\u00a5\3\2\2\2\u00b1"+
		"\u00a8\3\2\2\2\u00b1\u00ab\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b2\u00b5\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\25\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00b7\7\33\2\2\u00b7\u00b8\5\24\13\2\u00b8\u00bf\5\4\3"+
		"\2\u00b9\u00ba\7\34\2\2\u00ba\u00bb\5\24\13\2\u00bb\u00bc\5\4\3\2\u00bc"+
		"\u00be\3\2\2\2\u00bd\u00b9\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c4\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2"+
		"\u00c3\7\35\2\2\u00c3\u00c5\5\4\3\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3"+
		"\2\2\2\u00c5\27\3\2\2\2\u00c6\u00c7\5&\24\2\u00c7\u00c8\7\36\2\2\u00c8"+
		"\u00c9\5\24\13\2\u00c9\31\3\2\2\2\u00ca\u00cd\7\37\2\2\u00cb\u00ce\5\30"+
		"\r\2\u00cc\u00ce\7\'\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\33\3\2\2\2\u00cf\u00d2\7 \2\2\u00d0\u00d3\5\30\r\2\u00d1\u00d3\7\'\2"+
		"\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\35\3\2\2\2\u00d4\u00d7"+
		"\7!\2\2\u00d5\u00d6\7\"\2\2\u00d6\u00d8\5\24\13\2\u00d7\u00d5\3\2\2\2"+
		"\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\5\4\3\2\u00da\37"+
		"\3\2\2\2\u00db\u00dc\7#\2\2\u00dc\u00dd\5\24\13\2\u00dd!\3\2\2\2\u00de"+
		"\u00df\7\b\2\2\u00df\u00e0\7$\2\2\u00e0\u00e1\7\6\2\2\u00e1\u00e2\7\7"+
		"\2\2\u00e2\u00e3\5\4\3\2\u00e3#\3\2\2\2\u00e4\u00e5\7\b\2\2\u00e5\u00e6"+
		"\7%\2\2\u00e6\u00e7\7\6\2\2\u00e7\u00e8\7\7\2\2\u00e8\u00e9\5\4\3\2\u00e9"+
		"%\3\2\2\2\u00ea\u00ef\7\'\2\2\u00eb\u00ec\7&\2\2\u00ec\u00ee\7\'\2\2\u00ed"+
		"\u00eb\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\'\3\2\2\2\u00f1\u00ef\3\2\2\2\31+/\63;BHSX]_ev~\u0084\u009a"+
		"\u00b1\u00b3\u00bf\u00c4\u00cd\u00d2\u00d7\u00ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}