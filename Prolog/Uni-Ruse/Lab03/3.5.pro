/*

5 задача: Да се напише предикат, който по зададено цяло положително число K, намира сумата на първите K положителни цели числа.

*/

sum(1, 1).
sum(K, Result) :-
	integer(K),
	K > 1,
	K1 is K - 1,
	sum(K1, Result1),
	Result is Result1 + K.

?-sum(3, Result), write(Result), nl.
