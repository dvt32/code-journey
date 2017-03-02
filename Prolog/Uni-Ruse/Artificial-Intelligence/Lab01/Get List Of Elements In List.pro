member(X, [X|_]).
member(X, [_|T]) :- member(X, T).

?-member(X, [3,2,5]), write(X), nl, fail.
