// Generated from YayatsyiGrammar.g4 by ANTLR 4.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class YayatsyiGrammarParser extends Parser {
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
	public static final String[] tokenNames = {
		"<INVALID>", "LINE_COMMENT", "BOOLEAN_OPTION", "SHIFT_OPTION", "BLANK_SYMBOL", 
		"DEFAULT_TAPE", "'prg'", "'states'", "'tape_alphabet'", "'run'", "'initial_state'", 
		"'final_states'", "'transition_function'", "'state'", "'read'", "'write'", 
		"'shift'", "'tapes'", "'tape_instance'", "'read_only'", "'['", "']'", 
		"'{'", "'}'", "'('", "')'", "':='", "'.'", "':'", "'\\'", "'+'", "'->'", 
		"'''", "','", "'nondeterministic'", "'probabilistic'", "PROBABILITY_QUOTIENT", 
		"'p'", "'='", "'oracle'", "NO_ORACLE", "ORACLE_TAPE", "QUESTION_STATE", 
		"ANSWER_STATE", "'oracle_alphabet'", "INNER_ALPHABET_SYMBOL", "TAPE_ALPHABET_SYMBOL", 
		"TAPE_INSTANCE_SYMBOL", "IDENTIFIER", "WHITESPACE"
	};
	public static final int
		RULE_root = 0, RULE_program_header = 1, RULE_program_body = 2, RULE_run = 3, 
		RULE_program_attrs = 4, RULE_nondeterministic = 5, RULE_probabilistic = 6, 
		RULE_oracle = 7, RULE_tapes = 8, RULE_read_only = 9, RULE_possible_tapes = 10, 
		RULE_run_attrs = 11, RULE_states = 12, RULE_possible_states = 13, RULE_tape_alphabet = 14, 
		RULE_oracle_alphabet = 15, RULE_generic_alphabet = 16, RULE_possible_tape_alphabet_symbol = 17, 
		RULE_initial_state = 18, RULE_final_states = 19, RULE_transition_function = 20, 
		RULE_trans_func_line = 21, RULE_transition_function_state_from = 22, RULE_transition_function_state_to = 23, 
		RULE_transition_function_state = 24, RULE_transition_function_read = 25, 
		RULE_transition_function_write = 26, RULE_transition_function_shift = 27, 
		RULE_tape_argument = 28, RULE_trans_func_line_attrs = 29, RULE_trans_func_line_attrs_option = 30, 
		RULE_probability = 31;
	public static final String[] ruleNames = {
		"root", "program_header", "program_body", "run", "program_attrs", "nondeterministic", 
		"probabilistic", "oracle", "tapes", "read_only", "possible_tapes", "run_attrs", 
		"states", "possible_states", "tape_alphabet", "oracle_alphabet", "generic_alphabet", 
		"possible_tape_alphabet_symbol", "initial_state", "final_states", "transition_function", 
		"trans_func_line", "transition_function_state_from", "transition_function_state_to", 
		"transition_function_state", "transition_function_read", "transition_function_write", 
		"transition_function_shift", "tape_argument", "trans_func_line_attrs", 
		"trans_func_line_attrs_option", "probability"
	};

	@Override
	public String getGrammarFileName() { return "YayatsyiGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public YayatsyiGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RootContext extends ParserRuleContext {
		public Program_bodyContext program_body() {
			return getRuleContext(Program_bodyContext.class,0);
		}
		public Program_headerContext program_header() {
			return getRuleContext(Program_headerContext.class,0);
		}
		public RunContext run() {
			return getRuleContext(RunContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitRoot(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); program_header();
			setState(65); program_body();
			setState(66); run();
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

	public static class Program_headerContext extends ParserRuleContext {
		public Program_attrsContext program_attrs() {
			return getRuleContext(Program_attrsContext.class,0);
		}
		public TerminalNode ATTRIBUTES_END() { return getToken(YayatsyiGrammarParser.ATTRIBUTES_END, 0); }
		public TerminalNode EXPRESSION_DELIMITER() { return getToken(YayatsyiGrammarParser.EXPRESSION_DELIMITER, 0); }
		public TerminalNode PROGRAM_DEFINITION() { return getToken(YayatsyiGrammarParser.PROGRAM_DEFINITION, 0); }
		public TerminalNode ATTRIBUTES_BEGINNING() { return getToken(YayatsyiGrammarParser.ATTRIBUTES_BEGINNING, 0); }
		public Program_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterProgram_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitProgram_header(this);
		}
	}

	public final Program_headerContext program_header() throws RecognitionException {
		Program_headerContext _localctx = new Program_headerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(PROGRAM_DEFINITION);
			setState(73);
			_la = _input.LA(1);
			if (_la==ATTRIBUTES_BEGINNING) {
				{
				setState(69); match(ATTRIBUTES_BEGINNING);
				setState(70); program_attrs();
				setState(71); match(ATTRIBUTES_END);
				}
			}

			setState(75); match(EXPRESSION_DELIMITER);
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

	public static class Program_bodyContext extends ParserRuleContext {
		public Transition_functionContext transition_function() {
			return getRuleContext(Transition_functionContext.class,0);
		}
		public Oracle_alphabetContext oracle_alphabet() {
			return getRuleContext(Oracle_alphabetContext.class,0);
		}
		public Tape_alphabetContext tape_alphabet() {
			return getRuleContext(Tape_alphabetContext.class,0);
		}
		public StatesContext states() {
			return getRuleContext(StatesContext.class,0);
		}
		public Final_statesContext final_states() {
			return getRuleContext(Final_statesContext.class,0);
		}
		public Initial_stateContext initial_state() {
			return getRuleContext(Initial_stateContext.class,0);
		}
		public Program_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterProgram_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitProgram_body(this);
		}
	}

	public final Program_bodyContext program_body() throws RecognitionException {
		Program_bodyContext _localctx = new Program_bodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_program_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); states();
			setState(78); initial_state();
			setState(79); final_states();
			setState(80); tape_alphabet();
			setState(82);
			_la = _input.LA(1);
			if (_la==ORACLE_TAPE_ALPHABET_DEFINITION) {
				{
				setState(81); oracle_alphabet();
				}
			}

			setState(84); transition_function();
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
		public TerminalNode ATTRIBUTES_END() { return getToken(YayatsyiGrammarParser.ATTRIBUTES_END, 0); }
		public TerminalNode EXPRESSION_DELIMITER() { return getToken(YayatsyiGrammarParser.EXPRESSION_DELIMITER, 0); }
		public TerminalNode RUN_DEFINITION() { return getToken(YayatsyiGrammarParser.RUN_DEFINITION, 0); }
		public Run_attrsContext run_attrs() {
			return getRuleContext(Run_attrsContext.class,0);
		}
		public TerminalNode ATTRIBUTES_BEGINNING() { return getToken(YayatsyiGrammarParser.ATTRIBUTES_BEGINNING, 0); }
		public RunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitRun(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_run);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(RUN_DEFINITION);
			setState(91);
			_la = _input.LA(1);
			if (_la==ATTRIBUTES_BEGINNING) {
				{
				setState(87); match(ATTRIBUTES_BEGINNING);
				setState(88); run_attrs();
				setState(89); match(ATTRIBUTES_END);
				}
			}

			setState(93); match(EXPRESSION_DELIMITER);
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

	public static class Program_attrsContext extends ParserRuleContext {
		public List<TapesContext> tapes() {
			return getRuleContexts(TapesContext.class);
		}
		public NondeterministicContext nondeterministic(int i) {
			return getRuleContext(NondeterministicContext.class,i);
		}
		public OracleContext oracle(int i) {
			return getRuleContext(OracleContext.class,i);
		}
		public Read_onlyContext read_only(int i) {
			return getRuleContext(Read_onlyContext.class,i);
		}
		public List<Read_onlyContext> read_only() {
			return getRuleContexts(Read_onlyContext.class);
		}
		public List<ProbabilisticContext> probabilistic() {
			return getRuleContexts(ProbabilisticContext.class);
		}
		public TerminalNode LINE_BEGINNING(int i) {
			return getToken(YayatsyiGrammarParser.LINE_BEGINNING, i);
		}
		public TapesContext tapes(int i) {
			return getRuleContext(TapesContext.class,i);
		}
		public List<NondeterministicContext> nondeterministic() {
			return getRuleContexts(NondeterministicContext.class);
		}
		public List<TerminalNode> LINE_BEGINNING() { return getTokens(YayatsyiGrammarParser.LINE_BEGINNING); }
		public List<OracleContext> oracle() {
			return getRuleContexts(OracleContext.class);
		}
		public ProbabilisticContext probabilistic(int i) {
			return getRuleContext(ProbabilisticContext.class,i);
		}
		public Program_attrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_attrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterProgram_attrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitProgram_attrs(this);
		}
	}

	public final Program_attrsContext program_attrs() throws RecognitionException {
		Program_attrsContext _localctx = new Program_attrsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_program_attrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LINE_BEGINNING) {
				{
				{
				setState(95); match(LINE_BEGINNING);
				setState(101);
				switch (_input.LA(1)) {
				case NONDETERMINISTIC_OPTION:
					{
					setState(96); nondeterministic();
					}
					break;
				case PROBABILISTIC_OPTION:
					{
					setState(97); probabilistic();
					}
					break;
				case ORACLE:
					{
					setState(98); oracle();
					}
					break;
				case TAPES_DEFINITION:
					{
					setState(99); tapes();
					}
					break;
				case READ_ONLY:
					{
					setState(100); read_only();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(107);
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

	public static class NondeterministicContext extends ParserRuleContext {
		public TerminalNode BOOLEAN_OPTION() { return getToken(YayatsyiGrammarParser.BOOLEAN_OPTION, 0); }
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public TerminalNode NONDETERMINISTIC_OPTION() { return getToken(YayatsyiGrammarParser.NONDETERMINISTIC_OPTION, 0); }
		public NondeterministicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nondeterministic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterNondeterministic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitNondeterministic(this);
		}
	}

	public final NondeterministicContext nondeterministic() throws RecognitionException {
		NondeterministicContext _localctx = new NondeterministicContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_nondeterministic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(NONDETERMINISTIC_OPTION);
			setState(109); match(ELEMENT_ASSIGNMENT);
			setState(110); match(BOOLEAN_OPTION);
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

	public static class ProbabilisticContext extends ParserRuleContext {
		public TerminalNode BOOLEAN_OPTION() { return getToken(YayatsyiGrammarParser.BOOLEAN_OPTION, 0); }
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public TerminalNode PROBABILISTIC_OPTION() { return getToken(YayatsyiGrammarParser.PROBABILISTIC_OPTION, 0); }
		public ProbabilisticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probabilistic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterProbabilistic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitProbabilistic(this);
		}
	}

	public final ProbabilisticContext probabilistic() throws RecognitionException {
		ProbabilisticContext _localctx = new ProbabilisticContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_probabilistic);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(PROBABILISTIC_OPTION);
			setState(113); match(ELEMENT_ASSIGNMENT);
			setState(114); match(BOOLEAN_OPTION);
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

	public static class OracleContext extends ParserRuleContext {
		public TerminalNode ORACLE() { return getToken(YayatsyiGrammarParser.ORACLE, 0); }
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(YayatsyiGrammarParser.IDENTIFIER, 0); }
		public TerminalNode NO_ORACLE() { return getToken(YayatsyiGrammarParser.NO_ORACLE, 0); }
		public OracleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oracle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterOracle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitOracle(this);
		}
	}

	public final OracleContext oracle() throws RecognitionException {
		OracleContext _localctx = new OracleContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_oracle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(ORACLE);
			setState(117); match(ELEMENT_ASSIGNMENT);
			setState(118);
			_la = _input.LA(1);
			if ( !(_la==NO_ORACLE || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class TapesContext extends ParserRuleContext {
		public TerminalNode SET_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.SET_ASSIGNMENT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(YayatsyiGrammarParser.COMMA); }
		public TerminalNode SET_BEGINNING() { return getToken(YayatsyiGrammarParser.SET_BEGINNING, 0); }
		public TerminalNode TAPES_DEFINITION() { return getToken(YayatsyiGrammarParser.TAPES_DEFINITION, 0); }
		public List<Possible_tapesContext> possible_tapes() {
			return getRuleContexts(Possible_tapesContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(YayatsyiGrammarParser.COMMA, i);
		}
		public TerminalNode SET_END() { return getToken(YayatsyiGrammarParser.SET_END, 0); }
		public Possible_tapesContext possible_tapes(int i) {
			return getRuleContext(Possible_tapesContext.class,i);
		}
		public TapesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tapes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTapes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTapes(this);
		}
	}

	public final TapesContext tapes() throws RecognitionException {
		TapesContext _localctx = new TapesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tapes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(TAPES_DEFINITION);
			setState(121); match(SET_ASSIGNMENT);
			setState(122); match(SET_BEGINNING);
			setState(123); possible_tapes();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(124); match(COMMA);
				setState(125); possible_tapes();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131); match(SET_END);
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

	public static class Read_onlyContext extends ParserRuleContext {
		public TerminalNode READ_ONLY() { return getToken(YayatsyiGrammarParser.READ_ONLY, 0); }
		public TerminalNode BOOLEAN_OPTION() { return getToken(YayatsyiGrammarParser.BOOLEAN_OPTION, 0); }
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public Read_onlyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_only; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterRead_only(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitRead_only(this);
		}
	}

	public final Read_onlyContext read_only() throws RecognitionException {
		Read_onlyContext _localctx = new Read_onlyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_read_only);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133); match(READ_ONLY);
			setState(134); match(ELEMENT_ASSIGNMENT);
			setState(135); match(BOOLEAN_OPTION);
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

	public static class Possible_tapesContext extends ParserRuleContext {
		public TerminalNode ORACLE_TAPE() { return getToken(YayatsyiGrammarParser.ORACLE_TAPE, 0); }
		public TerminalNode DEFAULT_TAPE() { return getToken(YayatsyiGrammarParser.DEFAULT_TAPE, 0); }
		public Possible_tapesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possible_tapes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterPossible_tapes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitPossible_tapes(this);
		}
	}

	public final Possible_tapesContext possible_tapes() throws RecognitionException {
		Possible_tapesContext _localctx = new Possible_tapesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_possible_tapes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !(_la==DEFAULT_TAPE || _la==ORACLE_TAPE) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Run_attrsContext extends ParserRuleContext {
		public Tape_argumentContext tape_argument() {
			return getRuleContext(Tape_argumentContext.class,0);
		}
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public TerminalNode TAPE_INSTANCE_SYMBOL() { return getToken(YayatsyiGrammarParser.TAPE_INSTANCE_SYMBOL, 0); }
		public TerminalNode TAPE_INSTANCE() { return getToken(YayatsyiGrammarParser.TAPE_INSTANCE, 0); }
		public Run_attrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run_attrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterRun_attrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitRun_attrs(this);
		}
	}

	public final Run_attrsContext run_attrs() throws RecognitionException {
		Run_attrsContext _localctx = new Run_attrsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_run_attrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(TAPE_INSTANCE);
			setState(141);
			_la = _input.LA(1);
			if (_la==ARGUMENT_BEGINNING) {
				{
				setState(140); tape_argument();
				}
			}

			setState(143); match(ELEMENT_ASSIGNMENT);
			setState(144); match(TAPE_INSTANCE_SYMBOL);
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

	public static class StatesContext extends ParserRuleContext {
		public List<Possible_statesContext> possible_states() {
			return getRuleContexts(Possible_statesContext.class);
		}
		public TerminalNode SET_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.SET_ASSIGNMENT, 0); }
		public TerminalNode EXPRESSION_DELIMITER() { return getToken(YayatsyiGrammarParser.EXPRESSION_DELIMITER, 0); }
		public List<TerminalNode> COMMA() { return getTokens(YayatsyiGrammarParser.COMMA); }
		public TerminalNode SET_BEGINNING() { return getToken(YayatsyiGrammarParser.SET_BEGINNING, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(YayatsyiGrammarParser.COMMA, i);
		}
		public TerminalNode STATES_DEFINITION() { return getToken(YayatsyiGrammarParser.STATES_DEFINITION, 0); }
		public TerminalNode SET_END() { return getToken(YayatsyiGrammarParser.SET_END, 0); }
		public Possible_statesContext possible_states(int i) {
			return getRuleContext(Possible_statesContext.class,i);
		}
		public StatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterStates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitStates(this);
		}
	}

	public final StatesContext states() throws RecognitionException {
		StatesContext _localctx = new StatesContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(STATES_DEFINITION);
			setState(147); match(SET_ASSIGNMENT);
			setState(148); match(SET_BEGINNING);
			setState(149); possible_states();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(150); match(COMMA);
				setState(151); possible_states();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157); match(SET_END);
			setState(158); match(EXPRESSION_DELIMITER);
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

	public static class Possible_statesContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(YayatsyiGrammarParser.IDENTIFIER, 0); }
		public TerminalNode ANSWER_STATE() { return getToken(YayatsyiGrammarParser.ANSWER_STATE, 0); }
		public TerminalNode QUESTION_STATE() { return getToken(YayatsyiGrammarParser.QUESTION_STATE, 0); }
		public Possible_statesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possible_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterPossible_states(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitPossible_states(this);
		}
	}

	public final Possible_statesContext possible_states() throws RecognitionException {
		Possible_statesContext _localctx = new Possible_statesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_possible_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUESTION_STATE) | (1L << ANSWER_STATE) | (1L << IDENTIFIER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Tape_alphabetContext extends ParserRuleContext {
		public TerminalNode EXPRESSION_DELIMITER() { return getToken(YayatsyiGrammarParser.EXPRESSION_DELIMITER, 0); }
		public TerminalNode TAPE_ALPHABET_DEFINITION() { return getToken(YayatsyiGrammarParser.TAPE_ALPHABET_DEFINITION, 0); }
		public Generic_alphabetContext generic_alphabet() {
			return getRuleContext(Generic_alphabetContext.class,0);
		}
		public Tape_alphabetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tape_alphabet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTape_alphabet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTape_alphabet(this);
		}
	}

	public final Tape_alphabetContext tape_alphabet() throws RecognitionException {
		Tape_alphabetContext _localctx = new Tape_alphabetContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tape_alphabet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(TAPE_ALPHABET_DEFINITION);
			setState(163); generic_alphabet();
			setState(164); match(EXPRESSION_DELIMITER);
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

	public static class Oracle_alphabetContext extends ParserRuleContext {
		public TerminalNode EXPRESSION_DELIMITER() { return getToken(YayatsyiGrammarParser.EXPRESSION_DELIMITER, 0); }
		public TerminalNode ORACLE_TAPE_ALPHABET_DEFINITION() { return getToken(YayatsyiGrammarParser.ORACLE_TAPE_ALPHABET_DEFINITION, 0); }
		public Generic_alphabetContext generic_alphabet() {
			return getRuleContext(Generic_alphabetContext.class,0);
		}
		public Oracle_alphabetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oracle_alphabet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterOracle_alphabet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitOracle_alphabet(this);
		}
	}

	public final Oracle_alphabetContext oracle_alphabet() throws RecognitionException {
		Oracle_alphabetContext _localctx = new Oracle_alphabetContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_oracle_alphabet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); match(ORACLE_TAPE_ALPHABET_DEFINITION);
			setState(167); generic_alphabet();
			setState(168); match(EXPRESSION_DELIMITER);
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

	public static class Generic_alphabetContext extends ParserRuleContext {
		public Possible_tape_alphabet_symbolContext possible_tape_alphabet_symbol(int i) {
			return getRuleContext(Possible_tape_alphabet_symbolContext.class,i);
		}
		public TerminalNode SET_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.SET_ASSIGNMENT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(YayatsyiGrammarParser.COMMA); }
		public TerminalNode SET_BEGINNING() { return getToken(YayatsyiGrammarParser.SET_BEGINNING, 0); }
		public List<Possible_tape_alphabet_symbolContext> possible_tape_alphabet_symbol() {
			return getRuleContexts(Possible_tape_alphabet_symbolContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(YayatsyiGrammarParser.COMMA, i);
		}
		public TerminalNode SET_END() { return getToken(YayatsyiGrammarParser.SET_END, 0); }
		public Generic_alphabetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_alphabet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterGeneric_alphabet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitGeneric_alphabet(this);
		}
	}

	public final Generic_alphabetContext generic_alphabet() throws RecognitionException {
		Generic_alphabetContext _localctx = new Generic_alphabetContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_generic_alphabet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); match(SET_ASSIGNMENT);
			setState(171); match(SET_BEGINNING);
			setState(172); possible_tape_alphabet_symbol();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(173); match(COMMA);
				setState(174); possible_tape_alphabet_symbol();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180); match(SET_END);
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

	public static class Possible_tape_alphabet_symbolContext extends ParserRuleContext {
		public TerminalNode TAPE_ALPHABET_SYMBOL() { return getToken(YayatsyiGrammarParser.TAPE_ALPHABET_SYMBOL, 0); }
		public TerminalNode BLANK_SYMBOL() { return getToken(YayatsyiGrammarParser.BLANK_SYMBOL, 0); }
		public Possible_tape_alphabet_symbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_possible_tape_alphabet_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterPossible_tape_alphabet_symbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitPossible_tape_alphabet_symbol(this);
		}
	}

	public final Possible_tape_alphabet_symbolContext possible_tape_alphabet_symbol() throws RecognitionException {
		Possible_tape_alphabet_symbolContext _localctx = new Possible_tape_alphabet_symbolContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_possible_tape_alphabet_symbol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !(_la==BLANK_SYMBOL || _la==TAPE_ALPHABET_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Initial_stateContext extends ParserRuleContext {
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public TerminalNode EXPRESSION_DELIMITER() { return getToken(YayatsyiGrammarParser.EXPRESSION_DELIMITER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(YayatsyiGrammarParser.IDENTIFIER, 0); }
		public TerminalNode INITIAL_STATE_DEFINITION() { return getToken(YayatsyiGrammarParser.INITIAL_STATE_DEFINITION, 0); }
		public Initial_stateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initial_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterInitial_state(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitInitial_state(this);
		}
	}

	public final Initial_stateContext initial_state() throws RecognitionException {
		Initial_stateContext _localctx = new Initial_stateContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_initial_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(INITIAL_STATE_DEFINITION);
			setState(185); match(ELEMENT_ASSIGNMENT);
			setState(186); match(IDENTIFIER);
			setState(187); match(EXPRESSION_DELIMITER);
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

	public static class Final_statesContext extends ParserRuleContext {
		public TerminalNode SET_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.SET_ASSIGNMENT, 0); }
		public TerminalNode EXPRESSION_DELIMITER() { return getToken(YayatsyiGrammarParser.EXPRESSION_DELIMITER, 0); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(YayatsyiGrammarParser.IDENTIFIER, i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(YayatsyiGrammarParser.IDENTIFIER); }
		public List<TerminalNode> COMMA() { return getTokens(YayatsyiGrammarParser.COMMA); }
		public TerminalNode SET_BEGINNING() { return getToken(YayatsyiGrammarParser.SET_BEGINNING, 0); }
		public TerminalNode FINAL_STATES_DEFINITION() { return getToken(YayatsyiGrammarParser.FINAL_STATES_DEFINITION, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(YayatsyiGrammarParser.COMMA, i);
		}
		public TerminalNode SET_END() { return getToken(YayatsyiGrammarParser.SET_END, 0); }
		public Final_statesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_final_states; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterFinal_states(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitFinal_states(this);
		}
	}

	public final Final_statesContext final_states() throws RecognitionException {
		Final_statesContext _localctx = new Final_statesContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_final_states);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(FINAL_STATES_DEFINITION);
			setState(190); match(SET_ASSIGNMENT);
			setState(191); match(SET_BEGINNING);
			setState(192); match(IDENTIFIER);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(193); match(COMMA);
				setState(194); match(IDENTIFIER);
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200); match(SET_END);
			setState(201); match(EXPRESSION_DELIMITER);
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

	public static class Transition_functionContext extends ParserRuleContext {
		public TerminalNode TRANSITION_FUNCTION_DEFINITION() { return getToken(YayatsyiGrammarParser.TRANSITION_FUNCTION_DEFINITION, 0); }
		public TerminalNode SET_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.SET_ASSIGNMENT, 0); }
		public Trans_func_lineContext trans_func_line(int i) {
			return getRuleContext(Trans_func_lineContext.class,i);
		}
		public TerminalNode EXPRESSION_DELIMITER() { return getToken(YayatsyiGrammarParser.EXPRESSION_DELIMITER, 0); }
		public List<Trans_func_lineContext> trans_func_line() {
			return getRuleContexts(Trans_func_lineContext.class);
		}
		public TerminalNode SET_BEGINNING() { return getToken(YayatsyiGrammarParser.SET_BEGINNING, 0); }
		public TerminalNode SET_END() { return getToken(YayatsyiGrammarParser.SET_END, 0); }
		public Transition_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTransition_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTransition_function(this);
		}
	}

	public final Transition_functionContext transition_function() throws RecognitionException {
		Transition_functionContext _localctx = new Transition_functionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_transition_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(TRANSITION_FUNCTION_DEFINITION);
			setState(204); match(SET_ASSIGNMENT);
			setState(205); match(SET_BEGINNING);
			setState(207); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(206); trans_func_line();
				}
				}
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LINE_BEGINNING );
			setState(211); match(SET_END);
			setState(212); match(EXPRESSION_DELIMITER);
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

	public static class Trans_func_lineContext extends ParserRuleContext {
		public Transition_function_shiftContext transition_function_shift(int i) {
			return getRuleContext(Transition_function_shiftContext.class,i);
		}
		public Transition_function_state_fromContext transition_function_state_from() {
			return getRuleContext(Transition_function_state_fromContext.class,0);
		}
		public List<Transition_function_readContext> transition_function_read() {
			return getRuleContexts(Transition_function_readContext.class);
		}
		public List<Transition_function_writeContext> transition_function_write() {
			return getRuleContexts(Transition_function_writeContext.class);
		}
		public TerminalNode TRANSITION_FUNCTION_TO() { return getToken(YayatsyiGrammarParser.TRANSITION_FUNCTION_TO, 0); }
		public TerminalNode LINE_BEGINNING() { return getToken(YayatsyiGrammarParser.LINE_BEGINNING, 0); }
		public Transition_function_writeContext transition_function_write(int i) {
			return getRuleContext(Transition_function_writeContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(YayatsyiGrammarParser.COMMA, i);
		}
		public List<Transition_function_shiftContext> transition_function_shift() {
			return getRuleContexts(Transition_function_shiftContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(YayatsyiGrammarParser.COMMA); }
		public Transition_function_state_toContext transition_function_state_to() {
			return getRuleContext(Transition_function_state_toContext.class,0);
		}
		public Transition_function_readContext transition_function_read(int i) {
			return getRuleContext(Transition_function_readContext.class,i);
		}
		public Trans_func_line_attrsContext trans_func_line_attrs() {
			return getRuleContext(Trans_func_line_attrsContext.class,0);
		}
		public Trans_func_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trans_func_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTrans_func_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTrans_func_line(this);
		}
	}

	public final Trans_func_lineContext trans_func_line() throws RecognitionException {
		Trans_func_lineContext _localctx = new Trans_func_lineContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_trans_func_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214); match(LINE_BEGINNING);
			setState(215); transition_function_state_from();
			setState(216); match(COMMA);
			setState(217); transition_function_read();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(218); match(COMMA);
				setState(219); transition_function_read();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(225); match(TRANSITION_FUNCTION_TO);
			setState(226); transition_function_state_to();
			setState(227); match(COMMA);
			{
			setState(228); transition_function_write();
			setState(229); match(COMMA);
			setState(230); transition_function_shift();
			}
			setState(234);
			switch (_input.LA(1)) {
			case TRANSITION_FUNCTION_WRITE:
				{
				setState(232); transition_function_write();
				}
				break;
			case TRANSITION_FUNCTION_SHIFT:
				{
				setState(233); transition_function_shift();
				}
				break;
			case SET_END:
			case ARGUMENT_BEGINNING:
			case LINE_BEGINNING:
			case COMMA:
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(236); match(COMMA);
				setState(239);
				switch (_input.LA(1)) {
				case TRANSITION_FUNCTION_WRITE:
					{
					setState(237); transition_function_write();
					}
					break;
				case TRANSITION_FUNCTION_SHIFT:
					{
					setState(238); transition_function_shift();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(247);
			_la = _input.LA(1);
			if (_la==ARGUMENT_BEGINNING) {
				{
				setState(246); trans_func_line_attrs();
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

	public static class Transition_function_state_fromContext extends ParserRuleContext {
		public Transition_function_stateContext transition_function_state() {
			return getRuleContext(Transition_function_stateContext.class,0);
		}
		public Transition_function_state_fromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_function_state_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTransition_function_state_from(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTransition_function_state_from(this);
		}
	}

	public final Transition_function_state_fromContext transition_function_state_from() throws RecognitionException {
		Transition_function_state_fromContext _localctx = new Transition_function_state_fromContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_transition_function_state_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249); transition_function_state();
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

	public static class Transition_function_state_toContext extends ParserRuleContext {
		public Transition_function_stateContext transition_function_state() {
			return getRuleContext(Transition_function_stateContext.class,0);
		}
		public Transition_function_state_toContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_function_state_to; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTransition_function_state_to(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTransition_function_state_to(this);
		}
	}

	public final Transition_function_state_toContext transition_function_state_to() throws RecognitionException {
		Transition_function_state_toContext _localctx = new Transition_function_state_toContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_transition_function_state_to);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); transition_function_state();
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

	public static class Transition_function_stateContext extends ParserRuleContext {
		public Possible_statesContext possible_states() {
			return getRuleContext(Possible_statesContext.class,0);
		}
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public TerminalNode TRANSITION_FUNCTION_STATE() { return getToken(YayatsyiGrammarParser.TRANSITION_FUNCTION_STATE, 0); }
		public Transition_function_stateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_function_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTransition_function_state(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTransition_function_state(this);
		}
	}

	public final Transition_function_stateContext transition_function_state() throws RecognitionException {
		Transition_function_stateContext _localctx = new Transition_function_stateContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_transition_function_state);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); match(TRANSITION_FUNCTION_STATE);
			setState(254); match(ELEMENT_ASSIGNMENT);
			setState(255); possible_states();
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

	public static class Transition_function_readContext extends ParserRuleContext {
		public Tape_argumentContext tape_argument() {
			return getRuleContext(Tape_argumentContext.class,0);
		}
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public TerminalNode TRANSITION_FUNCTION_READ() { return getToken(YayatsyiGrammarParser.TRANSITION_FUNCTION_READ, 0); }
		public TerminalNode TAPE_ALPHABET_SYMBOL() { return getToken(YayatsyiGrammarParser.TAPE_ALPHABET_SYMBOL, 0); }
		public TerminalNode BLANK_SYMBOL() { return getToken(YayatsyiGrammarParser.BLANK_SYMBOL, 0); }
		public Transition_function_readContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_function_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTransition_function_read(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTransition_function_read(this);
		}
	}

	public final Transition_function_readContext transition_function_read() throws RecognitionException {
		Transition_function_readContext _localctx = new Transition_function_readContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_transition_function_read);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(TRANSITION_FUNCTION_READ);
			setState(259);
			_la = _input.LA(1);
			if (_la==ARGUMENT_BEGINNING) {
				{
				setState(258); tape_argument();
				}
			}

			setState(261); match(ELEMENT_ASSIGNMENT);
			setState(262);
			_la = _input.LA(1);
			if ( !(_la==BLANK_SYMBOL || _la==TAPE_ALPHABET_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Transition_function_writeContext extends ParserRuleContext {
		public Tape_argumentContext tape_argument() {
			return getRuleContext(Tape_argumentContext.class,0);
		}
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public TerminalNode TRANSITION_FUNCTION_WRITE() { return getToken(YayatsyiGrammarParser.TRANSITION_FUNCTION_WRITE, 0); }
		public TerminalNode TAPE_ALPHABET_SYMBOL() { return getToken(YayatsyiGrammarParser.TAPE_ALPHABET_SYMBOL, 0); }
		public TerminalNode BLANK_SYMBOL() { return getToken(YayatsyiGrammarParser.BLANK_SYMBOL, 0); }
		public Transition_function_writeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_function_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTransition_function_write(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTransition_function_write(this);
		}
	}

	public final Transition_function_writeContext transition_function_write() throws RecognitionException {
		Transition_function_writeContext _localctx = new Transition_function_writeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_transition_function_write);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(TRANSITION_FUNCTION_WRITE);
			setState(266);
			_la = _input.LA(1);
			if (_la==ARGUMENT_BEGINNING) {
				{
				setState(265); tape_argument();
				}
			}

			setState(268); match(ELEMENT_ASSIGNMENT);
			setState(269);
			_la = _input.LA(1);
			if ( !(_la==BLANK_SYMBOL || _la==TAPE_ALPHABET_SYMBOL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class Transition_function_shiftContext extends ParserRuleContext {
		public Tape_argumentContext tape_argument() {
			return getRuleContext(Tape_argumentContext.class,0);
		}
		public TerminalNode TRANSITION_FUNCTION_SHIFT() { return getToken(YayatsyiGrammarParser.TRANSITION_FUNCTION_SHIFT, 0); }
		public TerminalNode ELEMENT_ASSIGNMENT() { return getToken(YayatsyiGrammarParser.ELEMENT_ASSIGNMENT, 0); }
		public TerminalNode SHIFT_OPTION() { return getToken(YayatsyiGrammarParser.SHIFT_OPTION, 0); }
		public Transition_function_shiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition_function_shift; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTransition_function_shift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTransition_function_shift(this);
		}
	}

	public final Transition_function_shiftContext transition_function_shift() throws RecognitionException {
		Transition_function_shiftContext _localctx = new Transition_function_shiftContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_transition_function_shift);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271); match(TRANSITION_FUNCTION_SHIFT);
			setState(273);
			_la = _input.LA(1);
			if (_la==ARGUMENT_BEGINNING) {
				{
				setState(272); tape_argument();
				}
			}

			setState(275); match(ELEMENT_ASSIGNMENT);
			setState(276); match(SHIFT_OPTION);
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

	public static class Tape_argumentContext extends ParserRuleContext {
		public TerminalNode ARGUMENT_BEGINNING() { return getToken(YayatsyiGrammarParser.ARGUMENT_BEGINNING, 0); }
		public TerminalNode ARGUMENT_END() { return getToken(YayatsyiGrammarParser.ARGUMENT_END, 0); }
		public Possible_tapesContext possible_tapes() {
			return getRuleContext(Possible_tapesContext.class,0);
		}
		public Tape_argumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tape_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTape_argument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTape_argument(this);
		}
	}

	public final Tape_argumentContext tape_argument() throws RecognitionException {
		Tape_argumentContext _localctx = new Tape_argumentContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_tape_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278); match(ARGUMENT_BEGINNING);
			setState(279); possible_tapes();
			setState(280); match(ARGUMENT_END);
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

	public static class Trans_func_line_attrsContext extends ParserRuleContext {
		public TerminalNode ARGUMENT_BEGINNING() { return getToken(YayatsyiGrammarParser.ARGUMENT_BEGINNING, 0); }
		public List<TerminalNode> COMMA() { return getTokens(YayatsyiGrammarParser.COMMA); }
		public Trans_func_line_attrs_optionContext trans_func_line_attrs_option(int i) {
			return getRuleContext(Trans_func_line_attrs_optionContext.class,i);
		}
		public TerminalNode ARGUMENT_END() { return getToken(YayatsyiGrammarParser.ARGUMENT_END, 0); }
		public List<Trans_func_line_attrs_optionContext> trans_func_line_attrs_option() {
			return getRuleContexts(Trans_func_line_attrs_optionContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(YayatsyiGrammarParser.COMMA, i);
		}
		public Trans_func_line_attrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trans_func_line_attrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTrans_func_line_attrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTrans_func_line_attrs(this);
		}
	}

	public final Trans_func_line_attrsContext trans_func_line_attrs() throws RecognitionException {
		Trans_func_line_attrsContext _localctx = new Trans_func_line_attrsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_trans_func_line_attrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282); match(ARGUMENT_BEGINNING);
			setState(283); trans_func_line_attrs_option();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(284); match(COMMA);
				setState(285); trans_func_line_attrs_option();
				}
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(291); match(ARGUMENT_END);
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

	public static class Trans_func_line_attrs_optionContext extends ParserRuleContext {
		public ProbabilityContext probability() {
			return getRuleContext(ProbabilityContext.class,0);
		}
		public Trans_func_line_attrs_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trans_func_line_attrs_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterTrans_func_line_attrs_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitTrans_func_line_attrs_option(this);
		}
	}

	public final Trans_func_line_attrs_optionContext trans_func_line_attrs_option() throws RecognitionException {
		Trans_func_line_attrs_optionContext _localctx = new Trans_func_line_attrs_optionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_trans_func_line_attrs_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(293); probability();
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

	public static class ProbabilityContext extends ParserRuleContext {
		public TerminalNode PROBABILITY_DEFINITION() { return getToken(YayatsyiGrammarParser.PROBABILITY_DEFINITION, 0); }
		public TerminalNode PROBABILITY_QUOTIENT() { return getToken(YayatsyiGrammarParser.PROBABILITY_QUOTIENT, 0); }
		public TerminalNode PROBABILITY_EQUAL() { return getToken(YayatsyiGrammarParser.PROBABILITY_EQUAL, 0); }
		public ProbabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probability; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).enterProbability(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YayatsyiGrammarListener ) ((YayatsyiGrammarListener)listener).exitProbability(this);
		}
	}

	public final ProbabilityContext probability() throws RecognitionException {
		ProbabilityContext _localctx = new ProbabilityContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_probability);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295); match(PROBABILITY_DEFINITION);
			setState(296); match(PROBABILITY_EQUAL);
			setState(297); match(PROBABILITY_QUOTIENT);
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\63\u012e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3L\n\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\5\4U\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5^\n\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6h\n\6\7\6j\n\6\f\6\16\6m\13\6\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0081\n\n\f\n\16"+
		"\n\u0084\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\5\r\u0090\n"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u009b\n\16\f\16\16\16"+
		"\u009e\13\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\7\22\u00b2\n\22\f\22\16\22\u00b5\13"+
		"\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\7\25\u00c6\n\25\f\25\16\25\u00c9\13\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\6\26\u00d2\n\26\r\26\16\26\u00d3\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\7\27\u00df\n\27\f\27\16\27\u00e2\13\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00ed\n\27\3\27\3\27\3\27\5\27"+
		"\u00f2\n\27\7\27\u00f4\n\27\f\27\16\27\u00f7\13\27\3\27\5\27\u00fa\n\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\5\33\u0106\n\33\3\33"+
		"\3\33\3\33\3\34\3\34\5\34\u010d\n\34\3\34\3\34\3\34\3\35\3\35\5\35\u0114"+
		"\n\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u0121"+
		"\n\37\f\37\16\37\u0124\13\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\2\"\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\6\4\2**"+
		"\62\62\4\2\7\7++\4\2,-\62\62\4\2\6\6\60\60\u0125\2B\3\2\2\2\4F\3\2\2\2"+
		"\6O\3\2\2\2\bX\3\2\2\2\nk\3\2\2\2\fn\3\2\2\2\16r\3\2\2\2\20v\3\2\2\2\22"+
		"z\3\2\2\2\24\u0087\3\2\2\2\26\u008b\3\2\2\2\30\u008d\3\2\2\2\32\u0094"+
		"\3\2\2\2\34\u00a2\3\2\2\2\36\u00a4\3\2\2\2 \u00a8\3\2\2\2\"\u00ac\3\2"+
		"\2\2$\u00b8\3\2\2\2&\u00ba\3\2\2\2(\u00bf\3\2\2\2*\u00cd\3\2\2\2,\u00d8"+
		"\3\2\2\2.\u00fb\3\2\2\2\60\u00fd\3\2\2\2\62\u00ff\3\2\2\2\64\u0103\3\2"+
		"\2\2\66\u010a\3\2\2\28\u0111\3\2\2\2:\u0118\3\2\2\2<\u011c\3\2\2\2>\u0127"+
		"\3\2\2\2@\u0129\3\2\2\2BC\5\4\3\2CD\5\6\4\2DE\5\b\5\2E\3\3\2\2\2FK\7\b"+
		"\2\2GH\7\26\2\2HI\5\n\6\2IJ\7\27\2\2JL\3\2\2\2KG\3\2\2\2KL\3\2\2\2LM\3"+
		"\2\2\2MN\7\35\2\2N\5\3\2\2\2OP\5\32\16\2PQ\5&\24\2QR\5(\25\2RT\5\36\20"+
		"\2SU\5 \21\2TS\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\5*\26\2W\7\3\2\2\2X]\7\13"+
		"\2\2YZ\7\26\2\2Z[\5\30\r\2[\\\7\27\2\2\\^\3\2\2\2]Y\3\2\2\2]^\3\2\2\2"+
		"^_\3\2\2\2_`\7\35\2\2`\t\3\2\2\2ag\7 \2\2bh\5\f\7\2ch\5\16\b\2dh\5\20"+
		"\t\2eh\5\22\n\2fh\5\24\13\2gb\3\2\2\2gc\3\2\2\2gd\3\2\2\2ge\3\2\2\2gf"+
		"\3\2\2\2hj\3\2\2\2ia\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\13\3\2\2\2"+
		"mk\3\2\2\2no\7$\2\2op\7\36\2\2pq\7\4\2\2q\r\3\2\2\2rs\7%\2\2st\7\36\2"+
		"\2tu\7\4\2\2u\17\3\2\2\2vw\7)\2\2wx\7\36\2\2xy\t\2\2\2y\21\3\2\2\2z{\7"+
		"\23\2\2{|\7\34\2\2|}\7\30\2\2}\u0082\5\26\f\2~\177\7#\2\2\177\u0081\5"+
		"\26\f\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7\31\2\2"+
		"\u0086\23\3\2\2\2\u0087\u0088\7\25\2\2\u0088\u0089\7\36\2\2\u0089\u008a"+
		"\7\4\2\2\u008a\25\3\2\2\2\u008b\u008c\t\3\2\2\u008c\27\3\2\2\2\u008d\u008f"+
		"\7\24\2\2\u008e\u0090\5:\36\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0092\7\36\2\2\u0092\u0093\7\61\2\2\u0093\31"+
		"\3\2\2\2\u0094\u0095\7\t\2\2\u0095\u0096\7\34\2\2\u0096\u0097\7\30\2\2"+
		"\u0097\u009c\5\34\17\2\u0098\u0099\7#\2\2\u0099\u009b\5\34\17\2\u009a"+
		"\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\7\31\2\2\u00a0"+
		"\u00a1\7\35\2\2\u00a1\33\3\2\2\2\u00a2\u00a3\t\4\2\2\u00a3\35\3\2\2\2"+
		"\u00a4\u00a5\7\n\2\2\u00a5\u00a6\5\"\22\2\u00a6\u00a7\7\35\2\2\u00a7\37"+
		"\3\2\2\2\u00a8\u00a9\7.\2\2\u00a9\u00aa\5\"\22\2\u00aa\u00ab\7\35\2\2"+
		"\u00ab!\3\2\2\2\u00ac\u00ad\7\34\2\2\u00ad\u00ae\7\30\2\2\u00ae\u00b3"+
		"\5$\23\2\u00af\u00b0\7#\2\2\u00b0\u00b2\5$\23\2\u00b1\u00af\3\2\2\2\u00b2"+
		"\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\7\31\2\2\u00b7#\3\2\2\2\u00b8\u00b9"+
		"\t\5\2\2\u00b9%\3\2\2\2\u00ba\u00bb\7\f\2\2\u00bb\u00bc\7\36\2\2\u00bc"+
		"\u00bd\7\62\2\2\u00bd\u00be\7\35\2\2\u00be\'\3\2\2\2\u00bf\u00c0\7\r\2"+
		"\2\u00c0\u00c1\7\34\2\2\u00c1\u00c2\7\30\2\2\u00c2\u00c7\7\62\2\2\u00c3"+
		"\u00c4\7#\2\2\u00c4\u00c6\7\62\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2"+
		"\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cb\7\31\2\2\u00cb\u00cc\7\35\2\2\u00cc)\3\2\2"+
		"\2\u00cd\u00ce\7\16\2\2\u00ce\u00cf\7\34\2\2\u00cf\u00d1\7\30\2\2\u00d0"+
		"\u00d2\5,\27\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\31\2\2\u00d6"+
		"\u00d7\7\35\2\2\u00d7+\3\2\2\2\u00d8\u00d9\7 \2\2\u00d9\u00da\5.\30\2"+
		"\u00da\u00db\7#\2\2\u00db\u00e0\5\64\33\2\u00dc\u00dd\7#\2\2\u00dd\u00df"+
		"\5\64\33\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2"+
		"\u00e0\u00e1\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4"+
		"\7!\2\2\u00e4\u00e5\5\60\31\2\u00e5\u00e6\7#\2\2\u00e6\u00e7\5\66\34\2"+
		"\u00e7\u00e8\7#\2\2\u00e8\u00e9\58\35\2\u00e9\u00ec\3\2\2\2\u00ea\u00ed"+
		"\5\66\34\2\u00eb\u00ed\58\35\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2"+
		"\u00ec\u00ed\3\2\2\2\u00ed\u00f5\3\2\2\2\u00ee\u00f1\7#\2\2\u00ef\u00f2"+
		"\5\66\34\2\u00f0\u00f2\58\35\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2"+
		"\u00f2\u00f4\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8"+
		"\u00fa\5<\37\2\u00f9\u00f8\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa-\3\2\2\2"+
		"\u00fb\u00fc\5\62\32\2\u00fc/\3\2\2\2\u00fd\u00fe\5\62\32\2\u00fe\61\3"+
		"\2\2\2\u00ff\u0100\7\17\2\2\u0100\u0101\7\36\2\2\u0101\u0102\5\34\17\2"+
		"\u0102\63\3\2\2\2\u0103\u0105\7\20\2\2\u0104\u0106\5:\36\2\u0105\u0104"+
		"\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7\36\2\2"+
		"\u0108\u0109\t\5\2\2\u0109\65\3\2\2\2\u010a\u010c\7\21\2\2\u010b\u010d"+
		"\5:\36\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e"+
		"\u010f\7\36\2\2\u010f\u0110\t\5\2\2\u0110\67\3\2\2\2\u0111\u0113\7\22"+
		"\2\2\u0112\u0114\5:\36\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0116\7\36\2\2\u0116\u0117\7\5\2\2\u01179\3\2\2\2"+
		"\u0118\u0119\7\32\2\2\u0119\u011a\5\26\f\2\u011a\u011b\7\33\2\2\u011b"+
		";\3\2\2\2\u011c\u011d\7\32\2\2\u011d\u0122\5> \2\u011e\u011f\7#\2\2\u011f"+
		"\u0121\5> \2\u0120\u011e\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2"+
		"\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126"+
		"\7\33\2\2\u0126=\3\2\2\2\u0127\u0128\5@!\2\u0128?\3\2\2\2\u0129\u012a"+
		"\7\'\2\2\u012a\u012b\7(\2\2\u012b\u012c\7&\2\2\u012cA\3\2\2\2\26KT]gk"+
		"\u0082\u008f\u009c\u00b3\u00c7\u00d3\u00e0\u00ec\u00f1\u00f5\u00f9\u0105"+
		"\u010c\u0113\u0122";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}