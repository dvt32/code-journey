/*

6 задача:

Да  се  напише  предикат,  който  
заменя  в  даден списък, 
всички елементи X с друг елемент – Y.

*/

repl(_, _, [], []).
repl(X, Y, [X|Tail], [Y|Tail1]) :-
	repl(X, Y, Tail, Tail1).
repl(X, Y, [Head|Tail], [Head|Tail1]) :-
	repl(X, Y, Tail, Tail1).

?-repl(3, 4, [1,2,3,5,3,6], NewList), write(NewList), nl.
