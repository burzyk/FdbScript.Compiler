// Generated from /Users/pawel/work/java/FdbScriptCompiler/src/main/antlr/FdbScript.g4 by ANTLR 4.5
package com.jpbnetsoftware.fdbscript.compiler.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FdbScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, EQ=11, GT=12, LT=13, GE=14, LE=15, NEQ=16, AND=17, OR=18, NOT=19, 
		PLUS=20, MINUS=21, DIV=22, MUL=23, LISTCONCAT=24, TRUE=25, FALSE=26, INDEXSEPARATOR=27, 
		STRING=28, NUMBER=29, ID=30, MODULEID=31, WS=32;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "EQ", "GT", "LT", "GE", "LE", "NEQ", "AND", "OR", "NOT", "PLUS", 
		"MINUS", "DIV", "MUL", "LISTCONCAT", "TRUE", "FALSE", "INDEXSEPARATOR", 
		"STRING", "NUMBER", "ID", "MODULEID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'module'", "'='", "'f'", "'('", "','", "')'", "'->'", "'_'", "'['", 
		"']'", "'=='", "'>'", "'<'", "'>='", "'<='", "'!='", "'and'", "'or'", 
		"'!'", "'+'", "'-'", "'/'", "'*'", "'@'", "'true'", "'false'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "EQ", 
		"GT", "LT", "GE", "LE", "NEQ", "AND", "OR", "NOT", "PLUS", "MINUS", "DIV", 
		"MUL", "LISTCONCAT", "TRUE", "FALSE", "INDEXSEPARATOR", "STRING", "NUMBER", 
		"ID", "MODULEID", "WS"
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public FdbScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FdbScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\"\u00ba\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\7\35\u0090\n\35\f\35\16\35\u0093\13\35\3\35\3\35\3\36\5\36\u0098"+
		"\n\36\3\36\6\36\u009b\n\36\r\36\16\36\u009c\3\36\3\36\5\36\u00a1\n\36"+
		"\3\37\5\37\u00a4\n\37\3\37\3\37\7\37\u00a8\n\37\f\37\16\37\u00ab\13\37"+
		"\3 \3 \7 \u00af\n \f \16 \u00b2\13 \3!\6!\u00b5\n!\r!\16!\u00b6\3!\3!"+
		"\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\37= ?!A\"\3\2\13\5\2\f\f\17\17$$\4\2--//\3\2\62;\4\2&&))\3\2c|\5"+
		"\2\62;C\\c|\3\2C\\\4\2C\\c|\5\2\13\f\17\17\"\"\u00c1\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\3C\3\2\2\2\5J\3\2\2\2\7L\3\2\2\2\tN\3\2\2\2\13P\3"+
		"\2\2\2\rR\3\2\2\2\17T\3\2\2\2\21W\3\2\2\2\23Y\3\2\2\2\25[\3\2\2\2\27]"+
		"\3\2\2\2\31`\3\2\2\2\33b\3\2\2\2\35d\3\2\2\2\37g\3\2\2\2!j\3\2\2\2#m\3"+
		"\2\2\2%q\3\2\2\2\'t\3\2\2\2)v\3\2\2\2+x\3\2\2\2-z\3\2\2\2/|\3\2\2\2\61"+
		"~\3\2\2\2\63\u0080\3\2\2\2\65\u0085\3\2\2\2\67\u008b\3\2\2\29\u008d\3"+
		"\2\2\2;\u0097\3\2\2\2=\u00a3\3\2\2\2?\u00ac\3\2\2\2A\u00b4\3\2\2\2CD\7"+
		"o\2\2DE\7q\2\2EF\7f\2\2FG\7w\2\2GH\7n\2\2HI\7g\2\2I\4\3\2\2\2JK\7?\2\2"+
		"K\6\3\2\2\2LM\7h\2\2M\b\3\2\2\2NO\7*\2\2O\n\3\2\2\2PQ\7.\2\2Q\f\3\2\2"+
		"\2RS\7+\2\2S\16\3\2\2\2TU\7/\2\2UV\7@\2\2V\20\3\2\2\2WX\7a\2\2X\22\3\2"+
		"\2\2YZ\7]\2\2Z\24\3\2\2\2[\\\7_\2\2\\\26\3\2\2\2]^\7?\2\2^_\7?\2\2_\30"+
		"\3\2\2\2`a\7@\2\2a\32\3\2\2\2bc\7>\2\2c\34\3\2\2\2de\7@\2\2ef\7?\2\2f"+
		"\36\3\2\2\2gh\7>\2\2hi\7?\2\2i \3\2\2\2jk\7#\2\2kl\7?\2\2l\"\3\2\2\2m"+
		"n\7c\2\2no\7p\2\2op\7f\2\2p$\3\2\2\2qr\7q\2\2rs\7t\2\2s&\3\2\2\2tu\7#"+
		"\2\2u(\3\2\2\2vw\7-\2\2w*\3\2\2\2xy\7/\2\2y,\3\2\2\2z{\7\61\2\2{.\3\2"+
		"\2\2|}\7,\2\2}\60\3\2\2\2~\177\7B\2\2\177\62\3\2\2\2\u0080\u0081\7v\2"+
		"\2\u0081\u0082\7t\2\2\u0082\u0083\7w\2\2\u0083\u0084\7g\2\2\u0084\64\3"+
		"\2\2\2\u0085\u0086\7h\2\2\u0086\u0087\7c\2\2\u0087\u0088\7n\2\2\u0088"+
		"\u0089\7u\2\2\u0089\u008a\7g\2\2\u008a\66\3\2\2\2\u008b\u008c\7<\2\2\u008c"+
		"8\3\2\2\2\u008d\u0091\7$\2\2\u008e\u0090\n\2\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7$\2\2\u0095:\3\2\2\2\u0096\u0098"+
		"\t\3\2\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u009b\t\4\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009f\7\60\2\2\u009f"+
		"\u00a1\t\4\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1<\3\2\2\2"+
		"\u00a2\u00a4\t\5\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5"+
		"\3\2\2\2\u00a5\u00a9\t\6\2\2\u00a6\u00a8\t\7\2\2\u00a7\u00a6\3\2\2\2\u00a8"+
		"\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa>\3\2\2\2"+
		"\u00ab\u00a9\3\2\2\2\u00ac\u00b0\t\b\2\2\u00ad\u00af\t\t\2\2\u00ae\u00ad"+
		"\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"@\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\t\n\2\2\u00b4\u00b3\3\2\2\2"+
		"\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00b9\b!\2\2\u00b9B\3\2\2\2\13\2\u0091\u0097\u009c\u00a0"+
		"\u00a3\u00a9\u00b0\u00b6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}