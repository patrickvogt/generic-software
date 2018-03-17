// Generated from YayatsyiGrammar.g4 by ANTLR 4.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class YayatsyiGrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LINE_COMMENT=1, BOOLEAN_OPTION=2, SHIFT_OPTION=3, BLANK_SYMBOL=4, DEFAULT_TAPE=5, 
		PROGRAM_DEFINITION=6, STATES_DEFINITION=7, TAPE_ALPHABET_DEFINITION=8, 
		RUN_DEFINITION=9, INITIAL_STATE_DEFINITION=10, FINAL_STATES_DEFINITION=11, 
		TRANSITION_FUNCTION_DEFINITION=12, TRANSITION_FUNCTION_STATE=13, TRANSITION_FUNCTION_READ=14, 
		TRANSITION_FUNCTION_WRITE=15, TRANSITION_FUNCTION_SHIFT=16, TAPES_DEFINITION=17, 
		TAPE_INSTANCE=18, READ_ONLY=19, ATTRIBUTES_BEGINNING=20, ATTRIBUTES_END=21, 
		SET_BEGINNING=22, SET_END=23, ARGUMENT_BEGINNING=24, ARGUMENT_END=25, 
		SET_ASSIGNMENT=26, EXPRESSION_DELIMITER=27, ELEMENT_ASSIGNMENT=28, PROGRAM_DIRECTIVE=29, 
		LINE_BEGINNING=30, TRANSITION_FUNCTION_TO=31, STRING_DELIMITER=32, COMMA=33, 
		NONDETERMINISTIC_OPTION=34, PROBABILISTIC_OPTION=35, PROBABILITY_QUOTIENT=36, 
		PROBABILITY_DEFINITION=37, PROBABILITY_EQUAL=38, ORACLE=39, NO_ORACLE=40, 
		ORACLE_TAPE=41, QUESTION_STATE=42, ANSWER_STATE=43, ORACLE_TAPE_ALPHABET_DEFINITION=44, 
		INNER_ALPHABET_SYMBOL=45, TAPE_ALPHABET_SYMBOL=46, TAPE_INSTANCE_SYMBOL=47, 
		IDENTIFIER=48, WHITESPACE=49;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"LINE_COMMENT", "BOOLEAN_OPTION", "SHIFT_OPTION", "BLANK_SYMBOL", "DEFAULT_TAPE", 
		"'prg'", "'states'", "'tape_alphabet'", "'run'", "'initial_state'", "'final_states'", 
		"'transition_function'", "'state'", "'read'", "'write'", "'shift'", "'tapes'", 
		"'tape_instance'", "'read_only'", "'['", "']'", "'{'", "'}'", "'('", "')'", 
		"':='", "'.'", "':'", "'\\'", "'+'", "'->'", "'''", "','", "'nondeterministic'", 
		"'probabilistic'", "PROBABILITY_QUOTIENT", "'p'", "'='", "'oracle'", "NO_ORACLE", 
		"ORACLE_TAPE", "QUESTION_STATE", "ANSWER_STATE", "'oracle_alphabet'", 
		"INNER_ALPHABET_SYMBOL", "TAPE_ALPHABET_SYMBOL", "TAPE_INSTANCE_SYMBOL", 
		"IDENTIFIER", "WHITESPACE"
	};
	public static final String[] ruleNames = {
		"LINE_COMMENT_BEGIN", "LINE_COMMENT", "TRUE_OPTION", "FALSE_OPTION", "BOOLEAN_OPTION", 
		"LEFT_OPTION", "RIGHT_OPTION", "NOP_OPTION", "SHIFT_OPTION", "BLANK_SYMBOL", 
		"DEFAULT_TAPE", "PROGRAM_DEFINITION", "STATES_DEFINITION", "TAPE_ALPHABET_DEFINITION", 
		"RUN_DEFINITION", "INITIAL_STATE_DEFINITION", "FINAL_STATES_DEFINITION", 
		"TRANSITION_FUNCTION_DEFINITION", "TRANSITION_FUNCTION_STATE", "TRANSITION_FUNCTION_READ", 
		"TRANSITION_FUNCTION_WRITE", "TRANSITION_FUNCTION_SHIFT", "TAPES_DEFINITION", 
		"TAPE_INSTANCE", "READ_ONLY", "ATTRIBUTES_BEGINNING", "ATTRIBUTES_END", 
		"SET_BEGINNING", "SET_END", "ARGUMENT_BEGINNING", "ARGUMENT_END", "SET_ASSIGNMENT", 
		"EXPRESSION_DELIMITER", "ELEMENT_ASSIGNMENT", "PROGRAM_DIRECTIVE", "LINE_BEGINNING", 
		"TRANSITION_FUNCTION_TO", "STRING_DELIMITER", "COMMA", "NONDETERMINISTIC_OPTION", 
		"PROBABILISTIC_OPTION", "PROBABILITY_QUOTIENT", "PROBABILITY_DEFINITION", 
		"PROBABILITY_EQUAL", "ORACLE", "NO_ORACLE", "ORACLE_TAPE", "QUESTION_STATE", 
		"ANSWER_STATE", "ORACLE_TAPE_ALPHABET_DEFINITION", "INNER_ALPHABET_SYMBOL", 
		"TAPE_ALPHABET_SYMBOL", "TAPE_INSTANCE_SYMBOL", "IDENTIFIER", "WHITESPACE"
	};


	public YayatsyiGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "YayatsyiGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 1: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 54: WHITESPACE_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WHITESPACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = HIDDEN;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\63\u01cd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\3\3\3\7\3w\n\3"+
		"\f\3\16\3z\13\3\3\3\5\3}\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6\u0090\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\5\n\u00a4\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3"+
		"\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\5+\u0178\n+\3,\3,\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3"+
		"/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66\6\66\u01bd\n\66\r\66\16"+
		"\66\u01be\3\66\3\66\3\67\3\67\7\67\u01c5\n\67\f\67\16\67\u01c8\13\67\3"+
		"8\38\38\38\4x\u01be9\3\2\1\5\3\2\7\2\1\t\2\1\13\4\1\r\2\1\17\2\1\21\2"+
		"\1\23\5\1\25\6\1\27\7\1\31\b\1\33\t\1\35\n\1\37\13\1!\f\1#\r\1%\16\1\'"+
		"\17\1)\20\1+\21\1-\22\1/\23\1\61\24\1\63\25\1\65\26\1\67\27\19\30\1;\31"+
		"\1=\32\1?\33\1A\34\1C\35\1E\36\1G\37\1I \1K!\1M\"\1O#\1Q$\1S%\1U&\1W\'"+
		"\1Y(\1[)\1]*\1_+\1a,\1c-\1e.\1g/\1i\60\1k\61\1m\62\1o\63\3\3\2\6\5\2\f"+
		"\f\17\17\"\"\3\2c|\4\2\62;c|\5\2\13\f\17\17\"\"\u01ce\2\5\3\2\2\2\2\13"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\3q\3\2\2"+
		"\2\5t\3\2\2\2\7\u0082\3\2\2\2\t\u0087\3\2\2\2\13\u008f\3\2\2\2\r\u0091"+
		"\3\2\2\2\17\u0096\3\2\2\2\21\u009c\3\2\2\2\23\u00a3\3\2\2\2\25\u00a5\3"+
		"\2\2\2\27\u00ac\3\2\2\2\31\u00b5\3\2\2\2\33\u00b9\3\2\2\2\35\u00c0\3\2"+
		"\2\2\37\u00ce\3\2\2\2!\u00d2\3\2\2\2#\u00e0\3\2\2\2%\u00ed\3\2\2\2\'\u0101"+
		"\3\2\2\2)\u0107\3\2\2\2+\u010c\3\2\2\2-\u0112\3\2\2\2/\u0118\3\2\2\2\61"+
		"\u011e\3\2\2\2\63\u012c\3\2\2\2\65\u0136\3\2\2\2\67\u0138\3\2\2\29\u013a"+
		"\3\2\2\2;\u013c\3\2\2\2=\u013e\3\2\2\2?\u0140\3\2\2\2A\u0142\3\2\2\2C"+
		"\u0145\3\2\2\2E\u0147\3\2\2\2G\u0149\3\2\2\2I\u014b\3\2\2\2K\u014d\3\2"+
		"\2\2M\u0150\3\2\2\2O\u0152\3\2\2\2Q\u0154\3\2\2\2S\u0165\3\2\2\2U\u0177"+
		"\3\2\2\2W\u0179\3\2\2\2Y\u017b\3\2\2\2[\u017d\3\2\2\2]\u0184\3\2\2\2_"+
		"\u018a\3\2\2\2a\u0192\3\2\2\2c\u019c\3\2\2\2e\u01a4\3\2\2\2g\u01b4\3\2"+
		"\2\2i\u01b6\3\2\2\2k\u01ba\3\2\2\2m\u01c2\3\2\2\2o\u01c9\3\2\2\2qr\7/"+
		"\2\2rs\7/\2\2s\4\3\2\2\2tx\5\3\2\2uw\13\2\2\2vu\3\2\2\2wz\3\2\2\2xy\3"+
		"\2\2\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2{}\7\17\2\2|{\3\2\2\2|}\3\2\2\2}~"+
		"\3\2\2\2~\177\7\f\2\2\177\u0080\3\2\2\2\u0080\u0081\b\3\2\2\u0081\6\3"+
		"\2\2\2\u0082\u0083\7v\2\2\u0083\u0084\7t\2\2\u0084\u0085\7w\2\2\u0085"+
		"\u0086\7g\2\2\u0086\b\3\2\2\2\u0087\u0088\7h\2\2\u0088\u0089\7c\2\2\u0089"+
		"\u008a\7n\2\2\u008a\u008b\7u\2\2\u008b\u008c\7g\2\2\u008c\n\3\2\2\2\u008d"+
		"\u0090\5\7\4\2\u008e\u0090\5\t\5\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2"+
		"\2\2\u0090\f\3\2\2\2\u0091\u0092\7n\2\2\u0092\u0093\7g\2\2\u0093\u0094"+
		"\7h\2\2\u0094\u0095\7v\2\2\u0095\16\3\2\2\2\u0096\u0097\7t\2\2\u0097\u0098"+
		"\7k\2\2\u0098\u0099\7i\2\2\u0099\u009a\7j\2\2\u009a\u009b\7v\2\2\u009b"+
		"\20\3\2\2\2\u009c\u009d\7p\2\2\u009d\u009e\7q\2\2\u009e\u009f\7r\2\2\u009f"+
		"\22\3\2\2\2\u00a0\u00a4\5\r\7\2\u00a1\u00a4\5\21\t\2\u00a2\u00a4\5\17"+
		"\b\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4"+
		"\24\3\2\2\2\u00a5\u00a6\5G$\2\u00a6\u00a7\7d\2\2\u00a7\u00a8\7n\2\2\u00a8"+
		"\u00a9\7c\2\2\u00a9\u00aa\7p\2\2\u00aa\u00ab\7m\2\2\u00ab\26\3\2\2\2\u00ac"+
		"\u00ad\5G$\2\u00ad\u00ae\7f\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7h\2\2"+
		"\u00b0\u00b1\7c\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4"+
		"\7v\2\2\u00b4\30\3\2\2\2\u00b5\u00b6\7r\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8"+
		"\7i\2\2\u00b8\32\3\2\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc"+
		"\7c\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7g\2\2\u00be\u00bf\7u\2\2\u00bf"+
		"\34\3\2\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3\7r\2\2\u00c3"+
		"\u00c4\7g\2\2\u00c4\u00c5\7a\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7n\2\2"+
		"\u00c7\u00c8\7r\2\2\u00c8\u00c9\7j\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb"+
		"\7d\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7v\2\2\u00cd\36\3\2\2\2\u00ce\u00cf"+
		"\7t\2\2\u00cf\u00d0\7w\2\2\u00d0\u00d1\7p\2\2\u00d1 \3\2\2\2\u00d2\u00d3"+
		"\7k\2\2\u00d3\u00d4\7p\2\2\u00d4\u00d5\7k\2\2\u00d5\u00d6\7v\2\2\u00d6"+
		"\u00d7\7k\2\2\u00d7\u00d8\7c\2\2\u00d8\u00d9\7n\2\2\u00d9\u00da\7a\2\2"+
		"\u00da\u00db\7u\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7c\2\2\u00dd\u00de"+
		"\7v\2\2\u00de\u00df\7g\2\2\u00df\"\3\2\2\2\u00e0\u00e1\7h\2\2\u00e1\u00e2"+
		"\7k\2\2\u00e2\u00e3\7p\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7n\2\2\u00e5"+
		"\u00e6\7a\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7c\2\2"+
		"\u00e9\u00ea\7v\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7u\2\2\u00ec$\3\2\2"+
		"\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7t\2\2\u00ef\u00f0\7c\2\2\u00f0\u00f1"+
		"\7p\2\2\u00f1\u00f2\7u\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7v\2\2\u00f4"+
		"\u00f5\7k\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\7p\2\2\u00f7\u00f8\7a\2\2"+
		"\u00f8\u00f9\7h\2\2\u00f9\u00fa\7w\2\2\u00fa\u00fb\7p\2\2\u00fb\u00fc"+
		"\7e\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7k\2\2\u00fe\u00ff\7q\2\2\u00ff"+
		"\u0100\7p\2\2\u0100&\3\2\2\2\u0101\u0102\7u\2\2\u0102\u0103\7v\2\2\u0103"+
		"\u0104\7c\2\2\u0104\u0105\7v\2\2\u0105\u0106\7g\2\2\u0106(\3\2\2\2\u0107"+
		"\u0108\7t\2\2\u0108\u0109\7g\2\2\u0109\u010a\7c\2\2\u010a\u010b\7f\2\2"+
		"\u010b*\3\2\2\2\u010c\u010d\7y\2\2\u010d\u010e\7t\2\2\u010e\u010f\7k\2"+
		"\2\u010f\u0110\7v\2\2\u0110\u0111\7g\2\2\u0111,\3\2\2\2\u0112\u0113\7"+
		"u\2\2\u0113\u0114\7j\2\2\u0114\u0115\7k\2\2\u0115\u0116\7h\2\2\u0116\u0117"+
		"\7v\2\2\u0117.\3\2\2\2\u0118\u0119\7v\2\2\u0119\u011a\7c\2\2\u011a\u011b"+
		"\7r\2\2\u011b\u011c\7g\2\2\u011c\u011d\7u\2\2\u011d\60\3\2\2\2\u011e\u011f"+
		"\7v\2\2\u011f\u0120\7c\2\2\u0120\u0121\7r\2\2\u0121\u0122\7g\2\2\u0122"+
		"\u0123\7a\2\2\u0123\u0124\7k\2\2\u0124\u0125\7p\2\2\u0125\u0126\7u\2\2"+
		"\u0126\u0127\7v\2\2\u0127\u0128\7c\2\2\u0128\u0129\7p\2\2\u0129\u012a"+
		"\7e\2\2\u012a\u012b\7g\2\2\u012b\62\3\2\2\2\u012c\u012d\7t\2\2\u012d\u012e"+
		"\7g\2\2\u012e\u012f\7c\2\2\u012f\u0130\7f\2\2\u0130\u0131\7a\2\2\u0131"+
		"\u0132\7q\2\2\u0132\u0133\7p\2\2\u0133\u0134\7n\2\2\u0134\u0135\7{\2\2"+
		"\u0135\64\3\2\2\2\u0136\u0137\7]\2\2\u0137\66\3\2\2\2\u0138\u0139\7_\2"+
		"\2\u01398\3\2\2\2\u013a\u013b\7}\2\2\u013b:\3\2\2\2\u013c\u013d\7\177"+
		"\2\2\u013d<\3\2\2\2\u013e\u013f\7*\2\2\u013f>\3\2\2\2\u0140\u0141\7+\2"+
		"\2\u0141@\3\2\2\2\u0142\u0143\7<\2\2\u0143\u0144\7?\2\2\u0144B\3\2\2\2"+
		"\u0145\u0146\7\60\2\2\u0146D\3\2\2\2\u0147\u0148\7<\2\2\u0148F\3\2\2\2"+
		"\u0149\u014a\7^\2\2\u014aH\3\2\2\2\u014b\u014c\7-\2\2\u014cJ\3\2\2\2\u014d"+
		"\u014e\7/\2\2\u014e\u014f\7@\2\2\u014fL\3\2\2\2\u0150\u0151\7)\2\2\u0151"+
		"N\3\2\2\2\u0152\u0153\7.\2\2\u0153P\3\2\2\2\u0154\u0155\7p\2\2\u0155\u0156"+
		"\7q\2\2\u0156\u0157\7p\2\2\u0157\u0158\7f\2\2\u0158\u0159\7g\2\2\u0159"+
		"\u015a\7v\2\2\u015a\u015b\7g\2\2\u015b\u015c\7t\2\2\u015c\u015d\7o\2\2"+
		"\u015d\u015e\7k\2\2\u015e\u015f\7p\2\2\u015f\u0160\7k\2\2\u0160\u0161"+
		"\7u\2\2\u0161\u0162\7v\2\2\u0162\u0163\7k\2\2\u0163\u0164\7e\2\2\u0164"+
		"R\3\2\2\2\u0165\u0166\7r\2\2\u0166\u0167\7t\2\2\u0167\u0168\7q\2\2\u0168"+
		"\u0169\7d\2\2\u0169\u016a\7c\2\2\u016a\u016b\7d\2\2\u016b\u016c\7k\2\2"+
		"\u016c\u016d\7n\2\2\u016d\u016e\7k\2\2\u016e\u016f\7u\2\2\u016f\u0170"+
		"\7v\2\2\u0170\u0171\7k\2\2\u0171\u0172\7e\2\2\u0172T\3\2\2\2\u0173\u0174"+
		"\7\63\2\2\u0174\u0175\7\61\2\2\u0175\u0178\7\64\2\2\u0176\u0178\7\63\2"+
		"\2\u0177\u0173\3\2\2\2\u0177\u0176\3\2\2\2\u0178V\3\2\2\2\u0179\u017a"+
		"\7r\2\2\u017aX\3\2\2\2\u017b\u017c\7?\2\2\u017cZ\3\2\2\2\u017d\u017e\7"+
		"q\2\2\u017e\u017f\7t\2\2\u017f\u0180\7c\2\2\u0180\u0181\7e\2\2\u0181\u0182"+
		"\7n\2\2\u0182\u0183\7g\2\2\u0183\\\3\2\2\2\u0184\u0185\5G$\2\u0185\u0186"+
		"\7p\2\2\u0186\u0187\7q\2\2\u0187\u0188\7p\2\2\u0188\u0189\7g\2\2\u0189"+
		"^\3\2\2\2\u018a\u018b\5G$\2\u018b\u018c\7q\2\2\u018c\u018d\7t\2\2\u018d"+
		"\u018e\7c\2\2\u018e\u018f\7e\2\2\u018f\u0190\7n\2\2\u0190\u0191\7g\2\2"+
		"\u0191`\3\2\2\2\u0192\u0193\5G$\2\u0193\u0194\7s\2\2\u0194\u0195\7w\2"+
		"\2\u0195\u0196\7g\2\2\u0196\u0197\7u\2\2\u0197\u0198\7v\2\2\u0198\u0199"+
		"\7k\2\2\u0199\u019a\7q\2\2\u019a\u019b\7p\2\2\u019bb\3\2\2\2\u019c\u019d"+
		"\5G$\2\u019d\u019e\7c\2\2\u019e\u019f\7p\2\2\u019f\u01a0\7u\2\2\u01a0"+
		"\u01a1\7y\2\2\u01a1\u01a2\7g\2\2\u01a2\u01a3\7t\2\2\u01a3d\3\2\2\2\u01a4"+
		"\u01a5\7q\2\2\u01a5\u01a6\7t\2\2\u01a6\u01a7\7c\2\2\u01a7\u01a8\7e\2\2"+
		"\u01a8\u01a9\7n\2\2\u01a9\u01aa\7g\2\2\u01aa\u01ab\7a\2\2\u01ab\u01ac"+
		"\7c\2\2\u01ac\u01ad\7n\2\2\u01ad\u01ae\7r\2\2\u01ae\u01af\7j\2\2\u01af"+
		"\u01b0\7c\2\2\u01b0\u01b1\7d\2\2\u01b1\u01b2\7g\2\2\u01b2\u01b3\7v\2\2"+
		"\u01b3f\3\2\2\2\u01b4\u01b5\n\2\2\2\u01b5h\3\2\2\2\u01b6\u01b7\5M\'\2"+
		"\u01b7\u01b8\5g\64\2\u01b8\u01b9\5M\'\2\u01b9j\3\2\2\2\u01ba\u01bc\5M"+
		"\'\2\u01bb\u01bd\5g\64\2\u01bc\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01be\u01bc\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c1\5M"+
		"\'\2\u01c1l\3\2\2\2\u01c2\u01c6\t\3\2\2\u01c3\u01c5\t\4\2\2\u01c4\u01c3"+
		"\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7"+
		"n\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01ca\t\5\2\2\u01ca\u01cb\3\2\2\2"+
		"\u01cb\u01cc\b8\3\2\u01ccp\3\2\2\2\n\2x|\u008f\u00a3\u0177\u01be\u01c6";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}