/*

4 задача:

Даден е списъка 
	[alfa  beta  gamma  delta  epsilon]. 

Да се напише предикат, който като резултат
- да добавя елемента Kappa:

а. преди първия елемент на дадения списък;
б. между  първия  и  втория  елемент  на  дадения списък;
в. като последен елемент на дадения списък.

*/

add_before_first(Kappa, InputList, [Kappa|InputList]).
add_between_first_and_second(Kappa, [Head|Tail], [Head, Kappa|Tail]).
add_after_last([], List, List).
add_after_last([Head|Tail], [Kappa], [Head|NewList]) :-
	add_after_last(Tail, [Kappa], NewList).

% ?-add_before_first(kappa, [alfa, beta, gamma, delta, epsilon], NewList), write(NewList), nl.
% ?-add_between_first_and_second(kappa, [alfa, beta, gamma, delta, epsilon], NewList), write(NewList), nl.
% ?-add_after_last([alfa, beta, gamma, delta, epsilon], [kappa], NewList), write(NewList), nl.
