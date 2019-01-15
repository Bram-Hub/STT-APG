# STT APG
## Author
2014:
Bilal Salam

## General Usage

This program takes in a well-formed argument and uses the short truth table method to determine whether the argument is valid or not. This program will not allow values to be set if they are not forced therefore there may be cases where the argument cannot be proven to be valid via this program because the remaining values must be tested via guess and check to see if the argument is valid.

Input example:
*Note all variables are single characters
______________________
¬(A ? B)
¬A
¬B
C ? (¬C)
------------------------

Text file :
Top of the file is the first premise followed by any other premise of the argument and the last line is the conclusion. Each line of the argument must be a well-formed formula where if a literal is between two operators there must be parenthesis to designate order. Furthermore if the negation of a term is operand of an operator then the whole term with the negation must be in parenthesis to indicate the negation applies to the term first  as seen in C ? (¬C).To open a file select file-> open and select the .stt you would like to evaluate.

The user can also input arguments by typing into the white text fields and selecting add to add another line. The last line is the conclusion and all the other lines are premises. Operators are added by selecting the appropriate button in the GUI. In order to delete a line use the delete button.

________________________________________________________

Evaluating an argument

After opening a file or typing in the argument manually
select the Parse button. Selecting the parse button will cause the program to create a parse tree for each line of the argument and will initialize the main connectives of the premises to true and the main connective of the conclusion to false. Once the Parse button has been selected hit the step button until either the argument is determined to be valid(found a contradiction) or no more values could be forced. While the parse button is selected all other functions of the program are disabled. If you are done stepping through an argument, deselect the parse button to resume normal functions.

