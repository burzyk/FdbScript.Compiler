// Generated from /Users/pawel/work/java/FdbScriptCompiler/src/main/antlr/FdbScript.g4 by ANTLR 4.5
package com.jpbnetsoftware.fdbscriptcompiler.antlr;
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
		EQ=10, GT=11, LT=12, GE=13, LE=14, NEQ=15, AND=16, OR=17, PLUS=18, MINUS=19, 
		DIV=20, MUL=21, TRUE=22, FALSE=23, STRING=24, NUMBER=25, ID=26, MODULEID=27, 
		WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"EQ", "GT", "LT", "GE", "LE", "NEQ", "AND", "OR", "PLUS", "MINUS", "DIV", 
		"MUL", "TRUE", "FALSE", "STRING", "NUMBER", "ID", "MODULEID", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'module'", "'='", "'f'", "'('", "','", "')'", "':'", "'->'", "'_'", 
		"'=='", "'>'", "'<'", "'>='", "'<='", "'!='", "'&&'", "'||'", "'+'", "'-'", 
		"'/'", "'*'", "'true'", "'false'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "EQ", "GT", 
		"LT", "GE", "LE", "NEQ", "AND", "OR", "PLUS", "MINUS", "DIV", "MUL", "TRUE", 
		"FALSE", "STRING", "NUMBER", "ID", "MODULEID", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00a6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\7\31\177\n\31\f\31\16\31\u0082\13\31\3\31\3\31\3\32\5\32\u0087\n\32"+
		"\3\32\6\32\u008a\n\32\r\32\16\32\u008b\3\32\3\32\5\32\u0090\n\32\3\33"+
		"\3\33\7\33\u0094\n\33\f\33\16\33\u0097\13\33\3\34\3\34\7\34\u009b\n\34"+
		"\f\34\16\34\u009e\13\34\3\35\6\35\u00a1\n\35\r\35\16\35\u00a2\3\35\3\35"+
		"\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36\3\2\t\5\2\f\f\17\17$$\4\2--//\3\2\62;\3\2c|\4\2C\\c|\3\2C\\\5\2\13"+
		"\f\17\17\"\"\u00ac\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\3;\3\2\2\2\5B\3\2\2\2\7D\3\2\2\2\tF\3\2\2\2\13H\3\2\2\2\r"+
		"J\3\2\2\2\17L\3\2\2\2\21N\3\2\2\2\23Q\3\2\2\2\25S\3\2\2\2\27V\3\2\2\2"+
		"\31X\3\2\2\2\33Z\3\2\2\2\35]\3\2\2\2\37`\3\2\2\2!c\3\2\2\2#f\3\2\2\2%"+
		"i\3\2\2\2\'k\3\2\2\2)m\3\2\2\2+o\3\2\2\2-q\3\2\2\2/v\3\2\2\2\61|\3\2\2"+
		"\2\63\u0086\3\2\2\2\65\u0091\3\2\2\2\67\u0098\3\2\2\29\u00a0\3\2\2\2;"+
		"<\7o\2\2<=\7q\2\2=>\7f\2\2>?\7w\2\2?@\7n\2\2@A\7g\2\2A\4\3\2\2\2BC\7?"+
		"\2\2C\6\3\2\2\2DE\7h\2\2E\b\3\2\2\2FG\7*\2\2G\n\3\2\2\2HI\7.\2\2I\f\3"+
		"\2\2\2JK\7+\2\2K\16\3\2\2\2LM\7<\2\2M\20\3\2\2\2NO\7/\2\2OP\7@\2\2P\22"+
		"\3\2\2\2QR\7a\2\2R\24\3\2\2\2ST\7?\2\2TU\7?\2\2U\26\3\2\2\2VW\7@\2\2W"+
		"\30\3\2\2\2XY\7>\2\2Y\32\3\2\2\2Z[\7@\2\2[\\\7?\2\2\\\34\3\2\2\2]^\7>"+
		"\2\2^_\7?\2\2_\36\3\2\2\2`a\7#\2\2ab\7?\2\2b \3\2\2\2cd\7(\2\2de\7(\2"+
		"\2e\"\3\2\2\2fg\7~\2\2gh\7~\2\2h$\3\2\2\2ij\7-\2\2j&\3\2\2\2kl\7/\2\2"+
		"l(\3\2\2\2mn\7\61\2\2n*\3\2\2\2op\7,\2\2p,\3\2\2\2qr\7v\2\2rs\7t\2\2s"+
		"t\7w\2\2tu\7g\2\2u.\3\2\2\2vw\7h\2\2wx\7c\2\2xy\7n\2\2yz\7u\2\2z{\7g\2"+
		"\2{\60\3\2\2\2|\u0080\7$\2\2}\177\n\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2"+
		"\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3"+
		"\2\2\2\u0083\u0084\7$\2\2\u0084\62\3\2\2\2\u0085\u0087\t\3\2\2\u0086\u0085"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u008a\t\4\2\2\u0089"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u008f\3\2\2\2\u008d\u008e\7\60\2\2\u008e\u0090\t\4\2\2\u008f"+
		"\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\64\3\2\2\2\u0091\u0095\t\5\2"+
		"\2\u0092\u0094\t\6\2\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\66\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009c\t\7\2\2\u0099\u009b\t\6\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d8\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009f\u00a1\t\b\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\35"+
		"\2\2\u00a5:\3\2\2\2\n\2\u0080\u0086\u008b\u008f\u0095\u009c\u00a2\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}