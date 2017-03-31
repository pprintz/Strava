// Generated from /Users/Kasper/P4-AAU-Kursusopgaver/Projekt/Antlr/Robocommande/Robocommande.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RobocommandeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, ID=44, NUM=45, INT=46, 
		FLOAT=47, STRING=48, COMMENT=49, WS=50, NEWLINE=51, LETTER=52, ESC=53;
	public static final int
		RULE_prog = 0, RULE_setup = 1, RULE_run = 2, RULE_functions = 3, RULE_defineFunction = 4, 
		RULE_behaviorFunction = 5, RULE_formalParams = 6, RULE_actualParams = 7, 
		RULE_strategy = 8, RULE_defaultStrategy = 9, RULE_strategyDefinition = 10, 
		RULE_setupBlock = 11, RULE_block = 12, RULE_setupStmt = 13, RULE_stmt = 14, 
		RULE_generalStmtPart = 15, RULE_structDefinition = 16, RULE_declaration = 17, 
		RULE_type = 18, RULE_newEvent = 19, RULE_fieldAssignment = 20, RULE_assignment = 21, 
		RULE_ifStatement = 22, RULE_functionCall = 23, RULE_structInitialization = 24, 
		RULE_loop = 25, RULE_returnStatement = 26, RULE_expr = 27, RULE_fieldId = 28;
	public static final String[] ruleNames = {
		"prog", "setup", "run", "functions", "defineFunction", "behaviorFunction", 
		"formalParams", "actualParams", "strategy", "defaultStrategy", "strategyDefinition", 
		"setupBlock", "block", "setupStmt", "stmt", "generalStmtPart", "structDefinition", 
		"declaration", "type", "newEvent", "fieldAssignment", "assignment", "ifStatement", 
		"functionCall", "structInitialization", "loop", "returnStatement", "expr", 
		"fieldId"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'behavior'", "'onSetup'", "'('", "')'", "'onRun'", "'define'", 
		"','", "'strategy'", "'default'", "':'", "';'", "'{'", "'}'", "':='", 
		"'num'", "'text'", "'bool'", "'new'", "'event'", "'if'", "'else if'", 
		"'else'", "'loop'", "'while'", "'return'", "'true'", "'false'", "'not'", 
		"'-'", "'^'", "'*'", "'/'", "'%'", "'+'", "'<='", "'>='", "'<'", "'>'", 
		"'!='", "'='", "'and'", "'or'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "ID", "NUM", "INT", "FLOAT", 
		"STRING", "COMMENT", "WS", "NEWLINE", "LETTER", "ESC"
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
	public String getGrammarFileName() { return "Robocommande.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RobocommandeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DefaultStrategyContext defaultStrategy() {
			return getRuleContext(DefaultStrategyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RobocommandeParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(RobocommandeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RobocommandeParser.NEWLINE, i);
		}
		public SetupContext setup() {
			return getRuleContext(SetupContext.class,0);
		}
		public List<StrategyContext> strategy() {
			return getRuleContexts(StrategyContext.class);
		}
		public StrategyContext strategy(int i) {
			return getRuleContext(StrategyContext.class,i);
		}
		public List<DefineFunctionContext> defineFunction() {
			return getRuleContexts(DefineFunctionContext.class);
		}
		public DefineFunctionContext defineFunction(int i) {
			return getRuleContext(DefineFunctionContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(58);
				match(NEWLINE);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(64);
				setup();
				}
			}

			setState(67);
			defaultStrategy();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5 || _la==T__7) {
				{
				setState(70);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__7:
					{
					setState(68);
					strategy();
					}
					break;
				case T__5:
					{
					setState(69);
					defineFunction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
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
		public SetupBlockContext setupBlock() {
			return getRuleContext(SetupBlockContext.class,0);
		}
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitSetup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__0);
			setState(78);
			match(T__1);
			setState(79);
			match(T__2);
			setState(80);
			match(T__3);
			setState(81);
			setupBlock();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitRun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__0);
			setState(84);
			match(T__4);
			setState(85);
			match(T__2);
			setState(86);
			match(T__3);
			setState(87);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__5) {
				{
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(89);
					defineFunction();
					}
					break;
				case T__0:
					{
					setState(90);
					behaviorFunction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(95);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitDefineFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineFunctionContext defineFunction() throws RecognitionException {
		DefineFunctionContext _localctx = new DefineFunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_defineFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__5);
			setState(97);
			type();
			setState(98);
			match(ID);
			setState(99);
			match(T__2);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << ID))) != 0)) {
				{
				setState(100);
				formalParams();
				}
			}

			setState(103);
			match(T__3);
			setState(104);
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
		public List<TerminalNode> ID() { return getTokens(RobocommandeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RobocommandeParser.ID, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BehaviorFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_behaviorFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitBehaviorFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorFunctionContext behaviorFunction() throws RecognitionException {
		BehaviorFunctionContext _localctx = new BehaviorFunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_behaviorFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__0);
			setState(107);
			match(ID);
			setState(108);
			match(T__2);
			setState(109);
			match(ID);
			setState(110);
			match(T__3);
			setState(111);
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

	public static class FormalParamsContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(RobocommandeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RobocommandeParser.ID, i);
		}
		public FormalParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitFormalParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParamsContext formalParams() throws RecognitionException {
		FormalParamsContext _localctx = new FormalParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formalParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			type();
			setState(114);
			match(ID);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(115);
				match(T__6);
				setState(116);
				type();
				setState(117);
				match(ID);
				}
				}
				setState(123);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitActualParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualParamsContext actualParams() throws RecognitionException {
		ActualParamsContext _localctx = new ActualParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_actualParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			expr(0);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(125);
				match(T__6);
				setState(126);
				expr(0);
				}
				}
				setState(131);
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

	public static class StrategyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public StrategyDefinitionContext strategyDefinition() {
			return getRuleContext(StrategyDefinitionContext.class,0);
		}
		public StrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitStrategy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyContext strategy() throws RecognitionException {
		StrategyContext _localctx = new StrategyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_strategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__7);
			setState(133);
			match(ID);
			setState(134);
			strategyDefinition();
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

	public static class DefaultStrategyContext extends ParserRuleContext {
		public StrategyDefinitionContext strategyDefinition() {
			return getRuleContext(StrategyDefinitionContext.class,0);
		}
		public DefaultStrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultStrategy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitDefaultStrategy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultStrategyContext defaultStrategy() throws RecognitionException {
		DefaultStrategyContext _localctx = new DefaultStrategyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_defaultStrategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__7);
			setState(137);
			match(T__8);
			setState(138);
			strategyDefinition();
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

	public static class StrategyDefinitionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(RobocommandeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RobocommandeParser.NEWLINE, i);
		}
		public RunContext run() {
			return getRuleContext(RunContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public StrategyDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategyDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitStrategyDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyDefinitionContext strategyDefinition() throws RecognitionException {
		StrategyDefinitionContext _localctx = new StrategyDefinitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_strategyDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__9);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(141);
				match(NEWLINE);
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(147);
				run();
				}
				break;
			}
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(150);
				functions();
				}
				break;
			}
			setState(153);
			match(T__10);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(154);
				match(NEWLINE);
				}
				}
				setState(159);
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

	public static class SetupBlockContext extends ParserRuleContext {
		public List<SetupStmtContext> setupStmt() {
			return getRuleContexts(SetupStmtContext.class);
		}
		public SetupStmtContext setupStmt(int i) {
			return getRuleContext(SetupStmtContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RobocommandeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RobocommandeParser.NEWLINE, i);
		}
		public SetupBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setupBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitSetupBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupBlockContext setupBlock() throws RecognitionException {
		SetupBlockContext _localctx = new SetupBlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_setupBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__9);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(161);
				setupStmt();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			match(T__10);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(168);
				match(NEWLINE);
				}
				}
				setState(173);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(RobocommandeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RobocommandeParser.NEWLINE, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__9);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(175);
				stmt();
				}
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(181);
			match(T__10);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(182);
					match(NEWLINE);
					}
					} 
				}
				setState(187);
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
			exitRule();
		}
		return _localctx;
	}

	public static class SetupStmtContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(RobocommandeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RobocommandeParser.NEWLINE, i);
		}
		public GeneralStmtPartContext generalStmtPart() {
			return getRuleContext(GeneralStmtPartContext.class,0);
		}
		public NewEventContext newEvent() {
			return getRuleContext(NewEventContext.class,0);
		}
		public SetupStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setupStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitSetupStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupStmtContext setupStmt() throws RecognitionException {
		SetupStmtContext _localctx = new SetupStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_setupStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(188);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(191); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
			case T__19:
			case T__22:
			case ID:
				{
				setState(193);
				generalStmtPart();
				}
				break;
			case T__17:
				{
				setState(194);
				newEvent();
				}
				break;
			case T__10:
			case NEWLINE:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(200);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(197);
					match(NEWLINE);
					}
					} 
				}
				setState(202);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		public List<TerminalNode> NEWLINE() { return getTokens(RobocommandeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RobocommandeParser.NEWLINE, i);
		}
		public GeneralStmtPartContext generalStmtPart() {
			return getRuleContext(GeneralStmtPartContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(204); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(203);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(206); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
			case T__16:
			case T__19:
			case T__22:
			case ID:
				{
				setState(208);
				generalStmtPart();
				}
				break;
			case T__24:
				{
				setState(209);
				returnStatement();
				}
				break;
			case T__10:
			case NEWLINE:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(212);
					match(NEWLINE);
					}
					} 
				}
				setState(217);
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

	public static class GeneralStmtPartContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StructDefinitionContext structDefinition() {
			return getRuleContext(StructDefinitionContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FieldAssignmentContext fieldAssignment() {
			return getRuleContext(FieldAssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public GeneralStmtPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generalStmtPart; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitGeneralStmtPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GeneralStmtPartContext generalStmtPart() throws RecognitionException {
		GeneralStmtPartContext _localctx = new GeneralStmtPartContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_generalStmtPart);
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				structDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				assignment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				fieldAssignment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(222);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(223);
				functionCall();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(224);
				loop();
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

	public static class StructDefinitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public StructDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDefinition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitStructDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDefinitionContext structDefinition() throws RecognitionException {
		StructDefinitionContext _localctx = new StructDefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_structDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(ID);
			setState(228);
			match(T__11);
			setState(229);
			declaration();
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(230);
				match(T__6);
				setState(231);
				declaration();
				}
				}
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(237);
			match(T__12);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			type();
			setState(240);
			match(ID);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(241);
				match(T__13);
				setState(242);
				expr(0);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << ID))) != 0)) ) {
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

	public static class NewEventContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public NewEventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newEvent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitNewEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewEventContext newEvent() throws RecognitionException {
		NewEventContext _localctx = new NewEventContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_newEvent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__17);
			setState(248);
			match(T__18);
			setState(249);
			match(ID);
			setState(250);
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

	public static class FieldAssignmentContext extends ParserRuleContext {
		public FieldIdContext fieldId() {
			return getRuleContext(FieldIdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FieldAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAssignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitFieldAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAssignmentContext fieldAssignment() throws RecognitionException {
		FieldAssignmentContext _localctx = new FieldAssignmentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_fieldAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			fieldId();
			setState(253);
			match(T__13);
			setState(254);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(ID);
			setState(257);
			match(T__13);
			setState(258);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__19);
			setState(261);
			expr(0);
			setState(262);
			block();
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(263);
				match(T__20);
				setState(264);
				expr(0);
				setState(265);
				block();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(272);
				match(T__21);
				setState(273);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public FieldIdContext fieldId() {
			return getRuleContext(FieldIdContext.class,0);
		}
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public ActualParamsContext actualParams() {
			return getRuleContext(ActualParamsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(276);
				fieldId();
				}
				break;
			case 2:
				{
				setState(277);
				match(ID);
				}
				break;
			}
			setState(280);
			match(T__2);
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << ID) | (1L << NUM) | (1L << STRING))) != 0)) {
				{
				setState(281);
				actualParams();
				}
			}

			setState(284);
			match(T__3);
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

	public static class StructInitializationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public StructInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structInitialization; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitStructInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructInitializationContext structInitialization() throws RecognitionException {
		StructInitializationContext _localctx = new StructInitializationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_structInitialization);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(ID);
			setState(287);
			match(T__2);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(288);
				assignment();
				}
			}

			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(291);
				match(T__6);
				setState(292);
				assignment();
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(298);
			match(T__3);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(T__22);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__23) {
				{
				setState(301);
				match(T__23);
				setState(302);
				expr(0);
				}
			}

			setState(305);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			match(T__24);
			setState(308);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComparisonContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ComparisonContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivModContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusOrMinusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PlusOrMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitPlusOrMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegateBoolContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateBoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitNegateBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralContext extends ExprContext {
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public TerminalNode NUM() { return getToken(RobocommandeParser.NUM, 0); }
		public TerminalNode STRING() { return getToken(RobocommandeParser.STRING, 0); }
		public LiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GroupedExpressionContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GroupedExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitGroupedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructInitContext extends ExprContext {
		public StructInitializationContext structInitialization() {
			return getRuleContext(StructInitializationContext.class,0);
		}
		public StructInitContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitStructInit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldIdentifierContext extends ExprContext {
		public FieldIdContext fieldId() {
			return getRuleContext(FieldIdContext.class,0);
		}
		public FieldIdentifierContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitFieldIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FCallContext extends ExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitFCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowerContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PowerContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegateExpressionContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitNegateExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualityContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(311);
				_la = _input.LA(1);
				if ( !(_la==T__25 || _la==T__26) ) {
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
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(312);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(313);
				match(NUM);
				}
				break;
			case 4:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new FieldIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(315);
				fieldId();
				}
				break;
			case 6:
				{
				_localctx = new FCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(316);
				functionCall();
				}
				break;
			case 7:
				{
				_localctx = new StructInitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(317);
				structInitialization();
				}
				break;
			case 8:
				{
				_localctx = new GroupedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(318);
				match(T__2);
				setState(319);
				expr(0);
				setState(320);
				match(T__3);
				}
				break;
			case 9:
				{
				_localctx = new NegateBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(322);
				match(T__27);
				setState(323);
				expr(9);
				}
				break;
			case 10:
				{
				_localctx = new NegateExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(324);
				match(T__28);
				setState(325);
				expr(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(349);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(328);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(329);
						match(T__29);
						setState(330);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new MultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(331);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(332);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(333);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new PlusOrMinusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(334);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(335);
						_la = _input.LA(1);
						if ( !(_la==T__28 || _la==T__33) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(336);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(337);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(338);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(339);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(340);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(341);
						_la = _input.LA(1);
						if ( !(_la==T__38 || _la==T__39) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(342);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(343);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(344);
						match(T__40);
						setState(345);
						expr(3);
						}
						break;
					case 7:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(346);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(347);
						match(T__41);
						setState(348);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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

	public static class FieldIdContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RobocommandeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RobocommandeParser.ID, i);
		}
		public FieldIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitFieldId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldIdContext fieldId() throws RecognitionException {
		FieldIdContext _localctx = new FieldIdContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fieldId);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(ID);
			setState(357); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(355);
					match(T__42);
					setState(356);
					match(ID);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(359); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		case 27:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u016c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\7\2>\n\2\f\2\16"+
		"\2A\13\2\3\2\5\2D\n\2\3\2\3\2\3\2\7\2I\n\2\f\2\16\2L\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5^\n\5\f\5\16\5"+
		"a\13\5\3\6\3\6\3\6\3\6\3\6\5\6h\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bz\n\b\f\b\16\b}\13\b\3\t\3\t\3\t\7\t"+
		"\u0082\n\t\f\t\16\t\u0085\13\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\7\f\u0091\n\f\f\f\16\f\u0094\13\f\3\f\5\f\u0097\n\f\3\f\5\f\u009a"+
		"\n\f\3\f\3\f\7\f\u009e\n\f\f\f\16\f\u00a1\13\f\3\r\3\r\7\r\u00a5\n\r\f"+
		"\r\16\r\u00a8\13\r\3\r\3\r\7\r\u00ac\n\r\f\r\16\r\u00af\13\r\3\16\3\16"+
		"\7\16\u00b3\n\16\f\16\16\16\u00b6\13\16\3\16\3\16\7\16\u00ba\n\16\f\16"+
		"\16\16\u00bd\13\16\3\17\6\17\u00c0\n\17\r\17\16\17\u00c1\3\17\3\17\5\17"+
		"\u00c6\n\17\3\17\7\17\u00c9\n\17\f\17\16\17\u00cc\13\17\3\20\6\20\u00cf"+
		"\n\20\r\20\16\20\u00d0\3\20\3\20\5\20\u00d5\n\20\3\20\7\20\u00d8\n\20"+
		"\f\20\16\20\u00db\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e4"+
		"\n\21\3\22\3\22\3\22\3\22\3\22\7\22\u00eb\n\22\f\22\16\22\u00ee\13\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00f6\n\23\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\7\30\u010e\n\30\f\30\16\30\u0111\13\30\3\30\3\30\5\30"+
		"\u0115\n\30\3\31\3\31\5\31\u0119\n\31\3\31\3\31\5\31\u011d\n\31\3\31\3"+
		"\31\3\32\3\32\3\32\5\32\u0124\n\32\3\32\3\32\7\32\u0128\n\32\f\32\16\32"+
		"\u012b\13\32\3\32\3\32\3\33\3\33\3\33\5\33\u0132\n\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\5\35\u0149\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\7\35\u0160\n\35\f\35\16\35\u0163\13\35\3\36\3\36\3\36\6\36\u0168\n\36"+
		"\r\36\16\36\u0169\3\36\2\38\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:\2\b\4\2\21\23..\3\2\34\35\3\2!#\4\2\37\37$$\3"+
		"\2%(\3\2)*\u0187\2?\3\2\2\2\4O\3\2\2\2\6U\3\2\2\2\b_\3\2\2\2\nb\3\2\2"+
		"\2\fl\3\2\2\2\16s\3\2\2\2\20~\3\2\2\2\22\u0086\3\2\2\2\24\u008a\3\2\2"+
		"\2\26\u008e\3\2\2\2\30\u00a2\3\2\2\2\32\u00b0\3\2\2\2\34\u00bf\3\2\2\2"+
		"\36\u00ce\3\2\2\2 \u00e3\3\2\2\2\"\u00e5\3\2\2\2$\u00f1\3\2\2\2&\u00f7"+
		"\3\2\2\2(\u00f9\3\2\2\2*\u00fe\3\2\2\2,\u0102\3\2\2\2.\u0106\3\2\2\2\60"+
		"\u0118\3\2\2\2\62\u0120\3\2\2\2\64\u012e\3\2\2\2\66\u0135\3\2\2\28\u0148"+
		"\3\2\2\2:\u0164\3\2\2\2<>\7\65\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2"+
		"\2\2@C\3\2\2\2A?\3\2\2\2BD\5\4\3\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EJ\5\24"+
		"\13\2FI\5\22\n\2GI\5\n\6\2HF\3\2\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3"+
		"\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7\2\2\3N\3\3\2\2\2OP\7\3\2\2PQ\7\4\2\2QR"+
		"\7\5\2\2RS\7\6\2\2ST\5\30\r\2T\5\3\2\2\2UV\7\3\2\2VW\7\7\2\2WX\7\5\2\2"+
		"XY\7\6\2\2YZ\5\32\16\2Z\7\3\2\2\2[^\5\n\6\2\\^\5\f\7\2][\3\2\2\2]\\\3"+
		"\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\t\3\2\2\2a_\3\2\2\2bc\7\b\2\2cd"+
		"\5&\24\2de\7.\2\2eg\7\5\2\2fh\5\16\b\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2\2i"+
		"j\7\6\2\2jk\5\32\16\2k\13\3\2\2\2lm\7\3\2\2mn\7.\2\2no\7\5\2\2op\7.\2"+
		"\2pq\7\6\2\2qr\5\32\16\2r\r\3\2\2\2st\5&\24\2t{\7.\2\2uv\7\t\2\2vw\5&"+
		"\24\2wx\7.\2\2xz\3\2\2\2yu\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\17\3"+
		"\2\2\2}{\3\2\2\2~\u0083\58\35\2\177\u0080\7\t\2\2\u0080\u0082\58\35\2"+
		"\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\21\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7\n\2\2\u0087"+
		"\u0088\7.\2\2\u0088\u0089\5\26\f\2\u0089\23\3\2\2\2\u008a\u008b\7\n\2"+
		"\2\u008b\u008c\7\13\2\2\u008c\u008d\5\26\f\2\u008d\25\3\2\2\2\u008e\u0092"+
		"\7\f\2\2\u008f\u0091\7\65\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2"+
		"\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092"+
		"\3\2\2\2\u0095\u0097\5\6\4\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0099\3\2\2\2\u0098\u009a\5\b\5\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u009f\7\r\2\2\u009c\u009e\7\65\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\27\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a6\7\f\2\2\u00a3\u00a5"+
		"\5\34\17\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2"+
		"\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ad"+
		"\7\r\2\2\u00aa\u00ac\7\65\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2"+
		"\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\31\3\2\2\2\u00af\u00ad"+
		"\3\2\2\2\u00b0\u00b4\7\f\2\2\u00b1\u00b3\5\36\20\2\u00b2\u00b1\3\2\2\2"+
		"\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00bb\7\r\2\2\u00b8\u00ba\7\65\2\2"+
		"\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\33\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\7\65\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c6\5 \21\2\u00c4\u00c6\5(\25\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00ca\3\2"+
		"\2\2\u00c7\u00c9\7\65\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\35\3\2\2\2\u00cc\u00ca\3\2\2"+
		"\2\u00cd\u00cf\7\65\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d5\5 "+
		"\21\2\u00d3\u00d5\5\66\34\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\u00d9\3\2\2\2\u00d6\u00d8\7\65\2\2\u00d7\u00d6\3"+
		"\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\37\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00e4\5$\23\2\u00dd\u00e4\5\"\22"+
		"\2\u00de\u00e4\5,\27\2\u00df\u00e4\5*\26\2\u00e0\u00e4\5.\30\2\u00e1\u00e4"+
		"\5\60\31\2\u00e2\u00e4\5\64\33\2\u00e3\u00dc\3\2\2\2\u00e3\u00dd\3\2\2"+
		"\2\u00e3\u00de\3\2\2\2\u00e3\u00df\3\2\2\2\u00e3\u00e0\3\2\2\2\u00e3\u00e1"+
		"\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4!\3\2\2\2\u00e5\u00e6\7.\2\2\u00e6\u00e7"+
		"\7\16\2\2\u00e7\u00ec\5$\23\2\u00e8\u00e9\7\t\2\2\u00e9\u00eb\5$\23\2"+
		"\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7\17\2\2"+
		"\u00f0#\3\2\2\2\u00f1\u00f2\5&\24\2\u00f2\u00f5\7.\2\2\u00f3\u00f4\7\20"+
		"\2\2\u00f4\u00f6\58\35\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"%\3\2\2\2\u00f7\u00f8\t\2\2\2\u00f8\'\3\2\2\2\u00f9\u00fa\7\24\2\2\u00fa"+
		"\u00fb\7\25\2\2\u00fb\u00fc\7.\2\2\u00fc\u00fd\5\32\16\2\u00fd)\3\2\2"+
		"\2\u00fe\u00ff\5:\36\2\u00ff\u0100\7\20\2\2\u0100\u0101\58\35\2\u0101"+
		"+\3\2\2\2\u0102\u0103\7.\2\2\u0103\u0104\7\20\2\2\u0104\u0105\58\35\2"+
		"\u0105-\3\2\2\2\u0106\u0107\7\26\2\2\u0107\u0108\58\35\2\u0108\u010f\5"+
		"\32\16\2\u0109\u010a\7\27\2\2\u010a\u010b\58\35\2\u010b\u010c\5\32\16"+
		"\2\u010c\u010e\3\2\2\2\u010d\u0109\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0114\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0113\7\30\2\2\u0113\u0115\5\32\16\2\u0114\u0112\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115/\3\2\2\2\u0116\u0119\5:\36\2\u0117\u0119\7.\2\2\u0118\u0116"+
		"\3\2\2\2\u0118\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\7\5\2\2\u011b"+
		"\u011d\5\20\t\2\u011c\u011b\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3"+
		"\2\2\2\u011e\u011f\7\6\2\2\u011f\61\3\2\2\2\u0120\u0121\7.\2\2\u0121\u0123"+
		"\7\5\2\2\u0122\u0124\5,\27\2\u0123\u0122\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\u0129\3\2\2\2\u0125\u0126\7\t\2\2\u0126\u0128\5,\27\2\u0127\u0125\3\2"+
		"\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a"+
		"\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7\6\2\2\u012d\63\3\2\2"+
		"\2\u012e\u0131\7\31\2\2\u012f\u0130\7\32\2\2\u0130\u0132\58\35\2\u0131"+
		"\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\5\32"+
		"\16\2\u0134\65\3\2\2\2\u0135\u0136\7\33\2\2\u0136\u0137\58\35\2\u0137"+
		"\67\3\2\2\2\u0138\u0139\b\35\1\2\u0139\u0149\t\3\2\2\u013a\u0149\7.\2"+
		"\2\u013b\u0149\7/\2\2\u013c\u0149\7\62\2\2\u013d\u0149\5:\36\2\u013e\u0149"+
		"\5\60\31\2\u013f\u0149\5\62\32\2\u0140\u0141\7\5\2\2\u0141\u0142\58\35"+
		"\2\u0142\u0143\7\6\2\2\u0143\u0149\3\2\2\2\u0144\u0145\7\36\2\2\u0145"+
		"\u0149\58\35\13\u0146\u0147\7\37\2\2\u0147\u0149\58\35\n\u0148\u0138\3"+
		"\2\2\2\u0148\u013a\3\2\2\2\u0148\u013b\3\2\2\2\u0148\u013c\3\2\2\2\u0148"+
		"\u013d\3\2\2\2\u0148\u013e\3\2\2\2\u0148\u013f\3\2\2\2\u0148\u0140\3\2"+
		"\2\2\u0148\u0144\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u0161\3\2\2\2\u014a"+
		"\u014b\f\t\2\2\u014b\u014c\7 \2\2\u014c\u0160\58\35\t\u014d\u014e\f\b"+
		"\2\2\u014e\u014f\t\4\2\2\u014f\u0160\58\35\t\u0150\u0151\f\7\2\2\u0151"+
		"\u0152\t\5\2\2\u0152\u0160\58\35\b\u0153\u0154\f\6\2\2\u0154\u0155\t\6"+
		"\2\2\u0155\u0160\58\35\7\u0156\u0157\f\5\2\2\u0157\u0158\t\7\2\2\u0158"+
		"\u0160\58\35\6\u0159\u015a\f\4\2\2\u015a\u015b\7+\2\2\u015b\u0160\58\35"+
		"\5\u015c\u015d\f\3\2\2\u015d\u015e\7,\2\2\u015e\u0160\58\35\4\u015f\u014a"+
		"\3\2\2\2\u015f\u014d\3\2\2\2\u015f\u0150\3\2\2\2\u015f\u0153\3\2\2\2\u015f"+
		"\u0156\3\2\2\2\u015f\u0159\3\2\2\2\u015f\u015c\3\2\2\2\u0160\u0163\3\2"+
		"\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u01629\3\2\2\2\u0163\u0161"+
		"\3\2\2\2\u0164\u0167\7.\2\2\u0165\u0166\7-\2\2\u0166\u0168\7.\2\2\u0167"+
		"\u0165\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0167\3\2\2\2\u0169\u016a\3\2"+
		"\2\2\u016a;\3\2\2\2\'?CHJ]_g{\u0083\u0092\u0096\u0099\u009f\u00a6\u00ad"+
		"\u00b4\u00bb\u00c1\u00c5\u00ca\u00d0\u00d4\u00d9\u00e3\u00ec\u00f5\u010f"+
		"\u0114\u0118\u011c\u0123\u0129\u0131\u0148\u015f\u0161\u0169";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}