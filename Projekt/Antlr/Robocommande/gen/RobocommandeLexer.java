// Generated from /Users/Kasper/P4-AAU-Kursusopgaver/Projekt/Antlr/Robocommande/Robocommande.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RobocommandeLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"ID", "NUM", "INT", "FLOAT", "STRING", "COMMENT", "WS", "NEWLINE", "DIGIT", 
		"LETTER", "ESC"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'behavior'", "'onSetup'", "'('", "')'", "'onRun'", "'strategy'", 
		"'default'", "':'", "';'", "'define'", "'{'", "','", "'}'", "'var'", "':='", 
		"'new'", "'event'", "'if'", "'else if'", "'else'", "'loop'", "'while'", 
		"'return'", "'true'", "'false'", "'not'", "'-'", "'^'", "'*'", "'/'", 
		"'%'", "'+'", "'<='", "'>='", "'<'", "'>'", "'!='", "'='", "'and'", "'or'", 
		"'.'"
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


	public RobocommandeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Robocommande.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\65\u0158\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3"+
		"\'\3(\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\7+\u0112\n+\f+\16+\u0115\13+\3"+
		",\3,\5,\u0119\n,\3-\6-\u011c\n-\r-\16-\u011d\3.\6.\u0121\n.\r.\16.\u0122"+
		"\3.\3.\6.\u0127\n.\r.\16.\u0128\3/\3/\3/\7/\u012e\n/\f/\16/\u0131\13/"+
		"\3/\3/\3\60\3\60\3\60\3\60\7\60\u0139\n\60\f\60\16\60\u013c\13\60\3\60"+
		"\7\60\u013f\n\60\f\60\16\60\u0142\13\60\3\60\3\60\3\61\6\61\u0147\n\61"+
		"\r\61\16\61\u0148\3\61\3\61\3\62\5\62\u014e\n\62\3\62\3\62\3\63\3\63\3"+
		"\64\3\64\3\65\3\65\3\65\4\u012f\u013a\2\66\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\2g\64i\65\3\2\7\4\2\f\f\17\17\4\2\13\13\"\""+
		"\3\2\62;\4\2C\\c|\b\2$$^^ddppttvv\u0162\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\3k\3\2\2\2\5t\3\2\2\2\7|\3\2\2\2\t~\3\2\2\2\13\u0080\3\2\2\2"+
		"\r\u0086\3\2\2\2\17\u008f\3\2\2\2\21\u0097\3\2\2\2\23\u0099\3\2\2\2\25"+
		"\u009b\3\2\2\2\27\u00a2\3\2\2\2\31\u00a4\3\2\2\2\33\u00a6\3\2\2\2\35\u00a8"+
		"\3\2\2\2\37\u00ac\3\2\2\2!\u00af\3\2\2\2#\u00b3\3\2\2\2%\u00b9\3\2\2\2"+
		"\'\u00bc\3\2\2\2)\u00c4\3\2\2\2+\u00c9\3\2\2\2-\u00ce\3\2\2\2/\u00d4\3"+
		"\2\2\2\61\u00db\3\2\2\2\63\u00e0\3\2\2\2\65\u00e6\3\2\2\2\67\u00ea\3\2"+
		"\2\29\u00ec\3\2\2\2;\u00ee\3\2\2\2=\u00f0\3\2\2\2?\u00f2\3\2\2\2A\u00f4"+
		"\3\2\2\2C\u00f6\3\2\2\2E\u00f9\3\2\2\2G\u00fc\3\2\2\2I\u00fe\3\2\2\2K"+
		"\u0100\3\2\2\2M\u0103\3\2\2\2O\u0105\3\2\2\2Q\u0109\3\2\2\2S\u010c\3\2"+
		"\2\2U\u010e\3\2\2\2W\u0118\3\2\2\2Y\u011b\3\2\2\2[\u0120\3\2\2\2]\u012a"+
		"\3\2\2\2_\u0134\3\2\2\2a\u0146\3\2\2\2c\u014d\3\2\2\2e\u0151\3\2\2\2g"+
		"\u0153\3\2\2\2i\u0155\3\2\2\2kl\7d\2\2lm\7g\2\2mn\7j\2\2no\7c\2\2op\7"+
		"x\2\2pq\7k\2\2qr\7q\2\2rs\7t\2\2s\4\3\2\2\2tu\7q\2\2uv\7p\2\2vw\7U\2\2"+
		"wx\7g\2\2xy\7v\2\2yz\7w\2\2z{\7r\2\2{\6\3\2\2\2|}\7*\2\2}\b\3\2\2\2~\177"+
		"\7+\2\2\177\n\3\2\2\2\u0080\u0081\7q\2\2\u0081\u0082\7p\2\2\u0082\u0083"+
		"\7T\2\2\u0083\u0084\7w\2\2\u0084\u0085\7p\2\2\u0085\f\3\2\2\2\u0086\u0087"+
		"\7u\2\2\u0087\u0088\7v\2\2\u0088\u0089\7t\2\2\u0089\u008a\7c\2\2\u008a"+
		"\u008b\7v\2\2\u008b\u008c\7g\2\2\u008c\u008d\7i\2\2\u008d\u008e\7{\2\2"+
		"\u008e\16\3\2\2\2\u008f\u0090\7f\2\2\u0090\u0091\7g\2\2\u0091\u0092\7"+
		"h\2\2\u0092\u0093\7c\2\2\u0093\u0094\7w\2\2\u0094\u0095\7n\2\2\u0095\u0096"+
		"\7v\2\2\u0096\20\3\2\2\2\u0097\u0098\7<\2\2\u0098\22\3\2\2\2\u0099\u009a"+
		"\7=\2\2\u009a\24\3\2\2\2\u009b\u009c\7f\2\2\u009c\u009d\7g\2\2\u009d\u009e"+
		"\7h\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7g\2\2\u00a1"+
		"\26\3\2\2\2\u00a2\u00a3\7}\2\2\u00a3\30\3\2\2\2\u00a4\u00a5\7.\2\2\u00a5"+
		"\32\3\2\2\2\u00a6\u00a7\7\177\2\2\u00a7\34\3\2\2\2\u00a8\u00a9\7x\2\2"+
		"\u00a9\u00aa\7c\2\2\u00aa\u00ab\7t\2\2\u00ab\36\3\2\2\2\u00ac\u00ad\7"+
		"<\2\2\u00ad\u00ae\7?\2\2\u00ae \3\2\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1"+
		"\7g\2\2\u00b1\u00b2\7y\2\2\u00b2\"\3\2\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5"+
		"\7x\2\2\u00b5\u00b6\7g\2\2\u00b6\u00b7\7p\2\2\u00b7\u00b8\7v\2\2\u00b8"+
		"$\3\2\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7h\2\2\u00bb&\3\2\2\2\u00bc\u00bd"+
		"\7g\2\2\u00bd\u00be\7n\2\2\u00be\u00bf\7u\2\2\u00bf\u00c0\7g\2\2\u00c0"+
		"\u00c1\7\"\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7h\2\2\u00c3(\3\2\2\2\u00c4"+
		"\u00c5\7g\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7g\2\2"+
		"\u00c8*\3\2\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7q\2"+
		"\2\u00cc\u00cd\7r\2\2\u00cd,\3\2\2\2\u00ce\u00cf\7y\2\2\u00cf\u00d0\7"+
		"j\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7n\2\2\u00d2\u00d3\7g\2\2\u00d3."+
		"\3\2\2\2\u00d4\u00d5\7t\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7v\2\2\u00d7"+
		"\u00d8\7w\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7p\2\2\u00da\60\3\2\2\2\u00db"+
		"\u00dc\7v\2\2\u00dc\u00dd\7t\2\2\u00dd\u00de\7w\2\2\u00de\u00df\7g\2\2"+
		"\u00df\62\3\2\2\2\u00e0\u00e1\7h\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7"+
		"n\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7g\2\2\u00e5\64\3\2\2\2\u00e6\u00e7"+
		"\7p\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7v\2\2\u00e9\66\3\2\2\2\u00ea\u00eb"+
		"\7/\2\2\u00eb8\3\2\2\2\u00ec\u00ed\7`\2\2\u00ed:\3\2\2\2\u00ee\u00ef\7"+
		",\2\2\u00ef<\3\2\2\2\u00f0\u00f1\7\61\2\2\u00f1>\3\2\2\2\u00f2\u00f3\7"+
		"\'\2\2\u00f3@\3\2\2\2\u00f4\u00f5\7-\2\2\u00f5B\3\2\2\2\u00f6\u00f7\7"+
		">\2\2\u00f7\u00f8\7?\2\2\u00f8D\3\2\2\2\u00f9\u00fa\7@\2\2\u00fa\u00fb"+
		"\7?\2\2\u00fbF\3\2\2\2\u00fc\u00fd\7>\2\2\u00fdH\3\2\2\2\u00fe\u00ff\7"+
		"@\2\2\u00ffJ\3\2\2\2\u0100\u0101\7#\2\2\u0101\u0102\7?\2\2\u0102L\3\2"+
		"\2\2\u0103\u0104\7?\2\2\u0104N\3\2\2\2\u0105\u0106\7c\2\2\u0106\u0107"+
		"\7p\2\2\u0107\u0108\7f\2\2\u0108P\3\2\2\2\u0109\u010a\7q\2\2\u010a\u010b"+
		"\7t\2\2\u010bR\3\2\2\2\u010c\u010d\7\60\2\2\u010dT\3\2\2\2\u010e\u0113"+
		"\5g\64\2\u010f\u0112\5g\64\2\u0110\u0112\5e\63\2\u0111\u010f\3\2\2\2\u0111"+
		"\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2"+
		"\2\2\u0114V\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0119\5Y-\2\u0117\u0119"+
		"\5[.\2\u0118\u0116\3\2\2\2\u0118\u0117\3\2\2\2\u0119X\3\2\2\2\u011a\u011c"+
		"\5e\63\2\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011eZ\3\2\2\2\u011f\u0121\5e\63\2\u0120\u011f\3\2\2\2"+
		"\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124"+
		"\3\2\2\2\u0124\u0126\7\60\2\2\u0125\u0127\5e\63\2\u0126\u0125\3\2\2\2"+
		"\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\\\3"+
		"\2\2\2\u012a\u012f\7$\2\2\u012b\u012e\5i\65\2\u012c\u012e\13\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u012f\u012d\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u012f\3\2\2\2\u0132"+
		"\u0133\7$\2\2\u0133^\3\2\2\2\u0134\u0135\7\61\2\2\u0135\u0136\7\61\2\2"+
		"\u0136\u013a\3\2\2\2\u0137\u0139\13\2\2\2\u0138\u0137\3\2\2\2\u0139\u013c"+
		"\3\2\2\2\u013a\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u0140\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013d\u013f\n\2\2\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2"+
		"\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142"+
		"\u0140\3\2\2\2\u0143\u0144\b\60\2\2\u0144`\3\2\2\2\u0145\u0147\t\3\2\2"+
		"\u0146\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\b\61\2\2\u014bb\3\2\2\2\u014c"+
		"\u014e\7\17\2\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3"+
		"\2\2\2\u014f\u0150\7\f\2\2\u0150d\3\2\2\2\u0151\u0152\t\4\2\2\u0152f\3"+
		"\2\2\2\u0153\u0154\t\5\2\2\u0154h\3\2\2\2\u0155\u0156\7^\2\2\u0156\u0157"+
		"\t\6\2\2\u0157j\3\2\2\2\17\2\u0111\u0113\u0118\u011d\u0122\u0128\u012d"+
		"\u012f\u013a\u0140\u0148\u014d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}