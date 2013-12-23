grammar Yayatsi;
import CommonLexerRules;

root: 
    tmtype EXPR_END
    program_header EXPR_END
    program_body
    run EXPR_END
;

tmtype: 
    OTDTM_START
;

program_header:
    PRG_START
    (SET_BEGIN program_attrs SET_END)?
;

program_body:
    states EXPR_END
    tape_alphabet EXPR_END
    input_alphabet EXPR_END
    initial_state EXPR_END
    final_states EXPR_END
    transition_function EXPR_END
;

run:
    RUN_START
    (SET_BEGIN run_attrs SET_END)?

;

program_attrs:
    
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
;

tape_alphabet:
    TAPE_ALPH_DEF
    SET_ASSIGN
    SET_BEGIN
    (TAPE_ALPH_SYMBOL) (COMMA (TAPE_ALPH_SYMBOL|BLANK_SYMBOL))*
    SET_END
;

input_alphabet:
    INPUT_ALPH_DEF
    SET_ASSIGN
    SET_BEGIN
    (TAPE_ALPH_SYMBOL) (COMMA TAPE_ALPH_SYMBOL)*
    SET_END
;

initial_state:
    INIT_STATE_DEF
    SET_ASSIGN
    IDENTIFIER
;

final_states:
    FINAL_STATES_DEF
    SET_ASSIGN
    SET_BEGIN
    IDENTIFIER (COMMA IDENTIFIER)*
    SET_END
;

transition_function:
    TRANS_FUNC_DEF
    SET_ASSIGN  
    SET_BEGIN
    (trans_func_line) (TRANS_FUNC_LS trans_func_line)*
    SET_END
;

trans_func_line:
    TRANS_FUNC_STATE ATTR_SEPARATOR IDENTIFIER COMMA
    TRANS_FUNC_READ ATTR_SEPARATOR TAPE_ALPH_SYMBOL COMMA
    TRANS_FUNC_SHIFT ATTR_SEPARATOR TRANS_FUNC_MOV
;