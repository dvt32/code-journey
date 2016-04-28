/*

5 задача:
Да  се  напише  предикат,  който  премахва  от  даден 
списък, първия срещнат елемент, равен на даден.

*/

remove(Element, [], []).
remove(Element, [Element|Tail], Tail).
remove(Element, [Head|Tail], [Head|NewTail]) :-
	remove(Element, Tail, NewTail).

?-remove(a, [b,c,d,a,e,f], ResultList), write(ResultList), nl.
