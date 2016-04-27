/*

2 задача: 

Дадена е информация за представените модни колекции лято 2008. 

За всяка от тях е дадено името на дизайнера, неговата националност, брой представени модели и оценка на публиката. 

Да се представи информацията по подходящ начин, използвайки структури. 

Към представената информация да се зададат следните въпроси:

а. Кои дизайнери има повече от 3 представени модела?;
б. Има ли поне двама дизайнери с едно и също малко име?
в. Кои са имената на италианските дизайнери?
г. От кои народности са дизайнерите, които имат поне 10 точки?
д. Кой дизайнер има не по–малко от 25 точки?
е. Кое е името на дизайнера с най–висок брой точки?

*/

designer(name("Ivan", "Ivanov"), "Bulgarian", 12, 11).
designer(name("John", "Turturro"), "Italian", 2, 9).
designer(name("John", "McLane"), "American", 32, 26).
designer(name("Roberto", "Turturro"), "Italian", 32, 8).
designer(name("Petar", "Petrov"), "Bulgarian", 32, 23).

same_first_name(FirstName, LastName) :-
	designer(name(FirstName, LastName), _, _, _),
	designer(name(FirstName, LastName2), _, _, _),
	LastName \== LastName2.

designer_max_points(FirstName, LastName, Points) :-
	designer(name(FirstName, LastName), _, _, Points),
	not(designer(name(_,_), _,_, Points1), Points1 > Points).

% ?-designer(name(FirstName,LastName), _, NumberOfDesignedModels, _), NumberOfDesignedModels > 3, write(FirstName), write(" "), write(LastName), nl.
% ?-same_first_name(FirstName, LastName), write(FirstName), write(" "), write(LastName), nl.
% ?-designer(name(FirstName, LastName), "Italian", _, _), write(FirstName), write(" "), write(LastName), nl.
% ?-designer(_(_,_), Nationality, _, Points), Points >= 10, write(Nationality), nl.
% ?-designer(name(FirstName, LastName), _, _, Points), Points >= 25, write(FirstName), write(" "), write(LastName), nl.
?-designer_max_points(FirstName, LastName, Points), write(FirstName), write(" "), write(LastName), write(" "), write(Points), nl.
