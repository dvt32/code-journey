/*

16 задача: 

Даден е списък на хората, работещи в дадена фирма, който съдържа за всеки човек 
- име, 
- професия, 
- стаж, 
- работна позиция.
 
Да се дефинира предикат, който 
претърсва списъка и извежда имената на всички хора, 
- работещи на дадена позиция, които имат стаж по–малък от зададена граница.

Да се избере подходящо представяне на информацията на Prolog.

*/

company([
  person(names("Ivo", "Nikolov"), engineer, 10, programmer),
  person(names("Borislav", "Ivanov"), hygiene, 12, janitor),
  person(names("Ana", "Nedeva"), human_resources, 5, manager),
  person(names("Petar", "Ivanov"), computer_scientist, 6, programmer),
  person(names("Maria", "Petrova"), human_resources, 5, recruiter)
]).

person_matching_conditions(_, _, [], []).
person_matching_conditions(
	JobToBeFound,
	MaxExperience, 
	[person(names(FirstName, LastName), Profession, Experience, Job)|T], 
  	[[FirstName, LastName]|NewT]
) :-
	Experience < MaxExperience, 
	Job == JobToBeFound, !,
	person_matching_conditions(JobToBeFound, MaxExperience, T, NewT).
person_matching_conditions(JobToBeFound, MaxExperience, [H|T], NewT) :- person_matching_conditions(JobToBeFound, MaxExperience, T, NewT).

?-company(List), read(Job), read(MaxExperience), person_matching_conditions(Job, MaxExperience, List, NewList), write(NewList), nl, fail.
