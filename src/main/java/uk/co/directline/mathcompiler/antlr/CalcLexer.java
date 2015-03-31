// Generated from /Users/pawel/work/java/MathCompiler/src/main/antlr/Calc.g4 by ANTLR 4.5
package uk.co.directline.mathcompiler.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, WS=2, NUMBER=3, ID=4, PLUS=5, MINUS=6, DIV=7, MUL=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "WS", "NUMBER", "ID", "PLUS", "MINUS", "DIV", "MUL"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'CALC'", null, null, null, "'+'", "'-'", "'/'", "'*'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "WS", "NUMBER", "ID", "PLUS", "MINUS", "DIV", "MUL"
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


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\n\61\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\6\3\32\n\3\r\3\16\3\33\3\3\3\3\3\4\6\4!\n\4\r\4\16\4\"\3\5"+
		"\6\5&\n\5\r\5\16\5\'\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\2\2\n\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\3\2\5\5\2\13\f\17\17\"\"\3\2\62;\3\2c|\63\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\31\3\2\2\2\7 \3\2\2\2\t%\3\2"+
		"\2\2\13)\3\2\2\2\r+\3\2\2\2\17-\3\2\2\2\21/\3\2\2\2\23\24\7E\2\2\24\25"+
		"\7C\2\2\25\26\7N\2\2\26\27\7E\2\2\27\4\3\2\2\2\30\32\t\2\2\2\31\30\3\2"+
		"\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36\b\3"+
		"\2\2\36\6\3\2\2\2\37!\t\3\2\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2"+
		"\2\2#\b\3\2\2\2$&\t\4\2\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2("+
		"\n\3\2\2\2)*\7-\2\2*\f\3\2\2\2+,\7/\2\2,\16\3\2\2\2-.\7\61\2\2.\20\3\2"+
		"\2\2/\60\7,\2\2\60\22\3\2\2\2\6\2\33\"\'\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}