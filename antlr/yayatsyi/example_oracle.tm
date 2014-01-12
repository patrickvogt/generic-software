prg
[
    +tapes := {\default, \oracle}
    +nondeterministic: false    
    +probabilistic: false 
    +oracle: identity
].

-- example for a deterministic oracle turing machine

-- must be finite and non empty
states := {s1, s2, \question, \answer}.

-- initial state must be contained in set states
initial_state: s1.

-- accepting states, must be a subset of states.
final_states := {s2}.

-- must be finite and non empty and must contain \blank
tape_alphabet := {'0', '1', \blank}.

oracle_alphabet := {'0', '1', \blank}.

-- can be partial
transition_function :=
{
    -- state must not be contained in final_states.
    +state: s1, read(\default): '1' -> state: s2, write(\default): '0', shift(\default): left 
    +state: s1, read(\oracle): '0' -> state: s1, write(\oracle): '1', shift(\oracle): nop 
    +state: s1, read: '0' -> state: \question, write: '2', shift: nop
    +state: \answer, read: '0' -> state: s2, write: '0', shift: left --which tape?    
}.

run
[
    tape_instance(\default): '01001'
].