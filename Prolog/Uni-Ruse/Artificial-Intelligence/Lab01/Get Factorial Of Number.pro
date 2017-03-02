fact(0, 1).
fact(N, Res) :-
 N1 is N - 1,
 fact(N1, R),
 Res is N*R.

?-fact(6, R), write(R).
