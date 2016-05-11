/*

1. Да се дефинира предикат на Prolog, който:
- при въвеждане на K извежда
	- ако K е цяло положително число - (2*K+8) / (2*(K-10)),
	- ако K е цяло отрицателно число - (2*K-8) / 20
	- в противен случай - "not number".
Действието се повтаря, докато се въведе 10.

*/

f(K, Result) :-
	integer(K),
	K > 0,
	Result is (2*K+8) / (2*(K-10)).
f(K, Result) :-
	integer(K),
	K < 0,
	Result is (2*K-8) / 20.
f(_, "not number").

print(10) :- !.
print(K) :-
	f(K, Result), write(Result), nl,
	read(K1),
	print(K1).

?-read(K), print(K), nl.
