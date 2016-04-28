/*

2 задача:
Да се дефинира предикат, който 
- намира дължината на даден списък (т.е. броя на елементите му на първо ниво).

*/

length([], 0).
length([Head|Tail], NumberOfElements) :-
	length(Tail, CurrentNumberOfElements),
	NumberOfElements is CurrentNumberOfElements + 1.

?-length([a, b, c], Result), write(Result), nl.
