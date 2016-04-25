/*

2 задача: 

Да се дефинира предикат, 
който връща сумата на 2-та си аргумента, 
ако те са цели числа, 
в противен случай връща 0.

*/

sum_of_integer_arguments(Arg1, Arg2, Sum) :-
	integer(Arg1),
	integer(Arg2),
	Sum is Arg1 + Arg2.
sum_of_integer_arguments(Arg1, Arg2, 0).

?-sum_of_integer_arguments(55, 32, Sum), write(Sum), nl, !.

