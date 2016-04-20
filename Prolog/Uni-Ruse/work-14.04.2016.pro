/*

1 задача: Да се напише предикат, който проверява дали:

a дадено число x Є [1, 76];
b. поне две от три зададени числа a, b и c са равни;
c. намира средното аритметично на две числа, ако те са цели, положителни, в противен случай, връща по–малкото от двете;
d. пресмята a^n, като използва умножение.

*/

/* 1a */
is_in_range(START, END, X) :- X>=START, X=<END.
% ?-is_in_range(1, 76, 4).

/* 1b */
has_equality(A, B, C) :- 
  A = B;
  A = C;
  B = C.
% ?-has_equality(3, 2, 1).

/* 1c */
get_result(X, Y, RESULT) :- 
  X>0, 
  Y>0, 
  integer(X), 
  integer(Y), 
  RESULT is (X+Y)/2.
get_result(X, Y, RESULT) :-
  RESULT is min(X, Y).
% ?-get_result(1.0, 5.9, RESULT), write(RESULT), nl.

/* 1d */
get_power(_, 0, 1).
get_power(A, N, RESULT) :-
  N1 is N-1,
  get_power(A, N1, RESULT1),
  RESULT is RESULT1 * A.
?-get_power(2, 3, RESULT), write(RESULT), nl.
