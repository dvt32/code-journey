append([], L2, L2).
append([X|L1], L2, [X|L3]) :-
append(L1, L2, L3).

reverse([], []).
reverse([X|L], Rev) :-
  reverse(L, R),
  append(R, [X], Rev).

?-reverse([1,2,3], Rev), write(Rev), nl.
