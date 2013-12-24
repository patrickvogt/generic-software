grammar Yayatsi;
import CommonLexerRules;

root: 
    program_header 
    program_body
    run
;

program_header:
    PRG_START
    (ATTRS_BEGIN program_attrs ATTRS_END)?
    EXPR_END
;

program_body:
    states
    initial_state
    final_states
    tape_alphabet
    transition_function
;

run:
    RUN_START
    (ATTRS_BEGIN run_attrs ATTRS_END)?
    EXPR_END
;

program_attrs:
   (    nondeterministic
   |    probabilistic
   |    oracle
   |    tapes
   )* 
;

nondeterministic:
    PLUS NONDETERMINISTIC ATTR_SEPARATOR BOOLEAN_OPTION
;

probabilistic:
    PLUS PROBABILISTIC ATTR_SEPARATOR BOOLEAN_OPTION
;

oracle:
    PLUS ORACLE ATTR_SEPARATOR NO_ORACLE
;

tapes:
    PLUS TAPES SET_ASSIGN SET_BEGIN DEFAULT_TAPE SET_END
;

run_attrs:
    TAPE_INSTANCE ATTR_SEPARATOR TAPE_INST_SYMBOL
;

states:
    STATES_DEF
    SET_ASSIGN
    SET_BEGIN
    IDENTIFIER (COMMA IDENTIFIER)*
    SET_END
    EXPR_END
;

tape_alphabet:
    TAPE_ALPH_DEF
    SET_ASSIGN
    SET_BEGIN
    (TAPE_ALPH_SYMBOL) (COMMA (TAPE_ALPH_SYMBOL|BLANK_SYMBOL))*
    SET_END
    EXPR_END
;

initial_state:
    INIT_STATE_DEF
    ATTR_SEPARATOR
    IDENTIFIER
    EXPR_END
;

final_states:
    FINAL_STATES_DEF
    SET_ASSIGN
    SET_BEGIN
    IDENTIFIER (COMMA IDENTIFIER)*
    SET_END
    EXPR_END
;

transition_function:
    TRANS_FUNC_DEF
    SET_ASSIGN  
    SET_BEGIN
    (trans_func_line)+
    SET_END
    EXPR_END
;

trans_func_line:
    PLUS
    TRANS_FUNC_STATE ATTR_SEPARATOR IDENTIFIER COMMA
    TRANS_FUNC_READ ATTR_SEPARATOR TAPE_ALPH_SYMBOL
    TRANS_FUNC_TO
    TRANS_FUNC_STATE ATTR_SEPARATOR IDENTIFIER COMMA
    TRANS_FUNC_WRITE ATTR_SEPARATOR TAPE_ALPH_SYMBOL COMMA
    TRANS_FUNC_SHIFT ATTR_SEPARATOR TRANS_FUNC_MOV
;