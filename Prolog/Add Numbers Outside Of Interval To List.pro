/*

Дефинирайте предикат, който създава нов списък, съдържащ числата от входния списък с произволни елементи, чиито стойности НЕ лежат в отворения интервал (C, M).

Отворен интервал:

C < x < M

Затворен интервал:

C <= x <= M

*/

f(_, _, [], []).
f(C, M, [H|T], OutputList) :-
	number(H),
	(H =< C;
	 H >= M),
	f(C, M, T, OutputList1),
	OutputList is [H|OutputList1].
f(C, M, [H|T], OutputList) :-
	f(C, M, T, OutputList).

?-read(C), read(M), f(C, M, [a, 1, 2, 3, 4, 5, asdf, 6, 7], OutputList), write(OutputList), nl.
