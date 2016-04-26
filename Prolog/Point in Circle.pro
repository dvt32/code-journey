/* 

Да се дефинира предикат, който по зададени координати на точка, определя дали тя лежи в окръжност.

*/ 

is_in_circle(X, Y, Radius, Result) :-
	(X*X + Y*Y) =< Radius * Radius,
	Result is "Point is inside the circle.".
is_in_circle(X, Y, Radius, Result) :-
	Result is "Point is not inside the circle.".

?-is_in_circle(4, 4, 16, Result), write(Result), nl.
