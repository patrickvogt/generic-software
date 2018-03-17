// Generated from YayatsyiGrammar.g4 by ANTLR 4.1
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YayatsyiGrammarParser}.
 */
public interface YayatsyiGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#read_only}.
	 * @param ctx the parse tree
	 */
	void enterRead_only(@NotNull YayatsyiGrammarParser.Read_onlyContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#read_only}.
	 * @param ctx the parse tree
	 */
	void exitRead_only(@NotNull YayatsyiGrammarParser.Read_onlyContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(@NotNull YayatsyiGrammarParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(@NotNull YayatsyiGrammarParser.RootContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#oracle_alphabet}.
	 * @param ctx the parse tree
	 */
	void enterOracle_alphabet(@NotNull YayatsyiGrammarParser.Oracle_alphabetContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#oracle_alphabet}.
	 * @param ctx the parse tree
	 */
	void exitOracle_alphabet(@NotNull YayatsyiGrammarParser.Oracle_alphabetContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#transition_function}.
	 * @param ctx the parse tree
	 */
	void enterTransition_function(@NotNull YayatsyiGrammarParser.Transition_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#transition_function}.
	 * @param ctx the parse tree
	 */
	void exitTransition_function(@NotNull YayatsyiGrammarParser.Transition_functionContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#states}.
	 * @param ctx the parse tree
	 */
	void enterStates(@NotNull YayatsyiGrammarParser.StatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#states}.
	 * @param ctx the parse tree
	 */
	void exitStates(@NotNull YayatsyiGrammarParser.StatesContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#program_body}.
	 * @param ctx the parse tree
	 */
	void enterProgram_body(@NotNull YayatsyiGrammarParser.Program_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#program_body}.
	 * @param ctx the parse tree
	 */
	void exitProgram_body(@NotNull YayatsyiGrammarParser.Program_bodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#transition_function_state_to}.
	 * @param ctx the parse tree
	 */
	void enterTransition_function_state_to(@NotNull YayatsyiGrammarParser.Transition_function_state_toContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#transition_function_state_to}.
	 * @param ctx the parse tree
	 */
	void exitTransition_function_state_to(@NotNull YayatsyiGrammarParser.Transition_function_state_toContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#oracle}.
	 * @param ctx the parse tree
	 */
	void enterOracle(@NotNull YayatsyiGrammarParser.OracleContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#oracle}.
	 * @param ctx the parse tree
	 */
	void exitOracle(@NotNull YayatsyiGrammarParser.OracleContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(@NotNull YayatsyiGrammarParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(@NotNull YayatsyiGrammarParser.RunContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#generic_alphabet}.
	 * @param ctx the parse tree
	 */
	void enterGeneric_alphabet(@NotNull YayatsyiGrammarParser.Generic_alphabetContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#generic_alphabet}.
	 * @param ctx the parse tree
	 */
	void exitGeneric_alphabet(@NotNull YayatsyiGrammarParser.Generic_alphabetContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#possible_tape_alphabet_symbol}.
	 * @param ctx the parse tree
	 */
	void enterPossible_tape_alphabet_symbol(@NotNull YayatsyiGrammarParser.Possible_tape_alphabet_symbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#possible_tape_alphabet_symbol}.
	 * @param ctx the parse tree
	 */
	void exitPossible_tape_alphabet_symbol(@NotNull YayatsyiGrammarParser.Possible_tape_alphabet_symbolContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#tape_argument}.
	 * @param ctx the parse tree
	 */
	void enterTape_argument(@NotNull YayatsyiGrammarParser.Tape_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#tape_argument}.
	 * @param ctx the parse tree
	 */
	void exitTape_argument(@NotNull YayatsyiGrammarParser.Tape_argumentContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#possible_tapes}.
	 * @param ctx the parse tree
	 */
	void enterPossible_tapes(@NotNull YayatsyiGrammarParser.Possible_tapesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#possible_tapes}.
	 * @param ctx the parse tree
	 */
	void exitPossible_tapes(@NotNull YayatsyiGrammarParser.Possible_tapesContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#transition_function_state}.
	 * @param ctx the parse tree
	 */
	void enterTransition_function_state(@NotNull YayatsyiGrammarParser.Transition_function_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#transition_function_state}.
	 * @param ctx the parse tree
	 */
	void exitTransition_function_state(@NotNull YayatsyiGrammarParser.Transition_function_stateContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#program_header}.
	 * @param ctx the parse tree
	 */
	void enterProgram_header(@NotNull YayatsyiGrammarParser.Program_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#program_header}.
	 * @param ctx the parse tree
	 */
	void exitProgram_header(@NotNull YayatsyiGrammarParser.Program_headerContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void enterProbability(@NotNull YayatsyiGrammarParser.ProbabilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#probability}.
	 * @param ctx the parse tree
	 */
	void exitProbability(@NotNull YayatsyiGrammarParser.ProbabilityContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#transition_function_read}.
	 * @param ctx the parse tree
	 */
	void enterTransition_function_read(@NotNull YayatsyiGrammarParser.Transition_function_readContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#transition_function_read}.
	 * @param ctx the parse tree
	 */
	void exitTransition_function_read(@NotNull YayatsyiGrammarParser.Transition_function_readContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#trans_func_line_attrs}.
	 * @param ctx the parse tree
	 */
	void enterTrans_func_line_attrs(@NotNull YayatsyiGrammarParser.Trans_func_line_attrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#trans_func_line_attrs}.
	 * @param ctx the parse tree
	 */
	void exitTrans_func_line_attrs(@NotNull YayatsyiGrammarParser.Trans_func_line_attrsContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#tapes}.
	 * @param ctx the parse tree
	 */
	void enterTapes(@NotNull YayatsyiGrammarParser.TapesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#tapes}.
	 * @param ctx the parse tree
	 */
	void exitTapes(@NotNull YayatsyiGrammarParser.TapesContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#probabilistic}.
	 * @param ctx the parse tree
	 */
	void enterProbabilistic(@NotNull YayatsyiGrammarParser.ProbabilisticContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#probabilistic}.
	 * @param ctx the parse tree
	 */
	void exitProbabilistic(@NotNull YayatsyiGrammarParser.ProbabilisticContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#nondeterministic}.
	 * @param ctx the parse tree
	 */
	void enterNondeterministic(@NotNull YayatsyiGrammarParser.NondeterministicContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#nondeterministic}.
	 * @param ctx the parse tree
	 */
	void exitNondeterministic(@NotNull YayatsyiGrammarParser.NondeterministicContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#trans_func_line}.
	 * @param ctx the parse tree
	 */
	void enterTrans_func_line(@NotNull YayatsyiGrammarParser.Trans_func_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#trans_func_line}.
	 * @param ctx the parse tree
	 */
	void exitTrans_func_line(@NotNull YayatsyiGrammarParser.Trans_func_lineContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#transition_function_shift}.
	 * @param ctx the parse tree
	 */
	void enterTransition_function_shift(@NotNull YayatsyiGrammarParser.Transition_function_shiftContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#transition_function_shift}.
	 * @param ctx the parse tree
	 */
	void exitTransition_function_shift(@NotNull YayatsyiGrammarParser.Transition_function_shiftContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#transition_function_write}.
	 * @param ctx the parse tree
	 */
	void enterTransition_function_write(@NotNull YayatsyiGrammarParser.Transition_function_writeContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#transition_function_write}.
	 * @param ctx the parse tree
	 */
	void exitTransition_function_write(@NotNull YayatsyiGrammarParser.Transition_function_writeContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#transition_function_state_from}.
	 * @param ctx the parse tree
	 */
	void enterTransition_function_state_from(@NotNull YayatsyiGrammarParser.Transition_function_state_fromContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#transition_function_state_from}.
	 * @param ctx the parse tree
	 */
	void exitTransition_function_state_from(@NotNull YayatsyiGrammarParser.Transition_function_state_fromContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#possible_states}.
	 * @param ctx the parse tree
	 */
	void enterPossible_states(@NotNull YayatsyiGrammarParser.Possible_statesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#possible_states}.
	 * @param ctx the parse tree
	 */
	void exitPossible_states(@NotNull YayatsyiGrammarParser.Possible_statesContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#tape_alphabet}.
	 * @param ctx the parse tree
	 */
	void enterTape_alphabet(@NotNull YayatsyiGrammarParser.Tape_alphabetContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#tape_alphabet}.
	 * @param ctx the parse tree
	 */
	void exitTape_alphabet(@NotNull YayatsyiGrammarParser.Tape_alphabetContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#initial_state}.
	 * @param ctx the parse tree
	 */
	void enterInitial_state(@NotNull YayatsyiGrammarParser.Initial_stateContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#initial_state}.
	 * @param ctx the parse tree
	 */
	void exitInitial_state(@NotNull YayatsyiGrammarParser.Initial_stateContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#program_attrs}.
	 * @param ctx the parse tree
	 */
	void enterProgram_attrs(@NotNull YayatsyiGrammarParser.Program_attrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#program_attrs}.
	 * @param ctx the parse tree
	 */
	void exitProgram_attrs(@NotNull YayatsyiGrammarParser.Program_attrsContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#final_states}.
	 * @param ctx the parse tree
	 */
	void enterFinal_states(@NotNull YayatsyiGrammarParser.Final_statesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#final_states}.
	 * @param ctx the parse tree
	 */
	void exitFinal_states(@NotNull YayatsyiGrammarParser.Final_statesContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#run_attrs}.
	 * @param ctx the parse tree
	 */
	void enterRun_attrs(@NotNull YayatsyiGrammarParser.Run_attrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#run_attrs}.
	 * @param ctx the parse tree
	 */
	void exitRun_attrs(@NotNull YayatsyiGrammarParser.Run_attrsContext ctx);

	/**
	 * Enter a parse tree produced by {@link YayatsyiGrammarParser#trans_func_line_attrs_option}.
	 * @param ctx the parse tree
	 */
	void enterTrans_func_line_attrs_option(@NotNull YayatsyiGrammarParser.Trans_func_line_attrs_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YayatsyiGrammarParser#trans_func_line_attrs_option}.
	 * @param ctx the parse tree
	 */
	void exitTrans_func_line_attrs_option(@NotNull YayatsyiGrammarParser.Trans_func_line_attrs_optionContext ctx);
}