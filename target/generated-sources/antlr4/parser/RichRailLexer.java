// Generated from parser\RichRail.g4 by ANTLR 4.7.1
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RichRailLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ID=12, NUMSEATS=13, MAXWEIGHT=14, WHITESPACE=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "ID", "NUMSEATS", "MAXWEIGHT", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'new'", "'numseats'", "'maxweight'", "'add'", "'to'", "'get'", 
		"'delete'", "'remove'", "'from'", "'train'", "'wagon'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ID", "NUMSEATS", "MAXWEIGHT", "WHITESPACE"
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


	public RichRailLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RichRail.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u0086\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\re\n\r\f\r\16\rh\13"+
		"\r\3\16\6\16k\n\16\r\16\16\16l\3\17\6\17p\n\17\r\17\16\17q\3\17\3\17\7"+
		"\17v\n\17\f\17\16\17y\13\17\3\17\3\17\6\17}\n\17\r\17\16\17~\5\17\u0081"+
		"\n\17\3\20\3\20\3\20\3\20\2\2\21\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21\3\2\4\4\2\62;c|\5\2\13\f\16\17\""+
		"\"\2\u008b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3!\3\2\2"+
		"\2\5%\3\2\2\2\7.\3\2\2\2\t8\3\2\2\2\13<\3\2\2\2\r?\3\2\2\2\17C\3\2\2\2"+
		"\21J\3\2\2\2\23Q\3\2\2\2\25V\3\2\2\2\27\\\3\2\2\2\31b\3\2\2\2\33j\3\2"+
		"\2\2\35\u0080\3\2\2\2\37\u0082\3\2\2\2!\"\7p\2\2\"#\7g\2\2#$\7y\2\2$\4"+
		"\3\2\2\2%&\7p\2\2&\'\7w\2\2\'(\7o\2\2()\7u\2\2)*\7g\2\2*+\7c\2\2+,\7v"+
		"\2\2,-\7u\2\2-\6\3\2\2\2./\7o\2\2/\60\7c\2\2\60\61\7z\2\2\61\62\7y\2\2"+
		"\62\63\7g\2\2\63\64\7k\2\2\64\65\7i\2\2\65\66\7j\2\2\66\67\7v\2\2\67\b"+
		"\3\2\2\289\7c\2\29:\7f\2\2:;\7f\2\2;\n\3\2\2\2<=\7v\2\2=>\7q\2\2>\f\3"+
		"\2\2\2?@\7i\2\2@A\7g\2\2AB\7v\2\2B\16\3\2\2\2CD\7f\2\2DE\7g\2\2EF\7n\2"+
		"\2FG\7g\2\2GH\7v\2\2HI\7g\2\2I\20\3\2\2\2JK\7t\2\2KL\7g\2\2LM\7o\2\2M"+
		"N\7q\2\2NO\7x\2\2OP\7g\2\2P\22\3\2\2\2QR\7h\2\2RS\7t\2\2ST\7q\2\2TU\7"+
		"o\2\2U\24\3\2\2\2VW\7v\2\2WX\7t\2\2XY\7c\2\2YZ\7k\2\2Z[\7p\2\2[\26\3\2"+
		"\2\2\\]\7y\2\2]^\7c\2\2^_\7i\2\2_`\7q\2\2`a\7p\2\2a\30\3\2\2\2bf\4c|\2"+
		"ce\t\2\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\32\3\2\2\2hf\3\2\2"+
		"\2ik\4\62;\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m\34\3\2\2\2np\4\62"+
		";\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2sw\7\60\2\2tv\4\62"+
		";\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\u0081\3\2\2\2yw\3\2\2\2z"+
		"|\7\60\2\2{}\4\62;\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081"+
		"\3\2\2\2\u0080o\3\2\2\2\u0080z\3\2\2\2\u0081\36\3\2\2\2\u0082\u0083\t"+
		"\3\2\2\u0083\u0084\3\2\2\2\u0084\u0085\b\20\2\2\u0085 \3\2\2\2\t\2flq"+
		"w~\u0080\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}