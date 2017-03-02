append([], L2, L2).
append([X|L1], L2, [X|L3]) :-
  append(L1, L2, L3).

?-append([1,2,3], [4,5,6], L3), write(L3), nl.
