lexer grammar YayatsiLexerRules;

// Generic Part
LINE_COMMENT_BEGIN              : '--'                                                      ; // The beginning of a comment line
LINE_COMMENT                    : LINE_COMMENT_BEGIN ~[\r\n]*? '\r'?'\n' -> channel(HIDDEN) ; // A line comment

BOOLEAN_OPTION                  : (TRUE_OPTION | FALSE_OPTION)                              ; // Boolean option to specify some features of the turing machine
TRUE_OPTION                     : 'true'                                                    ; // Option to enable some features of the turing machine
FALSE_OPTION                    : 'false'                                                   ; // Option to disable some features of the turing machine

SHIFT_OPTION                    : (LEFT_OPTION | NOP_OPTION | RIGHT_OPTION)                 ; // Option to specify the shift of the tape head
LEFT_OPTION                     : 'left'                                                    ; // Move tape head one element to the left
RIGHT_OPTION                    : 'right'                                                   ; // Move tape head one element to the right 
NOP_OPTION                      : 'nop'                                                     ; // Don't move tape head

BLANK_SYMBOL                    : PROGRAM_DIRECTIVE 'blank'                                 ; // The blank symbol [of the tape(s)]
DEFAULT_TAPE                    : PROGRAM_DIRECTIVE 'default'                               ; // The default tape of the turing machine

PROGRAM_DEFINITION              : 'prg'                                                     ; // Definition of the turing machine's program
STATES_DEFINITION               : 'states'                                                  ; // Definition of the turing machine's states
TAPE_ALPHABET_DEFINITION        : 'tape_alphabet'                                           ; // Definition of the turing machine's tape alphabet
RUN_DEFINITION                  : 'run'                                                     ; // Definition of the turing machine's run instance
INITIAL_STATE_DEFINITION        : 'initial_state'                                           ; // Definition of the turing machine's initial state
FINAL_STATES_DEFINITION         : 'final_states'                                            ; // Definition of the turing machine's final states
TRANSITION_FUNCTION_DEFINITION  : 'transition_function'                                     ; // Definition of the turing machine's transition function
TRANSITION_FUNCTION_STATE       : 'state'                                                   ; // Definition of the transition function's state
TRANSITION_FUNCTION_READ        : 'read'                                                    ; // Definition of the transition function's read symbol
TRANSITION_FUNCTION_WRITE       : 'write'                                                   ; // Definition of the transition function's write symbol
TRANSITION_FUNCTION_SHIFT       : 'shift'                                                   ; // Definition of the transition function's shift of the head
TAPES_DEFINITION                : 'tapes'                                                   ; // Definition of the turing machine's tapes
TAPE_INSTANCE                   : 'tape_instance'                                           ; // Input instance of the default tape
READ_ONLY                       : 'read_only'                                               ; // Specifies if the turing machine is read only

ATTRIBUTES_BEGINNING            : '['                                                       ; // Beginning of attribute list
ATTRIBUTES_END                  : ']'                                                       ; // End of attribute list
SET_BEGINNING                   : '{'                                                       ; // Beginning of set
SET_END                         : '}'                                                       ; // End of set
ARGUMENT_BEGINNING              : '('                                                       ; // Beginning of an argument
ARGUMENT_END                    : ')'                                                       ; // End of an argument
SET_ASSIGNMENT                  : ':='                                                      ; // Assignment of a set
EXPRESSION_DELIMITER            : '.'                                                       ; // Separates several expressions
ELEMENT_ASSIGNMENT              : ':'                                                       ; // Assignment of an element
PROGRAM_DIRECTIVE               : '\\'                                                      ; // Directive within the program
LINE_BEGINNING                  : '+'                                                       ; // Beginning of a line 
TRANSITION_FUNCTION_TO          : '->'                                                      ; // Transition Function to the new tuple (state, write, shift)
STRING_DELIMITER                : '\''                                                      ; // used to delimit a string from the other parts
COMMA                           : ','                                                       ; // A comma
SET_ELEMENT_DELIMITER           : COMMA                                                     ; // Separates several elements within a set
TRANSITION_FUNCTION_DELIMITER   : COMMA                                                     ; // Separates several elements within a transition function line

// NTM Part
NONDETERMINISTIC_OPTION         : 'nondeterministic'                                        ; // Option to specify that the turing machine is nondeterministic

// Probabilistic Part
PROBABILISTIC_OPTION            : 'probabilistic'                                           ; // If the turing machine is nondeterministic probabilistic
PROBABILITY_QUOTIENT            : ('1/2' | '1')                                             ; // Probability of a transition function line 
PROBABILITY_DEFINITION          : 'p'                                                       ; // Probability of a transition function line
PROBABILITY_EQUAL               : '='                                                       ; // Probability equal sign 

// Oracle Part
ORACLE                          : 'oracle'                                                  ; // Specifies the oracle used within the oracle turing machine
NO_ORACLE                       : PROGRAM_DIRECTIVE 'none'                                  ; // Specifies that no oracle is used
ORACLE_TAPE                     : PROGRAM_DIRECTIVE 'oracle'                                ; // Specifies the oracle tape
QUESTION_STATE                  : PROGRAM_DIRECTIVE 'question'                              ; // Specifies the question state which initiates the oracle call
ANSWER_STATE                    : PROGRAM_DIRECTIVE 'answer'                                ; // Specifies the answer state which is the first state after the oracle call
ORACLE_TAPE_ALPHABET_DEFINITION : 'oracle_alphabet'                                         ; // Definition of the turing machine's oracle tape alphabet

// Generic Part
INNER_ALPHABET_SYMBOL           : ~[ \r\n]                                                  ; // All symbols which can be used within a tape's alphabet
TAPE_ALPHABET_SYMBOL            : STRING_DELIMITER INNER_ALPHABET_SYMBOL STRING_DELIMITER   ; // One single tape alphabet symbol
TAPE_INSTANCE_SYMBOL            : STRING_DELIMITER INNER_ALPHABET_SYMBOL+? STRING_DELIMITER ; // A long specifying the whole instance of the default tape
IDENTIFIER                      : [a-z][a-z0-9]*                                            ; // Identifier within the program e.g. for states
WHITESPACE                      : [ \t\r\n] -> skip                                         ; // Ignore Space, Tabulator, Carriage Return, Newline
