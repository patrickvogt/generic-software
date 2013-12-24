prg
[
    +tapes := {\default}
    +nondeterministic: false    
    +probabilistic: false 
    +oracle: \none 
].

-- example for an one tape deterministic turing machine

-- must be finite and non empty
states := {s1, s2}.

-- initial state must be contained in set states
initial_state: s1.

-- accepting states, must be a subset of states.
final_states := {s2}.

-- must be finite and non empty and must contain \blank
tape_alphabet := {'0', '1', \blank}.

-- can be partial
transition_function :=
{
    -- state must be not contained in final_states.
    +state: s1, read: '1' -> state: s2, write: '0', shift: left 
    +state: s1, read: '0' -> state: s1, write: '1', shift: nop  
}.

run
[
    tape_instance: '01001'
].