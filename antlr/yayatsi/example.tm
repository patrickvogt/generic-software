one tape deterministic turing machine.

prg{}.

-- example for an one tape deterministic turing machine

-- must be finite and non empty
states := {s1, s2}.

-- must be finite and non empty and must contain \blank
tape_alphabet := {'0', '1', \blank}.

-- input alphabet must be a real subset of tape_alphabet
input_alphabet := {'0', '1'}.

-- initial state must be contained in set states
initial_state := s1.

-- accepting states, must be a subset of states.
final_states := {s2}.

-- can be partial
transition_function :=
{
    -- state must be not contained in final_states.
    state: s1, read: '1', shift: left   /
    state: s1, read: '0', shift: nop    /
    state: s2, read: '0', shift: right  
}.

run
{
    tape_instance: '01001'
}.