################################################################################
# YAYATSYI                                                                      #
################################################################################

YAYATSYI - Yet Another Yet Another Turing machine Simulator, You Idiot.

This is a sketch-grammar for a Turing machine DSL.

Note: The grammar will only roughly check the syntax of the DSL. There are at least two visitors needed:
  + A visitor to check the validation of the input (IDs, options ...)
  + A visitor which translates the Turing machine into a Java file (which simulates the Turing machine).
  
Test with (environment setup as in 'The Definitive ANTLR 4 Reference' by Terence Parr):
``` 
$: antlr4 YayatsyiGrammar.g4
$: javac *.java
$: grun YayatsyiGrammar root -gui <Testfile>.tm
```