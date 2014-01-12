prg
[
    +tapes := {\default}
    +nondeterministic: false    
    +probabilistic: false 
    +oracle: \none 
    +read_only: false
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
    -- state must not be contained in final_states.
    +state: s1, read: '1' -> state: s2, write: '1', shift: nop 
    +state: s1, read: '0' -> state: s1, write: \blank, shift: right  
}.

run
[
    tape_instance: '01001'
].