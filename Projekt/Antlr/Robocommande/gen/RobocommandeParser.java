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
		T__38=39, T__39=40, T__40=41, ID=42, NUM=43, INT=44, FLOAT=45, STRING=46, 
		COMMENT=47, WS=48, NEWLINE=49, LETTER=50, ESC=51;
	public static final int
		RULE_prog = 0, RULE_setup = 1, RULE_run = 2, RULE_functions = 3, RULE_strategy = 4, 
		RULE_defaultStrategy = 5, RULE_strategyDefinition = 6, RULE_setupBlock = 7, 
		RULE_block = 8, RULE_setupStmt = 9, RULE_stmt = 10, RULE_defineFunction = 11, 
		RULE_behaviorFunction = 12, RULE_structDeclaration = 13, RULE_declaration = 14, 
		RULE_newDeclaration = 15, RULE_newEvent = 16, RULE_fieldAssignment = 17, 
		RULE_assignment = 18, RULE_changeStrategy = 19, RULE_ifStatement = 20, 
		RULE_functionCall = 21, RULE_structInitialization = 22, RULE_loop = 23, 
		RULE_returnStatement = 24, RULE_formalParams = 25, RULE_actualParams = 26, 
		RULE_expr = 27, RULE_fieldId = 28;
	public static final String[] ruleNames = {
		"prog", "setup", "run", "functions", "strategy", "defaultStrategy", "strategyDefinition", 
		"setupBlock", "block", "setupStmt", "stmt", "defineFunction", "behaviorFunction", 
		"structDeclaration", "declaration", "newDeclaration", "newEvent", "fieldAssignment", 
		"assignment", "changeStrategy", "ifStatement", "functionCall", "structInitialization", 
		"loop", "returnStatement", "formalParams", "actualParams", "expr", "fieldId"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'behavior'", "'onSetup'", "'('", "')'", "'onRun'", "'strategy'", 
		"'default'", "':'", "';'", "'define'", "'{'", "','", "'}'", "'var'", "':='", 
		"'new'", "'changeStrategy'", "'if'", "'else if'", "'else'", "'loop'", 
		"'while'", "'return'", "'true'", "'false'", "'not'", "'-'", "'^'", "'*'", 
		"'/'", "'%'", "'+'", "'<='", "'>='", "'<'", "'>'", "'!='", "'='", "'and'", 
		"'or'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "ID", "NUM", "INT", "FLOAT", "STRING", 
		"COMMENT", "WS", "NEWLINE", "LETTER", "ESC"
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
			while (_la==T__5 || _la==T__9) {
				{
				setState(70);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(68);
					strategy();
					}
					break;
				case T__9:
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
			while (_la==T__0 || _la==T__9) {
				{
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
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
		enterRule(_localctx, 8, RULE_strategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__5);
			setState(97);
			match(ID);
			setState(98);
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
		enterRule(_localctx, 10, RULE_defaultStrategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__5);
			setState(101);
			match(T__6);
			setState(102);
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
		enterRule(_localctx, 12, RULE_strategyDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__7);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(105);
				match(NEWLINE);
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(111);
				run();
				}
				break;
			}
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(114);
				functions();
				}
				break;
			}
			setState(117);
			match(T__8);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(118);
				match(NEWLINE);
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
		enterRule(_localctx, 14, RULE_setupBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__7);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(125);
				setupStmt();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			match(T__8);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(132);
				match(NEWLINE);
				}
				}
				setState(137);
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
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__7);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(139);
				stmt();
				}
				}
				setState(144);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			match(T__8);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(146);
					match(NEWLINE);
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public NewEventContext newEvent() {
			return getRuleContext(NewEventContext.class,0);
		}
		public ChangeStrategyContext changeStrategy() {
			return getRuleContext(ChangeStrategyContext.class,0);
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
		enterRule(_localctx, 18, RULE_setupStmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(152);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(155); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(157);
				declaration();
				}
				break;
			case 2:
				{
				setState(158);
				structDeclaration();
				}
				break;
			case 3:
				{
				setState(159);
				assignment();
				}
				break;
			case 4:
				{
				setState(160);
				fieldAssignment();
				}
				break;
			case 5:
				{
				setState(161);
				ifStatement();
				}
				break;
			case 6:
				{
				setState(162);
				functionCall();
				}
				break;
			case 7:
				{
				setState(163);
				loop();
				}
				break;
			case 8:
				{
				setState(164);
				structDeclaration();
				}
				break;
			case 9:
				{
				setState(165);
				newEvent();
				}
				break;
			case 10:
				{
				setState(166);
				changeStrategy();
				}
				break;
			}
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(169);
					match(NEWLINE);
					}
					} 
				}
				setState(174);
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

	public static class StmtContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(RobocommandeParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(RobocommandeParser.NEWLINE, i);
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
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(175);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(178); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(180);
				declaration();
				}
				break;
			case 2:
				{
				setState(181);
				structDeclaration();
				}
				break;
			case 3:
				{
				setState(182);
				assignment();
				}
				break;
			case 4:
				{
				setState(183);
				fieldAssignment();
				}
				break;
			case 5:
				{
				setState(184);
				ifStatement();
				}
				break;
			case 6:
				{
				setState(185);
				functionCall();
				}
				break;
			case 7:
				{
				setState(186);
				loop();
				}
				break;
			case 8:
				{
				setState(187);
				structDeclaration();
				}
				break;
			case 9:
				{
				setState(188);
				newDeclaration();
				}
				break;
			case 10:
				{
				setState(189);
				changeStrategy();
				}
				break;
			case 11:
				{
				setState(190);
				returnStatement();
				}
				break;
			}
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(193);
					match(NEWLINE);
					}
					} 
				}
				setState(198);
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

	public static class DefineFunctionContext extends ParserRuleContext {
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
		enterRule(_localctx, 22, RULE_defineFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__9);
			setState(200);
			match(ID);
			setState(201);
			match(T__2);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(202);
				formalParams();
				}
			}

			setState(205);
			match(T__3);
			setState(206);
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
		enterRule(_localctx, 24, RULE_behaviorFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__0);
			setState(209);
			match(ID);
			setState(210);
			match(T__2);
			setState(211);
			match(ID);
			setState(212);
			match(T__3);
			setState(213);
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
		public List<TerminalNode> ID() { return getTokens(RobocommandeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RobocommandeParser.ID, i);
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
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(ID);
			setState(216);
			match(T__10);
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(217);
				match(ID);
				}
				break;
			case 2:
				{
				setState(218);
				assignment();
				}
				break;
			}
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(221);
				match(T__11);
				setState(224);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(222);
					match(ID);
					}
					break;
				case 2:
					{
					setState(223);
					assignment();
					}
					break;
				}
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(231);
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
		enterRule(_localctx, 28, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(T__13);
			setState(234);
			match(ID);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(235);
				match(T__14);
				setState(236);
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
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NewDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitNewDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewDeclarationContext newDeclaration() throws RecognitionException {
		NewDeclarationContext _localctx = new NewDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_newDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__15);
			setState(240);
			match(ID);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(241);
				match(T__14);
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
		enterRule(_localctx, 32, RULE_newEvent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(T__15);
			setState(246);
			match(T__0);
			setState(247);
			match(ID);
			setState(248);
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
		enterRule(_localctx, 34, RULE_fieldAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			fieldId();
			setState(251);
			match(T__14);
			setState(252);
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
		enterRule(_localctx, 36, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(ID);
			setState(255);
			match(T__14);
			setState(256);
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
		public TerminalNode ID() { return getToken(RobocommandeParser.ID, 0); }
		public ChangeStrategyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_changeStrategy; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitChangeStrategy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangeStrategyContext changeStrategy() throws RecognitionException {
		ChangeStrategyContext _localctx = new ChangeStrategyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_changeStrategy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__16);
			setState(259);
			match(T__2);
			setState(260);
			match(ID);
			setState(261);
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
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__17);
			setState(264);
			expr(0);
			setState(265);
			block();
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(266);
				match(T__18);
				setState(267);
				expr(0);
				setState(268);
				block();
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(275);
				match(T__19);
				setState(276);
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
		enterRule(_localctx, 42, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(279);
				fieldId();
				}
				break;
			case 2:
				{
				setState(280);
				match(ID);
				}
				break;
			}
			setState(283);
			match(T__2);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << ID) | (1L << NUM) | (1L << STRING))) != 0)) {
				{
				setState(284);
				actualParams();
				}
			}

			setState(287);
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
		enterRule(_localctx, 44, RULE_structInitialization);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(ID);
			setState(290);
			match(T__2);
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(291);
				assignment();
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(297);
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
		enterRule(_localctx, 46, RULE_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(T__20);
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(300);
				match(T__21);
				setState(301);
				expr(0);
				}
			}

			setState(304);
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
		enterRule(_localctx, 48, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(T__22);
			setState(307);
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
		enterRule(_localctx, 50, RULE_formalParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(ID);
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(310);
				match(T__11);
				setState(311);
				match(ID);
				}
				}
				setState(316);
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
		enterRule(_localctx, 52, RULE_actualParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			expr(0);
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(318);
				match(T__11);
				setState(319);
				expr(0);
				}
				}
				setState(324);
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
	public static class StructInitializatorContext extends ExprContext {
		public StructInitializationContext structInitialization() {
			return getRuleContext(StructInitializationContext.class,0);
		}
		public StructInitializatorContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitStructInitializator(this);
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
			if ( visitor instanceof RobocommandeVisitor ) return ((RobocommandeVisitor<? extends T>)visitor).visitNegateNum(this);
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
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(326);
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
				setState(327);
				match(ID);
				}
				break;
			case 3:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(328);
				match(NUM);
				}
				break;
			case 4:
				{
				_localctx = new LiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(329);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new FieldIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(330);
				fieldId();
				}
				break;
			case 6:
				{
				_localctx = new FCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(331);
				functionCall();
				}
				break;
			case 7:
				{
				_localctx = new StructInitializatorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(332);
				structInitialization();
				}
				break;
			case 8:
				{
				_localctx = new GroupedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333);
				match(T__2);
				setState(334);
				expr(0);
				setState(335);
				match(T__3);
				}
				break;
			case 9:
				{
				_localctx = new NegateBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(337);
				match(T__25);
				setState(338);
				expr(9);
				}
				break;
			case 10:
				{
				_localctx = new NegateNumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(339);
				match(T__26);
				setState(340);
				expr(8);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(366);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(364);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new PowerContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(343);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(344);
						match(T__27);
						setState(345);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new MultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(346);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(347);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(348);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new PlusOrMinusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(349);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(350);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__31) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(351);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(352);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(353);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(354);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(355);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(356);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(357);
						expr(4);
						}
						break;
					case 6:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(358);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(359);
						match(T__38);
						setState(360);
						expr(3);
						}
						break;
					case 7:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(361);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(362);
						match(T__39);
						setState(363);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(368);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
			setState(369);
			match(ID);
			setState(372); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(370);
					match(T__40);
					setState(371);
					match(ID);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(374); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\65\u017b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\7\2>\n\2\f\2\16"+
		"\2A\13\2\3\2\5\2D\n\2\3\2\3\2\3\2\7\2I\n\2\f\2\16\2L\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5^\n\5\f\5\16\5"+
		"a\13\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b"+
		"\3\b\5\bs\n\b\3\b\5\bv\n\b\3\b\3\b\7\bz\n\b\f\b\16\b}\13\b\3\t\3\t\7\t"+
		"\u0081\n\t\f\t\16\t\u0084\13\t\3\t\3\t\7\t\u0088\n\t\f\t\16\t\u008b\13"+
		"\t\3\n\3\n\7\n\u008f\n\n\f\n\16\n\u0092\13\n\3\n\3\n\7\n\u0096\n\n\f\n"+
		"\16\n\u0099\13\n\3\13\6\13\u009c\n\13\r\13\16\13\u009d\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00aa\n\13\3\13\7\13\u00ad\n"+
		"\13\f\13\16\13\u00b0\13\13\3\f\6\f\u00b3\n\f\r\f\16\f\u00b4\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c2\n\f\3\f\7\f\u00c5\n\f\f\f"+
		"\16\f\u00c8\13\f\3\r\3\r\3\r\3\r\5\r\u00ce\n\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00de\n\17\3\17\3\17"+
		"\3\17\5\17\u00e3\n\17\7\17\u00e5\n\17\f\17\16\17\u00e8\13\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\5\20\u00f0\n\20\3\21\3\21\3\21\3\21\5\21\u00f6\n"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0111"+
		"\n\26\f\26\16\26\u0114\13\26\3\26\3\26\5\26\u0118\n\26\3\27\3\27\5\27"+
		"\u011c\n\27\3\27\3\27\5\27\u0120\n\27\3\27\3\27\3\30\3\30\3\30\7\30\u0127"+
		"\n\30\f\30\16\30\u012a\13\30\3\30\3\30\3\31\3\31\3\31\5\31\u0131\n\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\7\33\u013b\n\33\f\33\16\33\u013e"+
		"\13\33\3\34\3\34\3\34\7\34\u0143\n\34\f\34\16\34\u0146\13\34\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u0158\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u016f\n\35\f\35"+
		"\16\35\u0172\13\35\3\36\3\36\3\36\6\36\u0177\n\36\r\36\16\36\u0178\3\36"+
		"\2\38\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":\2\7\3\2\32\33\3\2\37!\4\2\35\35\"\"\3\2#&\3\2\'(\u01a3\2?\3\2\2\2\4"+
		"O\3\2\2\2\6U\3\2\2\2\b_\3\2\2\2\nb\3\2\2\2\ff\3\2\2\2\16j\3\2\2\2\20~"+
		"\3\2\2\2\22\u008c\3\2\2\2\24\u009b\3\2\2\2\26\u00b2\3\2\2\2\30\u00c9\3"+
		"\2\2\2\32\u00d2\3\2\2\2\34\u00d9\3\2\2\2\36\u00eb\3\2\2\2 \u00f1\3\2\2"+
		"\2\"\u00f7\3\2\2\2$\u00fc\3\2\2\2&\u0100\3\2\2\2(\u0104\3\2\2\2*\u0109"+
		"\3\2\2\2,\u011b\3\2\2\2.\u0123\3\2\2\2\60\u012d\3\2\2\2\62\u0134\3\2\2"+
		"\2\64\u0137\3\2\2\2\66\u013f\3\2\2\28\u0157\3\2\2\2:\u0173\3\2\2\2<>\7"+
		"\63\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@C\3\2\2\2A?\3\2\2\2BD"+
		"\5\4\3\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EJ\5\f\7\2FI\5\n\6\2GI\5\30\r\2"+
		"HF\3\2\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2"+
		"MN\7\2\2\3N\3\3\2\2\2OP\7\3\2\2PQ\7\4\2\2QR\7\5\2\2RS\7\6\2\2ST\5\20\t"+
		"\2T\5\3\2\2\2UV\7\3\2\2VW\7\7\2\2WX\7\5\2\2XY\7\6\2\2YZ\5\22\n\2Z\7\3"+
		"\2\2\2[^\5\30\r\2\\^\5\32\16\2][\3\2\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2"+
		"\2_`\3\2\2\2`\t\3\2\2\2a_\3\2\2\2bc\7\b\2\2cd\7,\2\2de\5\16\b\2e\13\3"+
		"\2\2\2fg\7\b\2\2gh\7\t\2\2hi\5\16\b\2i\r\3\2\2\2jn\7\n\2\2km\7\63\2\2"+
		"lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2or\3\2\2\2pn\3\2\2\2qs\5\6\4\2"+
		"rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tv\5\b\5\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2"+
		"w{\7\13\2\2xz\7\63\2\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\17\3\2"+
		"\2\2}{\3\2\2\2~\u0082\7\n\2\2\177\u0081\5\24\13\2\u0080\177\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2"+
		"\2\2\u0084\u0082\3\2\2\2\u0085\u0089\7\13\2\2\u0086\u0088\7\63\2\2\u0087"+
		"\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\21\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u0090\7\n\2\2\u008d\u008f"+
		"\5\26\f\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0097"+
		"\7\13\2\2\u0094\u0096\7\63\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2"+
		"\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\23\3\2\2\2\u0099\u0097"+
		"\3\2\2\2\u009a\u009c\7\63\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2"+
		"\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a9\3\2\2\2\u009f\u00aa"+
		"\5\36\20\2\u00a0\u00aa\5\34\17\2\u00a1\u00aa\5&\24\2\u00a2\u00aa\5$\23"+
		"\2\u00a3\u00aa\5*\26\2\u00a4\u00aa\5,\27\2\u00a5\u00aa\5\60\31\2\u00a6"+
		"\u00aa\5\34\17\2\u00a7\u00aa\5\"\22\2\u00a8\u00aa\5(\25\2\u00a9\u009f"+
		"\3\2\2\2\u00a9\u00a0\3\2\2\2\u00a9\u00a1\3\2\2\2\u00a9\u00a2\3\2\2\2\u00a9"+
		"\u00a3\3\2\2\2\u00a9\u00a4\3\2\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ae\3\2\2\2\u00ab\u00ad\7\63\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3"+
		"\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\25\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b3\7\63\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3"+
		"\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00c1\3\2\2\2\u00b6"+
		"\u00c2\5\36\20\2\u00b7\u00c2\5\34\17\2\u00b8\u00c2\5&\24\2\u00b9\u00c2"+
		"\5$\23\2\u00ba\u00c2\5*\26\2\u00bb\u00c2\5,\27\2\u00bc\u00c2\5\60\31\2"+
		"\u00bd\u00c2\5\34\17\2\u00be\u00c2\5 \21\2\u00bf\u00c2\5(\25\2\u00c0\u00c2"+
		"\5\62\32\2\u00c1\u00b6\3\2\2\2\u00c1\u00b7\3\2\2\2\u00c1\u00b8\3\2\2\2"+
		"\u00c1\u00b9\3\2\2\2\u00c1\u00ba\3\2\2\2\u00c1\u00bb\3\2\2\2\u00c1\u00bc"+
		"\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c1\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c6\3\2\2\2\u00c3\u00c5\7\63"+
		"\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c7\3\2\2\2\u00c7\27\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca\7\f\2"+
		"\2\u00ca\u00cb\7,\2\2\u00cb\u00cd\7\5\2\2\u00cc\u00ce\5\64\33\2\u00cd"+
		"\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\7\6"+
		"\2\2\u00d0\u00d1\5\22\n\2\u00d1\31\3\2\2\2\u00d2\u00d3\7\3\2\2\u00d3\u00d4"+
		"\7,\2\2\u00d4\u00d5\7\5\2\2\u00d5\u00d6\7,\2\2\u00d6\u00d7\7\6\2\2\u00d7"+
		"\u00d8\5\22\n\2\u00d8\33\3\2\2\2\u00d9\u00da\7,\2\2\u00da\u00dd\7\r\2"+
		"\2\u00db\u00de\7,\2\2\u00dc\u00de\5&\24\2\u00dd\u00db\3\2\2\2\u00dd\u00dc"+
		"\3\2\2\2\u00de\u00e6\3\2\2\2\u00df\u00e2\7\16\2\2\u00e0\u00e3\7,\2\2\u00e1"+
		"\u00e3\5&\24\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e5\3\2"+
		"\2\2\u00e4\u00df\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea\7\17"+
		"\2\2\u00ea\35\3\2\2\2\u00eb\u00ec\7\20\2\2\u00ec\u00ef\7,\2\2\u00ed\u00ee"+
		"\7\21\2\2\u00ee\u00f0\58\35\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2"+
		"\u00f0\37\3\2\2\2\u00f1\u00f2\7\22\2\2\u00f2\u00f5\7,\2\2\u00f3\u00f4"+
		"\7\21\2\2\u00f4\u00f6\58\35\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2"+
		"\u00f6!\3\2\2\2\u00f7\u00f8\7\22\2\2\u00f8\u00f9\7\3\2\2\u00f9\u00fa\7"+
		",\2\2\u00fa\u00fb\5\22\n\2\u00fb#\3\2\2\2\u00fc\u00fd\5:\36\2\u00fd\u00fe"+
		"\7\21\2\2\u00fe\u00ff\58\35\2\u00ff%\3\2\2\2\u0100\u0101\7,\2\2\u0101"+
		"\u0102\7\21\2\2\u0102\u0103\58\35\2\u0103\'\3\2\2\2\u0104\u0105\7\23\2"+
		"\2\u0105\u0106\7\5\2\2\u0106\u0107\7,\2\2\u0107\u0108\7\6\2\2\u0108)\3"+
		"\2\2\2\u0109\u010a\7\24\2\2\u010a\u010b\58\35\2\u010b\u0112\5\22\n\2\u010c"+
		"\u010d\7\25\2\2\u010d\u010e\58\35\2\u010e\u010f\5\22\n\2\u010f\u0111\3"+
		"\2\2\2\u0110\u010c\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112"+
		"\u0113\3\2\2\2\u0113\u0117\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\7\26"+
		"\2\2\u0116\u0118\5\22\n\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"+\3\2\2\2\u0119\u011c\5:\36\2\u011a\u011c\7,\2\2\u011b\u0119\3\2\2\2\u011b"+
		"\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f\7\5\2\2\u011e\u0120\5\66"+
		"\34\2\u011f\u011e\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0122\7\6\2\2\u0122-\3\2\2\2\u0123\u0124\7,\2\2\u0124\u0128\7\5\2\2\u0125"+
		"\u0127\5&\24\2\u0126\u0125\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2"+
		"\2\2\u0128\u0129\3\2\2\2\u0129\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b"+
		"\u012c\7\6\2\2\u012c/\3\2\2\2\u012d\u0130\7\27\2\2\u012e\u012f\7\30\2"+
		"\2\u012f\u0131\58\35\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132"+
		"\3\2\2\2\u0132\u0133\5\22\n\2\u0133\61\3\2\2\2\u0134\u0135\7\31\2\2\u0135"+
		"\u0136\58\35\2\u0136\63\3\2\2\2\u0137\u013c\7,\2\2\u0138\u0139\7\16\2"+
		"\2\u0139\u013b\7,\2\2\u013a\u0138\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013d\65\3\2\2\2\u013e\u013c\3\2\2\2\u013f"+
		"\u0144\58\35\2\u0140\u0141\7\16\2\2\u0141\u0143\58\35\2\u0142\u0140\3"+
		"\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\67\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\b\35\1\2\u0148\u0158\t\2\2"+
		"\2\u0149\u0158\7,\2\2\u014a\u0158\7-\2\2\u014b\u0158\7\60\2\2\u014c\u0158"+
		"\5:\36\2\u014d\u0158\5,\27\2\u014e\u0158\5.\30\2\u014f\u0150\7\5\2\2\u0150"+
		"\u0151\58\35\2\u0151\u0152\7\6\2\2\u0152\u0158\3\2\2\2\u0153\u0154\7\34"+
		"\2\2\u0154\u0158\58\35\13\u0155\u0156\7\35\2\2\u0156\u0158\58\35\n\u0157"+
		"\u0147\3\2\2\2\u0157\u0149\3\2\2\2\u0157\u014a\3\2\2\2\u0157\u014b\3\2"+
		"\2\2\u0157\u014c\3\2\2\2\u0157\u014d\3\2\2\2\u0157\u014e\3\2\2\2\u0157"+
		"\u014f\3\2\2\2\u0157\u0153\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0170\3\2"+
		"\2\2\u0159\u015a\f\t\2\2\u015a\u015b\7\36\2\2\u015b\u016f\58\35\t\u015c"+
		"\u015d\f\b\2\2\u015d\u015e\t\3\2\2\u015e\u016f\58\35\t\u015f\u0160\f\7"+
		"\2\2\u0160\u0161\t\4\2\2\u0161\u016f\58\35\b\u0162\u0163\f\6\2\2\u0163"+
		"\u0164\t\5\2\2\u0164\u016f\58\35\7\u0165\u0166\f\5\2\2\u0166\u0167\t\6"+
		"\2\2\u0167\u016f\58\35\6\u0168\u0169\f\4\2\2\u0169\u016a\7)\2\2\u016a"+
		"\u016f\58\35\5\u016b\u016c\f\3\2\2\u016c\u016d\7*\2\2\u016d\u016f\58\35"+
		"\4\u016e\u0159\3\2\2\2\u016e\u015c\3\2\2\2\u016e\u015f\3\2\2\2\u016e\u0162"+
		"\3\2\2\2\u016e\u0165\3\2\2\2\u016e\u0168\3\2\2\2\u016e\u016b\3\2\2\2\u016f"+
		"\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u01719\3\2\2\2"+
		"\u0172\u0170\3\2\2\2\u0173\u0176\7,\2\2\u0174\u0175\7+\2\2\u0175\u0177"+
		"\7,\2\2\u0176\u0174\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179;\3\2\2\2(?CHJ]_nru{\u0082\u0089\u0090\u0097\u009d"+
		"\u00a9\u00ae\u00b4\u00c1\u00c6\u00cd\u00dd\u00e2\u00e6\u00ef\u00f5\u0112"+
		"\u0117\u011b\u011f\u0128\u0130\u013c\u0144\u0157\u016e\u0170\u0178";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}