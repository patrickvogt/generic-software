grammar YayatsiGrammar;
// import the lexer grammar
import YayatsiLexerGrammar;

// the grammar begins here
root: 
    // first the program header, then the program body, then the run part
    program_header 
    program_body
    run
;

// a.o.t. defines the type of the turing machine
program_header:
    PROGRAM_DEFINITION
    (ATTRIBUTES_BEGINNING program_attrs ATTRIBUTES_END)?
    EXPRESSION_DELIMITER
;

program_body:
    states
    initial_state
    final_states
    tape_alphabet
    oracle_alphabet?
    transition_function
;

run:
    RUN_DEFINITION
    (ATTRIBUTES_BEGINNING run_attrs ATTRIBUTES_END)?
    EXPRESSION_DELIMITER
;

program_attrs:
   (    LINE_BEGINNING  
        (
            nondeterministic
            |    probabilistic
            |    oracle
            |    tapes
            |    read_only
        )
   )*
;

nondeterministic:
    NONDETERMINISTIC_OPTION ELEMENT_ASSIGNMENT BOOLEAN_OPTION
;

probabilistic:
    PROBABILISTIC_OPTION ELEMENT_ASSIGNMENT BOOLEAN_OPTION
;

oracle:
    ORACLE ELEMENT_ASSIGNMENT (NO_ORACLE | IDENTIFIER)
;

tapes:
    TAPES_DEFINITION SET_ASSIGNMENT SET_BEGINNING possible_tapes (COMMA possible_tapes)* SET_END
;

read_only:
    READ_ONLY ELEMENT_ASSIGNMENT BOOLEAN_OPTION
;

possible_tapes:
    (DEFAULT_TAPE | ORACLE_TAPE)
;

run_attrs:
    TAPE_INSTANCE tape_argument? ELEMENT_ASSIGNMENT TAPE_INSTANCE_SYMBOL
;

states:
    STATES_DEFINITION
    SET_ASSIGNMENT
    SET_BEGINNING
    possible_states (COMMA possible_states)*
    SET_END
    EXPRESSION_DELIMITER
;

possible_states:
    (IDENTIFIER | QUESTION_STATE | ANSWER_STATE)
;

tape_alphabet:
    TAPE_ALPHABET_DEFINITION
    generic_alphabet
    EXPRESSION_DELIMITER
;

oracle_alphabet:
    ORACLE_TAPE_ALPHABET_DEFINITION
    generic_alphabet
    EXPRESSION_DELIMITER
;

generic_alphabet:
    SET_ASSIGNMENT
    SET_BEGINNING
    possible_tape_alphabet_symbol (COMMA possible_tape_alphabet_symbol)*
    SET_END
;

possible_tape_alphabet_symbol:
    (TAPE_ALPHABET_SYMBOL | BLANK_SYMBOL)
;

initial_state:
    INITIAL_STATE_DEFINITION
    ELEMENT_ASSIGNMENT
    IDENTIFIER
    EXPRESSION_DELIMITER
;

final_states:
    FINAL_STATES_DEFINITION
    SET_ASSIGNMENT
    SET_BEGINNING
    IDENTIFIER (COMMA IDENTIFIER)*
    SET_END
    EXPRESSION_DELIMITER
;

transition_function:
    TRANSITION_FUNCTION_DEFINITION
    SET_ASSIGNMENT  
    SET_BEGINNING
    (trans_func_line)+
    SET_END
    EXPRESSION_DELIMITER
;

trans_func_line:
    LINE_BEGINNING
    transition_function_state_from COMMA
    transition_function_read (COMMA transition_function_read)*
    TRANSITION_FUNCTION_TO
    transition_function_state_to COMMA
    (transition_function_write COMMA
    transition_function_shift)
    (transition_function_write | transition_function_shift)? (COMMA (transition_function_write | transition_function_shift))*
    trans_func_line_attrs?
;

transition_function_state_from:
    transition_function_state
;

transition_function_state_to:
    transition_function_state
;

transition_function_state:
    TRANSITION_FUNCTION_STATE ELEMENT_ASSIGNMENT possible_states
;
transition_function_read:
    TRANSITION_FUNCTION_READ tape_argument? ELEMENT_ASSIGNMENT TAPE_ALPHABET_SYMBOL
;

transition_function_write:
    TRANSITION_FUNCTION_WRITE tape_argument? ELEMENT_ASSIGNMENT TAPE_ALPHABET_SYMBOL
;

transition_function_shift:
    TRANSITION_FUNCTION_SHIFT tape_argument? ELEMENT_ASSIGNMENT SHIFT_OPTION
;

tape_argument:
    ARGUMENT_BEGINNING possible_tapes ARGUMENT_END
;

trans_func_line_attrs:
    ARGUMENT_BEGINNING
    trans_func_line_attrs_option (COMMA trans_func_line_attrs_option)*
    ARGUMENT_END
;
    
trans_func_line_attrs_option:
    (probability)
;

probability:
    PROBABILITY_DEFINITION PROBABILITY_EQUAL PROBABILITY_QUOTIENT
;
