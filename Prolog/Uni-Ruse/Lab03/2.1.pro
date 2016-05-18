/*

1 задача: 

Да се дефинира предикат, който 
- при 2 дадени числа, 
- връща удвоено по–малкото от тях, 
- ако са равни – връща едното число без удвояване.

*/

double_min(Number1, Number2, MinNumber) :-
	Number1 < Number2,
	MinNumber is Number1 * 2.
double_min(Number1, Number2, MinNumber) :-
	Number2 < Number1,
	MinNumber is Number2 * 2.
double_min(Number1, Number2, Number1).

?-double_min(4, 3, MinNumber), write(MinNumber), nl, !.
