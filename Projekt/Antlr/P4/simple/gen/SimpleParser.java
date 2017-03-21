// Generated from /home/pprintz/stuff/P4-AAU-Kursusopgaver/Projekt/Antlr/P4/simple/Simple.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleParser extends Parser {
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
		RULE_prog = 0, RULE_setup = 1, RULE_run = 2, RULE_functions = 3, RULE_strategy = 4, 
		RULE_defaultStrategy = 5, RULE_strategyDefinition = 6, RULE_block = 7, 
		RULE_stmt = 8, RULE_defineFunction = 9, RULE_behaviorFunction = 10, RULE_structDeclaration = 11, 
		RULE_declaration = 12, RULE_newDeclaration = 13, RULE_newEvent = 14, RULE_fieldAssignment = 15, 
		RULE_assignment = 16, RULE_changeStrategy = 17, RULE_ifStatement = 18, 
		RULE_functionCall = 19, RULE_structInitialization = 20, RULE_loop = 21, 
		RULE_returnStatement = 22, RULE_formalParams = 23, RULE_actualParams = 24, 
		RULE_expr = 25, RULE_fieldId = 26;
	public static final String[] ruleNames = {
		"prog", "setup", "run", "functions", "strategy", "defaultStrategy", "strategyDefinition", 
		"block", "stmt", "defineFunction", "behaviorFunction", "structDeclaration", 
		"declaration", "newDeclaration", "newEvent", "fieldAssignment", "assignment", 
		"changeStrategy", "ifStatement", "functionCall", "structInitialization", 
		"loop", "returnStatement", "formalParams", "actualParams", "expr", "fieldId"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'behavior'", "'onSetup'", "'('", "')'", "'onRun'", "'strategy'", 
		"'default'", "':'", "';'", "'define'", "'{'", "','", "'}'", "'var'", "':='", 
		"'new'", "'changeStrategy'", "'if'", "'else if'", "'else'", "'loop'", 
		"'while'", "'return'", "'true'", "'false'", "'not'", "'-'", "'^'", "'['", 
		"']'", "'*'", "'/'", "'%'", "'+'", "'<='", "'>='", "'<'", "'>'", "'!='", 
		"'='", "'and'", "'or'", "'.'"
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
	public String getGrammarFileName() { return "Simple.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DefaultStrategyContext defaultStrategy() {
			return getRuleContext(DefaultStrategyContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SimpleParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParser.NEWLINE, i);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitProg(this);
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
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(54);
				match(NEWLINE);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(60);
				setup();
				}
			}

			setState(63);
			defaultStrategy();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(64);
				match(NEWLINE);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5 || _la==T__9) {
				{
				setState(72);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(70);
					strategy();
					}
					break;
				case T__9:
					{
					setState(71);
					defineFunction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SetupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setup; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitSetup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetupContext setup() throws RecognitionException {
		SetupContext _localctx = new SetupContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_setup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__0);
			setState(80);
			match(T__1);
			setState(81);
			match(T__2);
			setState(82);
			match(T__3);
			setState(83);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitRun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_run);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__0);
			setState(86);
			match(T__4);
			setState(87);
			match(T__2);
			setState(88);
			match(T__3);
			setState(89);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitFunctions(this);
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__9) {
				{
				setState(93);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(91);
					defineFunction();
					}
					break;
				case T__0:
					{
					setState(92);
					behaviorFunction();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(97);
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
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public StrategyDefinitionContext strategyDefinition() {
			return getRuleContext(StrategyDefinitionContext.class,0);
		}
		public StrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strategy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitStrategy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyContext strategy() throws RecognitionException {
		StrategyContext _localctx = new StrategyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_strategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__5);
			setState(99);
			match(ID);
			setState(100);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitDefaultStrategy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultStrategyContext defaultStrategy() throws RecognitionException {
		DefaultStrategyContext _localctx = new DefaultStrategyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_defaultStrategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__5);
			setState(103);
			match(T__6);
			setState(104);
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
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParser.NEWLINE, i);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitStrategyDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrategyDefinitionContext strategyDefinition() throws RecognitionException {
		StrategyDefinitionContext _localctx = new StrategyDefinitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_strategyDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__7);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(107);
				match(NEWLINE);
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(113);
				run();
				}
				break;
			}
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(116);
				functions();
				}
				break;
			}
			setState(119);
			match(T__8);
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
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParser.NEWLINE, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__7);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(122);
				stmt();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(T__8);
			setState(132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(129);
					match(NEWLINE);
					}
					} 
				}
				setState(134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		public List<TerminalNode> NEWLINE() { return getTokens(SimpleParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(SimpleParser.NEWLINE, i);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
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
		public NewDeclarationContext newDeclaration() {
			return getRuleContext(NewDeclarationContext.class,0);
		}
		public NewEventContext newEvent() {
			return getRuleContext(NewEventContext.class,0);
		}
		public ChangeStrategyContext changeStrategy() {
			return getRuleContext(ChangeStrategyContext.class,0);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_stmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(135);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(138); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(140);
				declaration();
				}
				break;
			case 2:
				{
				setState(141);
				structDeclaration();
				}
				break;
			case 3:
				{
				setState(142);
				assignment();
				}
				break;
			case 4:
				{
				setState(143);
				fieldAssignment();
				}
				break;
			case 5:
				{
				setState(144);
				ifStatement();
				}
				break;
			case 6:
				{
				setState(145);
				functionCall();
				}
				break;
			case 7:
				{
				setState(146);
				loop();
				}
				break;
			case 8:
				{
				setState(147);
				structDeclaration();
				}
				break;
			case 9:
				{
				setState(148);
				newDeclaration();
				}
				break;
			case 10:
				{
				setState(149);
				newEvent();
				}
				break;
			case 11:
				{
				setState(150);
				changeStrategy();
				}
				break;
			case 12:
				{
				setState(151);
				returnStatement();
				}
				break;
			}
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(154);
					match(NEWLINE);
					}
					} 
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitDefineFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineFunctionContext defineFunction() throws RecognitionException {
		DefineFunctionContext _localctx = new DefineFunctionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_defineFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__9);
			setState(161);
			match(ID);
			setState(162);
			match(T__2);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(163);
				formalParams();
				}
			}

			setState(166);
			match(T__3);
			setState(167);
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
		public List<TerminalNode> ID() { return getTokens(SimpleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleParser.ID, i);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitBehaviorFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BehaviorFunctionContext behaviorFunction() throws RecognitionException {
		BehaviorFunctionContext _localctx = new BehaviorFunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_behaviorFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__0);
			setState(170);
			match(ID);
			setState(171);
			match(T__2);
			setState(172);
			match(ID);
			setState(173);
			match(T__3);
			setState(174);
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

	public static class StructDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SimpleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleParser.ID, i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(ID);
			setState(177);
			match(T__10);
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(178);
				match(ID);
				}
				break;
			case 2:
				{
				setState(179);
				assignment();
				}
				break;
			}
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(182);
				match(T__11);
				setState(185);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(183);
					match(ID);
					}
					break;
				case 2:
					{
					setState(184);
					assignment();
					}
					break;
				}
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
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
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__13);
			setState(195);
			match(ID);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(196);
				match(T__14);
				setState(197);
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

	public static class NewDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NewDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitNewDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewDeclarationContext newDeclaration() throws RecognitionException {
		NewDeclarationContext _localctx = new NewDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_newDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__15);
			setState(201);
			match(ID);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(202);
				match(T__14);
				setState(203);
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

	public static class NewEventContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public NewEventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newEvent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitNewEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewEventContext newEvent() throws RecognitionException {
		NewEventContext _localctx = new NewEventContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_newEvent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__15);
			setState(207);
			match(T__0);
			setState(208);
			match(ID);
			setState(209);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitFieldAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAssignmentContext fieldAssignment() throws RecognitionException {
		FieldAssignmentContext _localctx = new FieldAssignmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fieldAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			fieldId();
			setState(212);
			match(T__14);
			setState(213);
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
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(ID);
			setState(216);
			match(T__14);
			setState(217);
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

	public static class ChangeStrategyContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public ChangeStrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changeStrategy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitChangeStrategy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangeStrategyContext changeStrategy() throws RecognitionException {
		ChangeStrategyContext _localctx = new ChangeStrategyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_changeStrategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__16);
			setState(220);
			match(T__2);
			setState(221);
			match(ID);
			setState(222);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__17);
			setState(225);
			expr(0);
			setState(226);
			block();
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(227);
				match(T__18);
				setState(228);
				expr(0);
				setState(229);
				block();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(236);
				match(T__19);
				setState(237);
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
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public ActualParamsContext actualParams() {
			return getRuleContext(ActualParamsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(240);
				fieldId();
				}
				break;
			case 2:
				{
				setState(241);
				match(ID);
				}
				break;
			}
			setState(244);
			match(T__2);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << ID) | (1L << NUM) | (1L << STRING))) != 0)) {
				{
				setState(245);
				actualParams();
				}
			}

			setState(248);
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
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitStructInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructInitializationContext structInitialization() throws RecognitionException {
		StructInitializationContext _localctx = new StructInitializationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_structInitialization);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(ID);
			setState(251);
			match(T__2);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(252);
				assignment();
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__20);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(261);
				match(T__21);
				setState(262);
				expr(0);
				}
			}

			setState(265);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__22);
			setState(268);
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

	public static class FormalParamsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SimpleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleParser.ID, i);
		}
		public FormalParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParams; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitFormalParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParamsContext formalParams() throws RecognitionException {
		FormalParamsContext _localctx = new FormalParamsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_formalParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(ID);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(271);
				match(T__11);
				setState(272);
				match(ID);
				}
				}
				setState(277);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitActualParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActualParamsContext actualParams() throws RecognitionException {
		ActualParamsContext _localctx = new ActualParamsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_actualParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			expr(0);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(279);
				match(T__11);
				setState(280);
				expr(0);
				}
				}
				setState(285);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitComparison(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitOr(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitMultDivMod(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitPlusOrMinus(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitNegateBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ListContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralContext extends ExprContext {
		public TerminalNode ID() { return getToken(SimpleParser.ID, 0); }
		public TerminalNode NUM() { return getToken(SimpleParser.NUM, 0); }
		public TerminalNode STRING() { return getToken(SimpleParser.STRING, 0); }
		public LiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitLiteral(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitGroupedExpression(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitFieldIdentifier(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitAnd(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitFCall(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructInitializatorContext extends ExprContext {
		public StructInitializationContext structInitialization() {
			return getRuleContext(StructInitializationContext.class,0);
		}
		public StructInitializatorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitStructInitializator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegateNumContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateNumContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitNegateNum(this);
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
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitEquality(this);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(287);
				_la = _input.LA(1);
				if ( !(_la==T__23 || _la==T__24) ) {
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
				setState(288);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(289);
				match(NUM);
				}
				break;
			case 4:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new FieldIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				fieldId();
				}
				break;
			case 6:
				{
				_localctx = new FCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				functionCall();
				}
				break;
			case 7:
				{
				_localctx = new StructInitializatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293);
				structInitialization();
				}
				break;
			case 8:
				{
				_localctx = new GroupedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294);
				match(T__2);
				setState(295);
				expr(0);
				setState(296);
				match(T__3);
				}
				break;
			case 9:
				{
				_localctx = new NegateBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				match(T__25);
				setState(299);
				expr(10);
				}
				break;
			case 10:
				{
				_localctx = new NegateNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(300);
				match(T__26);
				setState(301);
				expr(9);
				}
				break;
			case 11:
				{
				_localctx = new ListContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(302);
				match(T__28);
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << ID) | (1L << NUM) | (1L << STRING))) != 0)) {
					{
					setState(303);
					expr(0);
					}
				}

				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(306);
					match(T__11);
					setState(307);
					expr(0);
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(313);
				match(T__29);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(339);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(337);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(316);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(317);
						match(T__27);
						setState(318);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new MultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(319);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(320);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(321);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new PlusOrMinusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(322);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(323);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__33) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(324);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(325);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(326);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(327);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(328);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(329);
						_la = _input.LA(1);
						if ( !(_la==T__38 || _la==T__39) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(330);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(331);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(332);
						match(T__40);
						setState(333);
						expr(3);
						}
						break;
					case 7:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(334);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(335);
						match(T__41);
						setState(336);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(341);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		public List<TerminalNode> ID() { return getTokens(SimpleParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleParser.ID, i);
		}
		public FieldIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleVisitor ) return ((SimpleVisitor<? extends T>)visitor).visitFieldId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldIdContext fieldId() throws RecognitionException {
		FieldIdContext _localctx = new FieldIdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_fieldId);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(ID);
			setState(345); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(343);
					match(T__42);
					setState(344);
					match(ID);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(347); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		case 25:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\67\u0160\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\5\2@\n"+
		"\2\3\2\3\2\7\2D\n\2\f\2\16\2G\13\2\3\2\3\2\7\2K\n\2\f\2\16\2N\13\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5`\n\5"+
		"\f\5\16\5c\13\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\7\bo\n\b\f\b\16"+
		"\br\13\b\3\b\5\bu\n\b\3\b\5\bx\n\b\3\b\3\b\3\t\3\t\7\t~\n\t\f\t\16\t\u0081"+
		"\13\t\3\t\3\t\7\t\u0085\n\t\f\t\16\t\u0088\13\t\3\n\6\n\u008b\n\n\r\n"+
		"\16\n\u008c\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009b"+
		"\n\n\3\n\7\n\u009e\n\n\f\n\16\n\u00a1\13\n\3\13\3\13\3\13\3\13\5\13\u00a7"+
		"\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u00b7"+
		"\n\r\3\r\3\r\3\r\5\r\u00bc\n\r\7\r\u00be\n\r\f\r\16\r\u00c1\13\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\5\16\u00c9\n\16\3\17\3\17\3\17\3\17\5\17\u00cf"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00ea"+
		"\n\24\f\24\16\24\u00ed\13\24\3\24\3\24\5\24\u00f1\n\24\3\25\3\25\5\25"+
		"\u00f5\n\25\3\25\3\25\5\25\u00f9\n\25\3\25\3\25\3\26\3\26\3\26\7\26\u0100"+
		"\n\26\f\26\16\26\u0103\13\26\3\26\3\26\3\27\3\27\3\27\5\27\u010a\n\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u0114\n\31\f\31\16\31\u0117"+
		"\13\31\3\32\3\32\3\32\7\32\u011c\n\32\f\32\16\32\u011f\13\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\5\33\u0133\n\33\3\33\3\33\7\33\u0137\n\33\f\33\16\33\u013a"+
		"\13\33\3\33\5\33\u013d\n\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0154"+
		"\n\33\f\33\16\33\u0157\13\33\3\34\3\34\3\34\6\34\u015c\n\34\r\34\16\34"+
		"\u015d\3\34\2\3\64\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\66\2\7\3\2\32\33\3\2!#\4\2\35\35$$\3\2%(\3\2)*\u0180\2;\3\2"+
		"\2\2\4Q\3\2\2\2\6W\3\2\2\2\ba\3\2\2\2\nd\3\2\2\2\fh\3\2\2\2\16l\3\2\2"+
		"\2\20{\3\2\2\2\22\u008a\3\2\2\2\24\u00a2\3\2\2\2\26\u00ab\3\2\2\2\30\u00b2"+
		"\3\2\2\2\32\u00c4\3\2\2\2\34\u00ca\3\2\2\2\36\u00d0\3\2\2\2 \u00d5\3\2"+
		"\2\2\"\u00d9\3\2\2\2$\u00dd\3\2\2\2&\u00e2\3\2\2\2(\u00f4\3\2\2\2*\u00fc"+
		"\3\2\2\2,\u0106\3\2\2\2.\u010d\3\2\2\2\60\u0110\3\2\2\2\62\u0118\3\2\2"+
		"\2\64\u013c\3\2\2\2\66\u0158\3\2\2\28:\7\65\2\298\3\2\2\2:=\3\2\2\2;9"+
		"\3\2\2\2;<\3\2\2\2<?\3\2\2\2=;\3\2\2\2>@\5\4\3\2?>\3\2\2\2?@\3\2\2\2@"+
		"A\3\2\2\2AE\5\f\7\2BD\7\65\2\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2"+
		"FL\3\2\2\2GE\3\2\2\2HK\5\n\6\2IK\5\24\13\2JH\3\2\2\2JI\3\2\2\2KN\3\2\2"+
		"\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\2\2\3P\3\3\2\2\2QR\7\3"+
		"\2\2RS\7\4\2\2ST\7\5\2\2TU\7\6\2\2UV\5\20\t\2V\5\3\2\2\2WX\7\3\2\2XY\7"+
		"\7\2\2YZ\7\5\2\2Z[\7\6\2\2[\\\5\20\t\2\\\7\3\2\2\2]`\5\24\13\2^`\5\26"+
		"\f\2_]\3\2\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\t\3\2\2\2ca\3"+
		"\2\2\2de\7\b\2\2ef\7.\2\2fg\5\16\b\2g\13\3\2\2\2hi\7\b\2\2ij\7\t\2\2j"+
		"k\5\16\b\2k\r\3\2\2\2lp\7\n\2\2mo\7\65\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2"+
		"\2pq\3\2\2\2qt\3\2\2\2rp\3\2\2\2su\5\6\4\2ts\3\2\2\2tu\3\2\2\2uw\3\2\2"+
		"\2vx\5\b\5\2wv\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\13\2\2z\17\3\2\2\2{\177"+
		"\7\n\2\2|~\5\22\n\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3"+
		"\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0086\7\13\2\2\u0083"+
		"\u0085\7\65\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3"+
		"\2\2\2\u0086\u0087\3\2\2\2\u0087\21\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008b\7\65\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\u009a\3\2\2\2\u008e\u009b\5\32\16\2\u008f"+
		"\u009b\5\30\r\2\u0090\u009b\5\"\22\2\u0091\u009b\5 \21\2\u0092\u009b\5"+
		"&\24\2\u0093\u009b\5(\25\2\u0094\u009b\5,\27\2\u0095\u009b\5\30\r\2\u0096"+
		"\u009b\5\34\17\2\u0097\u009b\5\36\20\2\u0098\u009b\5$\23\2\u0099\u009b"+
		"\5.\30\2\u009a\u008e\3\2\2\2\u009a\u008f\3\2\2\2\u009a\u0090\3\2\2\2\u009a"+
		"\u0091\3\2\2\2\u009a\u0092\3\2\2\2\u009a\u0093\3\2\2\2\u009a\u0094\3\2"+
		"\2\2\u009a\u0095\3\2\2\2\u009a\u0096\3\2\2\2\u009a\u0097\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009f\3\2"+
		"\2\2\u009c\u009e\7\65\2\2\u009d\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\23\3\2\2\2\u00a1\u009f\3\2\2"+
		"\2\u00a2\u00a3\7\f\2\2\u00a3\u00a4\7.\2\2\u00a4\u00a6\7\5\2\2\u00a5\u00a7"+
		"\5\60\31\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2"+
		"\u00a8\u00a9\7\6\2\2\u00a9\u00aa\5\20\t\2\u00aa\25\3\2\2\2\u00ab\u00ac"+
		"\7\3\2\2\u00ac\u00ad\7.\2\2\u00ad\u00ae\7\5\2\2\u00ae\u00af\7.\2\2\u00af"+
		"\u00b0\7\6\2\2\u00b0\u00b1\5\20\t\2\u00b1\27\3\2\2\2\u00b2\u00b3\7.\2"+
		"\2\u00b3\u00b6\7\r\2\2\u00b4\u00b7\7.\2\2\u00b5\u00b7\5\"\22\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00bf\3\2\2\2\u00b8\u00bb\7\16\2\2"+
		"\u00b9\u00bc\7.\2\2\u00ba\u00bc\5\"\22\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba"+
		"\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00b8\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c2\u00c3\7\17\2\2\u00c3\31\3\2\2\2\u00c4\u00c5\7\20\2\2\u00c5"+
		"\u00c8\7.\2\2\u00c6\u00c7\7\21\2\2\u00c7\u00c9\5\64\33\2\u00c8\u00c6\3"+
		"\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\33\3\2\2\2\u00ca\u00cb\7\22\2\2\u00cb"+
		"\u00ce\7.\2\2\u00cc\u00cd\7\21\2\2\u00cd\u00cf\5\64\33\2\u00ce\u00cc\3"+
		"\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\35\3\2\2\2\u00d0\u00d1\7\22\2\2\u00d1"+
		"\u00d2\7\3\2\2\u00d2\u00d3\7.\2\2\u00d3\u00d4\5\20\t\2\u00d4\37\3\2\2"+
		"\2\u00d5\u00d6\5\66\34\2\u00d6\u00d7\7\21\2\2\u00d7\u00d8\5\64\33\2\u00d8"+
		"!\3\2\2\2\u00d9\u00da\7.\2\2\u00da\u00db\7\21\2\2\u00db\u00dc\5\64\33"+
		"\2\u00dc#\3\2\2\2\u00dd\u00de\7\23\2\2\u00de\u00df\7\5\2\2\u00df\u00e0"+
		"\7.\2\2\u00e0\u00e1\7\6\2\2\u00e1%\3\2\2\2\u00e2\u00e3\7\24\2\2\u00e3"+
		"\u00e4\5\64\33\2\u00e4\u00eb\5\20\t\2\u00e5\u00e6\7\25\2\2\u00e6\u00e7"+
		"\5\64\33\2\u00e7\u00e8\5\20\t\2\u00e8\u00ea\3\2\2\2\u00e9\u00e5\3\2\2"+
		"\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00f0"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7\26\2\2\u00ef\u00f1\5\20\t\2"+
		"\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\'\3\2\2\2\u00f2\u00f5\5"+
		"\66\34\2\u00f3\u00f5\7.\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\u00f8\7\5\2\2\u00f7\u00f9\5\62\32\2\u00f8\u00f7\3"+
		"\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\7\6\2\2\u00fb"+
		")\3\2\2\2\u00fc\u00fd\7.\2\2\u00fd\u0101\7\5\2\2\u00fe\u0100\5\"\22\2"+
		"\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7\6\2\2\u0105"+
		"+\3\2\2\2\u0106\u0109\7\27\2\2\u0107\u0108\7\30\2\2\u0108\u010a\5\64\33"+
		"\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c"+
		"\5\20\t\2\u010c-\3\2\2\2\u010d\u010e\7\31\2\2\u010e\u010f\5\64\33\2\u010f"+
		"/\3\2\2\2\u0110\u0115\7.\2\2\u0111\u0112\7\16\2\2\u0112\u0114\7.\2\2\u0113"+
		"\u0111\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2"+
		"\2\2\u0116\61\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011d\5\64\33\2\u0119"+
		"\u011a\7\16\2\2\u011a\u011c\5\64\33\2\u011b\u0119\3\2\2\2\u011c\u011f"+
		"\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\63\3\2\2\2\u011f"+
		"\u011d\3\2\2\2\u0120\u0121\b\33\1\2\u0121\u013d\t\2\2\2\u0122\u013d\7"+
		".\2\2\u0123\u013d\7/\2\2\u0124\u013d\7\62\2\2\u0125\u013d\5\66\34\2\u0126"+
		"\u013d\5(\25\2\u0127\u013d\5*\26\2\u0128\u0129\7\5\2\2\u0129\u012a\5\64"+
		"\33\2\u012a\u012b\7\6\2\2\u012b\u013d\3\2\2\2\u012c\u012d\7\34\2\2\u012d"+
		"\u013d\5\64\33\f\u012e\u012f\7\35\2\2\u012f\u013d\5\64\33\13\u0130\u0132"+
		"\7\37\2\2\u0131\u0133\5\64\33\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2"+
		"\2\u0133\u0138\3\2\2\2\u0134\u0135\7\16\2\2\u0135\u0137\5\64\33\2\u0136"+
		"\u0134\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013d\7 \2\2\u013c"+
		"\u0120\3\2\2\2\u013c\u0122\3\2\2\2\u013c\u0123\3\2\2\2\u013c\u0124\3\2"+
		"\2\2\u013c\u0125\3\2\2\2\u013c\u0126\3\2\2\2\u013c\u0127\3\2\2\2\u013c"+
		"\u0128\3\2\2\2\u013c\u012c\3\2\2\2\u013c\u012e\3\2\2\2\u013c\u0130\3\2"+
		"\2\2\u013d\u0155\3\2\2\2\u013e\u013f\f\n\2\2\u013f\u0140\7\36\2\2\u0140"+
		"\u0154\5\64\33\n\u0141\u0142\f\b\2\2\u0142\u0143\t\3\2\2\u0143\u0154\5"+
		"\64\33\t\u0144\u0145\f\7\2\2\u0145\u0146\t\4\2\2\u0146\u0154\5\64\33\b"+
		"\u0147\u0148\f\6\2\2\u0148\u0149\t\5\2\2\u0149\u0154\5\64\33\7\u014a\u014b"+
		"\f\5\2\2\u014b\u014c\t\6\2\2\u014c\u0154\5\64\33\6\u014d\u014e\f\4\2\2"+
		"\u014e\u014f\7+\2\2\u014f\u0154\5\64\33\5\u0150\u0151\f\3\2\2\u0151\u0152"+
		"\7,\2\2\u0152\u0154\5\64\33\4\u0153\u013e\3\2\2\2\u0153\u0141\3\2\2\2"+
		"\u0153\u0144\3\2\2\2\u0153\u0147\3\2\2\2\u0153\u014a\3\2\2\2\u0153\u014d"+
		"\3\2\2\2\u0153\u0150\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155"+
		"\u0156\3\2\2\2\u0156\65\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u015b\7.\2\2"+
		"\u0159\u015a\7-\2\2\u015a\u015c\7.\2\2\u015b\u0159\3\2\2\2\u015c\u015d"+
		"\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\67\3\2\2\2%;?E"+
		"JL_aptw\177\u0086\u008c\u009a\u009f\u00a6\u00b6\u00bb\u00bf\u00c8\u00ce"+
		"\u00eb\u00f0\u00f4\u00f8\u0101\u0109\u0115\u011d\u0132\u0138\u013c\u0153"+
		"\u0155\u015d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}